package vitily.com.other_entity;

import java.io.Serializable;

/**
 * 获取手机验证码频繁次数
 * @author lether
 *
 */
public class SMSVerifyCodeFrequent implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int count = 0;
	/**
	 * 操作时间
	 */
	private long millTime = 0;
	/**
	 * 短信内容：仅保存验证码
	 */
	private String content;
	
	/**
	 * 错误次数
	 */
	private int errorCount=0;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public long getMillTime() {
		return millTime;
	}
	public void setMillTime(long millTime) {
		this.millTime = millTime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getErrorCount() {
		return errorCount;
	}
	public void setErrorCount(int errorCount) {
		this.errorCount = errorCount;
	}
}
