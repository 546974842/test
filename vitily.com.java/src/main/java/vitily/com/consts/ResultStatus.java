package vitily.com.consts;

/**
 * 执行结果返回码
 * @author lether
 *
 */
public enum ResultStatus {
	操作异常("400","操作异常，请联系管理员"),
	未登录("401","您未登录或者登录状态已过期"),
	用户名或密码错误("402","用户名或密码错误"),
	无权限("403","您无此操作权限"),
	查询不存在("404","查询不存在"),//如数据库中不存在等
	页面请求异常("405","页面请求异常"),
	接口不存在("406","请求接口不存在"),
	重复数据("407","已存在重复数据"),//如数据库中不存在等
	参数不全("408","参数不全"),
	用户不存在("409","用户不存在"),
	用户已禁用("501","用户已禁用"),
	正常("200","success"),
	Token无效("300","Token无效"),
	接口Token无效("301","Token无效"),
	参数不符合要求("302","参数不符合要求"),
	请求次数过多("303","请求次数过多"),
	不再使用该录("304","不再使用该录"),
	数据状态不正确("305","数据状态不正确"),
	余额不足了哟("306","余额不足了哟"),
	该信息已过时("307","该信息已过时"),
	邀请码不存在("410","用户不存在"),
	
	其他("509","其他");
	private final String value;
	private final String desc;
	ResultStatus(String value, String desc){
		this.value=value;
		this.desc=desc;
	}
	public String getValue() {
		return value;
	}
	public String getDesc() {
		return desc;
	}
}
