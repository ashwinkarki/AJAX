package com.ashwin.springwebstuck.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ashwin.springwebstuck.dao.CategoryDAO;
import com.ashwin.springwebstuck.dao.ProductDAO;
import com.ashwin.springwebstuck.entity.Category;
import com.ashwin.springwebstuck.entity.Product;
import com.ashwin.springwebstuck.exception.ProductNotFoundException;

@Controller
public class PageController {
	
	private static final Logger logger=LoggerFactory.getLogger(PageController.class);
	
	
	@Autowired
	private CategoryDAO categoryDAO;
	
	@Autowired
	private ProductDAO productDAO;
	
	@RequestMapping(value= {"/","/home"})
	public ModelAndView index() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Home");
		
		logger.info("Inside PageController index method - INFO");
		logger.info("Inside PageController index method - DEBUG");
		
		mv.addObject("categories",categoryDAO.getAllCategory());
		
		mv.addObject("userClickHome",true);
		return mv;
				
	}
	
	@RequestMapping(value= "/about")
	public ModelAndView about() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","About us");
		mv.addObject("userClickAbout",true);
		return mv;
				
	}
	
	@RequestMapping(value= "/contact")
	public ModelAndView contact() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","Contact us");
		mv.addObject("userClickContact",true);
		return mv;
				
	}
	
	/*
	 * methods to load all the products and based on category
	 * */
	@RequestMapping(value="/show/all/products")
	public ModelAndView showAllProducts() {
		ModelAndView mv=new ModelAndView("page");
		mv.addObject("title","All Products");
		
		mv.addObject("categories",categoryDAO.getAllCategory());
		
		mv.addObject("userClickAllProducts",true);
		return mv;
				
	}
	
	
	@RequestMapping(value="/show/category/{id}/products")
	public ModelAndView showCategoryProducts(@PathVariable("id") int id) {
		ModelAndView mv=new ModelAndView("page");
		
		//cateogoryDAo to fetch single category
		Category category=null;
		category=categoryDAO.getById(id);
		
		mv.addObject("title",category.getName());
		
		mv.addObject("categories",categoryDAO.getAllCategory());
		
		//passing the single category object
		mv.addObject("category",category);
		
		mv.addObject("userClickCategoryProducts",true);
		return mv;
				
	}
	
	//js ko str bata <a href click vayechi yaha aaucha
	//viewing a single product
	@RequestMapping(value="/show/{id}/product")
	public ModelAndView showSingleProduct(@PathVariable("id") int id) throws ProductNotFoundException
	{
		ModelAndView mv=new ModelAndView("page");
		
		Product product=productDAO.getById(id);

		if(product==null) {
			throw new ProductNotFoundException();
		}
		
		//update the count of views
		product.setViews(product.getViews()+1);
		productDAO.updateProduct(product);
		
		mv.addObject("title",product.getName());
		mv.addObject("product",product);
		
		mv.addObject("userClickShowProduct",true);
		
		return mv;
		}
	
	
}
