package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_org_info表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbOrgInfo extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 机构名称
     */
    private String name;

    /**
     * 简称
     */
    private String shortName;

    /**
     * 服务电话
     */
    private String servicePhone;

    /**
     * 地址
     */
    private String area;

    /**
     * 网址
     */
    private String netUrl;

    /**
     * 机构类型
     */
    private Integer type;

    /**
     * 机构名称
     * [whh]@return name 机构名称
     */
    public String getName() {
        return name;
    }

    /**
     * 机构名称
     * @param name 机构名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 简称
     * [whh]@return short_name 简称
     */
    public String getShortName() {
        return shortName;
    }

    /**
     * 简称
     * @param shortName 简称
     */
    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    /**
     * 服务电话
     * [whh]@return service_phone 服务电话
     */
    public String getServicePhone() {
        return servicePhone;
    }

    /**
     * 服务电话
     * @param servicePhone 服务电话
     */
    public void setServicePhone(String servicePhone) {
        this.servicePhone = servicePhone;
    }

    /**
     * 地址
     * [whh]@return area 地址
     */
    public String getArea() {
        return area;
    }

    /**
     * 地址
     * @param area 地址
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 网址
     * [whh]@return net_url 网址
     */
    public String getNetUrl() {
        return netUrl;
    }

    /**
     * 网址
     * @param netUrl 网址
     */
    public void setNetUrl(String netUrl) {
        this.netUrl = netUrl;
    }

    /**
     * 机构类型
     * [whh]@return type 机构类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 机构类型
     * @param type 机构类型
     */
    public void setType(Integer type) {
        this.type = type;
    }
}