package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

/**
 * creator : whh-lether
 * date    : 2019/1/18 9:25
 * desc    :
 **/
public class TqSaveOrderExpress extends TqMemBase{
    @RequireValidator
    private Integer orderId;
    @RequireValidator
    private String deliveryName;
    @RequireValidator
    private String expressNo;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
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
