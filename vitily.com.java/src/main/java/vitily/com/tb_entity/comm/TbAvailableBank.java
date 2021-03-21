package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_comm_availble_bank表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-01-23
 */
public class TbAvailableBank extends BaseEntity {
    /**
     * 卡号类型
     */
    private Integer type;

    /**
     * 银行名称
     */
    private String name;

    /**
     * 银行简称
     */
    private String shortName;

    /**
     * 银行编码
     */
    private String code;

    /**
     * 备注
     */
    private String memo;

    /**
     * 支持平台（以,分割）
     */
    private String platform;

    /**
     * 图片地址
     */
    private String picUrl;
    /**
     * 卡号类型
     * [whh]@return type 卡号类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 卡号类型
     * @param type 卡号类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 银行名称
     * [whh]@return bank_name 银行名称
     */
    public String getName() {
        return name;
    }

    /**
     * 银行名称
     * @param bankName 银行名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 银行简称
     * [whh]@return short_name 银行简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 银行简称
     * @param shortName 银行简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 银行编码
     * [whh]@return code 银行编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 银行编码
     * @param code 银行编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 备注
     * [whh]@return memo 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * 支持平台（以,分割）
     * [whh]@return platform 支持平台（以,分割）
     */
    public String getPlatform() {
        return platform;
    }

    /**
     * 支持平台（以,分割）
     * @param platform 支持平台（以,分割）
     */
    public void setPlatform(String platform) {
        this.platform = platform;
    }

    /**
     * 图片地址
     * [whh]@return pic_url 图片地址
     */
    public String getPicUrl() {
        return picUrl;
    }

    /**
     * 图片地址
     * @param picUrl 图片地址
     */
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}