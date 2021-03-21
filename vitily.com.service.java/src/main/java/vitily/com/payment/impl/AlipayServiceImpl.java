package vitily.com.payment.impl;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alipay.api.*;
import com.alipay.api.domain.AlipayAccount;
import com.alipay.api.request.AlipayTradeWapPayRequest;
import org.apache.log4j.Logger;
import org.jdom.JDOMException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.AlipayTradePagePayRequest;
import vitily.com.consts.*;
import vitily.com.other_entity.CustomerException;
import vitily.com.payment.PayMentService;
import vitily.com.payment.util.AlipayBizObject;
import vitily.com.payment.util.PayConfigUtil;
import vitily.com.service.pay.impl.PayOrderServiceImpl;
import vitily.com.tb_entity.finance.TbRecharge;
import vitily.com.tb_entity.mem.TbMemBase;
import vitily.com.tb_entity.pay.TbOrderDropout;
import vitily.com.tb_entity.pay.TbOrderFlow;
import vitily.com.tb_entity.pay.TbPayOrder;
import vitily.com.tb_entity.pay.TbPayRecord;
import vitily.com.tv_entity.finance.TvRecharge;
import vitily.com.tv_entity.pay.TvPayOrder;
import vitily.com.util.CommonUtil;
import vitily.com.util.NumberUtil;


@Service("payMentService_0")
public class AlipayServiceImpl extends PayOrderServiceImpl implements PayMentService {

