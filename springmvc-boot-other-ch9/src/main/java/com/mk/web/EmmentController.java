package com.mk.web;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class EmmentController {

	@RequestMapping(value="/emment")
	public String emment() {
		return "emment";
	}
	
	 /**
     * @return
     * 演示服务器端每5秒钟向浏览器推送随机消息
     */
    @RequestMapping(value="/push",produces="text/event-stream")
    public @ResponseBody String push(){
        Random r=new Random();
        return "data:Testing 1,2,3"+r.nextInt()+"\n\n";
    }
	
}
