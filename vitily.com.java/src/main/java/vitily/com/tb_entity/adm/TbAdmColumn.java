package vitily.com.tb_entity.adm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:ti_adm_column表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbAdmColumn extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 栏目名称
     */
    private String name;
    /**
     * 链接路径
     */
    private String urlLink;
    /**
     * 旗下权限url
     */
    private String rightUrls;
    /**
     * 是否按钮
     */
    private Integer isBtn;
    /**
     * 导航图标
     */
    private String icon;

    /**
     * 父级id
     * [whh]@return parent_id 父级id
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级id
     * @param parentId 父级id
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 栏目名称
     * [whh]@return name 栏目名称
     */
    public String getName() {
        return name;
    }

    /**
     * 栏目名称
     * @param name 栏目名称
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 链接路径
     * [whh]@return url_link 链接路径
     */
    public String getUrlLink() {
        return urlLink;
    }

    /**
     * 链接路径
     * @param urlLink 链接路径
     */
    public void setUrlLink(String urlLink) {
        this.urlLink = urlLink;
    }

    public String getRightUrls() {
        return rightUrls;
    }

    public void setRightUrls(String rightUrls) {
        this.rightUrls = rightUrls;
    }

    public Integer getIsBtn() {
        return isBtn;
    }

    public void setIsBtn(Integer isBtn) {
        this.isBtn = isBtn;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}