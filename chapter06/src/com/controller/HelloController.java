package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
	@RequestMapping(value="/main/aaa", method=RequestMethod.GET)
	public ModelAndView hello() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", "Hello Spring!!");
		//mav.setViewName("hello");
		mav.setViewName("/main/aaa");
		return mav;
	}

}












