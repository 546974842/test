package vitily.com.tb_entity.mem;

import vitily.base.tb_entity.BaseEntity;


/**
 * 描述:角色组表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-07-08
 */
public class TbMemArtist extends BaseEntity {
    /**
     * 
     */
    private Integer memberId;

    /**
     * 身份证正面照
     */
    private String idcarPositive;

    /**
     * 身份证正面照
     */
    private String idcarNegative;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 个人作品图集
     */
    private String picList;

    /**
     * 工作时间0：个人，1：团队
     */
    private Integer operatingHours;

    /**
     * 描述
     */
    private String description;

    /**
     * 
     * [whh]@return member_id 
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 
     * @param memberId 
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 身份证正面照
     * [whh]@return idcar_positive 身份证正面照
     */
    public String getIdcarPositive() {
        return idcarPositive;
    }

    /**
     * 身份证正面照
     * @param idcarPositive 身份证正面照
     */
    public void setIdcarPositive(String idcarPositive) {
        this.idcarPositive = idcarPositive;
    }

    /**
     * 身份证正面照
     * [whh]@return idcar_negative 身份证正面照
     */
    public String getIdcarNegative() {
        return idcarNegative;
    }

    /**
     * 身份证正面照
     * @param idcarNegative 身份证正面照
     */
    public void setIdcarNegative(String idcarNegative) {
        this.idcarNegative = idcarNegative;
    }

    /**
     * 分组名称
     * [whh]@return name 分组名称
     */
    public String getName() {
        return name;
    }

    /**
     * 分组名称
     * @param name 分组名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 个人作品图集
     * [whh]@return pic_list 个人作品图集
     */
    public String getPicList() {
        return picList;
    }

    /**
     * 个人作品图集
     * @param picList 个人作品图集
     */
    public void setPicList(String picList) {
        this.picList = picList;
    }

    /**
     * 工作时间0：个人，1：团队
     * [whh]@return operating_hours 工作时间0：个人，1：团队
     */
    public Integer getOperatingHours() {
        return operatingHours;
    }

    /**
     * 工作时间0：个人，1：团队
     * @param operatingHours 工作时间0：个人，1：团队
     */
    public void setOperatingHours(Integer operatingHours) {
        this.operatingHours = operatingHours;
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