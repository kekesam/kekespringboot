package com.mk.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mk.bean.User;

@Controller
public class UserController {
	@RequestMapping("/reg")
	public String reg(Model model) {
		return "reg";
	}

	@RequestMapping("/add")
	public String userAdd(@Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			List<ObjectError> list = result.getAllErrors();
			for (ObjectError error : list) {
				System.out.println(error.getCode() + "---" + error.getArguments() + "---" + error.getDefaultMessage());
			}
			model.addAttribute("errors",list);
			return "reg";
		}
		return "index";
	}
}
