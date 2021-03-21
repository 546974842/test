package vitily.com.tb_entity.cms;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_cms_dynpro_val表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbCmsDynproVal extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 对应新闻id
     */
    private Integer newsId;

    /**
     * 对应动态属性id
     */
    private Integer properId;

    /**
     * 属性名称
     */
    private String properName;

    /**
     * guid
     */
    private String guid;

    /**
     * 属性值
     */
    private String value;

    /**
     * 对应新闻id
     * [whh]@return news_id 对应新闻id
     */
    public Integer getNewsId() {
        return newsId;
    }

    /**
     * 对应新闻id
     * @param newsId 对应新闻id
     */
    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    /**
     * 对应动态属性id
     * [whh]@return proper_id 对应动态属性id
     */
    public Integer getProperId() {
        return properId;
    }

    /**
     * 对应动态属性id
     * @param properId 对应动态属性id
     */
    public void setProperId(Integer properId) {
        this.properId = properId;
    }

    /**
     * 属性名称
     * [whh]@return proper_name 属性名称
     */
    public String getProperName() {
        return properName;
    }

    /**
     * 属性名称
     * @param properName 属性名称
     */
    public void setProperName(String properName) {
        this.properName = properName;
    }

    /**
     * guid
     * [whh]@return guid guid
     */
    public String getGuid() {
        return guid;
    }

    /**
     * guid
     * @param guid guid
     */
    public void setGuid(String guid) {
        this.guid = guid;
    }

    /**
     * 属性值
     * [whh]@return value 属性值
     */
    public String getValue() {
        return value;
    }

    /**
     * 属性值
     * @param value 属性值
     */
    public void setValue(String value) {
        this.value = value;
    }
}