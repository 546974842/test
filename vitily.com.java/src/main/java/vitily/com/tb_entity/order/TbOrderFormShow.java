package vitily.com.tb_entity.order;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.util.CentToYuanSerializer;

import java.util.Date;

/**
 * 描述:订单主表表的实体类tb_order_form_show
 * @version
 * @author:  lether
 * @创建时间: 2018-03-24
 */
public class TbOrderFormShow extends BaseEntity {
    /**
	* @Fields {todo}
	*/
	private static final long serialVersionUID = 1L;

	/**
     * 配送方式id
     */
    private Integer deliveryId;

    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 商品id
     */
    private Integer showId;

    /**
     * 订单号
     */
    private String orderNo;

    /**
     * 产品价格(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long proPrice;

    /**
     * 支付状态
     */
    private Integer payState;

    /**
     * 收货人
     */
    private String receiver;

    /**
     * 省市区
     */
    private String area;

    /**
     * 详细地址
     */
    private String address;

    /**
     * 邮编
     */
    private String postCode;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 固话
     */
    private String call;

    /**
     * 收货人邮箱
     */
    private String email;

    /**
     * 指定送货时间
     */
    private String sendDate;

    /**
     * 运费(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long deliveryCost;

    /**
     * 已支付金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long amountPaid;

    /**
     * 订单总金额(单位：分)
     */
    @JSONField(serializeUsing= CentToYuanSerializer.class)
    private Long amountPay;

    /**
     * 支付方式id
     */
    private Integer payWayId;

    /**
     * 发票抬头
     */
    private String voteTitle;

    /**
     * 单位名称
     */
    private String voteCompany;

    /**
     * 发票内容
     */
    private String voteContent;

    /**
     * 物流状态
     */
    private Integer deliveryStatus;

    /**
     * 订单类型id组合
     */
    private String orderTypeStr;

    /**
     * 是否锁定
     */
    private Integer lock;

    /**
     * 订单留言
     */
    private String leaveMessage;

    /**
     * 处理状态
     */
    private Integer dealStatus;

    /**
     * 订单处理流水
     */
    private String dealFlow;
    /**
     * 主图
     */
    private String babyMainPic;

    /**
     * 下单时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date orderDate;

    private String deliveryName;
    private String expressNo;

    /**
     * 配送方式id
     * [whh]@return delivery_id 配送方式id
     */
    public Integer getDeliveryId() {
        return deliveryId;
    }

    
    public String getBabyMainPic() {
		return babyMainPic;
	}


	public void setBabyMainPic(String babyMainPic) {
		this.babyMainPic = babyMainPic;
	}


	/**
     * 配送方式id
     * @param deliveryId 配送方式id
     */
    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
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
     * 产品价格(单位：分)
     * [whh]@return pro_price 产品价格(单位：分)
     */
    public Long getProPrice() {
        return proPrice;
    }

    /**
     * 产品价格(单位：分)
     * @param proPrice 产品价格(单位：分)
     */
    public void setProPrice(Long proPrice) {
        this.proPrice = proPrice;
    }

    /**
     * 支付状态
     * [whh]@return pay_state 支付状态
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 支付状态
     * @param payState 支付状态
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * 收货人
     * [whh]@return receiver 收货人
     */
    public String getReceiver() {
        return receiver;
    }

    /**
     * 收货人
     * @param receiver 收货人
     */
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    /**
     * 省市区
     * [whh]@return area 省市区
     */
    public String getArea() {
        return area;
    }

    /**
     * 省市区
     * @param area 省市区
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 详细地址
     * [whh]@return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * 邮编
     * [whh]@return post_code 邮编
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
     * 手机号码
     * [whh]@return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 固话
     * [whh]@return call 固话
     */
    public String getCall() {
        return call;
    }

    /**
     * 固话
     * @param call 固话
     */
    public void setCall(String call) {
        this.call = call;
    }

    /**
     * 收货人邮箱
     * [whh]@return email 收货人邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 收货人邮箱
     * @param email 收货人邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 指定送货时间
     * [whh]@return send_date 指定送货时间
     */
    public String getSendDate() {
        return sendDate;
    }

