package vitily.com.payment;

import org.jdom.JDOMException;
import vitily.com.api_entity.req_entity.mem.TqPlaceOrder;
import vitily.com.other_entity.CustomerException;
import vitily.com.service.pay.PayOrderService;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.tv_entity.pay.TvPayOrder;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public interface PayMentService extends PayOrderService {
	/**
	 * 各种网关支付：拼接成html再自动提交：参考银联支付
	 * @return
	 */
	public String createAutoFormHtml(TbPayOrder sfud, HttpServletRequest request, HttpServletResponse response)throws CustomerException,IOException,Exception;
	String createAutoFormHtml(TbPayOrder sfud,String mode, HttpServletRequest request, HttpServletResponse response)
			throws CustomerException,IOException,Exception;
	//1，创建二维码接口
	//2，跳转支付接口
	//3,获取支付结果接口：扫码支付
	
	/**
	 * 获取/创建二维码的url
	 * @return
	 */
	public String getOrderQrcodeUrl(TvPayOrder enitty)throws JDOMException,CustomerException,IOException,Exception;
	/**
	 * 输出二维码
	 * @param recharge
	 * @param request
	 * @param response
	 * @throws JDOMException
	 * @throws CustomerException
	 * @throws IOException
	 * @throws Exception
	 */
	public void respOrderQrcode(TbRecharge recharge, HttpServletRequest request, HttpServletResponse response)throws JDOMException,CustomerException,IOException,Exception;
	
	/**
	 * 第三方通知
	 * @return
	 * @throws CustomerException
	 * @throws IOException
	 */
	public String notifyOrder(HttpServletRequest request, HttpServletResponse response)throws CustomerException,IOException,Exception;
	/**
	 * 查询类交易：成功时返回Map
	 * @param payOrder
	 * @param request
	 * @param response
	 * @throws CustomerException
	 * @throws Exception
	 */
	@SuppressWarnings("rawtypes")
	public Map query(TbPayOrder payOrder, HttpServletRequest request, HttpServletResponse response)throws CustomerException,Exception;
}
