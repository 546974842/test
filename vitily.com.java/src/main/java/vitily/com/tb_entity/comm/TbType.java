package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_type表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbType extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 类别名称
     */
    private String name;

    /**
     * url标识符
     */
    private String urlTip;

    /**
     * 规格id组合
     */
    private String specIds;

    /**
     * 描述
     */
    private String description;
    
    /**
     * 系统类型
     */
    private Integer sysType;

    /**
     * 类别名称
     * [whh]@return name 类别名称
     */
    public String getName() {
        return name;
    }

    /**
     * 类别名称
     * @param name 类别名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * url标识符
     * [whh]@return url_tip url标识符
     */
    public String getUrlTip() {
        return urlTip;
    }

    /**
     * url标识符
     * @param urlTip url标识符
     */
    public void setUrlTip(String urlTip) {
        this.urlTip = urlTip;
    }

    /**
     * 规格id组合
     * [whh]@return spec_ids 规格id组合
     */
    public String getSpecIds() {
        return specIds;
    }

    /**
     * 规格id组合
     * @param specIds 规格id组合
     */
    public void setSpecIds(String specIds) {
        this.specIds = specIds;
    }

    /**
     * 描述
     * [whh]@return description 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 描述
     * @param description 描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 系统类型
     * @return 系统类型
     */
	public Integer getSysType() {
		return sysType;
	}

	/**
	 * 系统类型
	 * @param  系统类型
	 */
	public void setSysType(Integer sysType) {
		this.sysType = sysType;
	}
    
}