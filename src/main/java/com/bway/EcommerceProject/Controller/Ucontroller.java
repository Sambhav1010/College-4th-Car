package com.bway.EcommerceProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.EcommerceProject.model.Userdetails;
import com.bway.EcommerceProject.service.ProductService;
import com.bway.EcommerceProject.service.Userserv;


@Controller
public class Ucontroller {
	
	@Autowired
	private Userserv userservice;
	
	@Autowired
	private ProductService ps;
	
	@GetMapping("/signinmethod")
	public String getlogin() {
		
		return "Login";
	}
	
	@PostMapping("/signinmethod")
	public String postlogin(@ModelAttribute Userdetails user, Model model) {
		
		Userdetails usr=userservice.login(user.getUsername(), user.getPassword());
		
		if(usr!=null) {
			return "redirect:/homemethod";
		}
		model.addAttribute("error","User not found");
		
		return"Login";
		
	}
	
	@GetMapping("/signupmethod")
	public String getsignup()
	{
		return "Signup";
	}
	
	@PostMapping("/signupmethod")
	public String postSignup(@ModelAttribute Userdetails user) {
		
		userservice.signup(user);
		return "Login";
	}
	
	@GetMapping("/contactmethod")
	public String getContact() {
		
		return "Contact";
	}
	
	@GetMapping("/homemethod")
	public String getHome(/*Model model*/) {
		
		//model.addAttribute("productlist",ps.getAllProduct());
		
		return "Dashboard";
	}
}

