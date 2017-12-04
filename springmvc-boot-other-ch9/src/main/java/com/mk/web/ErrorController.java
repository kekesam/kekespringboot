package com.mk.web;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class ErrorController extends AbstractErrorController {

	public ErrorController(ErrorAttributes errorAttributes) {
		super(errorAttributes);
	}

	/**
	 * 指定错误页面
	 * 方法名：getError<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年11月28日-下午10:08:58 <br/>
	 * 手机:15074816437<br/>
	 * @return String<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	public String getErrorPath() {
		return "error";
	}
	
	
	

	@ResponseBody
    @RequestMapping(value = "/error")
    public String error(HttpServletResponse response, HttpServletRequest request) {
		Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request, false));
		//获取异常
		Throwable throwable = getErrors(request);
		//获取状态
		int status = (Integer)model.get("status");
		//错误信息
		String message = (String)model.get("message");//详细错误信息
		String path = (String)model.get("path");//除服哦路径
		String exception = (String)model.get("exception");//除服哦路径
		Date timestamp = (Date)model.get("timestamp");//错误发生时间
		String error = (String)model.get("error");//Not Found /Bad Request
		//List<ObjectError> errors = (List<ObjectError>)model.get("errors");//Not Found /Bad Request
		System.out.println("错误路径是：=====>"+path);
		System.out.println("错误时间是：=====>"+timestamp);
		System.out.println("异常类名是：=====>"+exception);
		System.out.println("错误信息是：=====>"+error);
		System.out.println("状态是：=====>"+status);
		System.out.println("错误信息是：=====>"+message);
		/*for (ObjectError objectError : errors) {
			System.out.println("==========>"+objectError.getDefaultMessage());
		}*/
		//获取错误提示
		String errormessage = getErrorMessage(throwable);
		response.setStatus(status);
        return "错误码："+status+"<br/>错误信息是："+message+"<br/>"+errormessage;
    }
	
	
	
	/**
	 * 调用系统底层的异常
	 * 方法名：getErrors<br/>
	 * 创建人：xuchengfeifei <br/>
	 * 时间：2017年11月28日-下午10:24:12 <br/>
	 * 手机:15074816437<br/>
	 * @param request
	 * @return Throwable<br/>
	 * @exception <br/>
	 * @since  1.0.0<br/>
	 */
	private Throwable getErrors(HttpServletRequest request) {
		Throwable throwable = (Throwable)request.getAttribute("javax.servlet.error.exception");
		if(throwable!=null) {
			while(throwable instanceof ServletException && throwable.getCause()!=null) {
				throwable = ((ServletException)throwable).getCause();
			}
		}
		return throwable;
	}
	
	private String getErrorMessage(Throwable ex) {
		return "服务器出现错误,请联系管理员!";
	}
	
	
	
}
