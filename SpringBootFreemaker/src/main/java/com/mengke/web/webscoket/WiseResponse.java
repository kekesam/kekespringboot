package com.mengke.web.webscoket;

/**
 * 
 * 服务器响应类
 * WiseMessage<br/>
 * 创建人:xuchengfeifei<br/>
 * 时间：2017年11月16日-下午8:30:35 <br/>
 * @version 1.0.0<br/>
 *
 */
public class WiseResponse {

	private String responseMessage;

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public WiseResponse(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	
}
