package vitily.com.util;
import vitily.base.tb_entity.BaseEntity;
import vitily.com.consts.DelTagDesc;
import vitily.com.consts.ResultStatus;
import vitily.com.other_entity.CustomerException;
import vitily.com.other_entity.NoExistsException;
import vitily.com.other_entity.ResultBack;
import vitily.com.util.log.LogAdapter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Random;

/**
 * 一些常用攻击集合
 * @author lether
 *
 */
public class CommonUtil {
	public static LogAdapter logger=LogAdapter.getLogAdapter(CommonUtil.class);
	/**
	 * 判断某个短字符串是否在常字符串内
	 * @param longStr 1
	 * @param shortStr 2
	 * @param trimStr 3
	 * @return 4
	 */
	public static boolean inStr(String longStr,String shortStr,char trimStr){
		return !StringUtil.isEmpty(shortStr) && (trimStr + longStr + trimStr).contains(trimStr + shortStr + trimStr);
	}
	/**
	 * 判断是否是正常的sql 只有[,a-zA-Z_d]" 才是
	 * @param sql 1
	 * @return 2
	 */
	public static boolean isNormalSql(String sql){
		return null != sql && sql.matches("^[a-z0-9A-Z,_.]*$");
	}

	/**
	 * 匹配逗号、数字(1,2,...3)
	 * @param strVal 1
	 * @return 2
	 */
    public static boolean isNumOrD(String strVal)
    {
    	return null != strVal && strVal.matches("^[-]?[\\d]+([,][-]?[\\d]+)*$");
    }
    /**
     * is email
     * @param strVal 1
     * @return 2
     */
    public static boolean isEmail(String strVal)
    {
    	return null != strVal && strVal.indexOf('@') > -1 && strVal.matches("^([a-z0-9A-Z_]+[-|.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$");
    }
    /**
     * 是否手机号码
     * @param strVal 1
     * @return 2
     */
    public static boolean isPhone(String strVal)
    {
    	return null != strVal && strVal.matches("^((13)|(14)|(15)|(16)|(17)|(18)|(19))(([0-9]{9})$)");
    }

	/**
	 * 是否整数
	 * @param strVal 1
	 * @return 2
	 */
	public static boolean isNumber(String strVal)
    {
    	return null != strVal && strVal.matches("^-?\\d+$");
    }

	/**
	 * 匹配逗号、数字｛含小数点｝
	 * @param strVal 1
	 * @return 2
	 */
	public static boolean isDecimalOrD(String strVal)
    {
    	return null != strVal && strVal.matches("^(\\d+(\\.)?\\d*)([,]\\d+(\\.)?\\d*)*$");
    }
    public static boolean isDecimal(String strVal){
    	return null != strVal && strVal.matches("^-?\\d+((\\.)?\\d+)?$");
    }
    public static boolean isNormalFilepath(String strVal){
		return (strVal != null && strVal.length() != 0) && strVal.matches("^[a-z0-9A-Z\\-_/]*$");
	}
    /**
     * 获取随即字符串[A-Z1-9]
     * @param length 1
     * @return 2
     */
    public static String ranStr(int length){
    	String base = "ABCDEFGHIJKLMNPQRSTUVWXYZ123456789";   
	    Random random = new Random();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();   
    }
	private static <T> boolean isEqualOfType(T left,T right){
        if (null != left) {
            return left.equals(right);
        } else if (null != right) {
            return false;
        }
		return true;
	}
	public final static boolean isNull(Object o){
		return null == o;
	}
	public final static boolean isNotNull(Object o){
		return null != o;
	}

	public static boolean isEqual(String left,String right){
		return isEqualOfType(left,right);
	}
	public static boolean isEqual(BigDecimal left, BigDecimal right){
		return isEqualOfType(left,right);
	}
	public static boolean isEqual(Integer left, Integer right){
		return isEqualOfType(left,right);
	}
	public static boolean isEqual(Long left, Long right){
		return isEqualOfType(left,right);
	}
    public static boolean isEqual(Enum left, Enum right){
        return isEqualOfType(left,right);
    }
	public static void SystemPrintln(Object obj){
		System.out.println(obj);
	}
	public static void SystemDebugPrintln(Object obj){
		System.out.println(obj);
	}
	public static ResultBack getResultByThrowle(Throwable e){
		ResultBack result;
		if(e instanceof CustomerException){
			logger.debug(e.getMessage());
			result = ((CustomerException) e).getResult();
		}else{
			logger.error(e.getMessage(),e);
			result = new ResultBack(ResultStatus.操作异常,null);
		}
		return result;
	}
	public final static void formartInsertEnntity(BaseEntity be){
		be.setCreateDate(new Date());
		be.setDeltag(DelTagDesc.正常.getValue());
	}
	public final static void formartUpdateEnntity(BaseEntity be){
		be.setUpdateDate(new Date());
	}
	public final static void checkIsNullEntity(Object o)throws Exception{
		if(isNull(o)) throw new NoExistsException("查询记录不存在，请检查");
	}
	/**
	 * 22位数：订单
	 * OrderTypeStr：3位订单类型
	 * serviceId:4位业务ID，不足补0，多的截取后4位
	 * memberId：4会员ID，不足补0，多的截取后4位
	 * timeMills:11位时间戳
	 *1234567890123456789012
	 * @param OrderTypeStr :订单分类：如001，002
	 * @param serviceId：涉及业务Id
	 * @param memberId：会员Id
	 * @return 1
	 */
	public static String getOrderNo(String OrderTypeStr,Integer serviceId,Integer memberId){
		if(OrderTypeStr == null){
			OrderTypeStr = "001";
		}
		char oc[] = {
				'0','0','0','0','0',
				'0','0','0','0','0',
				'0','0','0','0','0',
				'0','0','0','0','0',
				'0','0'};
		char[] tc = OrderTypeStr.toCharArray();
		//3位订单类型号
		setCharOfString(oc,OrderTypeStr,0,3);
		//4位业务id号
		setCharOfString(oc,String.valueOf(serviceId),3,4);
		//4位会员
		setCharOfString(oc,String.valueOf(memberId),7,4);
		//11位时间戳
		setCharOfString(oc,DateUtil.dateToDateString(new Date(),"ddHHmmssSSS"),11,11);

		return String.valueOf(oc);
	}
	private static void setCharOfString(char[] cc,String v,int beginPos,int len){
		if(v == null){
			v = "";
		}
		char[] tc = v.toCharArray();
		for(int i = len-1,l = tc.length -1;i >= 0 && l >=0;--i,--l){
			cc[beginPos+i] = tc[l];
		}
	}
}
