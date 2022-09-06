package com.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.login.entity.User;
import com.login.service.UserService;

@Controller
public class ManagerController {

	@Autowired private UserService userService;
	
	@RequestMapping(value = "/managerPage", method = {RequestMethod.GET})
	public ModelAndView managerPage() {
		ModelAndView mav = new ModelAndView("managerPage");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		mav.addObject("user", user);
		
		return mav;
	}
}
