package vitily.com.payment.util;

import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.util.PropertiesFileUtil;
import vitily.com.util.StringUtil;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PayConfigUtil {
	public static final Object ORDER_DEAL_LOCK = new Object();
	public static String getWxAppId(){
		String appId = PropertiesFileUtil.readValue("wx_appid");
		return appId;
	}
	public static String getWxMchId(){
		String mchId = PropertiesFileUtil.readValue("wx_mch_id");
		return mchId;
	}
	public static String getWxNotifyUrl(){
		String notifyUrl = PropertiesFileUtil.readValue("wx_notify_url");
		return notifyUrl;
	}
	public static String getWxUnifiedorder(){
		String unifiedorder = PropertiesFileUtil.readValue("wx_unifiedorder");
		return unifiedorder;
	}
	public static String getWxRefundUrl(){
		String refundUrl = PropertiesFileUtil.readValue("wx_refund_url");
		return refundUrl;
	}
	public static String getWxRefundQueryUrl(){
		String refundQueryUrl = PropertiesFileUtil.readValue("wx_refund_query_url");
		return refundQueryUrl;
	}
	public static String getWxSSlcertPath(){
		String sslCertPath = PropertiesFileUtil.readValue("wx_sslcert_path");
		return sslCertPath;
	}
	public static String getWxSSlcertPwd(){
		String sslCertPwd = PropertiesFileUtil.readValue("wx_sslcert_pwd");
		return sslCertPwd;
	}
	public static String getWxApiKey(){
		String apiKey = PropertiesFileUtil.readValue("wx_api_key");
		return apiKey;
	}
	public static String getWxNativeTradeType(){
		String tradetype = PropertiesFileUtil.readValue("wx_native_trade_type");
		return tradetype;
	}
	
	
	
	public static String getUnionPayMerId(){
		String value = PropertiesFileUtil.readValue("acpsdk.merId");
		return value;
	}
	
	
	
	//
	public static String getAlipayGatewayUrl(){
		String value = PropertiesFileUtil.readValue("alipay.gatewayUrl");
		return value;
	}
	public static String getAlipayAppId(){
		String value = PropertiesFileUtil.readValue("alipay.APP_ID");
		return value;
	}
	public static String getAlipayAppPriKey(){
		String value = PropertiesFileUtil.readValue("alipay.APP_PRIVATE_KEY");
		return value;
	}
	public static String getAlipayAppPubKey(){
		String value = PropertiesFileUtil.readValue("alipay.ALIPAY_PUBLIC_KEY");
		return value;
	}
	public static String getAlipaySignType(){
		String value = PropertiesFileUtil.readValue("alipay.SIGN_TYPE");
		return value;
	}
	public static String getAlipayFormat(){
		String value = PropertiesFileUtil.readValue("alipay.FORMAT");
		return value;
	}
	public static String getAlipayNotifyUrl(){
		String value = PropertiesFileUtil.readValue("alipay.notify_url");
		return value;
	}
	public static String getAlipayReturnUrl(){
		String value = PropertiesFileUtil.readValue("alipay.return_url");
		return value;
	}
	public static String getAlipayWapReturnUrl(){
		String value = PropertiesFileUtil.readValue("alipay.wap.return_url");
		return value;
	}
	
	
	/**
	 * 判断订单是否归属于某人：韦海鹤 2017年05月27日10:08:50
	 * userId：登陆过后的userId
	 * phone：登陆过后的手机号码
	 * 说明：以phone为基准，假如用户登录了phone在登录userId，那么在对一个order进行评判时，
	 * 1，订单是单个订单，则判断stuPhones是否等于phone
	 * 2，订单是个多phone组合订单，则判断userId是否等于userId
	 * @param primeOrder
	 * @param userId
	 * @param phone
	 * @return
	 * @throws Exception
	 */
	public static boolean checkOrderOra(TbPayOrder primeOrder, String userId, String phone){
//		if(stuPhones.indexOf(",") < 0){
//			return stuPhones.equals(phone);
//		}
		return !StringUtil.isEmpty(primeOrder.getUserId()) && primeOrder.getUserId().equals(userId);
	}
	public static String getCurrentTime() {
		return new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
	}
	/**
	 * 获取 分单位的金钱
	 * @param primeAmount
	 * @return
	 */
	public static String getOrderAmount(BigDecimal primeAmount){
		String cc = primeAmount.multiply(new BigDecimal(100))+"";
		int dotPos = cc.indexOf(".");
		if(dotPos > -1){
			cc = cc.substring(0,dotPos);
		}
		return cc;
	}
}
