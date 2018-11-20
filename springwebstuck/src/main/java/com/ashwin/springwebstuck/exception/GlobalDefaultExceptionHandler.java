package com.ashwin.springwebstuck.exception;


import java.io.PrintWriter;
import java.io.StringWriter;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
	public ModelAndView handlerNotFoundException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","the page is not found");
		
		mv.addObject("errorDescription","the page you are looking for is not available now");
		
		mv.addObject("title","404 page not found error");
		return mv;
		
		
	}
	
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handlerProductNotFoundException() {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","Product Not available");
		
		mv.addObject("errorDescription","the product you are looking for is not available now");
		
		mv.addObject("title","Product Unavaialble");
		return mv;
		
		
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView handlerException(Exception ex) {
		ModelAndView mv=new ModelAndView("error");
		
		mv.addObject("errorTitle","Contact your administrator");
		
		/* only for debugging the application */
		StringWriter sw=new StringWriter();
		PrintWriter pw=new PrintWriter(sw);
		
		ex.printStackTrace(pw);
		
		
		
		mv.addObject("errorDescription",sw.toString());
		
		mv.addObject("title","Product Unavaialble");
		return mv;
		
		
	}
	
	
}
