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
import vitily.com.consts.*;
import vitily.com.mapper.mem.MemRecInfoMapper;
import vitily.com.mapper.order.OrderOperaRecordMapper;
import vitily.com.tb_entity.comm.TbDeliveryWay;
import vitily.com.tb_entity.order.TbOrderForm;
import vitily.com.tb_entity.order.TbOrderOperaRecord;
import vitily.com.tb_entity.pro.TbProBase;
import vitily.com.mapper.comm.DeliveryWayMapper;
import vitily.com.mapper.order.OrderDetailMapper;
import vitily.com.mapper.order.OrderFormMapper;
import vitily.com.mapper.pro.ProBaseMapper;
import vitily.com.mapper.pro.ProSpValMapper;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.order.OrderFormService;
import vitily.com.ts_entity.order.TsOrderForm;
import vitily.com.ts_entity.pro.TsProBase;
import vitily.com.ts_entity.pro.TsProSpVal;
import vitily.com.tv_entity.mem.TvMemRecInfo;
import vitily.com.tv_entity.order.TvOrderDetail;
import vitily.com.tv_entity.order.TvOrderForm;
import vitily.com.tv_entity.pro.TvProSpVal;
import vitily.com.util.CommonUtil;

@Component
public class OrderFormServiceImpl extends BasicServiceImpl<TbOrderForm,TsOrderForm,TvOrderForm> implements OrderFormService {
	public static final Object orderLockObject=new Object();//并发控制

	final
    OrderFormMapper orderFormMapper;
	final
    ProBaseMapper proBaseMapper;
	final
    ProSpValMapper proSpValMapper;
	final
    OrderDetailMapper orderDetailMapper;
	final DeliveryWayMapper deliveryWayMapper;
	final MemRecInfoMapper memRecInfoMapper;
	final OrderOperaRecordMapper orderOperaRecordMapper;

