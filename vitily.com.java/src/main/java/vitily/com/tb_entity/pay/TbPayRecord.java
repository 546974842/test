package vitily.com.tb_entity.pay;

import vitily.base.tb_entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:tb_pay_record表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-05-19
 */
public class TbPayRecord extends BaseEntity {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 订单id
     */
    private Integer orderId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 应支付金额
     */
    private Long payAmount;

    /**
     * 支付状态
     */
    private String payState;

    /**
     * 支付方式
     */
    private Integer payment;

    /**
     * 接收时间
     */
    private Date receivedTime;

    /**
     * 描述
     */
    private String desc;

    /**
     * 已支付金额
     */
    private Long paidAmount;

    /**
     * 支付号码
     */
    private String payId;

    /**
     * 通知url
     */
    private String notifyUrl;

    /**
     * 其他0
     */
    private String other0;

    /**
     * 
     */
    private String other1;

    /**
     * 
     */
    private String other2;

    /**
     * 
     */
    private String other3;

    /**
     * 
     */
    private String other4;

    /**
     * 订单id
     * [whh]@return orderId 订单id
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     * 订单id
     * @param orderId 订单id
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     * 订单号
     * [whh]@return orderNo 订单号
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
     * 应支付金额
     * [whh]@return payAmount 应支付金额
     */
    public Long getPayAmount() {
        return payAmount;
    }

    /**
     * 应支付金额
     * @param payAmount 应支付金额
     */
    public void setPayAmount(Long payAmount) {
        this.payAmount = payAmount;
    }

    /**
     * 支付状态
     * [whh]@return payState 支付状态
     */
    public String getPayState() {
        return payState;
    }

    /**
     * 支付状态
     * @param payState 支付状态
     */
    public void setPayState(String payState) {
        this.payState = payState;
    }

    /**
     * 支付方式
     * [whh]@return payment 支付方式
     */
    public Integer getPayment() {
        return payment;
    }

    /**
     * 支付方式
     * @param payment 支付方式
     */
    public void setPayment(Integer payment) {
        this.payment = payment;
    }

    /**
     * 接收时间
     * [whh]@return receivedTime 接收时间
     */
    public Date getReceivedTime() {
        return receivedTime;
    }

    /**
     * 接收时间
     * @param receivedTime 接收时间
     */
    public void setReceivedTime(Date receivedTime) {
        this.receivedTime = receivedTime;
    }

    /**
     * 描述
     * [whh]@return desc 描述
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 描述
     * @param desc 描述
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }

    /**
     * 已支付金额
     * [whh]@return paidAmount 已支付金额
     */
    public Long getPaidAmount() {
        return paidAmount;
    }

    /**
     * 已支付金额
     * @param paidAmount 已支付金额
     */
    public void setPaidAmount(Long paidAmount) {
        this.paidAmount = paidAmount;
    }

    /**
     * 支付号码
     * [whh]@return payId 支付号码
     */
    public String getPayId() {
        return payId;
    }

    /**
     * 支付号码
     * @param payId 支付号码
     */
    public void setPayId(String payId) {
        this.payId = payId;
    }

    /**
     * 通知url
     * [whh]@return notifyUrl 通知url
     */
    public String getNotifyUrl() {
        return notifyUrl;
    }

    /**
     * 通知url
     * @param notifyUrl 通知url
     */
    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    /**
     * 其他0
     * [whh]@return other0 其他0
     */
    public String getOther0() {
        return other0;
    }

    /**
     * 其他0
     * @param other0 其他0
     */
    public void setOther0(String other0) {
        this.other0 = other0;
    }

    /**
     * 
     * [whh]@return other1 
     */
    public String getOther1() {
        return other1;
    }

    /**
     * 
     * @param other1 
     */
    public void setOther1(String other1) {
        this.other1 = other1;
    }

    /**
     * 
     * [whh]@return other2 
     */
    public String getOther2() {
        return other2;
    }

    /**
     * 
     * @param other2 
     */
    public void setOther2(String other2) {
        this.other2 = other2;
    }

    /**
     * 
     * [whh]@return other3 
     */
    public String getOther3() {
        return other3;
    }

    /**
     * 
     * @param other3 
     */
    public void setOther3(String other3) {
        this.other3 = other3;
    }

    /**
     * 
     * [whh]@return other4 
     */
    public String getOther4() {
        return other4;
    }

    /**
     * 
     * @param other4 
     */
    public void setOther4(String other4) {
        this.other4 = other4;
    }
}