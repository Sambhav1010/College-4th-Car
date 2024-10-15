package com.bway.EcommerceProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bway.EcommerceProject.model.Admin;
import com.bway.EcommerceProject.service.Adminservice;

@Controller
public class AdminController {
	
	@Autowired
	private Adminservice adminservice;

	@GetMapping("/adminloginmethod")
	public String getAdminloginpage() {
		
		return "Adminlogin";
	}
	
	@GetMapping("/adminsignupmethod")
	public String getAdminsignuppage() {
		
		return "Adminsignup";
	}
	
	@PostMapping("/adminsignupmethod")
	public String postAdminsignuppage(@ModelAttribute Admin ad) {
		
		adminservice.signup(ad);
		return "Adminlogin";
	}
	
	@PostMapping("/adminloginmethod")
	public String postAdminloginpage(@ModelAttribute Admin ad, Model model) {
	
		Admin add=adminservice.login(ad.getUsername(), ad.getPassword());
		
		if(add!=null) {
			return "AdminDashboard";
		}
		model.addAttribute("error","User not found");
		return"Adminlogin";
	}
}
