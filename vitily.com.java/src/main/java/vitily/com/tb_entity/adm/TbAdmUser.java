package vitily.com.tb_entity.adm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import org.springframework.format.annotation.DateTimeFormat;
import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_adm_user表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
@SuppressWarnings("ALL")
public class TbAdmUser extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 后台用户登录名
     */
    private String userName;

    /**
     * 登陆密码
     */
    private String password;

    /**
     * 密码随机数
     */
    private String salt;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 证件号码
     */
    private String idNumber;

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 分组Id
     */
    private Integer roleId;

    /**
     * 临时tokenkey，每次登陆需要清除一次
     */
    private String authToken;

    /**
     * 最后一次登陆时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date lastLoginDate;

    /**
     * 密码过期时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date passwordExpiration;

    /**
     * 权限字符串
     */
    private String permissionStr;

    /**
     * 后台用户登录名
     * [whh]@return user_name 后台用户登录名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 后台用户登录名
     * @param userName 后台用户登录名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 登陆密码
     * [whh]@return password 登陆密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登陆密码
     * @param password 登陆密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 密码随机数
     * [whh]@return salt 密码随机数
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 密码随机数
     * @param salt 密码随机数
     */
    public void setSalt(String salt) {
        this.salt = salt;
    }

    /**
     * 手机号码
     * [whh]@return phone 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 邮箱地址
     * [whh]@return email 邮箱地址
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱地址
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 真实姓名
     * [whh]@return real_name 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 证件号码
     * [whh]@return id_number 证件号码
     */
    public String getIdNumber() {
        return idNumber;
    }

    /**
     * 证件号码
     * @param idNumber 证件号码
     */
    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
     * 分组Id
     * [whh]@return role_id 分组Id
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 分组Id
     * @param roleId 分组Id
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     * 临时tokenkey，每次登陆需要清除一次
     * [whh]@return auth_token 临时tokenkey，每次登陆需要清除一次
     */
    public String getAuthToken() {
        return authToken;
    }

    /**
     * 临时tokenkey，每次登陆需要清除一次
     * @param authToken 临时tokenkey，每次登陆需要清除一次
     */
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
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
     * 密码过期时间
     * [whh]@return password_expiration 密码过期时间
     */
    public Date getPasswordExpiration() {
        return passwordExpiration;
    }

    /**
     * 密码过期时间
     * @param passwordExpiration 密码过期时间
     */
    public void setPasswordExpiration(Date passwordExpiration) {
        this.passwordExpiration = passwordExpiration;
    }

    /**
     * 权限字符串
     * [whh]@return permission_str 权限字符串
     */
    public String getPermissionStr() {
        return permissionStr;
    }

    /**
     * 权限字符串
     * @param permissionStr 权限字符串
     */
    public void setPermissionStr(String permissionStr) {
        this.permissionStr = permissionStr;
    }
}