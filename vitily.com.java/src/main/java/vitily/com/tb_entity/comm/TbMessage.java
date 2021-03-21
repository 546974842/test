package vitily.com.tb_entity.comm;

import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_message表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbMessage extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 会员id
     */
    private Integer memberId;

    /**
     * 后台用户id
     */
    private Integer adminId;

    /**
     * 消息标题
     */
    private String title;

    /**
     * 消息内容
     */
    private String content;

    /**
     * 查看状态
     */
    private Integer viewState;

    /**
     * 类型
     */
    private Integer type;

    /**
     * 上一级id：如果不为空表示是回复的
     */
    private Integer parentId;

    /**
     * 联系人
     */
    private String contactor;

    /**
     * 联系人手机
     */
    private String phone;

    /**
     * email
     */
    private String email;

    /**
     * 职务
     */
    private String post;

    /**
     * 所在公司
     */
    private String company;

    /**
     * 所在省份
     */
    private String province;

    /**
     * 所在城市
     */
    private String city;

    /**
     * 详细地址
     */
    private String address;

    /**
     * ip
     */
    private String ip;

    /**
     * 回复内容
     */
    private String reply;

    /**
     * 会员id
     * [whh]@return member_id 会员id
     */
    public Integer getMemberId() {
        return memberId;
    }

    /**
     * 会员id
     * @param memberId 会员id
     */
    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    /**
     * 后台用户id
     * [whh]@return admin_id 后台用户id
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 后台用户id
     * @param adminId 后台用户id
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 消息标题
     * [whh]@return title 消息标题
     */
    public String getTitle() {
        return title;
    }

    /**
     * 消息标题
     * @param title 消息标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 消息内容
     * [whh]@return content 消息内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 消息内容
     * @param content 消息内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 查看状态
     * [whh]@return view_state 查看状态
     */
    public Integer getViewState() {
        return viewState;
    }

    /**
     * 查看状态
     * @param viewState 查看状态
     */
    public void setViewState(Integer viewState) {
        this.viewState = viewState;
    }

    /**
     * 类型
     * [whh]@return type 类型
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型
     * @param type 类型
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 上一级id：如果不为空表示是回复的
     * [whh]@return parent_id 上一级id：如果不为空表示是回复的
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 上一级id：如果不为空表示是回复的
     * @param parentId 上一级id：如果不为空表示是回复的
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 联系人
     * [whh]@return contactor 联系人
     */
    public String getContactor() {
        return contactor;
    }

    /**
     * 联系人
     * @param contactor 联系人
     */
    public void setContactor(String contactor) {
        this.contactor = contactor;
    }

    /**
     * 联系人手机
     * [whh]@return phone 联系人手机
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 联系人手机
     * @param phone 联系人手机
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * email
     * [whh]@return email email
     */
    public String getEmail() {
        return email;
    }

    /**
     * email
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 职务
     * [whh]@return post 职务
     */
    public String getPost() {
        return post;
    }

    /**
     * 职务
     * @param post 职务
     */
    public void setPost(String post) {
        this.post = post;
    }

    /**
     * 所在公司
     * [whh]@return company 所在公司
     */
    public String getCompany() {
        return company;
    }

    /**
     * 所在公司
     * @param company 所在公司
     */
    public void setCompany(String company) {
        this.company = company;
    }

    /**
     * 所在省份
     * [whh]@return province 所在省份
     */
    public String getProvince() {
        return province;
    }

    /**
     * 所在省份
     * @param province 所在省份
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 所在城市
     * [whh]@return city 所在城市
     */
    public String getCity() {
        return city;
    }

    /**
     * 所在城市
     * @param city 所在城市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 详细地址
     * [whh]@return address 详细地址
     */
    public String getAddress() {
        return address;
    }

    /**
     * 详细地址
     * @param address 详细地址
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * ip
     * [whh]@return ip ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * ip
     * @param ip ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 回复内容
     * [whh]@return reply 回复内容
     */
    public String getReply() {
        return reply;
    }

    /**
     * 回复内容
     * @param reply 回复内容
     */
    public void setReply(String reply) {
        this.reply = reply;
    }
}