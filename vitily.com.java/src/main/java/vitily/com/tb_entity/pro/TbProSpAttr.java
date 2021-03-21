package vitily.com.tb_entity.pro;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_spec_par表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbProSpAttr extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 规格id
     */
    private Integer specId;

    /**
     * 参数名称
     */
    private String name;

    /**
     * 规格图片地址
     */
    private String picSrc;

    /**
     * 规格id
     * [whh]@return spec_id 规格id
     */
    public Integer getSpecId() {
        return specId;
    }

    /**
     * 规格id
     * @param specId 规格id
     */
    public void setSpecId(Integer specId) {
        this.specId = specId;
    }

    /**
     * 参数名称
     * [whh]@return name 参数名称
     */
    public String getName() {
        return name;
    }

    /**
     * 参数名称
     * @param name 参数名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 规格图片地址
     * [whh]@return pic_src 规格图片地址
     */
    public String getPicSrc() {
        return picSrc;
    }

    /**
     * 规格图片地址
     * @param picSrc 规格图片地址
     */
    public void setPicSrc(String picSrc) {
        this.picSrc = picSrc;
    }
}