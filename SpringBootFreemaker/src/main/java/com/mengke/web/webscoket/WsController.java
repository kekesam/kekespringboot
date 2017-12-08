package com.mengke.web.webscoket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WsController {
	
	@RequestMapping("/ws")
	public String wsindex(){
		return "ws/ws";
	}
	
	@MessageMapping("/stomp")  
    @SendTo("/topic/response")  
    public WiseResponse greeting(WiseMessage message) throws Exception {  
        System.out.println("receiving " + message);  
        System.out.println("connecting successfully.");  
        return new WiseResponse("Hello, " + message.getName() + "!");  
    }  

}
