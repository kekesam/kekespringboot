package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.service.IUserService;

/**
 * @author xuke
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserService userService;

    
    @GetMapping("/get/{id}")
    public Object get(@PathVariable("id")Integer id) {
    	return userService.getUser(id);
    }
}