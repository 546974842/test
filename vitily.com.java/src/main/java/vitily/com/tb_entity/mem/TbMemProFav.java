package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_mem_pro_fav表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbMemProFav extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 产品规格参数id
     */
    private Integer specParProId;
    
    /**
     * 产品Id
     */
    private Integer productId;

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
     * 产品规格参数id
     * [whh]@return spec_par_pro_id 产品规格参数id
     */
    public Integer getSpecParProId() {
        return specParProId;
    }

    /**
     * 产品规格参数id
     * @param specParProId 产品规格参数id
     */
    public void setSpecParProId(Integer specParProId) {
        this.specParProId = specParProId;
    }
    
    /**
     * 产品Id
     * @return 产品Id
     */
	public Integer getProductId() {
		return productId;
	}

	/**
	 *  产品Id
	 * @param 产品Id
	 */
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
    
    
}