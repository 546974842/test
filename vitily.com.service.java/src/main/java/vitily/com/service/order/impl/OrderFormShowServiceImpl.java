package vitily.com.service.order.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vitily.com.api_entity.req_entity.mem.TqOrderDetail;
import vitily.com.api_entity.req_entity.mem.TqPlaceOrder;
import vitily.com.api_entity.req_entity.mem.TqPlaceShowOrder;
import vitily.com.api_entity.req_entity.mem.TqSaveOrderExpress;
import vitily.com.cache.DictionaryCache;
import vitily.com.consts.*;
import vitily.com.mapper.mem.MemBaseMapper;
import vitily.com.mapper.mem.MemModelMapper;
import vitily.com.mapper.mem.MemRecInfoMapper;
import vitily.com.mapper.order.OrderOperaRecordMapper;
import vitily.com.mapper.show.ShowBaseMapper;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.service.show.ShowBaseService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.tb_entity.comm.TbDeliveryWay;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.tb_entity.order.TbOrderFormShow;
import vitily.com.tb_entity.order.TbOrderOperaRecord;
import vitily.com.tb_entity.pro.TbProBase;
import vitily.com.mapper.comm.DeliveryWayMapper;
import vitily.com.mapper.order.OrderDetailMapper;
import vitily.com.mapper.order.OrderFormShowMapper;
import vitily.com.mapper.pro.ProBaseMapper;
import vitily.com.mapper.pro.ProSpValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.order.OrderFormShowService;
import vitily.com.tb_entity.show.TbShowBase;
import vitily.com.ts_entity.mem.TsModelInfo;
import vitily.com.ts_entity.order.TsOrderFormShow;
import vitily.com.ts_entity.pro.TsProBase;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.ts_entity.show.TsShowBase;
import vitily.com.tv_entity.mem.TvMemRecInfo;
import vitily.com.tv_entity.order.TvOrderDetail;
import vitily.com.tv_entity.order.TvOrderFormShow;
import vitily.com.tv_entity.pro.TvProSpVal;
import vitily.com.util.CommonUtil;
import vitily.com.util.DateUtil;
import vitily.com.util.NumberUtil;
import vitily.com.util.StringUtil;

@Component
public class OrderFormShowServiceImpl extends BasicServiceImpl<TbOrderFormShow,TsOrderFormShow,TvOrderFormShow> implements OrderFormShowService {
	public static final Object orderLockObject=new Object();//并发控制

	final
    OrderFormShowMapper orderFormShowMapper;
	final
    ProBaseMapper proBaseMapper;
	final
    ProSpValMapper proSpValMapper;
	final
    OrderDetailMapper orderDetailMapper;
	final DeliveryWayMapper deliveryWayMapper;
	final MemRecInfoMapper memRecInfoMapper;
	final OrderOperaRecordMapper orderOperaRecordMapper;
	@Autowired
	private ShowBaseMapper showBaseMapper;
	@Autowired
	private MemModelMapper memModelMapper;
	@Autowired
	MemBaseMapper memBaseMapper;
	@Autowired
	DictionaryCache dictionaryCache;
	@Autowired
	MemLocalAccountAdapter memLocalAccountAdapter;