	private static Logger logger = Logger.getLogger(AlipayServiceImpl.class);
	/**
	 * 各种网关支付：拼接成html再自动提交：参考银联支付
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	public String createAutoFormHtml(TbPayOrder sfud, HttpServletRequest request, HttpServletResponse response)throws
			CustomerException,IOException,Exception{
		logger.info("支付宝网关支付开始.");

        //检查是否可以去支付
		synchronized(PayConfigUtil.ORDER_DEAL_LOCK){
			TvPayOrder payOrder = payOrderMapper.selectForUpdate(sfud.getOrderNo());
	        getToPayCheck(payOrder);
	        //set session for return_url
	        request.getSession().setAttribute(Const.CURRENT_SESSEIONID, payOrder.getId());
	        //
	        
			AlipayClient alipayClient = 
					new DefaultAlipayClient(
							PayConfigUtil.getAlipayGatewayUrl(), 
							PayConfigUtil.getAlipayAppId(), 
							PayConfigUtil.getAlipayAppPriKey(), 
							PayConfigUtil.getAlipayFormat(), 
							"utf-8", 
							PayConfigUtil.getAlipayAppPubKey(), 
							PayConfigUtil.getAlipaySignType());
			AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
			alipayRequest.setReturnUrl(PayConfigUtil.getAlipayReturnUrl());
			alipayRequest.setNotifyUrl(PayConfigUtil.getAlipayNotifyUrl());
			StringBuffer payContent = new StringBuffer("{");
			//orderNo
			payContent.append("\"out_trade_no\":\"").append(payOrder.getOrderNo()).append("\",");
			//product_code
			payContent.append("\"product_code\":\"FAST_INSTANT_TRADE_PAY\",");
			//subject
			//********************************************** 注意原始单位是分，需要转化 **********************************************
			payContent.append("\"total_amount\":").append(NumberUtil.respScale2MDownYuanByCent(payOrder.getOrderAmount())).append(",");
			payContent.append("\"subject\":\"").append("rec:baiwanxiu,id:"+payOrder.getId()).append("\",");
			
			//timeout_express：由于存在可控，因此过期时间不设置
			
			//passback_params
			payContent.append("\"passback_params\":\"").append(payOrder.getUserId()).append("\"");;
			
			payContent.append("}");
			alipayRequest.setBizContent(payContent.toString());//填充业务参数
		    String form="";
		    try {
		        form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
		    } catch (AlipayApiException e) {
		        e.printStackTrace();
		    }

			//更新订单
			sfud.setId(payOrder.getId());
			payOrderMapper.updateByPrimaryKeySelective(sfud);
			
//		    response.setContentType("text/html;charset=utf-8");
//		    response.getWriter().write(form);//直接将完整的表单html输出到页面
//		    response.getWriter().flush();
//		    response.getWriter().close();
			return form;
		}
	}
	/**
	 * 各种网关支付：拼接成html再自动提交：参考银联支付
	 * @param
	 * @param
	 * @param
	 * @return
	 */
	@Override
	public String createAutoFormHtml(TbPayOrder sfud,String mode, HttpServletRequest request, HttpServletResponse response)
			throws CustomerException,IOException,Exception{
		logger.info("支付宝网关支付开始.");

		//检查是否可以去支付
		synchronized(PayConfigUtil.ORDER_DEAL_LOCK){
			TvPayOrder payOrder = payOrderMapper.selectForUpdate(sfud.getOrderNo());
			getToPayCheck(payOrder);
			//set session for return_url
			request.getSession().setAttribute(Const.CURRENT_SESSEIONID, payOrder.getId());
			//

			AlipayClient alipayClient =
					new DefaultAlipayClient(
							PayConfigUtil.getAlipayGatewayUrl(),
							PayConfigUtil.getAlipayAppId(),
							PayConfigUtil.getAlipayAppPriKey(),
							PayConfigUtil.getAlipayFormat(),
							"utf-8",
							PayConfigUtil.getAlipayAppPubKey(),
							PayConfigUtil.getAlipaySignType());
			AlipayRequest alipayRequest;
			String productCode = "QUICK_WAP_PAY";
			if(CommonUtil.isEqual(mode,RechargeModeDesc.wap.getValue())){
				alipayRequest = new AlipayTradeWapPayRequest();
				alipayRequest.setReturnUrl(PayConfigUtil.getAlipayWapReturnUrl());
				alipayRequest.setNotifyUrl(PayConfigUtil.getAlipayNotifyUrl());
			}else{
				alipayRequest = new AlipayTradePagePayRequest();
				alipayRequest.setReturnUrl(PayConfigUtil.getAlipayReturnUrl());
				alipayRequest.setNotifyUrl(PayConfigUtil.getAlipayNotifyUrl());
				productCode = "FAST_INSTANT_TRADE_PAY";
			}

			StringBuffer payContent = new StringBuffer("{");
			//orderNo
			payContent.append("\"out_trade_no\":\"").append(payOrder.getOrderNo()).append("\",");
			//product_code
			payContent.append("\"product_code\":\"FAST_INSTANT_TRADE_PAY\",");
			//subject
			//********************************************** 注意原始单位是分，需要转化 **********************************************
			payContent.append("\"total_amount\":").append(NumberUtil.respScale2MDownYuanByCent(payOrder.getOrderAmount())).append(",");
			payContent.append("\"subject\":\"").append("rec:baiwanxiu,id:"+payOrder.getId()).append("\",");

			//timeout_express：由于存在可控，因此过期时间不设置

			//passback_params
			payContent.append("\"passback_params\":\"").append(payOrder.getUserId()).append("\"");
			payContent.append("}");

			AlipayBizObject alipayObject = new AlipayBizObject();
			alipayObject.setOutTradeNo(payOrder.getOrderNo());
			alipayObject.setProductCode(productCode);//
			alipayObject.setTotalAmount(NumberUtil.respScale2MDownYuanByCent(payOrder.getOrderAmount()));
			alipayObject.setSubject("rec:baiwanxiu,id:"+payOrder.getId());
			alipayObject.setPassbackParams(payOrder.getUserId());
			alipayRequest.setBizModel(alipayObject);//填充业务参数
			String form="";
			try {
				form = alipayClient.pageExecute(alipayRequest).getBody(); //调用SDK生成表单
			} catch (AlipayApiException e) {
				e.printStackTrace();
			}

			//更新订单
			sfud.setId(payOrder.getId());
			payOrderMapper.updateByPrimaryKeySelective(sfud);

//		    response.setContentType("text/html;charset=utf-8");
//		    response.getWriter().write(form);//直接将完整的表单html输出到页面
//		    response.getWriter().flush();
//		    response.getWriter().close();
			return form;
		}
	}
	/**
	 * 获取二维码图片的url:
	 * 生成直接支付url，支付url有效期为2小时,模式二
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public String getOrderQrcodeUrl(TvPayOrder entity)throws JDOMException,CustomerException,IOException,Exception{
        return null;
	}
	
	/**
	 * 支付通知
	 * 依支付宝要求，仅作为支付通知，不做退款通知
	 * 
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	@Transactional(rollbackFor=Exception.class,propagation=Propagation.NESTED)
	public String notifyOrder(HttpServletRequest request,HttpServletResponse response) throws CustomerException, IOException,Exception {
		//读取参数  
		logger.info("支付宝验签开始...");
		Map<String,String> params = new HashMap<String,String>();
		Map<String,String[]> requestParams = request.getParameterMap();
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			//乱码解决，这段代码在出现乱码时使用
			valueStr = new String(valueStr.getBytes("ISO-8859-1"), "utf-8");
			params.put(name, valueStr);
		}
		logger.info("params:" + JSON.toJSONString(params));
		System.out.println("params:" + JSON.toJSONString(params));
		
		boolean signVerified = AlipaySignature.rsaCheckV1(
				params, 
				PayConfigUtil.getAlipayAppPubKey(), 
				"utf-8", 
				PayConfigUtil.getAlipaySignType()
				); //调用SDK验证签名
		String app_id = request.getParameter("app_id");
		if(signVerified && PayConfigUtil.getAlipayAppId().equals(app_id)){
			String out_trade_no = request.getParameter("out_trade_no");
			
			//支付宝交易号
			String trade_no = request.getParameter("trade_no");
		
			//交易状态
			String trade_status = request.getParameter("trade_status");

            //锁：非分布式下可用
            Date now = new Date();
            synchronized (PayConfigUtil.ORDER_DEAL_LOCK) {

	            TbPayOrder sfude = new TbPayOrder();
	            sfude.setOrderNo(out_trade_no);
	            TbPayOrder payOrder = payOrderMapper.selectForUpdate(out_trade_no);
	            //创建支付记录
	            TbPayRecord tbPayRecord = new TbPayRecord();
	            tbPayRecord.setOrderNo(out_trade_no);//订单号
	        	if(null != payOrder){
	            	tbPayRecord.setOrderId(payOrder.getId());//订单id：加入有的话
	            	tbPayRecord.setPayAmount(payOrder.getOrderAmount());//应支付金额
	        	}
	        	tbPayRecord.setPayment(PaymentEnum.ZFBInstant.getValue());
	        	tbPayRecord.setReceivedTime(now);
	        	tbPayRecord.setDesc(request.getParameter("body")+"");
	            tbPayRecord.setNotifyUrl(PayConfigUtil.getAlipayNotifyUrl());

	            //支付成功
	            if("TRADE_FINISHED".equals(trade_status) || "TRADE_SUCCESS".equals(trade_status)){
	                  
	                String total_fee = (String)request.getParameter("total_amount");
	                Long b_total_fee = (long)(NumberUtil.toBigDecimal(total_fee).doubleValue()*Const.AMOUNT_UNIT);
	                
	                tbPayRecord.setPaidAmount(b_total_fee);
	                tbPayRecord.setOther0(request.getParameter("seller_id"));//
	                tbPayRecord.setOther1(trade_no);//支付订单号
	                tbPayRecord.setOther2(request.getParameter("body"));//商家数据包，原样返回
	                tbPayRecord.setPayId(request.getParameter("buyer_id"));//用户在商户appid下的唯一标识
	                
	                //////////执行自己的业务逻辑////////////////
	                logger.info("支付成功,金额：" + b_total_fee);
	
	            	//如果订单不存在：追加进入掉单表
	            	//如果订单无法处理:追加进入掉单表
	            	if(null == payOrder || !PayStateEnum.getCouldDealPaid(payOrder.getPayState())){
	            		TbOrderDropout tbOrderDropout = new TbOrderDropout();
	            		tbOrderDropout.setOrderId(null == payOrder ? 0 : payOrder.getId());//如果是null说明订单异常
	            		tbOrderDropout.setOrderNo(out_trade_no);
	            		tbOrderDropout.setDropAmount(b_total_fee);
	            		tbOrderDropout.setDealed(TrueFalseDesc.否.getValue());
	            		tbOrderDropout.setPayment(PaymentEnum.ZFBInstant.getValue());
	            		orderDropoutMapper.insertSelective(tbOrderDropout);
	            		
	            	}else{
	            		//订单存在且可以进行处理的 判断订单金额：更新已支付金额
	            		//假如订单金额>已支付金额 改成部分支付
	            		//假如订单金额=已支付金额 改成已支付
	            		Long paidAmount = b_total_fee;
	            		if(null != payOrder.getPaidAmount()){
	            			paidAmount = paidAmount + (payOrder.getPaidAmount());
	            		}
	            		if(payOrder.getOrderAmount().compareTo(paidAmount) > 0){
	            			sfude.setPayState(PayStateEnum.PaidPart.getValue());
	            		}else{
	            			sfude.setPayState(PayStateEnum.PaidAll.getValue());
	            		}
	            		tbPayRecord.setPayState(sfude.getPayState()+"");

	            		//为了防止出错，仅仅修改订单状态/actualPayUser/paidAmount/paidTime
	            		//
	            		sfude.setId(payOrder.getId());
	            		sfude.setPaidAmount(paidAmount);
	            		sfude.setActualPayUser(request.getParameter("buyer_id"));
	            		sfude.setPaidTime(now);//以接收到通知为准
	            		sfude.setPayment(PaymentEnum.ZFBInstant.getValue());
	            		sfude.setTransactionId(trade_no);
	            		payOrderMapper.updateByPrimaryKeySelective(sfude);
	            		
	            		//插入订单流水
	            		TbOrderFlow orderFlow = new TbOrderFlow();
	            		orderFlow.setOrderId(payOrder.getId());
	            		orderFlow.setOrderNo(payOrder.getOrderNo());
	            		orderFlow.setHandler("system");
	            		orderFlow.setDesc(
	            				"支付宝支付通知更新订单，该次成功支付金额:" 
	            				+ b_total_fee);
	            		orderFlow.setContent(JSON.toJSONString(sfude));
	            		orderFlow.setDealTime(now);
	            		orderFlowMapper.insertSelective(orderFlow);

	            		//如果是入驻类型的，直接升级入驻不加入余额
						if(CommonUtil.isEqual(payOrder.getOther6(),DictionaryKey.Keys.模特入驻费用.getValue())){
							//
							TbMemBase upMember = new TbMemBase();
							upMember.setLevel(1);
							upMember.setId(Integer.valueOf(payOrder.getUserId()));
							memBaseMapper.updateByPrimaryKeySelective(upMember);

						}else {

							TvRecharge recharge = rechargeMapper.selectByOrderNoForUpdate(out_trade_no);
							if (CommonUtil.isNotNull(recharge) && CommonUtil.isEqual(recharge.getState(), RechargeStateDesc.充值中.getValue())) {
								recharge.setArrivedAmount(paidAmount);
								recharge.setUpdateDate(new Date());
								recharge.setState(RechargeStateDesc.充值成功.getValue());
								String memo = recharge.getModeDesc() + "充值,订单号：" + recharge.getOrderNo() + "金额：" + NumberUtil.respScale2MDownYuanByCent(recharge.getApplyAmount());
								recharge.setMemo(memo);
								rechargeMapper.updateByPrimaryKeySelective(recharge);

								FundsTypeDesc fundsType = FundsTypeDesc.充值;
								memLocalAccountAdapter.availableIn(recharge.getMemberId(), recharge.getArrivedAmount(), fundsType, memo, recharge.getPlatform(), recharge.getId(), now);
							} else {
								logger.info("充值记录不存在：" + out_trade_no);
							}
						}
	            		
	            	}
	            } else {
	            	tbPayRecord.setPayState(PayStateEnum.Error.getValue()+"");//支付失败
	            }
	        	//添加支付记录
	            payRecordMapper.insertSelective(tbPayRecord);
            }
			
			response.getWriter().print("success");
		}else{
            logger.info("支付宝通知签名验证失败");
			response.getWriter().print("fail");
		}
		return null;
	}
	
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
	@SuppressWarnings("unchecked")
	public void respOrderQrcode(TbRecharge recharge, HttpServletRequest request, HttpServletResponse response)throws JDOMException,CustomerException,IOException,Exception{

	}
	public static void main(String[] args){
		String str = "\"saf\"fds\"fdsa";
		System.out.println(str);
		System.out.println(str.replace("\"", "-"));
//		BigDecimal a = new BigDecimal("20.00222");
//		System.out.println("a:" + a);
//		a = a.setScale(2, RoundingMode.UP);
//		System.out.println("a:" + a);
//		BigDecimal b = a;
//		b = b.add(BigDecimal.ONE);
//		System.out.println("a:" + a);
//		System.out.println("b:" + b);
	}

	
	/**
	 * 普通查询类交易
	 */
	@Override
	public Map query(TbPayOrder payOrder, HttpServletRequest request,
			HttpServletResponse response) throws CustomerException, Exception {
		// TODO Auto-generated method stub
		return null;
	}
}
