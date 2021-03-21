package vitily.com.service.show.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.consts.*;
import vitily.com.mapper.order.OrderFormShowMapper;
import vitily.com.mapper.show.ShowBaseMapper;
import vitily.com.mapper.show.ShowTimeMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.show.ShowBaseService;
import vitily.com.service_adapter.MemLocalAccountAdapter;
import vitily.com.tb_entity.show.TbShowBase;
import vitily.com.ts_entity.show.TsShowBase;
import vitily.com.ts_entity.show.TsShowTime;
import vitily.com.tv_entity.show.TvShowBase;
import vitily.com.tv_entity.show.TvShowTime;
import vitily.com.util.CommonUtil;

import java.util.Date;
import java.util.List;

@Component
public class ShowBaseServiceImpl extends BasicServiceImpl<TbShowBase,TsShowBase,TvShowBase> implements ShowBaseService {

	final
	ShowBaseMapper showBaseMapper;
	final ShowTimeMapper showTimeMapper;

	@Autowired
	OrderFormShowMapper orderFormShowMapper;
	@Autowired
	MemLocalAccountAdapter memLocalAccountAdapter;

	@Autowired()
	public ShowBaseServiceImpl(ShowBaseMapper showBaseMapper, ShowTimeMapper showTimeMapper) {
		this.showBaseMapper = showBaseMapper;
		this.showTimeMapper = showTimeMapper;
		super.setBaseMapper(showBaseMapper);
	}
	@Override
	public TvShowBase selectByPrimaryKeyForTv(int id)throws Exception{
		TvShowBase v = showBaseMapper.selectByPrimaryKeyForTv(id);
		CommonUtil.checkIsNullEntity(v);
		TsShowTime tsShowTime = new TsShowTime();
		tsShowTime.getEntity().setShowId(id);
		List<TvShowTime> showTimes = (List<TvShowTime>)showTimeMapper.getListByBean(tsShowTime);
		if(showTimes.size() > 0){
			v.setShowTime(showTimes.get(0));
		}
		return v;
	}

	/**
	 * 取消体验秀
	 * 1、任务发布暂时没有模特领取的，可以取消
	 * 2、任务发布已经被模特领取的不可取消
	 * 3、模特领取完任务超过任务要求下单时间未下单的，商家提交平台取消任务
	 * 4、发布任务信息填写错误的暂时还没有模特领取的可以取消
	 * @param showId
	 * @param memberId
	 * @throws Exception
	 */
	@Override
	public void appCancelShowInfo(Integer showId,Integer memberId)throws Exception {
		TbShowBase showBase = showBaseMapper.selectByPrimaryKey(showId);
		if (showBase == null) {
			return;
		}
		if (!CommonUtil.isEqual(memberId, showBase.getMemberId())) {
			throw new CustomerException("该体验秀不属于你", ResultStatus.数据状态不正确);
		}
		TbShowBase upShow = new TbShowBase();
		upShow.setId(showId);
		upShow.setUpdateDate(new Date());
		//未审核直接返回
		if(CommonUtil.isEqual(showBase.getState(),ShowStateDesc.未审核.getValue())){
			upShow.setState(ShowStateDesc.已取消.getValue());
			showBaseMapper.updateByPrimaryKeySelective(upShow);
			return;
		}
		if(!CommonUtil.isEqual(showBase.getState(),ShowStateDesc.审核通过.getValue())){
			throw new CustomerException("只有审核通过的才可以进行取消", ResultStatus.数据状态不正确);
		}
		upShow.setState(ShowStateDesc.申请取消中.getValue());
		showBaseMapper.updateByPrimaryKeySelective(upShow);

//		TsOrderFormShow queryOrder = new TsOrderFormShow();
//		queryOrder.getEntity().setShowId(showId);
//		//1 4 可以取消
//		int hasOrder = orderFormShowMapper.getCountPaging(queryOrder);
//		Date now = new Date();
//		if(hasOrder == 0){
//			upShow.setState(ShowStateDesc.申请取消中.getValue());
//			showBaseMapper.updateByPrimaryKeySelective(upShow);
//			//取消后返还相应手续费给商家
//			//memLocalAccountAdapter.freezeIn(showBase.getMemberId(), showBase.getTotalPayAmount(), FundsTypeDesc.取消任务返还金额, "取消任务返还金额", PlatformDesc.银行.getValue(), showBase.getId(), now);
//
//			return;
//		}
//		//2 3 申请取消
////		进行中(67,"进行中"),
////		已结束(68,"已结束"),
////		寄回中(69,"寄回中"),
////		待商家审核评论(70,"待商家审核评论"),
//		List<Integer> status = new ArrayList<>();
//		status.add(OrderDealStatusDesc.进行中.getValue());
//		status.add(OrderDealStatusDesc.寄回中.getValue());
//		status.add(OrderDealStatusDesc.待商家审核评论.getValue());
//		queryOrder.setStates(status);
//		hasOrder = orderFormShowMapper.getCountPaging(queryOrder);
//		if(hasOrder == 0){
//			upShow.setState(ShowStateDesc.已取消.getValue());
//			showBaseMapper.updateByPrimaryKeySelective(upShow);
//		}else{
//			upShow.setState(ShowStateDesc.申请取消中.getValue());
//			showBaseMapper.updateByPrimaryKeySelective(upShow);
//		}

	}
}
