package com.ashwin.springwebstuck.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/manage")
public class ManagementController {
	
	
	@RequestMapping(value="/products",method=RequestMethod.GET)
	public ModelAndView showManageProducts() {
		
		ModelAndView mv=new ModelAndView("page");
		
		mv.addObject("title","Manage Products");
		mv.addObject("userClickManageProducts",true);
		
		return mv;
		
	}

}
