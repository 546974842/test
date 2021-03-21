package vitily.com.tb_entity.pay;

import vitily.base.tb_entity.BaseEntity;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 描述:tb_pay_order表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-05-19
 */
public class TbPayOrder extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 支付方式
     */
    private Integer payment;

    /**
     * 支付的手机号
     */
    private String payMobile;

    /**
     * 实际支付账号(第三方传回)
     */
    private String actualPayUser;

    /**
     * 订单总额
     */
    private Long orderAmount;

    /**
     * 已支付金额
     */
    private Long paidAmount;

    /**
     * 订单支付状态
     */
    private Integer payState;

    /**
     * 订单创建时间
     */
    private Date orderTime;

    /**
     * 最近一次支付时间
     */
    private Date paidTime;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 锁定状态（0:未锁定,1:锁定）
     */
    private Integer lockState;

    /**
     * 发票抬头
     */
    private String invoiceTitle;

    /**
     * 发票内容
     */
    private String invoiceContent;

    /**
     * 发票收货地址
     */
    private String invoiceReceiveAddr;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 发票收货人
     */
    private String invoiceReseiver;

    /**
     * 支付成功通知手机
     */
    private String notifyMobile;

    /**
     * 支付成功通知email
     */
    private String notifyEmail;

    /**
     * 发票状态,0:未发，1:已发
     */
    private Integer invoiceState;

    /**
     * 是否需要发票
     */
    private Integer needInvoice;

    /**
     * 订单描述(后台)
     */
    private String desc;

    /**
     * 其他0
     */
    private String other0;

    /**
     * 其他1
     */
    private String other1;

    /**
     * 其他2
     */
    private String other2;

    /**
     * 其他3
     */
    private String other3;

    /**
     * 其他4
     */
    private String other4;

    /**
     * 其他5
     */
    private String other5;

    /**
     * 其他6
     */
    private String other6;
    /**
     * 支付截止时间
     */
    private Date payDeadline;
    
    /**
     * 订单说明：前台
     */
    private String remark;
    
    /**
     * 发起请求的ip
     */
    private String requestIp;
    
    /**
     * 订单用户
     */
    private String userId;
    
    /**
     * 关联第三方Id
     */
    private String transactionId;
    
    private Date lastWxQrcodeDate;
    
    private Date lastAliQrcodeDate;
    
    private Date lastUnionQrcodeDate;

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
     * 支付的手机号
     * [whh]@return payMobile 支付的手机号
     */
    public String getPayMobile() {
        return payMobile;
    }

    /**
     * 支付的手机号
     * @param payMobile 支付的手机号
     */
    public void setPayMobile(String payMobile) {
        this.payMobile = payMobile;
    }

    /**
     * 实际支付账号(第三方传回)
     * [whh]@return actualPayUser 实际支付账号(第三方传回)
     */
    public String getActualPayUser() {
        return actualPayUser;
    }

    /**
     * 实际支付账号(第三方传回)
     * @param actualPayUser 实际支付账号(第三方传回)
     */
    public void setActualPayUser(String actualPayUser) {
        this.actualPayUser = actualPayUser;
    }

    /**
     * 订单总额
     * [whh]@return orderAmount 订单总额
     */
    public Long getOrderAmount() {
        return orderAmount;
    }

    /**
     * 订单总额
     * @param orderAmount 订单总额
     */
    public void setOrderAmount(Long orderAmount) {
        this.orderAmount = orderAmount;
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
     * 订单支付状态
     * [whh]@return payState 订单支付状态
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 订单支付状态
     * @param payState 订单支付状态
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * 订单创建时间
     * [whh]@return orderTime 订单创建时间
     */
    public Date getOrderTime() {
        return orderTime;
    }

    /**
     * 订单创建时间
     * @param orderTime 订单创建时间
     */
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    /**
     * 最近一次支付时间
     * [whh]@return paidTime 最近一次支付时间
     */
    public Date getPaidTime() {
        return paidTime;
    }

    /**
     * 最近一次支付时间
     * @param paidTime 最近一次支付时间
     */
    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
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
     * 锁定状态（0:未锁定,1:锁定）
     * [whh]@return lockState 锁定状态（0:未锁定,1:锁定）
     */
    public Integer getLockState() {
        return lockState;
    }

    /**
     * 锁定状态（0:未锁定,1:锁定）
     * @param lockState 锁定状态（0:未锁定,1:锁定）
     */
    public void setLockState(Integer lockState) {
        this.lockState = lockState;
    }

    /**
     * 发票抬头
     * [whh]@return invoiceTitle 发票抬头
     */
    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    /**
     * 发票抬头
     * @param invoiceTitle 发票抬头
     */
    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }

    /**
     * 发票内容
     * [whh]@return invoiceContent 发票内容
     */
    public String getInvoiceContent() {
        return invoiceContent;
    }

    /**
     * 发票内容
     * @param invoiceContent 发票内容
     */
    public void setInvoiceContent(String invoiceContent) {
        this.invoiceContent = invoiceContent;
    }

    /**
     * 发票收货地址
     * [whh]@return invoiceReceiveAddr 发票收货地址
     */
    public String getInvoiceReceiveAddr() {
        return invoiceReceiveAddr;
    }

    /**
     * 发票收货地址
     * @param invoiceReceiveAddr 发票收货地址
     */
    public void setInvoiceReceiveAddr(String invoiceReceiveAddr) {
        this.invoiceReceiveAddr = invoiceReceiveAddr;
    }

    /**
     * 邮编
     * [whh]@return postCode 邮编
     */
    public String getPostCode() {
        return postCode;
    }

    /**
     * 邮编
     * @param postCode 邮编
     */
    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    /**
     * 发票收货人
     * [whh]@return invoiceReseiver 发票收货人
     */
    public String getInvoiceReseiver() {
        return invoiceReseiver;
    }

    /**
     * 发票收货人
     * @param invoiceReseiver 发票收货人
     */
    public void setInvoiceReseiver(String invoiceReseiver) {
        this.invoiceReseiver = invoiceReseiver;
    }

    /**
     * 支付成功通知手机
     * [whh]@return notifyMobile 支付成功通知手机
     */
    public String getNotifyMobile() {
        return notifyMobile;
    }

    /**
     * 支付成功通知手机
     * @param notifyMobile 支付成功通知手机
     */
    public void setNotifyMobile(String notifyMobile) {
        this.notifyMobile = notifyMobile;
    }

    /**
     * 支付成功通知email
     * [whh]@return notifyEmail 支付成功通知email
     */
    public String getNotifyEmail() {
        return notifyEmail;
    }

    /**
     * 支付成功通知email
     * @param notifyEmail 支付成功通知email
     */
    public void setNotifyEmail(String notifyEmail) {
        this.notifyEmail = notifyEmail;
    }

    /**
     * 发票状态,0:未发，1:已发
     * [whh]@return invoiceState 发票状态,0:未发，1:已发
     */
    public Integer getInvoiceState() {
        return invoiceState;
    }

    /**
     * 发票状态,0:未发，1:已发
     * @param invoiceState 发票状态,0:未发，1:已发
     */
    public void setInvoiceState(Integer invoiceState) {
        this.invoiceState = invoiceState;
    }

    /**
     * 是否需要发票
     * [whh]@return needInvoice 是否需要发票
     */
    public Integer getNeedInvoice() {
        return needInvoice;
    }

    /**
     * 是否需要发票
     * @param needInvoice 是否需要发票
     */
    public void setNeedInvoice(Integer needInvoice) {
        this.needInvoice = needInvoice;
    }

    /**
     * 订单描述(后台)
     * [whh]@return desc 订单描述(后台)
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 订单描述(后台)
     * @param desc 订单描述(后台)
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
     * 其他1
     * [whh]@return other1 其他1
     */
    public String getOther1() {
        return other1;
    }

    /**
     * 其他1
     * @param other1 其他1
     */
    public void setOther1(String other1) {
        this.other1 = other1;
    }

    /**
     * 其他2
     * [whh]@return other2 其他2
     */
    public String getOther2() {
        return other2;
    }

    /**
     * 其他2
     * @param other2 其他2
     */
    public void setOther2(String other2) {
        this.other2 = other2;
    }

    /**
     * 其他3
     * [whh]@return other3 其他3
     */
    public String getOther3() {
        return other3;
    }

    /**
     * 其他3
     * @param other3 其他3
     */
    public void setOther3(String other3) {
        this.other3 = other3;
    }

    /**
     * 其他4
     * [whh]@return other4 其他4
     */
    public String getOther4() {
        return other4;
    }

    /**
     * 其他4
     * @param other4 其他4
     */
    public void setOther4(String other4) {
        this.other4 = other4;
    }

    /**
     * 其他5
     * [whh]@return other5 其他5
     */
    public String getOther5() {
        return other5;
    }

    /**
     * 其他5
     * @param other5 其他5
     */
    public void setOther5(String other5) {
        this.other5 = other5;
    }

    /**
     * 其他6
     * [whh]@return other6 其他6
     */
    public String getOther6() {
        return other6;
    }

    /**
     * 其他6
     * @param other6 其他6
     */
    public void setOther6(String other6) {
        this.other6 = other6;
    }
	/**
	 * 支付截止时间
	 * @return 支付截止时间
	 */
	public Date getPayDeadline() {
		return payDeadline;
	}
	/**
	 * 支付截止时间
	 * @param
	 */
	public void setPayDeadline(Date payDeadline) {
		this.payDeadline = payDeadline;
	}
	/**
	 * 订单说明：前台
	 * @return 订单说明：前台
	 */
	public String getRemark() {
		return remark;
	}
	/**
	 * 订单说明：前台
	 * @param  ：前台
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 发起请求的ip
	 * @return 发起请求的ip
	 */
	public String getRequestIp() {
		return requestIp;
	}

	/**
	 * 发起请求的ip
	 * @param
	 */
	public void setRequestIp(String requestIp) {
		this.requestIp = requestIp;
	}
	
	/**
	 * 订单用户
	 * @return 订单用户
	 */
	public String getUserId() {
		return userId;
	}
	
	/**
	 *  订单用户
	 * @param
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	/**
	 * 关联第三方订单Id
	 * @return 关联第三方订单Id
	 */
	public String getTransactionId() {
		return transactionId;
	}
	
	/**
	 *  关联第三方订单Id
	 * @param
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public Date getLastWxQrcodeDate() {
		return lastWxQrcodeDate;
	}

	public void setLastWxQrcodeDate(Date lastWxQrcodeDate) {
		this.lastWxQrcodeDate = lastWxQrcodeDate;
	}

	public Date getLastAliQrcodeDate() {
		return lastAliQrcodeDate;
	}

	public void setLastAliQrcodeDate(Date lastAliQrcodeDate) {
		this.lastAliQrcodeDate = lastAliQrcodeDate;
	}

	public Date getLastUnionQrcodeDate() {
		return lastUnionQrcodeDate;
	}

	public void setLastUnionQrcodeDate(Date lastUnionQrcodeDate) {
		this.lastUnionQrcodeDate = lastUnionQrcodeDate;
	}

}