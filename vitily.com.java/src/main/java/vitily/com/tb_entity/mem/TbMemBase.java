package vitily.com.tb_entity.mem;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import vitily.base.tb_entity.BaseEntity;

import java.util.Date;

/**
 * 描述:tb_mem_base表的实体类
 * @version
 * @author:  whh
 * @创建时间: 2018-03-06
 */
public class TbMemBase extends BaseEntity {
    /**
     * 会员登录名
     */
    private String name;

    /**
     * 分组id
     */
    private Integer groupId;

    /**
     * 0个人用户1企业用户
     */
    private Integer type;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * email
     */
    private String email;

    /**
     * 来源
     */
    private Integer regFrom;

    /**
     * qq号
     */
    private String qq;

    /**
     * 描述
     */
    private String description;

    /**
     * 用户头像
     */
    private String headPortrati;

    /**
     * salt
     */
    private String salt;

    /**
     * 密码
     */
    private String password;

    /**
     * tokenkey
     */
    private String tokenKey;

    /**
     * 问题
     */
    private String question;

    /**
     * 问题答案
     */
    private String answer;

    /**
     * 最后一次登陆时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDate;

    /**
     * 是否已开通信用信息：0未开通1已开通
     */
    private Integer openCreditfile;

    /**
     * 分类：0网红1商家2美工
     */
    private Integer cate;
    /**
     * 微信号
     */
    private String wxNo;

    /**
     * 支付宝Id
     */
    private String zfbId;
    private Integer level;
    /**
     * 邀请码
     */
    private Integer parentId;
    
    
    public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	/**
     * 会员登录名
     * [whh]@return name 会员登录名
     */
    public String getName() {
        return name;
    }

    /**
     * 会员登录名
     * @param name 会员登录名
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 分组id
     * [whh]@return group_id 分组id
     */
    public Integer getGroupId() {
        return groupId;
    }

    /**
     * 分组id
     * @param groupId 分组id
     */
    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    /**
     * 0个人用户1企业用户
     * [whh]@return type 0个人用户1企业用户
     */
    public Integer getType() {
        return type;
    }

    /**
     * 0个人用户1企业用户
     * @param type 0个人用户1企业用户
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 昵称
     * [whh]@return nick_name 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName;
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
     * 来源
     * [whh]@return reg_from 来源
     */
    public Integer getRegFrom() {
        return regFrom;
    }

    /**
     * 来源
     * @param regFrom 来源
     */
    public void setRegFrom(Integer regFrom) {
        this.regFrom = regFrom;
    }

    /**
     * qq号
     * [whh]@return qq qq号
     */
    public String getQq() {
        return qq;
    }

    /**
     * qq号
     * @param qq qq号
     */
    public void setQq(String qq) {
        this.qq = qq;
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

    /**
     * 用户头像
     * [whh]@return head_portrati 用户头像
     */
    public String getHeadPortrati() {
        return headPortrati;
    }

    /**
     * 用户头像
     * @param headPortrati 用户头像
     */
    public void setHeadPortrati(String headPortrati) {
        this.headPortrati = headPortrati;
    }

    /**
     * salt
     * [whh]@return salt salt
     */
    public String getSalt() {
        return salt;
    }

    /**
     * salt
     * @param salt salt
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 密码
     * [whh]@return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * tokenkey
     * [whh]@return token_key tokenkey
     */
    public String getTokenKey() {
        return tokenKey;
    }

    /**
     * tokenkey
     * @param tokenKey tokenkey
     */
    public void setTokenKey(String tokenKey) {
        this.tokenKey = tokenKey;
    }

    /**
     * 问题
     * [whh]@return question 问题
     */
    public String getQuestion() {
        return question;
    }

    /**
     * 问题
     * @param question 问题
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * 问题答案
     * [whh]@return answer 问题答案
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * 问题答案
     * @param answer 问题答案
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }

    /**
     * 最后一次登陆时间
     * [whh]@return last_login_date 最后一次登陆时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 最后一次登陆时间
     * @param lastLoginDate 最后一次登陆时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 是否已开通信用信息：0未开通1已开通
     * [whh]@return open_creditfile 是否已开通信用信息：0未开通1已开通
     */
    public Integer getOpenCreditfile() {
        return openCreditfile;
    }

    /**
     * 是否已开通信用信息：0未开通1已开通
     * @param openCreditfile 是否已开通信用信息：0未开通1已开通
     */
    public void setOpenCreditfile(Integer openCreditfile) {
        this.openCreditfile = openCreditfile;
    }
    /**
     * 分类：0网红1商家2美工
     * [whh]@return cate 分类：0网红1商家2美工
     */
    public Integer getCate() {
        return cate;
    }

    /**
     * 分类：0网红1商家2美工
     * @param cate 分类：0网红1商家2美工
     */
    public void setCate(Integer cate) {
        this.cate = cate;
    }

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    public String getZfbId() {
        return zfbId;
    }

    public void setZfbId(String zfbId) {
        this.zfbId = zfbId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}