	@Autowired()
	public OrderFormServiceImpl(OrderFormMapper orderFormMapper,
								ProBaseMapper proBaseMapper,
								ProSpValMapper proSpValMapper,
								OrderDetailMapper orderDetailMapper,
								DeliveryWayMapper deliveryWayMapper,
								MemRecInfoMapper memRecInfoMapper,
								OrderOperaRecordMapper orderOperaRecordMapper) {
		this.orderFormMapper = orderFormMapper;
		this.proBaseMapper = proBaseMapper;
		this.proSpValMapper = proSpValMapper;
		this.orderDetailMapper = orderDetailMapper;
		this.deliveryWayMapper = deliveryWayMapper;
		this.memRecInfoMapper = memRecInfoMapper;
		this.orderOperaRecordMapper = orderOperaRecordMapper;
		super.setBaseMapper(orderFormMapper);
	}
	/**
	 * 插入订单 ：
	 * 从购物车中获取产品信息，并且从数据库中查询相关的商品价格库存等
	 * @param entity 1
	 * @throws Exception 2
	 */
	@Transactional(propagation=Propagation.NESTED,rollbackForClassName={"CustomerException","Exception"})
	public boolean placeOrder(TqPlaceOrder bean)throws Exception{
		synchronized (orderLockObject) {
			List<TvOrderDetail> orderDetails = new ArrayList <>();
			TbOrderForm orderForm = new TbOrderForm();
			orderForm.setOrderDate(new Date());
			//设置收货人
			TvMemRecInfo memRecInfo=memRecInfoMapper.selectByPrimaryKeyForTv(bean.getMemRecInfoId());
			if(CommonUtil.isNull(memRecInfo) || !CommonUtil.isEqual(bean.getMemberId(), memRecInfo.getMemberId())){
				throw new CustomerException("收货人信息不存在.", ResultStatus.查询不存在);
			}

			orderForm.setReceiver(memRecInfo.getReceiver());
			orderForm.setArea(memRecInfo.getProvince()+"."+memRecInfo.getCity()+"."+memRecInfo.getArea());
			orderForm.setAddress(memRecInfo.getAddress());
			orderForm.setPostCode(memRecInfo.getPhone());
			orderForm.setCall(memRecInfo.getCall());
			orderForm.setPhone(memRecInfo.getPhone());
			orderForm.setPostCode(memRecInfo.getPostCode());
			orderForm.setMemberId(bean.getMemberId());
			orderForm.setProPrice(0L);
			//订单信息并检查
			for(TqOrderDetail detail:bean.getDetails()){
				TvOrderDetail orderDetail = new TvOrderDetail();
				orderDetail.setPurchaseQuantity(detail.getPurchaseQuantity());
				orderDetail.setProductId(detail.getProductId());
				orderDetail.setProSpId(detail.getProSpId());
				//获取商品价格
				//非规格商品：从商品里表里获取
				if(CommonUtil.isNull(detail.getProSpId())){
					TbProBase product=proBaseMapper.selectByPrimaryKey(detail.getProductId());
					if(CommonUtil.isNull(product) || !CommonUtil.isEqual(product.getDeltag(),DelTagDesc.正常.getValue())){
						throw new NoExistsException("购买的商品不存在.");
					}
					orderDetail.setProStock(product.getStock());
					orderDetail.setProVersion(product.getVersion());
					orderDetail.setProPrice(product.getSalePrice());//产品单价
					orderDetail.setProPicList(product.getPicList());//图片
					orderDetail.setProName(product.getName()+"(编号:"+product.getNumber()+")");//产品描述
					orderDetail.setProNumber(product.getNumber());
					if(!CommonUtil.isEqual(StateDesc.正常.getValue(), product.getState())){
						throw new NoExistsException("商品["+orderDetail.getProName()+"]已下架.");
					}
				}else{
					TvProSpVal product=proSpValMapper.selectByPrimaryKeyForTv(orderDetail.getProSpId());
					if(CommonUtil.isNull(product) || !CommonUtil.isEqual(product.getDeltag(),DelTagDesc.正常.getValue())){
						throw new NoExistsException("购买的商品不存在.");
					}
					orderDetail.setProName(product.getProductName()+"(编号:"+product.getNumber()+","+product.getSpecParVals()+")");//产品描述
					if(!CommonUtil.isEqual(StateDesc.正常.getValue(), product.getState())){
						throw new NoExistsException("商品["+orderDetail.getProName()+"]已下架.");
					}
					orderDetail.setProStock(product.getStock());
					orderDetail.setProVersion(product.getVersion());
					orderDetail.setProPrice(product.getSalePrice());
					orderDetail.setProNumber(product.getNumber());
				}
				if(CommonUtil.isNull(orderDetail.getPurchaseQuantity()) || orderDetail.getProStock() < orderDetail.getPurchaseQuantity()){
					throw new CustomerException("购买的商品["+orderDetail.getProName()+"]库存不足.", ResultStatus.其他);
				}
				//商品价格
				orderForm.setProPrice(orderForm.getProPrice() + orderDetail.getProPrice() * orderDetail.getPurchaseQuantity());
				orderDetails.add(orderDetail);
				
			}
			orderForm.setPayState(PayStateDesc.未支付.getValue());//支付状态
			//获取配送方式价格
			TbDeliveryWay deliveryWay=deliveryWayMapper.selectByPrimaryKey(bean.getDeliveryId());
			if(CommonUtil.isNull(deliveryWay)){
				throw new NoExistsException("没有该配送方式或者该配送方式已经停止使用,请联系客服.");
			}
			orderForm.setDeliveryId(bean.getDeliveryId());
			orderForm.setDeliveryCost(deliveryWay.getPrice());//运费
			orderForm.setAmountPay(orderForm.getProPrice() + orderForm.getDeliveryCost());//订单总金额
			orderForm.setAmountPaid(0l);//已支付：0
			orderForm.setDeliveryStatus(DeliveryStatusDesc.未配送.getValue());//配送状态
			orderForm.setDealStatus(OrderDealStatusDesc.未处理.getValue());
			orderForm.setOrderNo(CommonUtil.getOrderNo(orderForm.getOrderTypeStr(),0, bean.getMemberId()));//订单号设置
			orderForm.setPayWayId(bean.getPayWayId());
			orderForm.setEmail(bean.getEmail());
			orderForm.setSendDate(bean.getSendDate());
			orderForm.setVoteTitle(bean.getVoteTitle());
			orderForm.setVoteCompany(bean.getVoteCompany());
			orderForm.setVoteContent(bean.getVoteContent());
			orderForm.setLeaveMessage(bean.getLeaveMessage());
			
			//订单入库
			CommonUtil.formartInsertEnntity(orderForm);
			orderForm.setState(StateDesc.正常.getValue());
			orderFormMapper.insertSelective(orderForm);
			if(orderForm.getId() > 0){
				//入库成功,添加详细信息并且更新商品库存
				for(TvOrderDetail orderDetail:orderDetails){
					orderDetail.setOrderId(orderForm.getId());
					orderDetail.setCreateDate(new Date());
					orderDetail.setDeltag(DelTagDesc.正常.getValue());
					orderDetail.setState(StateDesc.正常.getValue());
					orderDetailMapper.insertSelective(orderDetail);
					//更新商品库存以及版本号
					if(CommonUtil.isNull(orderDetail.getProSpId())){
						//更新普通商品
						TsProBase product=new TsProBase();
						product.getEntity().setDeltag(null);
						product.getEntity().setState(null);
						product.getEntity().setStock(orderDetail.getProStock()-orderDetail.getPurchaseQuantity());
						product.getEntity().setVersion(orderDetail.getProVersion() + 1);
						product.setOldVersion(orderDetail.getProVersion());
						product.getEntity().setId(orderDetail.getProductId());
						proBaseMapper.updateByBean(product);
					}else{
						//更新规格商品
						TsProSpVal product=new TsProSpVal();
						product.getEntity().setDeltag(null);
						product.getEntity().setState(null);
						product.getEntity().setStock(orderDetail.getProStock()-orderDetail.getPurchaseQuantity());
						product.getEntity().setVersion(orderDetail.getProVersion() + 1);
						product.setOldVersion(orderDetail.getProVersion());
						product.getEntity().setId(orderDetail.getProSpId());
						proSpValMapper.updateByBean(product);
					}
				}
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
				orderOperaRecord.setValue01(String.valueOf(orderForm.getAmountPay()));
				orderOperaRecord.setField02("member_id");
				orderOperaRecord.setValue02(String.valueOf(orderForm.getMemberId()));
				orderOperaRecord.setIp(bean.getReqIp());
				orderOperaRecord.setCreateDate(orderForm.getCreateDate());
				orderOperaRecord.setState(StateDesc.正常.getValue());
				orderOperaRecord.setDeltag(DelTagDesc.正常.getValue());
				orderOperaRecord.setOrderId(orderForm.getId());
				orderOperaRecord.setType(OrderOperaTypeDesc.创建订单.getValue());
				orderOperaRecord.setRelationId(orderForm.getId());
				orderOperaRecord.setMemo(memo);
				orderOperaRecord.setContent(JSON.toJSONString(orderForm));
				orderOperaRecordMapper.insertSelective(orderOperaRecord);
				return true;
			}
		}
		return false;
	}
}