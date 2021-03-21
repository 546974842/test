package vitily.com.tv_entity.order;

import java.math.BigDecimal;
import java.util.List;

import vitily.com.consts.*;
import vitily.com.tb_entity.order.TbOrderFormShow;
import vitily.com.util.CommonUtil;
import vitily.com.util.EnumHelperUtil;

public class TvOrderFormShow extends TbOrderFormShow {
	/**
	* @Fields {todo}
	*/
	private static final long serialVersionUID = 1L;
	private String memName;//购买该产品地会员
	private String deliveryName;//送货方式
	private String payWayName;//支付方式
	private String babyName;//商品名称
	private String babyMainPic;//主图
	private BigDecimal modelReward;//奖励价格
	private BigDecimal babyPrice;//宝贝价格
	private Integer experiType;//类型
	private String experiTypeDes;//类型
	private Integer surplusNumber;//已体验数
	private Integer experiNumber;//总数
	private Integer platform;
	private String platformDesc;
	private String dealStatusDesc;
	/**
	 * 订单支付状态
	 */
	private String payStateDesc;
	/**
	 * 订单物流状态
	 */
	private String deliveryStatusDesc;
	private Integer leftAuditNumber;//待审核人数

	private String modelPic;//模特封面图

	private String modelName;//模特艺名


	public Integer getPlatform() {
		return platform;
	}

	public void setPlatform(Integer platform) {
		this.platform = platform;
	}

	public String getPlatformDesc() {
		this.platformDesc = EnumHelperUtil.getEnumWrapDescByValue(ShowPlatformDesc.class,this.getPlatform());
		return platformDesc;
	}

	public Integer getSurplusNumber() {
		return surplusNumber;
	}
	public void setSurplusNumber(Integer surplusNumber) {
		this.surplusNumber = surplusNumber;
	}
	public Integer getExperiNumber() {
		return experiNumber;
	}
	public void setExperiNumber(Integer experiNumber) {
		this.experiNumber = experiNumber;
	}
	public String getExperiTypeDes() {
		if(experiType==0){
			experiTypeDes="线下退货";
		}else{
			experiTypeDes="产品赠送";
		}
		return experiTypeDes;
	}
	public void setExperiTypeDes(String experiTypeDes) {
		this.experiTypeDes = experiTypeDes;
	}
	public Integer getExperiType() {
		return experiType;
	}
	public void setExperiType(Integer experiType) {
		this.experiType = experiType;
	}
	public String getBabyMainPic() {
		return babyMainPic;
	}
	public void setBabyMainPic(String babyMainPic) {
		this.babyMainPic = babyMainPic;
	}
	public String getBabyName() {
		return babyName;
	}
	public void setBabyName(String babyName) {
		this.babyName = babyName;
	}
	
	public BigDecimal getModelReward() {
		return modelReward;
	}
	public void setModelReward(BigDecimal modelReward) {
		this.modelReward = modelReward;
	}
	public BigDecimal getBabyPrice() {
		return babyPrice;
	}
	public void setBabyPrice(BigDecimal babyPrice) {
		this.babyPrice = babyPrice;
	}

	private List<TvOrderDetail> orderDetails;

	public List<TvOrderDetail> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<TvOrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	public String getDealStatusDesc() {
		if(CommonUtil.isNull(dealStatusDesc)){
			this.dealStatusDesc = EnumHelperUtil.getEnumWrapDescByValue(OrderDealShowStatusDesc.class,this.getDealStatus());
		}
		return dealStatusDesc;
	}

	public String getPayStateDesc() {
		if(CommonUtil.isNull(payStateDesc)){
			this.payStateDesc = EnumHelperUtil.getEnumWrapDescByValue(PayStateDesc.class,this.getPayState());
		}
		return payStateDesc;
	}

	public String getDeliveryStatusDesc() {
		if(CommonUtil.isNull(deliveryStatusDesc)){
			this.deliveryStatusDesc = EnumHelperUtil.getEnumWrapDescByValue(DeliveryStatusDesc.class,this.getDeliveryStatus());
		}
		return deliveryStatusDesc;
	}

	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public String getPayWayName() {
		return payWayName;
	}
	public void setPayWayName(String payWayName) {
		this.payWayName = payWayName;
	}

	public Integer getLeftAuditNumber() {
		return leftAuditNumber;
	}

	public void setLeftAuditNumber(Integer leftAuditNumber) {
		this.leftAuditNumber = leftAuditNumber;
	}

	public String getModelPic() {
		return modelPic;
	}

	public void setModelPic(String modelPic) {
		this.modelPic = modelPic;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}
}
