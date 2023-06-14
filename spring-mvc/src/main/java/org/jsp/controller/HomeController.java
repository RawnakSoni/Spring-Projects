package org.jsp.controller;

import org.jsp.dto.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController 
{
	@RequestMapping(value = "/home")
	public String home(Model model) 
	{
		model.addAttribute("user","Samthish");
		return "home.jsp";			
	}
	
	@RequestMapping(value = "/sum")
	public String sum(Model  model, @RequestParam(name = "n1") int a, @RequestParam(name = "n2") int b)
	{
		model.addAttribute("result", "The Sum is: "+(a+b));
		return "print.jsp";
	}
	
	@RequestMapping(value = "/diff")
	public String diff(Model  model, @RequestParam int n1, @RequestParam int n2)
	{
		model.addAttribute("result", "The Difference is: "+(n1-n2));
		return "print.jsp";
	}
	
	@RequestMapping(value = "/pro")
	public String pro(Model  model, @RequestParam int n1, @RequestParam int n2)
	{
		model.addAttribute("result", "The Product is: "+(n1*n2));
		return "print.jsp";
	}
	
	@RequestMapping(value = "/div")
	public String div(Model  model, @RequestParam int n1, @RequestParam int n2)
	{
		model.addAttribute("result", "The Divide sum is: "+(n1/n2));
		return "print.jsp";
	}
	
	@RequestMapping(value = "/mod")
	public String mod(Model  model, @RequestParam int n1, @RequestParam int n2)
	{
		model.addAttribute("result", "The Modulus is: "+(n1%n2));
		return "print.jsp";
	}
	
	@PostMapping("/register")
	public ModelAndView request(ModelAndView view,@ModelAttribute User user)
	{
		view.addObject("user",user);
		view.setViewName("printUser.jsp");
		return view;
	}
}
