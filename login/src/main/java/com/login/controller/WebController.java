package com.login.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.login.entity.User;
import com.login.service.UserService;

@Controller
public class WebController {

	@Autowired private UserService userService;

	//LOGIN PAGE
	@RequestMapping(value={"/", "/login"}, method= {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginPage(@ModelAttribute("loginUser") User login) {
		ModelAndView mav = new ModelAndView("index");
		return mav;
	}
	
	@RequestMapping(value = "/loginSuccess", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginSuccess() {
//		ModelAndView mav = null;
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//		User user = userService.findByUsername(auth.getName());
		
		ModelAndView mav = new ModelAndView("redirect:/dashboard");
		return mav;
	}
	
	@RequestMapping(value = "/loginProcess", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView loginProcess(@ModelAttribute("loginUser") User login) {
		ModelAndView mav = null;
		Optional<User> loginUser = userService.validateUser(login);
		
		if (loginUser == null || !loginUser.isPresent()) {
			mav = new ModelAndView("index");
			mav.addObject("message", "Invalid userid or password.");
		} else {
			mav = new ModelAndView("unknownError");
			System.out.println("Unknown error");
		}
		
		mav.addObject("login", login);
		return mav;
	}
	
	//LOGOUT PAGE
	@RequestMapping("/logout")
	public String logoutPage() {
		return "logout";
	}
	
	//UNKNOWN ERROR
	@RequestMapping("/unknownError")
	public String unknownError() {
		return "unknownError";
	}
}