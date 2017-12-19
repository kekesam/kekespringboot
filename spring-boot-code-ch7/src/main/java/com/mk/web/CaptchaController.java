package com.mk.web;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;

/**
 * 防止Captcha机器人登陆
 * @author xuchengfei
 * 
 */
@Controller
@RequestMapping("/kaptcha")
public class CaptchaController {
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	

	@Autowired
	private Producer captchaProducer = null;
	/**
	 *  kaptcha.border  是否有边框  默认为true  我们可以自己设置yes，no
		kaptcha.border.color   边框颜色   默认为Color.BLACK
		kaptcha.border.thickness  边框粗细度  默认为1
		kaptcha.producer.impl   验证码生成器  默认为DefaultKaptcha
		kaptcha.textproducer.impl   验证码文本生成器  默认为DefaultTextCreator
		kaptcha.textproducer.char.string   验证码文本字符内容范围  默认为abcde2345678gfynmnpwx
		kaptcha.textproducer.char.length   验证码文本字符长度  默认为5
		kaptcha.textproducer.font.names    验证码文本字体样式  默认为new Font("Arial", 1, fontSize), new Font("Courier", 1, fontSize)
		kaptcha.textproducer.font.size   验证码文本字符大小  默认为40
		kaptcha.textproducer.font.color  验证码文本字符颜色  默认为Color.BLACK
		kaptcha.textproducer.char.space  验证码文本字符间距  默认为2
		kaptcha.noise.impl    验证码噪点生成对象  默认为DefaultNoise
		kaptcha.noise.color   验证码噪点颜色   默认为Color.BLACK
		kaptcha.obscurificator.impl   验证码样式引擎  默认为WaterRipple
		kaptcha.word.impl   验证码文本字符渲染   默认为DefaultWordRenderer
		kaptcha.background.impl   验证码背景生成器   默认为DefaultBackground
		kaptcha.background.clear.from   验证码背景颜色渐进   默认为Color.LIGHT_GRAY
		kaptcha.background.clear.to   验证码背景颜色渐进   默认为Color.WHITE
		kaptcha.image.width   验证码图片宽度  默认为200
		kaptcha.image.height  验证码图片高度  默认为50 
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.web 
	 * 方法名：getKaptchaImage
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2016年1月5日-下午7:10:18 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * 返回类型：ModelAndView
	 * @exception 
	 * @since  1.0.0
	 */
	/**
	 * (这里用一句话描述这个方法的作用)
	 * com.tz.web 
	 * 方法名：getKaptchaImage
	 * 创建人：xuchengfei 
	 * 手机号码:15074816437
	 * 时间：2016年1月5日-下午7:13:46 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception 
	 * 返回类型：ModelAndView
	 * @exception 
	 * @since  1.0.0
	*/
	@RequestMapping("/code")
	public void getKaptchaImage(HttpServletRequest request,
			HttpServletResponse response,HttpSession session) throws Exception {
		//清空浏览器缓存
		response.setDateHeader("Expires", 0);
		response.setHeader("Cache-Control",
				"no-store, no-cache, must-revalidate");
		response.addHeader("Cache-Control", "post-check=0, pre-check=0");
		response.setHeader("Pragma", "no-cache");
		response.setContentType("image/jpeg");
		
		//创建验证码，获取验证生成的内容
		String capText = captchaProducer.createText();
		//把生成的验证码，放入到session中
		session.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		//通过流输出浏览器
		BufferedImage bi = captchaProducer.createImage(capText);
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "jpg", out);
		try {
			out.flush();
		} finally {
			out.close();
		}
	}
}