package com.liveasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.liveasy.model.User;
import com.liveasy.service.UserService;

//Controller for Address Controller: 
@Controller
@Transactional
public class AddressController {

	@Autowired
	private UserService userService;


    @GetMapping("/admin/address")
	public ModelAndView address(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/address");
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("user", user);
		modelAndView.addObject("userAddress", "Your address is: " + user.getAddress());
		return modelAndView;
    }
    
	@RequestMapping(value = "/admin/address", method = RequestMethod.POST)
	public ModelAndView updateUserAddress( @ModelAttribute("user") User addressUser, BindingResult bindingResult) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		ModelAndView modelAndView = new ModelAndView();
		
		userService.updateUserAddress(user.getId(), addressUser.getAddress());
		modelAndView.addObject("successMessage", "User Address has been updated successfully");
		user = userService.findUserByEmail(auth.getName());
		
		modelAndView.addObject("userAddress", "Your address is: " + user.getAddress());
		System.out.println(user.getAddress());
		modelAndView.setViewName("admin/address");

		return modelAndView;
	}

}
