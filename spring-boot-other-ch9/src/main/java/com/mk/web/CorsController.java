package com.mk.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.User;

@RestController
@RequestMapping("/cors")
public class CorsController {

	@CrossOrigin(origins = "http://xxxx.com", maxAge = 3600)
    @RequestMapping("/{id}")
    public User retrieve(@PathVariable("id") Long id) {
    	return null;
    }

	@CrossOrigin(origins = "http://xxxx.com", maxAge = 3600)
    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public void remove(@PathVariable Long id) {
    }
}
