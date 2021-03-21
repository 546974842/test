package vitily.com.payment.util;

import vitily.com.payment.PayMentService;
import vitily.com.util.PropertiesFileUtil;
import vitily.com.util.SpringContextUtil;

public class PaymentSerficeFac {
	/**
	 * 通过支付类型获取支付service
	 * @param payment
	 * @return
	 */
	public static PayMentService getMentServiceByPayment(Integer payment){
		return SpringContextUtil.getBean("payMentService_" + payment);
	}
}
