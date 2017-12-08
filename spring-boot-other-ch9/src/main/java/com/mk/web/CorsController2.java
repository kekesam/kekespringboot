package com.mk.web;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.User;

@CrossOrigin(origins = "http://xxxx.com", maxAge = 3600)
@RestController
@RequestMapping("/cors2")
public class CorsController2 {

    @RequestMapping("/{id}")
    public User retrieve(@PathVariable("id") Long id) {
    	return null;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public void remove(@PathVariable Long id) {
    }
}
