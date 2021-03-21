package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_image_model表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbImageSams extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 标签id组合
     */
    private String labelIds;

    /**
     * 图片地址(小)
     */
    private String lmtSrc;

    /**
     * 图片地址(中)暂时不用
     */
    private String cntSrc;

    /**
     * 图片地址(大)暂时不用
     */
    private String bigSrc;

    /**
     * 图片名称
     */
    private String name;

    /**
     * 系统类型
     */
    private Integer sysType;

    /**
     * 描述
     */
    private String description;

    /**
     * 标签id组合
     * [whh]@return label_ids 标签id组合
     */
    public String getLabelIds() {
        return labelIds;
    }

    /**
     * 标签id组合
     * @param labelIds 标签id组合
     */
    public void setLabelIds(String labelIds) {
        this.labelIds = labelIds;
    }

    /**
     * 图片地址(小)
     * [whh]@return lmt_src 图片地址(小)
     */
    public String getLmtSrc() {
        return lmtSrc;
    }

    /**
     * 图片地址(小)
     * @param lmtSrc 图片地址(小)
     */
    public void setLmtSrc(String lmtSrc) {
        this.lmtSrc = lmtSrc;
    }

    /**
     * 图片地址(中)暂时不用
     * [whh]@return cnt_src 图片地址(中)暂时不用
     */
    public String getCntSrc() {
        return cntSrc;
    }

    /**
     * 图片地址(中)暂时不用
     * @param cntSrc 图片地址(中)暂时不用
     */
    public void setCntSrc(String cntSrc) {
        this.cntSrc = cntSrc;
    }

    /**
     * 图片地址(大)暂时不用
     * [whh]@return big_src 图片地址(大)暂时不用
     */
    public String getBigSrc() {
        return bigSrc;
    }

    /**
     * 图片地址(大)暂时不用
     * @param bigSrc 图片地址(大)暂时不用
     */
    public void setBigSrc(String bigSrc) {
        this.bigSrc = bigSrc;
    }

    /**
     * 图片名称
     * [whh]@return name 图片名称
     */
    public String getName() {
        return name;
    }

    /**
     * 图片名称
     * @param name 图片名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 系统类型
     * [whh]@return sys_type 系统类型
     */
    public Integer getSysType() {
        return sysType;
    }

    /**
     * 系统类型
     * @param sysType 系统类型
     */
    public void setSysType(Integer sysType) {
        this.sysType = sysType;
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
}