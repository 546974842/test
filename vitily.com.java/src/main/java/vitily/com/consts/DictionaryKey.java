package vitily.com.consts;

public class DictionaryKey {

	//以下是会员事件
	public enum Keys{
		上传图片宽度("PIC_WIDTH"),//图片宽度
		上传图片高度("PIC_HEIGHT"),//图片高度
		会员登陆尝试次数("DAY_MEM_TRY_LOGIN_COUNT"),//会员当天登录错误几次无法再次登陆
		会员每天可发送短信次数("DAY_SEND_VERIFYCODE_COUNT"),//会员每天可以发多少次短信验证码（每种类型）
		发送验证码时间间隔("VERIFYCODE_FREQUENT_TIME"),//会员每次发送验证码间隔时间(单位秒每种类型)
		前台是否显示短信内容("IS_SHOW_SMS_CONTENT"),//前台是否显示手机验证码：测试需要(1是，0否)
		是否真实发送短信("IS_SEND_SMS_CONTENT"),//是否发送验证码：测试不需要发送（1:发送，0:不发送）
		每天验证码尝试匹配次数("DAY_VERIFYCODE_TRY_COUNT"),//一天输入验证码错误多少次数不可再输入且不可再发送
		身份校验通过有效期("IDENTITY_VERIFY_VALITY"),//身份校验通过有效期(秒钟，退出后清除) //注意存的是eToken 因为每个会员都是唯一的
		订单频繁时间间隔("ORDER_FREQUENT"),//订单频繁次数时间间隔（单位：秒）
		会员Token("MEMBER_TOKEN"),//服务器存为key（值为memberId），客户端（请求api的源存为值）
		后台用户Token("ADMIN_TOKEN"),//后台token保存默认时长
		后台验证码长度("ADMIN_VERIFY_LEN"),//
		客户端验证码长度("CONSUMER_VERIFY_LEN"),//
		每天尝试密保问题次数("SECURITY_TRY_COUNT"),
		公共缓存次数保存时长("COMMON_SERVICE_TRY_COUNT"),
		后台用户名最短长度("ADM_NAME_MIN_LEN"),//后台用户名最少长度
		后台用户名最长长度("ADM_NAME_MAX_LEN"),//后台用户名最长长度
		后台用户密码最短长度("ADM_PWD_MIN_LEN"),//后台用户密码最少长度
		后台用户密码最长长度("ADM_PWD_MAX_LEN"),//后台用户密码最长长度
		默认提现手续费("DEFAULT_WITHDRAW_FEE"),//默认提现手续费
		SESSION保存时长("SESSION_CACHE_PERIOD"),

		会员用户名最短长度("MEM_NAME_MIN_LEN"),//会员用户名最短长度
		会员用户名最长长度("MEM_NAME_MAX_LEN"),//会员用户名最长长度
		会员用户密码最短长度("MEM_PWD_MIN_LEN"),//会员用户密码最短长度
		会员用户密码最长长度("MEM_PWD_MAX_LEN"),//会员用户密码最长长度
		会员昵称最短长度("MEM_NICKNAME_MIN_LEN"),//会员昵称最短长度
		会员昵称最长长度("MEM_NICKNAME_MAX_LEN"),//会员昵称最长长度

		后台最大登陆尝试次数("DAY_ADMIN_TRY_LOGIN_COUNT"),//后台当天登录错误几次无法再次登陆
		还剩几天密码过期提醒("ADM_PWD_EXP_REMID_DAY"),//
		浏览器登录几次错误后需要验证码("MEM_TRY_LORR_COUNT"),
		接口url保存时长("API_URI_SAVE_TIME"),
		接口日志保存("API_LOG_SAVE"),
		接口商户信息("APICONSUMER_SAVE_TIME"),
		文件上传地址("FILE_UP_DIR"),//分布式文件系统下应保存在相同的路径
		图片上传保存时长("IMG_UP_SAVE"),
		图片上传大小限制("IMG_UP_MAX_SIZE"),
		附件上传大小限制("FILE_UP_MAX_SIZE"),
		后台日志保存("ADM_LOG_SAVE"),
		CMS每页显示条数("CMSNEWS_PAGESIZE"),
		
		文件服务器域名("FILE_HOST"),
		内容默认来源("CONTENT_FROM_DEFAULT"),

		APIToken保存时长("API_TOKEN_TIME"),
		每个IP最多可以同时存在TOKEN数("API_TOKEN_MAX_COUNT"),

		企业资产认证默认信息积分("CREDITFILE_COMPANY_COMPANY_ASSETS_INTEGRAL"),
		企业注册资本默认信用积分("CREDITFILE_COMPANY_REGISTERED_CAPITAL_INTEGRAL"),
		企业营业执照默认信用积分("CREDITFILE_COMPANY_BUSINESS_LICENSE_INTEGRAL"),
		股票基金默认信用积分("CREDITFILE_STOCK_FUND_INTEGRAL"),
		房产信息默认信用积分("CREDITFILE_ESTATE_INFO_INTEGRAL"),
		车辆认证信息默认信用积分("CREDITFILE_CAR_INFO_INTEGRAL"),
		个人驾照认证默认信用积分("CREDITFILE_PERSONAL_DRIVER_LICENSE_INTEGRAL"),
		个人工作年限认证默认信用积分("CREDITFILE_PERSONAL_JOBS_YEARS_INTEGRAL"),
		个人学历认证默认信用积分("CREDITFILE_PERSONAL_EDUCATION_LEVEL_INTEGRAL"),
		一年按多少天计算天息("DAY_RATE_OF_YEAR"),
		距离多少天还款就提醒用户该准备还款了("LIMIT_DAY_TO_REMIND_MEM_REPAY_DEBIT"),
		P2P商户平台会员ID("P2P_MERCH_MEMBER_ID"),
		模特入驻费用("MODEL_ENTER_FEE"),
		分润会员ID组合("SPECIAL_MEMBER_IDS"),
		提分润会员提成点("提分润会员提成点"),
		
		//以下是数据库没有的
		系统字典_NOSQL("sys_dictionary_"),//独立
		接口商户登陆Token("APICONSUMER_TOKEN"),
		其他("COMMON_SERVICE_OTHER"),
		分类("CATEGORY_SAVE"),

		;
		public String value;
		Keys(String value){
			this.value=value;
		}
		public String getValue() {
			return value;
		}
	}
	/**
	 * 后台用户
	 * @author lether
	 *
	 */
	public enum AdminServiceKeyType{
		后台用户登陆尝试次数(0),
		验证码问题尝试次数(1);
		public final int value;
		AdminServiceKeyType(int value){
			this.value=value;
		}
		public int getValue() {
			return value;
		}
	}
	/**
	 * 会员公共缓存次数保存 类型
	 * @author lether
	 *
	 */
	public enum MemServiceKeyType{
		会员登陆尝试次数(0),
		会员验证码问题尝试次数(1),
		后台用户登陆尝试次数(2),
		后台验证码问题尝试次数(3),
		每个IP最多可以同时存在TOKEN数(4),
		;
		public final int value;
		MemServiceKeyType(int value){
			this.value=value;
		}
		public int getValue() {
			return value;
		}
	}
	public enum IdentityVerifyType{
		手机验证码校验(0),
		密保问题校验(1),
		密保卡校验(2),
		支付密码校验(3);
		public final int value;
		IdentityVerifyType(int value){
			this.value=value;
		}
		public int getValue() {
			return value;
		}
	}
}
