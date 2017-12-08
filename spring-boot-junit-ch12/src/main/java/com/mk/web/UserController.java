package com.mk.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bean.User;
import com.mk.dao.IUserDao;

/**
 * @author xuke
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private IUserDao userDao;
	
    @PostMapping("/save")
    public User save(User user) throws Exception {
    	userDao.saveUser(user);
        return user;
    }
    
    @GetMapping("/get/{id}")
    public User get(@PathVariable("id")Integer id) throws Exception {
    	return userDao.getUser(id);
    }
}