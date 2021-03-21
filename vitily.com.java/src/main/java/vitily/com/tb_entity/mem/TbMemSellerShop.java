package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_seller_shop表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbMemSellerShop extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 绑定店铺名称
     */
    private String shopName;

    /**
     * 绑定店铺掌柜id
     */
    private String shopId;
    /**
     * 类型
     */
    private String type;

    
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getShopId() {
		return shopId;
	}

	public void setShopId(String shopId) {
		this.shopId = shopId;
	}

}