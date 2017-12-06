package com.mk.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.support.RequestContextUtils;

@Controller
public class I18NController {

	@RequestMapping("/login")
    public String login(){
          return"/login";
    }
	
	
	@ResponseBody
	@GetMapping("/changelan")
	public String  language(HttpServletRequest request, HttpServletResponse response, @RequestParam("lan")
		String language){
	    LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(request);
	    language=language.toLowerCase();
        if(language.equals("zh")){
            localeResolver.setLocale(request, response, Locale.CHINA);
        }else if(language.equals("en")){
            localeResolver.setLocale(request, response, Locale.US);
        }else{
            localeResolver.setLocale(request, response, Locale.CHINA );
        }
	    return "success";
	}
	
}
