package vitily.com.tb_entity.pay;

import vitily.base.tb_entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:tb_order_dropout表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-05-19
 */
public class TbOrderDropout extends BaseEntity {

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
     * 掉单金额
     */
    private Long dropAmount;

    /**
     * 是否已处理(0)
     */
    private Integer dealed;

    /**
     * 处理人
     */
    private String handler;

    /**
     * 处理时间
     */
    private Date dealTime;

    /**
     * 接收信息
     */
    private String receivedMsg;
    
    /**
     * 支付方式
     */
    private Integer payment;

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
     * 掉单金额
     * [whh]@return dropAmount 掉单金额
     */
    public Long getDropAmount() {
        return dropAmount;
    }

    /**
     * 掉单金额
     * @param dropAmount 掉单金额
     */
    public void setDropAmount(Long dropAmount) {
        this.dropAmount = dropAmount;
    }

    /**
     * 是否已处理(0)
     * [whh]@return dealed 是否已处理(0)
     */
    public Integer getDealed() {
        return dealed;
    }

    /**
     * 是否已处理(0)
     * @param dealed 是否已处理(0)
     */
    public void setDealed(Integer dealed) {
        this.dealed = dealed;
    }

    /**
     * 处理人
     * [whh]@return handler 处理人
     */
    public String getHandler() {
        return handler;
    }

    /**
     * 处理人
     * @param handler 处理人
     */
    public void setHandler(String handler) {
        this.handler = handler;
    }

    /**
     * 处理时间
     * [whh]@return dealTime 处理时间
     */
    public Date getDealTime() {
        return dealTime;
    }

    /**
     * 处理时间
     * @param dealTime 处理时间
     */
    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }

    /**
     * 接收信息
     * [whh]@return receivedMsg 接收信息
     */
    public String getReceivedMsg() {
        return receivedMsg;
    }

    /**
     * 接收信息
     * @param receivedMsg 接收信息
     */
    public void setReceivedMsg(String receivedMsg) {
        this.receivedMsg = receivedMsg;
    }

    /**
     * 支付方式
     * @return 支付方式
     */
	public Integer getPayment() {
		return payment;
	}
	/**
	 *  支付方式
	 * @param payment 支付方式
	 */
	public void setPayment(Integer payment) {
		this.payment = payment;
	}
}