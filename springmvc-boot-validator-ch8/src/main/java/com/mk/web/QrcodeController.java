package com.mk.web;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mk.util.QRcodeUtil;

@Controller
public class QrcodeController {
	
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
	/**
	 * 生成二维码
	 * 方法名：createQrode<br/>
	 * 创建人：xuke <br/>
	 * 时间：2017年11月9日-上午12:32:26 <br/>
	 * 手机:15074816437<br/>
	 * @param response void<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	@ResponseBody
	@RequestMapping("/qrcode")
	public void createQrode(@RequestParam("content")String content,HttpServletResponse response){
		try {
			QRcodeUtil.createQrcode(content, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
