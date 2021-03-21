package vitily.com.service.order.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import vitily.com.api_entity.req_entity.mem.TqAuditOrderComment;
import vitily.com.consts.*;
import vitily.com.mapper.order.OrderCommentMapper;
import vitily.com.mapper.order.OrderFormShowMapper;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.DuplicateDataException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.service.base.impl.BasicServiceImpl;
import vitily.com.service.order.OrderCommentService;
import vitily.com.tb_entity.order.TbOrderComment;
import vitily.com.tb_entity.order.TbOrderFormShow;
import vitily.com.ts_entity.order.TsOrderComment;
import vitily.com.tv_entity.order.TvOrderComment;
import vitily.com.util.CommonUtil;

import java.util.Date;

@Component
public class OrderCommentServiceImpl extends BasicServiceImpl<TbOrderComment, TsOrderComment, TvOrderComment> implements OrderCommentService {

    private final OrderCommentMapper orderCommentMapper;
    @Autowired
    OrderFormShowMapper orderFormShowMapper;
    @Autowired
    public OrderCommentServiceImpl(OrderCommentMapper orderCommentMapper) {
        this.orderCommentMapper = orderCommentMapper;
        super.setBaseMapper(orderCommentMapper);
    }

    /**
     * 保存评论
     * @param entity
     * @throws Exception
     */
    @Override
    public void saveComment(TbOrderComment entity)throws Exception{

        TbOrderFormShow orderFormShow = orderFormShowMapper.selectByPrimaryKey(entity.getOrderId());
        if(CommonUtil.isNull(orderFormShow) || !CommonUtil.isEqual(orderFormShow.getMemberId(),entity.getMemberId())){
            throw new CustomerException("该订单不存在！", ResultStatus.操作异常);
        }
        if(!CommonUtil.isEqual(OrderDealShowStatusDesc.进行中.getValue(),orderFormShow.getDealStatus())){
            throw new CustomerException("只有进行中的订单才可以进行评论！",ResultStatus.数据状态不正确);
        }
        orderFormShow.setDealStatus(OrderDealStatusDesc.待商家审核评论.getValue());
        orderFormShowMapper.updateByPrimaryKey(orderFormShow);
        TsOrderComment tsOrderComment = new TsOrderComment();
        tsOrderComment.getEntity().setOrderId(orderFormShow.getId());
        tsOrderComment.getEntity().setMemberId(entity.getMemberId());
        tsOrderComment.getEntity().setType(entity.getType());
        tsOrderComment.setStateStr(CommonAuditStateDesc.未审核.getValue()+","+CommonAuditStateDesc.审核通过.getValue());
        TbOrderComment orderComment = orderCommentMapper.selectSingleByBean(tsOrderComment);
        if(null != orderComment){
            throw new DuplicateDataException("已经发表过评论，无法再进行评论！");
        }
        entity.setDeltag(DelTagDesc.正常.getValue());
        entity.setCreateDate(new Date());
        entity.setState(CommonAuditStateDesc.未审核.getValue());
        entity.setShowId(orderFormShow.getShowId());
        orderCommentMapper.insertSelective(entity);
    }

    /**
     * 审核订单评论
     * @param bean
     * @throws Exception
     */
    @Override
    public void auditComment(TqAuditOrderComment bean)throws Exception{
        TvOrderComment orderComment = orderCommentMapper.selectByPrimaryKeyForTv(bean.getOrderCommentId());
        if(null == orderComment || !CommonUtil.isEqual(bean.getMemberId(),orderComment.getShowOwnerMemberId())){
            throw new NoExistsException("评论不存在或者不属于你的评论！");
        }
        if(!CommonUtil.isEqual(orderComment.getState(),CommonAuditStateDesc.未审核.getValue())){
            throw new CustomerException("只有未审核的评论才可以审核！",ResultStatus.数据状态不正确);
        }
        TbOrderFormShow orderFormShow = new TbOrderFormShow();
        orderFormShow.setId(orderComment.getOrderId());
        //审核通过
        if(CommonUtil.isEqual(CommonAuditStateDesc.审核通过.getValue(),bean.getResult())){
            orderFormShow.setDealStatus(OrderDealStatusDesc.寄回中.getValue());
        }else{
            //审核不成功，改成进行中
            orderFormShow.setDealStatus(OrderDealStatusDesc.进行中.getValue());
        }
        orderFormShowMapper.updateByPrimaryKeySelective(orderFormShow);

        TbOrderComment upComment = new TbOrderComment();
        upComment.setState(bean.getResult());
        upComment.setUpdateDate(new Date());
        upComment.setAuditDescription(bean.getAuditDescription());
        upComment.setId(bean.getOrderCommentId());
        orderCommentMapper.updateByPrimaryKeySelective(upComment);
    }
}