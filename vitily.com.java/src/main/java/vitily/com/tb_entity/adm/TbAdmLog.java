package vitily.com.tb_entity.adm;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import vitily.base.tb_entity.BaseEntity;

/**
 * 描述:tb_adm_log表的实体类
 * @version
 * @author:  lether
 * @创建时间: 2017-07-21
 */
public class TbAdmLog extends BaseEntity {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    /**
     * 栏目Id
     */
    private Integer columnId;

    /**
     * 调用时间
     */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date time;

    /**
     * 操作人员
     */
    private String userName;

    /**
     * 操作人员Id
     */
    private Integer userId;

    /**
     * 操作描述
     */
    private String operaDesc;

    /**
     * 操作uri
     */
    private String uri;

    /**
     * 入参
     */
    private String arguments;

    /**
     * 出参
     */
    private String returnValue;

    /**
     * 其他参数
     */
    private String otherArgs;

    /**
     * ip
     */
    private String ip;

    /**
     * 栏目Id
     * [whh]@return column_id 栏目Id
     */
    public Integer getColumnId() {
        return columnId;
    }

    /**
     * 栏目Id
     * @param columnId 栏目Id
     */
    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    /**
     * 调用时间
     * [whh]@return time 调用时间
     */
    public Date getTime() {
        return time;
    }

    /**
     * 调用时间
     * @param time 调用时间
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * 操作人员
     * [whh]@return user_name 操作人员
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 操作人员
     * @param userName 操作人员
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 操作人员Id
     * [whh]@return user_id 操作人员Id
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 操作人员Id
     * @param userId 操作人员Id
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 操作描述
     * [whh]@return opera_desc 操作描述
     */
    public String getOperaDesc() {
        return operaDesc;
    }

    /**
     * 操作描述
     * @param operaDesc 操作描述
     */
    public void setOperaDesc(String operaDesc) {
        this.operaDesc = operaDesc;
    }

    /**
     * 操作uri
     * [whh]@return uri 操作uri
     */
    public String getUri() {
        return uri;
    }

    /**
     * 操作uri
     * @param uri 操作uri
     */
    public void setUri(String uri) {
        this.uri = uri;
    }

    /**
     * 入参
     * [whh]@return arguments 入参
     */
    public String getArguments() {
        return arguments;
    }

    /**
     * 入参
     * @param arguments 入参
     */
    public void setArguments(String arguments) {
        this.arguments = arguments;
    }

    /**
     * 出参
     * [whh]@return return_value 出参
     */
    public String getReturnValue() {
        return returnValue;
    }

    /**
     * 出参
     * @param returnValue 出参
     */
    public void setReturnValue(String returnValue) {
        this.returnValue = returnValue;
    }

    /**
     * 其他参数
     * [whh]@return other_args 其他参数
     */
    public String getOtherArgs() {
        return otherArgs;
    }

    /**
     * 其他参数
     * @param otherArgs 其他参数
     */
    public void setOtherArgs(String otherArgs) {
        this.otherArgs = otherArgs;
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
}