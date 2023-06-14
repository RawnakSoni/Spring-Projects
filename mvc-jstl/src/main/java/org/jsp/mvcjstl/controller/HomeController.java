package org.jsp.mvcjstl.controller;

import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	@RequestMapping("/test")
	public ModelAndView test(@RequestParam int n1, @RequestParam int n2)
	{
		ModelAndView view = new ModelAndView();
		view.addObject("sum", n1+n2);
		view.setViewName("checksum");
		return view;
	}
	
	@RequestMapping("/print")
	public ModelAndView printEven(int n1,int n2,int n3, int n4, int n5,int n6)
	{
		ArrayList<Integer> nums = new ArrayList<Integer>(Arrays.asList(n1,n2,n3,n4,n5,n6));
		ModelAndView view = new ModelAndView();
		view.addObject("nums",nums);
		view.setViewName("printevennumbers");
		return view;
	}
}
