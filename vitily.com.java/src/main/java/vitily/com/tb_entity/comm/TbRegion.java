package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_comm_region表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2018-01-21
 */
public class TbRegion extends BaseEntity {

    /**
     * 编码
     */
    private String code;

    /**
     * 地址名
     */
    private String name;

    /**
     * 上一级ID
     */
    private Integer parentId;

    /**
     * 级别
     */
    private Integer level;

    /**
     * 拼音
     */
    private String pinyin;

    /**
     * 拼音简写
     */
    private String shortPinyin;

    /**
     * 编码
     * [whh]@return code 编码
     */
    public String getCode() {
        return code;
    }

    /**
     * 编码
     * @param code 编码
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * 地址名
     * [whh]@return name 地址名
     */
    public String getName() {
        return name;
    }

    /**
     * 地址名
     * @param name 地址名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 上一级ID
     * [whh]@return parent_id 上一级ID
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 上一级ID
     * @param parentId 上一级ID
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 级别
     * [whh]@return level 级别
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 级别
     * @param level 级别
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 拼音
     * [whh]@return pinyin 拼音
     */
    public String getPinyin() {
        return pinyin;
    }

    /**
     * 拼音
     * @param pinyin 拼音
     */
    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    /**
     * 拼音简写
     * [whh]@return short_pinyin 拼音简写
     */
    public String getShortPinyin() {
        return shortPinyin;
    }

    /**
     * 拼音简写
     * @param shortPinyin 拼音简写
     */
    public void setShortPinyin(String shortPinyin) {
        this.shortPinyin = shortPinyin;
    }
}