	@Autowired()
	public OrderFormShowServiceImpl(OrderFormShowMapper orderFormShowMapper,
								ProBaseMapper proBaseMapper,
								ProSpValMapper proSpValMapper,
								OrderDetailMapper orderDetailMapper,
								DeliveryWayMapper deliveryWayMapper,
								MemRecInfoMapper memRecInfoMapper,
								OrderOperaRecordMapper orderOperaRecordMapper) {
		this.orderFormShowMapper = orderFormShowMapper;
		this.proBaseMapper = proBaseMapper;
		this.proSpValMapper = proSpValMapper;
		this.orderDetailMapper = orderDetailMapper;
		this.deliveryWayMapper = deliveryWayMapper;
		this.memRecInfoMapper = memRecInfoMapper;
		this.orderOperaRecordMapper = orderOperaRecordMapper;
		super.setBaseMapper(orderFormShowMapper);
	}
	/**
	 * 插入订单 ：
	 * 从购物车中获取产品信息，并且从数据库中查询相关的商品价格库存等
	 * @param bean 1
	 * @throws Exception 2
	 */
	@Transactional(propagation=Propagation.NESTED,rollbackForClassName={"CustomerException","Exception"})
	public boolean placeOrder(TqPlaceShowOrder bean)throws Exception{
		synchronized (orderLockObject) {
			TsModelInfo tsModelInfo = new TsModelInfo();
			tsModelInfo.getEntity().setMemberId(bean.getMemberId());
			if(CommonUtil.isNull(memModelMapper.selectSingleByBean(tsModelInfo))){
				throw new CustomerException("请先完善模特信息！", ResultStatus.查询不存在);
			}
			TsOrderFormShow existsBean = new TsOrderFormShow();
			existsBean.getEntity().setMemberId(bean.getMemberId());
			existsBean.getEntity().setShowId(bean.getShowId());
			if(orderFormShowMapper.getListByBean(existsBean).size() > 0){
				throw new DuplicateDataException("你已申请过该体验秀，无法再申请！");
			}
			//
			TsOrderFormShow countBean = new TsOrderFormShow();
			countBean.getEntity().setMemberId(bean.getMemberId());
			Date now = new Date();
			countBean.setBeginCreateDate(DateUtil.dateToDateString(now,DateUtil.yyyy_MM_dd_EN));
			countBean.setEndCreateDate(DateUtil.dateToDateString(DateUtil.addDate(now,1),DateUtil.yyyy_MM_dd_EN));

			 int hasCountOfDay = orderFormShowMapper.getCountPaging(countBean);//每个模特每天只能申请20个任务
			if(hasCountOfDay >= 20){
				throw new DuplicateDataException("你今天已经申请过20单模特秀，无法再进行申请，请等明天同一时间再进行操作！");
			}
			//每一个体验秀只能同时有20个在申请中
			countBean = new TsOrderFormShow();
			countBean.getEntity().setShowId(bean.getShowId());
			countBean.getEntity().setDealStatus(OrderDealStatusDesc.待审核.getValue());
			hasCountOfDay = orderFormShowMapper.getCountPaging(countBean);//每个模特每天只能申请20个任务
			if(hasCountOfDay >= 20){
				throw new DuplicateDataException("该体验秀已经有20人在申请了，请等待商家审核其他模特之后再申请！");
			}

			TbOrderFormShow orderFormShow = new TbOrderFormShow();
			orderFormShow.setOrderDate(new Date());
			TbShowBase showBase = showBaseMapper.selectByPrimaryKey(bean.getShowId());
			if(!CommonUtil.isEqual(showBase.getState(),ShowStateDesc.审核通过.getValue())){
				throw new CustomerException("体验秀未审核或者审核未通过.", ResultStatus.查询不存在);
			}
			if(showBase.getSurplusNumber() >= showBase.getExperiNumber()){
				throw new CustomerException("体验秀已满额，请等待商家审核.", ResultStatus.数据状态不正确);
			}
			//设置收货人
			TvMemRecInfo memRecInfo=memRecInfoMapper.selectByPrimaryKeyForTv(bean.getMemRecInfoId());
			if(CommonUtil.isNull(memRecInfo) || !CommonUtil.isEqual(bean.getMemberId(), memRecInfo.getMemberId())){
				throw new CustomerException("收货人信息不存在.", ResultStatus.查询不存在);
			}

			orderFormShow.setReceiver(memRecInfo.getReceiver());
			orderFormShow.setArea(memRecInfo.getProvince()+"."+memRecInfo.getCity()+"."+memRecInfo.getArea());
			orderFormShow.setAddress(memRecInfo.getAddress());
			orderFormShow.setPostCode(memRecInfo.getPhone());
			orderFormShow.setCall(memRecInfo.getCall());
			orderFormShow.setPhone(memRecInfo.getPhone());
			orderFormShow.setPostCode(memRecInfo.getPostCode());
			orderFormShow.setMemberId(bean.getMemberId());
			orderFormShow.setProPrice(showBase.getBabyPrice());

			orderFormShow.setPayState(PayStateDesc.未支付.getValue());//支付状态
			//获取配送方式价格
			TbDeliveryWay deliveryWay=deliveryWayMapper.selectByPrimaryKey(bean.getDeliveryId());
			if(CommonUtil.isNull(deliveryWay)){
				throw new NoExistsException("没有该配送方式或者该配送方式已经停止使用,请联系客服.");
			}
			orderFormShow.setDeliveryId(bean.getDeliveryId());
			orderFormShow.setDeliveryCost(0L);//运费
			orderFormShow.setAmountPay(orderFormShow.getProPrice() + orderFormShow.getDeliveryCost());//订单总金额
			orderFormShow.setAmountPaid(0l);//已支付：0
			orderFormShow.setDeliveryStatus(DeliveryStatusDesc.未配送.getValue());//配送状态
			orderFormShow.setDealStatus(OrderDealStatusDesc.待审核.getValue());
			orderFormShow.setOrderNo(CommonUtil.getOrderNo(orderFormShow.getOrderTypeStr(),0, bean.getMemberId()));//订单号设置
			orderFormShow.setPayWayId(bean.getPayWayId());
			orderFormShow.setEmail(bean.getEmail());
			orderFormShow.setSendDate(bean.getSendDate());
			orderFormShow.setVoteTitle(bean.getVoteTitle());
			orderFormShow.setVoteCompany(bean.getVoteCompany());
			orderFormShow.setVoteContent(bean.getVoteContent());
			orderFormShow.setLeaveMessage(bean.getLeaveMessage());
			orderFormShow.setShowId(showBase.getId());
			
			//订单入库
			CommonUtil.formartInsertEnntity(orderFormShow);
			orderFormShow.setState(StateDesc.正常.getValue());
			orderFormShowMapper.insertSelective(orderFormShow);
			if(orderFormShow.getId() > 0){
				//入库成功,添加详细信息并且更新商品库存
//				TbShowBase upShowBase = new TbShowBase();
//				upShowBase.setId(showBase.getId());
//				showBaseMapper.updateByPrimaryKeySelective(upShowBase);

				TbOrderOperaRecord orderOperaRecord = new TbOrderOperaRecord();
				String memo = "";
				if(CommonUtil.isNotNull(bean.getAdmUserId())){
					orderOperaRecord.setAdmUserId(bean.getAdmUserId());
					memo = "后台用户[admUserId="+bean.getAdmUserId()+"]创建订单.";
				}else{
					orderOperaRecord.setMemberId(bean.getMemberId());
					memo = "前台用户[memberId="+bean.getMemberId()+"]创建订单.";
				}
				orderOperaRecord.setField01("amount_pay");
				orderOperaRecord.setValue01(String.valueOf(orderFormShow.getAmountPay()));
				orderOperaRecord.setField02("member_id");
				orderOperaRecord.setValue02(String.valueOf(orderFormShow.getMemberId()));
				orderOperaRecord.setIp(bean.getReqIp());
				orderOperaRecord.setCreateDate(orderFormShow.getCreateDate());
				orderOperaRecord.setState(StateDesc.正常.getValue());
				orderOperaRecord.setDeltag(DelTagDesc.正常.getValue());
				orderOperaRecord.setOrderId(orderFormShow.getId());
				orderOperaRecord.setType(OrderOperaTypeDesc.创建订单.getValue());
				orderOperaRecord.setRelationId(orderFormShow.getId());
				orderOperaRecord.setMemo(memo);
				orderOperaRecord.setContent(JSON.toJSONString(orderFormShow));
				orderOperaRecordMapper.insertSelective(orderOperaRecord);
				return true;
			}
		}
		return false;
	}
	@Transactional(propagation=Propagation.NESTED,rollbackForClassName={"CustomerException","Exception"})
	@Override
	public void saveExpress(TqSaveOrderExpress bean)throws Exception{
		TbOrderFormShow order =orderFormShowMapper.selectByPrimaryKey(bean.getOrderId());
		if(CommonUtil.isNull(order)){
			throw new NoExistsException("订单不存在");
		}
		if(!CommonUtil.isEqual(bean.getMemberId(),order.getMemberId())){
			throw new CustomerException("订单不属于您",ResultStatus.数据状态不正确);
		}
		if(!CommonUtil.isEqual(order.getDealStatus(),OrderDealStatusDesc.寄回中.getValue())){
			throw new CustomerException("只有寄回中的订单才可以保存快递信息",ResultStatus.数据状态不正确);
		}
		if(StringUtil.isNotEmpty(order.getExpressNo())){
			throw new DuplicateDataException("快递信息已保存，请勿再保存");
		}
		TbOrderFormShow upOrder = new TbOrderFormShow();
		upOrder.setId(order.getId());
		upOrder.setUpdateDate(new Date());
		upOrder.setExpressNo(bean.getExpressNo());
		upOrder.setDeliveryName(bean.getDeliveryName());
		orderFormShowMapper.updateByPrimaryKeySelective(upOrder);
	}
	private static final Object updateOrderSyn = new Object();
	@Override
	@Transactional(propagation=Propagation.NESTED,rollbackForClassName={"CustomerException","Exception"})
	public int update(TsOrderFormShow bean)throws Exception{
		Date now = new Date();
		bean.getEntity().setUpdateDate(now);
		//审核通过，给分润会员加上5%平台出的奖励
		String specialMemberIds = dictionaryCache.getValue(DictionaryKey.Keys.模特入驻费用.getValue());
		synchronized (updateOrderSyn) {
			//
			TbOrderFormShow orderFormShow = orderFormShowMapper.selectByPrimaryKey(bean.getEntity().getId());
			TbShowBase showBase = showBaseMapper.selectByPrimaryKey(orderFormShow.getShowId());
			if (!CommonUtil.isEqual(bean.getFromShowOwnerId(), showBase.getMemberId())) {
				throw new CustomerException("订单不属于您", ResultStatus.数据状态不正确);
			}
			//不是待审核订单 且来审核
			if
					(!CommonUtil.isEqual(OrderDealStatusDesc.待审核.getValue(), orderFormShow.getDealStatus())//不是待审核订单
					&& (
					CommonUtil.isEqual(OrderDealStatusDesc.进行中.getValue(), bean.getEntity().getDealStatus())
							||
							CommonUtil.isEqual(OrderDealStatusDesc.已作废.getValue(), bean.getEntity().getDealStatus())
			)
					) {
				throw new CustomerException("该订单已审核！", ResultStatus.数据状态不正确);
			}
			//商家审核模特任务订单为进行中
			if (CommonUtil.isEqual(OrderDealStatusDesc.进行中.getValue(), bean.getEntity().getDealStatus())) {
				//
				showBase.setSurplusNumber(showBase.getSurplusNumber() + 1);
				if(showBase.getSurplusNumber() > showBase.getExperiNumber()){
					throw new CustomerException("该体验秀最多可以有"+showBase.getExperiNumber()+"个模特可以进行体验！", ResultStatus.数据状态不正确);
				}
				if(showBase.getId() <=480 && showBase.getId() > 422){
					String memo = "商家审核发布通过：" + showBase.getId();
					memLocalAccountAdapter.availableOut(showBase.getMemberId(), showBase.getServicePrice()+showBase.getModelReward(), FundsTypeDesc.审核发布体验秀通过, memo, PlatformDesc.支付宝.getValue(), showBase.getId(), now);
				}
				showBaseMapper.updateByPrimaryKeySelective(showBase);
			}
			TbMemBase memBase = memBaseMapper.selectByPrimaryKey(orderFormShow.getMemberId());
			TbMemBase showUser = memBaseMapper.selectByPrimaryKey(showBase.getMemberId());
			if (CommonUtil.isEqual(OrderDealStatusDesc.已结束.getValue(), bean.getEntity().getDealStatus())) {
				//防止多次
				if(!CommonUtil.isEqual(OrderDealStatusDesc.寄回中.getValue(),orderFormShow.getDealStatus())){
					throw new CustomerException("只有机会中的才可以结束！", ResultStatus.数据状态不正确);
				}
				if (memBase.getParentId() != null && CommonUtil.inStr(specialMemberIds, String.valueOf(memBase.getParentId()), ',')) {
					//分润
					FundsTypeDesc fundsType = FundsTypeDesc.模特推荐人享受分润提成;
					String memo = "模特推荐人享受分润提成";
					Double commissionPercent = Double.valueOf(dictionaryCache.getValue(DictionaryKey.Keys.提分润会员提成点.getValue()));
					if(commissionPercent > 0D && commissionPercent < 1D) {
						Long amount = NumberUtil.half_even_up(commissionPercent * showBase.getModelReward());
						memLocalAccountAdapter.availableIn(memBase.getParentId(), amount, fundsType, memo, PlatformDesc.银行.getValue(), showBase.getId(), now);
					}
				}

				//结束了给商家推荐人奖励

				//商家邀请奖励9032提成
				if(showUser.getParentId()!=null &&
						(showUser.getParentId()==9032
								||showUser.getParentId()==10082
								|| showUser.getParentId()==8904
								||showUser.getParentId()==9906
								||showUser.getParentId()==10992
						)){
					//10992=30%
					long rate= 5L;
					if(showUser.getParentId()==10992){
						rate = 30L;
					}
					long a= 100L;
					long memamount=(showBase.getModelAreaPrice()+showBase.getAddValuePrice()+showBase.getNaughtyPrice()+showBase.getServicePrice())*rate/a ;
					String mem = "好友:"+showUser.getId()+"发布体验秀：" +showBase.getId()+ ",奖励金额："+NumberUtil.respScale2MDownYuanByCent(memamount);
					memLocalAccountAdapter.availableIn(showUser.getParentId(),memamount,FundsTypeDesc.推荐人发布奖励,mem,PlatformDesc.支付宝.getValue(),showBase.getId(),new Date());
				}

				//结束了给模特佣金：系统给（因为在发布的时候已经扣钱了）
				Long amount = orderFormShow.getAmountPay();
				if (amount > showBase.getModelReward()) {
					amount = showBase.getModelReward();
				}
				bean.getEntity().setPayState(PayStateDesc.已支付.getValue());
				bean.getEntity().setAmountPaid(amount);
				if (amount > 0) {
					memLocalAccountAdapter.availableIn(memBase.getId(), amount, FundsTypeDesc.佣金获利, "任务完成奖励佣金", PlatformDesc.银行.getValue(), showBase.getId(), now);
				}
				//结束了给模特返还本金：
				if(orderFormShow.getId() > 123){
					memLocalAccountAdapter.availableIn(memBase.getId(), orderFormShow.getProPrice(), FundsTypeDesc.产品本金返还, "任务完成奖励佣金", PlatformDesc.银行.getValue(), showBase.getId(), now);
				}

			}
			int res = orderFormShowMapper.updateByPrimaryKeySelective(bean.getEntity());


			return res;
		}
	}

}