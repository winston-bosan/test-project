package com.liveasy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.liveasy.model.House;
import com.liveasy.model.User;
import com.liveasy.service.HouseService;
import com.liveasy.service.UserService;

@Controller
public class HouseController {
	
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private UserService userService;

	
    @GetMapping("/admin/house")
	public ModelAndView address(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/house");	
		House house = new House();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		
		
		modelAndView.addObject("houseAddress", "Your address is: " + user.getHouses().get(0).getAddress());
		modelAndView.addObject("houseBedrooms", "Bedroom Count: " + user.getHouses().get(0).getBedrooms());
		modelAndView.addObject("houseWashrooms", "Washroom Count: " + user.getHouses().get(0).getWashrooms());
		modelAndView.addObject("houseArea", "Area: " + user.getHouses().get(0).getArea());
		modelAndView.addObject("houseYear", "Year Built: " + user.getHouses().get(0).getYearBuilt());
		
		modelAndView.addObject("house", house);

		return modelAndView;
    }
    
	@RequestMapping(value = "/admin/house", method = RequestMethod.POST)
	public ModelAndView updateUserAddress( @ModelAttribute("house") House house, BindingResult bindingResult) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		user.addHouse(house);
		house.setUser(user);
		houseService.saveHouse(house);
		userService.saveUser(user);
		
		
		modelAndView.addObject("successMessage", "Your house has been contructed!");
		
		modelAndView.addObject("houseAddress", "Your address is: " + user.getHouses().get(0).getAddress());
		modelAndView.addObject("houseBedrooms", "Bedroom Count: " + user.getHouses().get(0).getBedrooms());
		modelAndView.addObject("houseWashrooms", "Washroom Count: " + user.getHouses().get(0).getWashrooms());
		modelAndView.addObject("houseArea", "Area: " + user.getHouses().get(0).getArea());
		modelAndView.addObject("houseYear", "Year Built: " + user.getHouses().get(0).getYearBuilt());

		
		System.out.println(user.getAddress());
		modelAndView.setViewName("admin/house");

		return modelAndView;
	}

}
