package vitily.com.util;

import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.MessageDigest;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;

import vitily.com.util.log.LogAdapter;

/**
 * HTTP-CLIENT 相关
 * 
 * 
 */
public class HttpClientUtil {
	static public LogAdapter logger= LogAdapter.getLogAdapter(HttpClientUtil.class);
    public static final String CHARSET_UTF_8 = "UTF-8";
    private static final String $line_feed = "\r\n";
    public static int connFTPNumber = 0;//链接ftp的次数

    public static <T> T doJsonService(String reqURL, Object obj, Class<T> clazz, int timeOut) throws Exception {
        //请求字符串
        //String reqStr = JSONObject.toJSONString(obj);
        String reqStr = JSON.toJSONString(obj);
        //调用接口
        timeOut = 60000;
        String respStr = doJSONPostMethod(reqURL, reqStr, timeOut);
        //封装对象
        return JSON.parseObject(respStr, clazz);
    }
    public static void main(String[] args) {
        try {
			String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx9446697eab8864e7&secret=d63f38c3d89f11f39ec51ac66b745827&code=021iaGt60aZxiK1yuxv602d0u60iaGtu&grant_type=authorization_code";
			String content = doJSONPostMethod(url,"",10000);

			System.out.println(content);
//        	TlAppFundinfo tlAppFundinfo = doJsonService("http://58.61.28.218:8002/gsinfo/fjjj/get_list.do",
//        			new Object(),TlAppFundinfo.class,10000
//        			);
//        	logger.info("tlAppFundinfo:"+(null == tlAppFundinfo));
//        	logger.info("tlAppFundinfo:"+(null == tlAppFundinfo.getGet_graded_fund_info()));
//        	logger.info("tlAppFundinfo:"+(null == tlAppFundinfo.getGet_graded_fund_list()));
//        	if(null != tlAppFundinfo){
//            	logger.info("tlAppFundinfo:"+JSON.toJSONString(tlAppFundinfo));
//        	}
//            String url = "http://localhost:10010/member/register_test";
//            TqRegister register = new TqRegister();
//            register.setValifyCode("1233");
//            register.setEntity(new TvMemBase());
//            register.getEntity().setId(343);
//            String jsonStr = JSON.toJSONString(register);
//          //调用接口
//            logger.info("jsonStr:"+jsonStr);
//            String respStr = doJSONPostMethod(url,jsonStr, 10000);
//            respStr = respStr.replace("\\\"", "\"");
//            logger.info("respStr:"+respStr);
            //封装对象
           // logger.info("results:"+JSON.toJSONString(JSON.parseObject(respStr, ResultBack.class)));
//            String content = "{\"service_name\":\"test\"}";
//            doPost("http", url, content, "", "", 36000);
            //String url_long="http://www.lovecaibao.com/acb/access/regCustomer.action?recommended=13724256432";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 抓取url内容并写入html
     * @url : url全地址
     * @fileName ： 保存的路径
     * @return
     */
    public static void ReadUrlToHtml(String strUrl,String dir,String fileName){
    	InputStream is;
    	FileOutputStream fos = null;
    	BufferedOutputStream bos = null;
    	BufferedInputStream bis = null;
    	try{
    		logger.info("====filepath====:" + dir + fileName);
        	File dest = new File(dir);
        	if(!dest.exists()){
        		dest.mkdirs();
        	}
        	dest = new File(dir, fileName);
	        fos = new FileOutputStream(dest);//字节输出流
	        URL url = new URL(strUrl);
	    	is = url.openStream();
	
	        bis = new BufferedInputStream(is);//为字节输入流加缓冲
	        bos = new BufferedOutputStream(fos);//为字节输出流加缓冲
	        int length;
	        byte[] bytes = new byte[1024*20];
	        while((length = bis.read(bytes, 0, bytes.length)) != -1){
	            fos.write(bytes, 0, length);
	        }
    	}catch(Exception e){
    		logger.info("error0:" + e.getMessage());
    	}finally{
    		logger.info(".end.");
    		try{
		        bos.close();
		        fos.close();
		        bis.close();
    		}catch(Exception ex){
        		logger.info("stream close error:" + ex.getMessage());
    		}
    	}
    }
    public static String doJSONPostMethod(String strURL, String requestStr, int timeOut) throws Exception {
        StringBuffer sbReturn = new StringBuffer("");
        URL url = null;
        HttpURLConnection httpConnection = null;
        InputStream in = null;
        OutputStream out = null;
        BufferedReader br = null;
        try {
            url = new URL(strURL);
            httpConnection = (HttpURLConnection) url.openConnection();

            httpConnection.setRequestMethod("POST");
            httpConnection.setRequestProperty("Content-Type", "application/json");
            httpConnection.setRequestProperty("Cache-Control", "no-cache");
            httpConnection.setRequestProperty("Content-Length", String.valueOf(requestStr.length()));
            httpConnection.setRequestProperty("accept", "*/*");


            httpConnection.setDoInput(true);
            httpConnection.setDoOutput(true);
            httpConnection.setConnectTimeout(timeOut);
            httpConnection.setReadTimeout(timeOut);

            out = httpConnection.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out, CHARSET_UTF_8);
            osw.append(requestStr);
            osw.flush();
            osw.close();

            in = httpConnection.getInputStream();
            br = new BufferedReader(new InputStreamReader(in, CHARSET_UTF_8));
            String strRead = "";
            while ((strRead = br.readLine()) != null) {
                sbReturn.append(strRead);
                sbReturn.append($line_feed);
            }
        } catch (Exception ex) {
            logger.error(strURL + "  can't curl   " + ex.getMessage(), ex);
            throw ex;
        } finally {
            try {
                if (out != null)
                    out.close();
            } catch (Exception fx) {
                fx.printStackTrace();
            }
            try {
                if (in != null)
                    in.close();
            } catch (Exception fx) {
                fx.printStackTrace();
            }
            try {
                if (br != null)
                    br.close();
            } catch (Exception fx) {
                fx.printStackTrace();
            }
            try {
                if (httpConnection != null)
                    httpConnection.disconnect();
            } catch (Exception fx) {
                fx.printStackTrace();
            }
        }
        String respString = sbReturn.toString();
        logger.info("Http strURL -->" + strURL);
        //logger.info("Http return response -->" + respString);
        return respString;
    }
//
//    public static <T> T doPostService(String reqURL, Object obj, Class<T> clazz, int timeOut) throws Exception {
//        //请求字符串
//        String reqStr = JSONObject.toJSONString(obj);
//        //调用接口
//        String respStr = doPost("",reqURL, reqStr,CHARSET_UTF_8, timeOut);
//        //封装对象
//        return JSON.parseObject(respStr, clazz);
//    }
//    /**
//     * 兼容 http 和 https 协议，如果需要用到 https 协议，需要修改 system.properties 的配置
//     *
//     * @param scheme
//     * @param reqURL
//     * @param content
//     * @param contentType
//     * @param charset
//     * @param timeout
//     * @return
//     * @throws Exception
//     */
//    @SuppressWarnings("unused")
//	public static String doPost(String scheme, String reqURL, String content, String charset, int timeout) throws Exception {
//        Map<String, String> params = new HashMap<String, String>();
//        //long responseLength = 0l;                         //响应长度
//        String responseContent = null;                   //响应内容
//        org.apache.http.client.HttpClient httpClient = new DefaultHttpClient(); //创建默认的httpClient实例
//
//        try {
//            long beginTime = System.currentTimeMillis();
//
//            if (scheme.equals("https"))
//                doSSL(httpClient);
//
//            httpClient.getParams().setParameter(CoreConnectionPNames.CONNECTION_TIMEOUT, timeout);
//            httpClient.getParams().setParameter(CoreConnectionPNames.SO_TIMEOUT, timeout);
//
//            if (StringUtil.isEmpty(charset))
//                charset = CHARSET_UTF_8;
//
//            HttpPost httpPost = new HttpPost(reqURL);                        //创建HttpPost
//
//            byte[] b = content.getBytes(charset);
//            InputStream is = new ByteArrayInputStream(b, 0, b.length);
//            HttpEntity httpEntity = new InputStreamEntity(is, b.length);
//            httpPost.setEntity(httpEntity);
//
//            HttpResponse response = httpClient.execute(httpPost); //执行POST请求
//            HttpEntity ehcacheUtil = response.getEntity();             //获取响应实体
//
//            if (null != ehcacheUtil) {
//                //responseLength = ehcacheUtil.getContentLength();
//                responseContent = EntityUtils.toString(ehcacheUtil, charset);
//                EntityUtils.consume(ehcacheUtil); //Consume response content
//            }
////            logger.info("请求地址: " + httpPost.getURI());
////            logger.info("响应状态: " + response.getStatusLine());
////            logger.info("响应长度: " + responseLength);
//            long endTime = System.currentTimeMillis();
//            logger.info("request url:" + reqURL + ",use time：" + (endTime - beginTime) + " ms，respContent:\r\n" + responseContent);
//        } finally {
//            httpClient.getConnectionManager().shutdown(); //关闭连接,释放资源
//        }
//        return responseContent;
//    }
//
//    private static void doSSL(org.apache.http.client.HttpClient httpClient) throws Exception {
//
////        String key_path = PropertiesFileUtils.readValue("https_key_path");
////        String psw = PropertiesFileUtils.readValue("https_psw");
////        int port = Integer.parseInt(PropertiesFileUtils.readValue("https_port"));
////        String scheme = "https";
////
////        //获得密匙库
////        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
////        FileInputStream instream = new FileInputStream(new File(key_path));
////        //密匙库的密码
////        trustStore.load(instream, psw.toCharArray());
////        //注册密匙库
////        SSLSocketFactory socketFactory = new SSLSocketFactory(trustStore);
////        //不校验域名
////        socketFactory.setHostnameVerifier(SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
////        Scheme sch = new Scheme(scheme, port, socketFactory);
////        httpClient.getConnectionManager().getSchemeRegistry().register(sch);
////
////        X509TrustManager xtm = new X509TrustManager() {   //创建TrustManager
////            public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
////            }
////
////            public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
////            }
////
////            public X509Certificate[] getAcceptedIssuers() {
////                return null;
////            }
////        };
////
////        //TLS1.0与SSL3.0基本上没有太大的差别，可粗略理解为TLS是SSL的继承者，但它们使用的是相同的SSLContext
////        SSLContext ctx = SSLContext.getInstance("TLS");
////
////        //使用TrustManager来初始化该上下文，TrustManager只是被SSL的Socket所使用
////        ctx.init(null, new TrustManager[]{xtm}, null);
//
//    }
//
//    /**
//     * 檢查請求訪問接口的IP是否合法
//     * @param reqIP
//     * @return
//     */
//    public static boolean check_get_api_ip(String reqIP){
//        String aollow_ips="127.0.0.1";
//        String config_ips="";
//        if(config_ips!=null && config_ips.length()>0){
//            aollow_ips+=",";
//            aollow_ips+=config_ips;
//        }
//        boolean isOkIp=false;
//        String userIp=reqIP;
//        String[] ipsArr=aollow_ips.split(",");
//        for(int i=0;i<ipsArr.length;++i){
//            if(ipsArr[i].equals(userIp)){
//                isOkIp=true;
//                break;
//            }
//        }
//        return isOkIp;
//    }

    public static String getIP(HttpServletRequest request){
        if(request == null){
            return "";
        }
        String ip = request.getHeader("x-forward-for");
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if ((ip == null) || (ip.length() == 0) || ("unknown".equalsIgnoreCase(ip))) {
            ip = request.getRemoteAddr();
        }

        if("0:0:0:0:0:0:0:1".equals(ip)){
            ip = "127.0.0.1";
        }
        return ip;
    }
    /**
	 * 根据url下载文件
	 * 
	 * @param url 
	 * @param localPath 文件保存路径，含文件名
	 * @return
	 * @throws Exception
	 */
	public static boolean downHTTPFile(String url, String localPath)
			throws Exception {
		boolean result = false;
		try {
			URL resourceUrl = new URL(url);
			HttpURLConnection con = (HttpURLConnection) resourceUrl.openConnection();
			////////////////yuxiaohui 2013.04.17 begin////////////////////
			con.setRequestProperty("Charset", "GBK");
			//con.setRequestProperty("contentType", "UTF-8");
			logger.info("======第"+connFTPNumber+"次链接=="+url);
			logger.info("========{"+con.getConnectTimeout()+","+con.getContentEncoding()+","+con.getContentLength()+","+con.getContentType()+","+
			        con.getDate()+","+con.getLastModified()+","+con.getExpiration()+","+con.getRequestMethod()+","+con.getResponseCode()+","+
			        con.getResponseMessage()+"}");
			if (null == con || (null != con && con.getResponseCode() != 200)){//|| (null != con && con.getContentLength() < 10000 && con.getContentLength() != -1)
	            if (connFTPNumber < 10){
	                connFTPNumber++;
	                con.disconnect();
	                Thread.sleep(3000);
	                downHTTPFile(url,localPath);
	            } else {
	                connFTPNumber = 0;
	            }
			}
			connFTPNumber = 0;
			/////////////////yuxiaohui 2013.04.17 end/////////////////////
			DataInputStream reader = new DataInputStream(con.getInputStream());
			File file = new File(localPath);
			if (!file.getParentFile().exists()) {
				file.getParentFile().mkdirs();
			}
			DataOutputStream writer = new DataOutputStream(
					new FileOutputStream(file));
			int ks = 0;
			while ((ks = reader.read()) != -1) {
				writer.write(ks);
			}
			writer.flush();//yuxiaohui 2013.04.17 
			reader.close();
			writer.close();
			con.disconnect();//yuxiaohui 2013.04.17 
			result=true;
		} catch (Exception e) {
			logger.error("连不上服务器!", e);
			logger.info(url);
			throw new Exception("下载http文件异常");
		}
		return result;
	}

	
	/**
	 * MD5比较两个文件是否一致
	 * 
	 * @param srcPath
	 * @param disPath
	 * @return
	 */
	public static boolean compareFileByMd5(String srcPath, String disPath) {
		boolean result = false;
		try {
			logger.info("-----left:" + srcPath);
			logger.info("-----right:" + disPath);
			File srcFile = new File(srcPath);
			File disFile = new File(disPath);
			if (!srcFile.isFile() || !disFile.isFile()) {
				return result;
			}
			String srcStr = getFileMD5(srcFile);
			String disStr = getFileMD5(disFile);
			if (srcStr == null || disStr == null) {
				return result;
			}
			if (srcStr.equals(disStr)) {
				result = true;
			}
		} catch (Exception e) {
			logger.debug("比较文档异常" + e.getMessage(), e);
		}
		return result;
	}
	/**
	 * 获得文件MD5内容
	 * 
	 * @param file
	 * @return
	 */
	public static String getFileMD5(File file) {
		if (!file.isFile()) {
			return null;
		}
		MessageDigest digest = null;
		FileInputStream in = null;
		byte buffer[] = new byte[1024];
		int len;
		try {
			digest = MessageDigest.getInstance("MD5");
			in = new FileInputStream(file);
			while ((len = in.read(buffer, 0, 1024)) != -1) {
				digest.update(buffer, 0, len);
			}
			in.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		BigInteger bigInt = new BigInteger(1, digest.digest());
		return bigInt.toString(16);
	}
}
