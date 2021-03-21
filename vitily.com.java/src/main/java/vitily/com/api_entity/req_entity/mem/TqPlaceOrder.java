package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RegexValidator;
import vitily.com.annotation.RequireValidator;
import vitily.com.util.Validator;

import java.util.List;

/**
 * 下单请求
 * @author lether
 *
 */
public class TqPlaceOrder extends TqMemBase {
	/**
	 *
	 */
	Integer admUserId;
	/**
	 * 收货人收获信息地址Id
	 */
	@RequireValidator(paramName = "收货地址ID")
	Integer memRecInfoId;
	@RequireValidator(paramName = "配送方式")
	Integer deliveryId;
	@RequireValidator(paramName = "支付方式")
	Integer payWayId;
	/**
	 * 通知邮箱
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	String email;
	/**
	 * 指定送货时间
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH64)
	String sendDate;
	/**
	 * 发票抬头
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	String voteTitle;
	/**
	 * 发票公司名称
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	String voteCompany;
	/**
	 * 发票内容
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	String voteContent;
	/**
	 * 订单留言
	 */
	@RegexValidator(regexStr = Validator.STR_MAX_LENGTH128)
	String leaveMessage;
	@RequireValidator(paramName = "产品详情")
	List<TqOrderDetail> details;

	public Integer getAdmUserId() {
		return admUserId;
	}

	public void setAdmUserId(Integer admUserId) {
		this.admUserId = admUserId;
	}

	public Integer getMemRecInfoId() {
		return memRecInfoId;
	}

	public void setMemRecInfoId(Integer memRecInfoId) {
		this.memRecInfoId = memRecInfoId;
	}

	public Integer getDeliveryId() {
		return deliveryId;
	}

	public void setDeliveryId(Integer deliveryId) {
		this.deliveryId = deliveryId;
	}

	public Integer getPayWayId() {
		return payWayId;
	}

	public void setPayWayId(Integer payWayId) {
		this.payWayId = payWayId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSendDate() {
		return sendDate;
	}

	public void setSendDate(String sendDate) {
		this.sendDate = sendDate;
	}

	public String getVoteTitle() {
		return voteTitle;
	}

	public void setVoteTitle(String voteTitle) {
		this.voteTitle = voteTitle;
	}

	public String getVoteCompany() {
		return voteCompany;
	}

	public void setVoteCompany(String voteCompany) {
		this.voteCompany = voteCompany;
	}

	public String getVoteContent() {
		return voteContent;
	}

	public void setVoteContent(String voteContent) {
		this.voteContent = voteContent;
	}

	public String getLeaveMessage() {
		return leaveMessage;
	}

	public void setLeaveMessage(String leaveMessage) {
		this.leaveMessage = leaveMessage;
	}

	public List <TqOrderDetail> getDetails() {
		return details;
	}

	public void setDetails(List <TqOrderDetail> details) {
		this.details = details;
	}
}
