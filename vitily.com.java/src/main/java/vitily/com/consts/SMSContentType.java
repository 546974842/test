package vitily.com.consts;

/**
 * 手机验证码类型：业务类型
 * @author lether
 *
 */
public enum SMSContentType {
	注册(1),//需要数据库中国中不存在     不需要登陆
	添加手机号码(2),//需要用户没有手机且库中无此手机 －－ 需要登陆
	解除手机号码(3), //需要用户已绑定手机 －－ 需要登陆
	身份验证(4),//需要数据库中存在手机  －－ 需要登陆：校验过后修改其他信息就不需要重新校验了
	找回密码(5),//需要数据库中存在该手机－－不需要登陆
	广告内容(6),//该处不需要缓存
	其他内容(7);//该处不需要缓存
	private int value;
	private SMSContentType(int value){
		this.value=value;
	}
	public int getValue(){
		return this.value;
	}
}
