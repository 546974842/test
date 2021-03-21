package vitily.com.tb_entity.pay;

import vitily.base.tb_entity.BaseEntity;

import java.util.Date;

/**
 * 描述:tb_order_flow表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-05-19
 */
public class TbOrderFlow extends BaseEntity {

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
     * 处理人
     */
    private String handler;

    /**
     * 处理说明
     */
    private String desc;

    /**
     * 处理时间
     */
    private Date dealTime;

    /**
     * 操作内容
     */
    private String content;

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
     * 处理说明
     * [whh]@return desc 处理说明
     */
    public String getDesc() {
        return desc;
    }

    /**
     * 处理说明
     * @param desc 处理说明
     */
    public void setDesc(String desc) {
        this.desc = desc;
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
     * 操作内容
     * [whh]@return content 操作内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 操作内容
     * @param content 操作内容
     */
    public void setContent(String content) {
        this.content = content;
    }
}