package com.mk.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class I18NController {

	@RequestMapping("/login")
    public String login(){
          return"/login";
    }
	
}
