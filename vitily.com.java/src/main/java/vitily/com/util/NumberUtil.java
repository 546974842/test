package vitily.com.util;

import vitily.com.consts.Const;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 数值相关转换
 * @author lether
 *
 */
public class NumberUtil {
	public static Integer toInteger(Object obj,int defVal){
		if(obj == null){
			return defVal;
		}
		int ret = defVal;
		try{
			if(obj instanceof String){
				ret = new Integer((String)obj);
			}else{
				ret = (Integer)obj;
			}
		}catch(Exception e){
			ret = defVal;
		}
		return ret;
	}
	public static Integer toInteger(Object obj){
		if(obj == null){
			return null;
		}else if(obj instanceof String){
			return new Integer((String)obj);
		}
		return (Integer)obj;
	}
	/**
	 * 将字符串转成Long：如果String为null 则返回null
	 * @param str
	 * @return
	 */
	public static Long toLong(Object obj){
		if(obj == null){
			return null;
		}else if(obj instanceof String){
			return new Long((String)obj);
		}
		return (Long)obj;
	}
	public static Long toInteger(Object obj,long defVal){
		if(obj == null){
			return defVal;
		}
		long ret = defVal;
		try{
			if(obj instanceof String){
				ret = new Long((String)obj);
			}else{
				ret = (Long)obj;
			}
		}catch(Exception e){
			ret = defVal;
		}
		return ret;
	}
	/**
	 * 将字符串转成BigDecimal：如果String为null 则返回null
	 * @param str
	 * @return
	 */
	public static BigDecimal toBigDecimal(String str){
		if(str == null || !CommonUtil.isDecimal(str)){
			return null;
		}
		return new BigDecimal(str);
	}
	public static BigDecimal getScale2M(BigDecimal oldBigdecimal){
		BigDecimal setScale = oldBigdecimal.setScale(2,BigDecimal.ROUND_HALF_DOWN);
		return setScale;
	}
	public static BigDecimal getScale2M(Double value){
		BigDecimal setScale = BigDecimal.valueOf(value).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		return setScale;
	}
	public static String respScale2MDown(Double value){
		BigDecimal b = BigDecimal.valueOf(value).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		return String.valueOf(b);
	}

