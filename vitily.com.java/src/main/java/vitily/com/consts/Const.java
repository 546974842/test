package vitily.com.consts;

public class Const {

    public static final String[] PRO_FILTER_ITEMS={"id","fieldName","fieldShowName","rowWidth","sortable","fieldProperName","visibleTemplate","colGroup","rowGroup","fixed"};
	/**
	 * 后台用户存储保存key
	 */
	public static final String ADMIN_STORAGE_KEY="admin_storage_key";
	/**
	 * 后台验证码 session key
	 */
	public static final String ADMIN_VERIFY_SESSION="admin_verifyCode";
    /**
     * 前台验证码 session key
     */
    public static final String MEMBER_VERIFY_SESSION="member_verifyCode";
    public static final String MEMBER_SERVER_STORAGE_KEY = "member_server_storage";
    public static  final int PHONE_VERIFYCODE_DEFAULT_LEAVE_SECONDES = 5 * 60;
    public static final String CURRENT_SESSEIONID = "CURRENT_SESSEIONID";
    /**
     * 前台验证码 session key
     */
    public static final int PHONE_CODE_LENGTH = 4;

	/**
	 * 超级管理员id
	 */
    public static final int SUP_ADMIN_ID = 1;

    /**
     * 额外超级管理员ID
     */
    public static final int EXP_SUP_ADMIN_ID = 749823251;
    
    /**
     * 公共默认缓存时长:秒
     */
    public static final int COMMON_CACHE_DEFAULT_VALITY_SECONDS=60;
    
    /**
     * 每页最大显示条数
     */
    public static final int COMMON_MAX_PAGESIZE = 500000;
    
    /**
     * 每页默认显示条数
     */
    public static final int COMMON_DEFAULT_PAGESIZE = 10;
    

    /// 信息分类Id
    public final static int NEWSCATE_SYSTYPE_ID = 32;
    /// 产品分类Id
    public final static int PROCATE_SYSTYPE_ID = 70;
    public final static int AMOUNT_UNIT = 100;
    public final static int RATE_UNIT = 100;
}
