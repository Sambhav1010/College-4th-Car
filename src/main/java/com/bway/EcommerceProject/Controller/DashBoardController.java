package com.bway.EcommerceProject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bway.EcommerceProject.service.ProductService;

@Controller
public class DashBoardController {
	@Autowired
	ProductService prod;
	
	@GetMapping("/")
	public String getdashboard(/*Model model*/) {
		
		//model.addAttribute("productlist",prod.getAllProduct());
		return "redirect:/homemethod";
	}

	@GetMapping("/aboutmethod")
	public String getabout() {
		
		return "about";
	}
	
	@GetMapping("/newdb")
	public String newdbcheck() {
		
		return "checkdb";
	}
}
