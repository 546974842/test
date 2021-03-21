package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_comm_chenkin表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-19
 */
public class TbChenkin extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    /**
     * 店铺链接
     */
    private String url;
    /**
     * 掌柜昵称
     */
    private String name;
    /**
     * 店铺类别
     */
    private String type;
    /**
     * 品牌名称
     */
    private String title;
    /**
     * DSR最小值
     */
    private String min;
    /**
     * 商家所在地
     */
    private String address;
    /**
     * 联系名称
     */
    private String realName;
    /**
     * 职位
     */
    private String job;
    /**
     * 手机号
     */
    private String tell;
    /**
     * QQ
     */
    private String qq;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMin() {
		return min;
	}
	public void setMin(String min) {
		this.min = min;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getTell() {
		return tell;
	}
	public void setTell(String tell) {
		this.tell = tell;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}

    
}