package vitily.com.other_entity;

import vitily.com.consts.ResultStatus;
import vitily.com.util.CommonUtil;

import java.io.Serializable;

/**
 * 返回结果
 * @author lether
 *
 */
public class ResultBack implements Serializable{

	private static final long serialVersionUID = 7750274510921255337L;

	public ResultBack(){
	}
	public ResultBack(ResultStatus status,Object content){
		this(status,status.getDesc(),content);
	}
	public ResultBack(ResultStatus status,String message,Object content){
		this.code = status.getValue();
		this.message = message;
		this.content = content;
	}
	/**
	 * 结果代码：
	 * 404返回－99
	 * 没有登陆返回－2
	 * 当没有权限的时候返回－1
	 * 
	 */
	private String code = ResultStatus.正常.getValue();
	private String message = ResultStatus.正常.getDesc();
	/**
	 * 结果内容：
	 */
	private Object content;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}
}
