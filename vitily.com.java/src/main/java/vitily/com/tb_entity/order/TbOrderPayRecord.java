package vitily.com.tb_entity.order;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

import java.util.Date;

/**
 * 描述:支付纪录表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbOrderPayRecord extends BaseEntity {
    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 对应订单号
     */
    private Integer orderId;

    /**
     * 支付方式id
     */
    private Integer payWayId;

    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 交易时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date tradingDate;

    /**
     * 交易金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long tradingAmount;

    /**
     * 交易说明
     */
    private String description;
    /**
     * 订单号
     * [whh]@return order_no 订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 订单号
     * @param orderNo 订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    /**
     * 对应订单号
     * [whh]@return order_id 对应订单号
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 对应订单号
     * @param orderId 对应订单号
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 支付方式id
     * [whh]@return pay_way_id 支付方式id
     */
    public Integer getPayWayId() {
        return payWayId;
    }

    /**
     * 支付方式id
     * @param payWayId 支付方式id
     */
    public void setPayWayId(Integer payWayId) {
        this.payWayId = payWayId;
    }

    /**
     * 会员id
     * [whh]@return member_id 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员id
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 交易时间
     * [whh]@return trading_date 交易时间
     */
    public Date getTradingDate() {
        return tradingDate;
    }

    /**
     * 交易时间
     * @param tradingDate 交易时间
     */
    public void setTradingDate(Date tradingDate) {
        this.tradingDate = tradingDate;
    }

    /**
     * 交易金额(单位：分)
     * [whh]@return trading_amount 交易金额(单位：分)
     */
    public Long getTradingAmount() {
        return tradingAmount;
    }

    /**
     * 交易金额(单位：分)
     * @param tradingAmount 交易金额(单位：分)
     */
    public void setTradingAmount(Long tradingAmount) {
        this.tradingAmount = tradingAmount;
    }

    /**
     * 交易说明
     * [whh]@return description 交易说明
     */
    public String getDescription() {
        return description;
    }

    /**
     * 交易说明
     * @param description 交易说明
     */
    public void setDescription(String description) {
        this.description = description;
    }
}