	/**
	 * 根据分转成元输出
	 * @param digit
	 * @return
	 */
	public static BigDecimal getScale2MDownYuanByCent(Long cent){
		return BigDecimal.valueOf(centToYuan(cent)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
	}
	public static String respScale2MDownYuanByCent(Long cent){
		BigDecimal op = BigDecimal.valueOf(centToYuan(cent)).setScale(2,BigDecimal.ROUND_HALF_DOWN);
		return String.valueOf(op);
	}
	public static double centToYuan(long cent){
		return (double)cent / Const.AMOUNT_UNIT;
	}

	/**
	 * 元转分：
	 * @param yuan
	 * @return
	 */
	public static long yuanToCent(double yuan){
		return Math.round(yuan*Const.AMOUNT_UNIT*Const.AMOUNT_UNIT)/Const.AMOUNT_UNIT;
	}

	/**
	 * 计算一次性还款利息
	 * @param cent
	 * @return
	 */
	public static double oneTimeIntest(long principal,double rate,int day,int dayOfYear){
		double intests = (principal*rate*day)/(Const.RATE_UNIT*dayOfYear);
		//return Math.round(intests*10)/10;
		return intests;
	}
	/**
	 * 计算按月付息总利息
	 * @param cent
	 * @return
	 */
	public static double monthlyPaymentDue(long principal,double rate,int month,int monthOfYear){
		double intests = (principal*rate*month)/(Const.RATE_UNIT*monthOfYear);
		//return Math.round(intests*10)/10;
		return intests;
	}

	/**
	 * 等额本金计算公式
	 * @param pricipal
	 * @param rate
	 * @param period
	 * @param monthOfYear
	 * @return
	 */
	public static List<Map<String,Long>> equalPrincipal(long pricipal, double rate, int period, int monthOfYear){
		List<Map<String,Long>> list = new ArrayList<>();
		long periodPrincipal = Math.round((double)pricipal / period);
		Map<String,Long> map;
		long restPrincipal =  pricipal;
		for(int i=0;i<period;++i){
			map = new HashMap<>();
			map.put("principal",periodPrincipal);
			map.put("period",(long)i+1);
			map.put("interests",half_even_up(restPrincipal*rate)/(Const.RATE_UNIT*monthOfYear));
			list.add(map);
			restPrincipal -=periodPrincipal;
		}
		//最后一期本金
		map = list.get(period-1);
		map.put("principal",map.get("principal") + restPrincipal);
		return list;
	}

	/**
	 * 等额本息每个月偿还金额/每个月偿还利息、本金（按分算）
	 * @param principal
	 * @param yearRate
	 * @param totalmonth
	 * @param monthOfYear
	 * @return
	 */
	public static Map<String,Object> getPerMonthPrincipal(long principal, double yearRate, int totalmonth,int monthOfYear) {
		double monthRate = yearRate / monthOfYear;
		//每个月偿还总金额
		long monthAmount = half_even_up(principal * monthRate * Math.pow(1 + monthRate, totalmonth)/(Math.pow(1 + monthRate, totalmonth) - 1));
		//每个月利息
		long[] perInterests = getPerMonthInterest(principal, yearRate, totalmonth,monthOfYear);
		long[] perPrincipals = new long[perInterests.length];
		long restPrincipal = principal;
		for(int i=0;i<perInterests.length;++i){
			perPrincipals[i] = monthAmount - perInterests[i];
			restPrincipal -= perPrincipals[i];
		}
		if(restPrincipal != 0){
			perPrincipals[perPrincipals.length-1] = perPrincipals[perPrincipals.length-1] + restPrincipal;
			perInterests[perInterests.length-1] = perInterests[perInterests.length-1] - restPrincipal;
		}

		Map<String,Object> map = new HashMap<>();
		map.put("monthAmount",monthAmount);//每个月偿还金额
		map.put("perPrincipals",perPrincipals);//每个月偿还利息列表
		map.put("perInterests",perInterests);//每个月偿还本金列表
		return map;
	}
	/**
	 * 等额本息每个月偿还本金
	 * @param principal
	 * @param yearRate
	 * @param totalmonth
	 * @param monthOfYear
	 * @return
	 */
	public static List<Double> getPerMonthPrincipal(double principal, double yearRate, int totalmonth,int monthOfYear) {
		double monthRate = yearRate / monthOfYear;
		double monthAmount = principal * monthRate * Math.pow(1 + monthRate, totalmonth)/(Math.pow(1 + monthRate, totalmonth) - 1);
		List<Double> interests = getPerMonthInterest(principal, yearRate, totalmonth,monthOfYear);
		List<Double> perPricipals = new ArrayList <>(interests.size());
		double restPrincipal = principal;
		for(int i=0;i<interests.size();++i){
			double p = monthAmount - interests.get(i);
			restPrincipal -= p;
			perPricipals.add(p);
		}
		return perPricipals;
	}
	/**
	 * 等额本息：每个月偿还利息
	 * @param principal
	 * @param yearRate
	 * @param totalmonth
	 * @param monthOfYear
	 * @return
	 */
	public static long[] getPerMonthInterest(long principal, double yearRate, int totalmonth,int monthOfYear) {
		double monthRate = yearRate/monthOfYear;
		double monthInterest;
		long[] perInterests = new long[totalmonth];
		for (int i = 1; i < totalmonth + 1; i++) {
			double multiply = principal*monthRate;
			double sub  = Math.pow(1 + monthRate, totalmonth) - Math.pow(1 + monthRate, i-1);
			monthInterest = multiply * sub/(Math.pow(1 + monthRate, totalmonth) - 1);
			perInterests[i-1] = half_even_up(monthInterest);
		}
		return perInterests;
	}
	/**
	 * 等额本息：每个月偿还利息
	 * @param principal
	 * @param yearRate
	 * @param totalmonth
	 * @param monthOfYear
	 * @return
	 */
	public static List<Double> getPerMonthInterest(double principal, double yearRate, int totalmonth,int monthOfYear) {
		List<Double> lst = new ArrayList <>();
		double monthRate = yearRate/monthOfYear;
		double monthInterest;
		for (int i = 1; i < totalmonth + 1; i++) {
			double multiply = principal*monthRate;
			double sub  = Math.pow(1 + monthRate, totalmonth) - Math.pow(1 + monthRate, i-1);
			monthInterest = multiply * sub/(Math.pow(1 + monthRate, totalmonth) - 1);
			lst.add(monthInterest);
		}
		return lst;
	}

	/**
	 * 四舍六入五考虑，五后非零就进一，五后为零看奇偶，五前为偶应舍去，五前为奇要进一
	 * @param cent
	 * @return
	 */
	public static long half_even_up(Double cent){
		//先乘以 10000 四舍五入
		double x = (double) Math.round(cent*10000)/10000;

		long o = (long)x;
		int y = (int)(x*10)%10;
		if(y < 5){//舍去
			return o;
		}else if(y > 5){//进一
			return o+1;
		}else{
			//5后非0就进1
			int z=(int)(x*100)%10;
			if(z !=0){
				return o+1;
			}else{
				//5后为0 看奇偶
				//五前为偶应舍去
				if((int)x%2 == 0){
					return o;
				}else{//五前为奇要进一
					return o+1;
				}
			}
		}
	}
	/**
	 * 计算一次性还款利息：单位：分,对厘的下一位进行四舍五入
	 * 1，假如利息计算是6045.699999：则算的6045
	 * 2，假如利息计算是6045.9499999，则算的6045
	 * 3，假如利息计算是6045.9511111，则算的6046
	 * @param cent
	 * @return
	 */
	public static long monthlyPaymentDueIntest(long principal,double rate,int day,int dayOfYear){
		double intests = (principal*rate*day)/(Const.RATE_UNIT*dayOfYear);
		return Math.round(intests*10)/10;
	}
	public static void main(String[] args){
		Long l = 1000l;
		CommonUtil.SystemDebugPrintln(l/11);
	}
}
