package com.mengke.util.phone;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import com.mengke.web.qrcode.CheckSumBuilder;

import net.sf.json.JSONObject;
/**
 * 这个checkSumBuilder的参考示例，请在官网上服务器端API上查看，有一个计算checkSum的实例
 */
/**
 * 发送验证码
 * @author liuxuanlin
 *
 */
public class SendCode {
	/**
	 *  通知类短信，请求的URL（https://api.netease.im/sms/sendtemplate.action ）
		运营类短信，请求的URL（https://api.netease.im/sms/sendtemplate.action ）
		验证码短信，请求的URL（https://api.netease.im/sms/sendcode.action）
	 */
    //发送验证码的请求路径URL
    private static final String
            SERVER_URL="https://api.netease.im/sms/sendcode.action";
    //网易云信分配的账号，请替换你在管理后台应用下申请的Appkey
    private static final String 
            APP_KEY="ceaeabdc0f3df8a1de2cb7edb1c08930";
    //网易云信分配的密钥，请替换你在管理后台应用下申请的appSecret
    private static final String APP_SECRET="1a9cddb0917a";
    //随机数
    private static final String NONCE="123456";
    //短信模板ID
    private static final String TEMPLATEID="3142060";
    //手机号
    //private static final String MOBILE="18273496162";
    //验证码长度，范围4～10，默认为4
    private static final String CODELEN="4";

    public static String sendPone(String telephone) {
    	try {
    		DefaultHttpClient httpClient = new DefaultHttpClient();
	        HttpPost httpPost = new HttpPost(SERVER_URL);
	        String curTime = String.valueOf((new Date()).getTime() / 1000L);
	        /*
	         * 参考计算CheckSum的java代码，在上述文档的参数列表中，有CheckSum的计算文档示例
	         */
	       String checkSum = CheckSumBuilder.getCheckSum(APP_SECRET, NONCE, curTime);
	        //String checkSum ="123456";
	        // 设置请求的header
	        httpPost.addHeader("AppKey", APP_KEY);
	        httpPost.addHeader("Nonce", NONCE);
	        httpPost.addHeader("CurTime", curTime);
	        httpPost.addHeader("CheckSum", checkSum);
	        httpPost.addHeader("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");

	        // 设置请求的的参数，requestBody参数
	        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
	        /*
	         * 1.如果是模板短信，请注意参数mobile是有s的，详细参数配置请参考“发送模板短信文档”
	         * 2.参数格式是jsonArray的格式，例如 "['13888888888','13666666666']"
	         * 3.params是根据你模板里面有几个参数，那里面的参数也是jsonArray格式
	         */
	        nvps.add(new BasicNameValuePair("templateid", TEMPLATEID));
	        nvps.add(new BasicNameValuePair("mobile", telephone));
	        nvps.add(new BasicNameValuePair("codeLen", CODELEN));

	        httpPost.setEntity(new UrlEncodedFormEntity(nvps, "utf-8"));

	        // 执行请求
	        HttpResponse response = httpClient.execute(httpPost);
	        String message = EntityUtils.toString(response.getEntity(), "utf-8");
	        JSONObject  myJson = JSONObject.fromObject(message);
	        //如果code==200成功
	        if(String.valueOf(myJson.get("code")).equals("200")){
	        	return String.valueOf(myJson.get("obj"));
	        }else{
	        	return null;
	        }
		} catch (Exception e) {
			return null;
		}
       
    }
    
    public static void main(String[] args) {
    	String code = sendPone("18273496162");
    	System.out.println("发送成功，你是短信是："+code);
	}
}