    /**
     * 指定送货时间
     * @param sendDate 指定送货时间
     */
    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 运费(单位：分)
     * [whh]@return delivery_cost 运费(单位：分)
     */
    public Long getDeliveryCost() {
        return deliveryCost;
    }

    /**
     * 运费(单位：分)
     * @param deliveryCost 运费(单位：分)
     */
    public void setDeliveryCost(Long deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    /**
     * 已支付金额(单位：分)
     * [whh]@return amount_paid 已支付金额(单位：分)
     */
    public Long getAmountPaid() {
        return amountPaid;
    }

    /**
     * 已支付金额(单位：分)
     * @param amountPaid 已支付金额(单位：分)
     */
    public void setAmountPaid(Long amountPaid) {
        this.amountPaid = amountPaid;
    }

    /**
     * 订单总金额(单位：分)
     * [whh]@return amount_pay 订单总金额(单位：分)
     */
    public Long getAmountPay() {
        return amountPay;
    }

    /**
     * 订单总金额(单位：分)
     * @param amountPay 订单总金额(单位：分)
     */
    public void setAmountPay(Long amountPay) {
        this.amountPay = amountPay;
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
     * 发票抬头
     * [whh]@return vote_title 发票抬头
     */
    public String getVoteTitle() {
        return voteTitle;
    }

    /**
     * 发票抬头
     * @param voteTitle 发票抬头
     */
    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    /**
     * 单位名称
     * [whh]@return vote_company 单位名称
     */
    public String getVoteCompany() {
        return voteCompany;
    }

    /**
     * 单位名称
     * @param voteCompany 单位名称
     */
    public void setVoteCompany(String voteCompany) {
        this.voteCompany = voteCompany;
    }

    /**
     * 发票内容
     * [whh]@return vote_content 发票内容
     */
    public String getVoteContent() {
        return voteContent;
    }

    /**
     * 发票内容
     * @param voteContent 发票内容
     */
    public void setVoteContent(String voteContent) {
        this.voteContent = voteContent;
    }

    /**
     * 物流状态
     * [whh]@return delivery_status 物流状态
     */
    public Integer getDeliveryStatus() {
        return deliveryStatus;
    }

    /**
     * 物流状态
     * @param deliveryStatus 物流状态
     */
    public void setDeliveryStatus(Integer deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    /**
     * 订单类型id组合
     * [whh]@return order_type_str 订单类型id组合
     */
    public String getOrderTypeStr() {
        return orderTypeStr;
    }

    /**
     * 订单类型id组合
     * @param orderTypeStr 订单类型id组合
     */
    public void setOrderTypeStr(String orderTypeStr) {
        this.orderTypeStr = orderTypeStr;
    }

    /**
     * 是否锁定
     * [whh]@return lock 是否锁定
     */
    public Integer getLock() {
        return lock;
    }

    /**
     * 是否锁定
     * @param lock 是否锁定
     */
    public void setLock(Integer lock) {
        this.lock = lock;
    }

    /**
     * 订单留言
     * [whh]@return leave_message 订单留言
     */
    public String getLeaveMessage() {
        return leaveMessage;
    }

    /**
     * 订单留言
     * @param leaveMessage 订单留言
     */
    public void setLeaveMessage(String leaveMessage) {
        this.leaveMessage = leaveMessage;
    }

    /**
     * 处理状态
     * [whh]@return deal_status 处理状态
     */
    public Integer getDealStatus() {
        return dealStatus;
    }

    /**
     * 处理状态
     * @param dealStatus 处理状态
     */
    public void setDealStatus(Integer dealStatus) {
        this.dealStatus = dealStatus;
    }

    /**
     * 订单处理流水
     * [whh]@return deal_flow 订单处理流水
     */
    public String getDealFlow() {
        return dealFlow;
    }

    /**
     * 订单处理流水
     * @param dealFlow 订单处理流水
     */
    public void setDealFlow(String dealFlow) {
        this.dealFlow = dealFlow;
    }

    /**
     * 下单时间
     * [whh]@return order_date 下单时间
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * 下单时间
     * @param orderDate 下单时间
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

	public Integer getShowId() {
		return showId;
	}

	public void setShowId(Integer showId) {
		this.showId = showId;
	}

    public String getDeliveryName() {
        return deliveryName;
    }

    public void setDeliveryName(String deliveryName) {
        this.deliveryName = deliveryName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}