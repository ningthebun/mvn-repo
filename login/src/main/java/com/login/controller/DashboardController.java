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
public class DashboardController {

	@Autowired private UserService userService;
	
	@RequestMapping(value = "/dashboard", method = {RequestMethod.GET})
	public ModelAndView dashboardPage() {
		ModelAndView mav = new ModelAndView("dashboard");

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByUsername(auth.getName());
		mav.addObject("user", user);
		
		return mav;
	}
}
