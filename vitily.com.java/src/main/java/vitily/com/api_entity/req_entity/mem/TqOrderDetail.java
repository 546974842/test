package vitily.com.api_entity.req_entity.mem;

import vitily.com.annotation.RequireValidator;

import java.io.Serializable;

public class TqOrderDetail implements Serializable {
    /**
     * 规格ID
     */
    Integer proSpId;
    /**
     * 产品ID
     */
    @RequireValidator
    Integer productId;
    /**
     * 购买数量
     */
    @RequireValidator(paramName = "购买数量")
    Integer purchaseQuantity;

    public Integer getProSpId() {
        return proSpId;
    }

    public void setProSpId(Integer proSpId) {
        this.proSpId = proSpId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(Integer purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }
}
