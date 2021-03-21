package vitily.com.consts;

/**
 * 手机验证码类型：业务类型
 * @author lether
 *
 */
public enum SMSCodeType {
	文本(1),//
	语音(2),//
	图形码(3), //
	其他(4);//
	private int value;
	private SMSCodeType(int value){
		this.value=value;
	}
	public int getValue(){
		return this.value;
	}
}
