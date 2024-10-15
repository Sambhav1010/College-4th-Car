package com.bway.EcommerceProject.Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.bway.EcommerceProject.model.Product;
import com.bway.EcommerceProject.model.ProductAtDb;
import com.bway.EcommerceProject.service.ProductAtDbService;
import com.bway.EcommerceProject.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService ps;
	
	@Autowired
	private ProductAtDbService pss;
	
	@GetMapping("/addproductmethod")
	public String getaddproduct() {
		
		
		return "ProductForm";
	}
	
	@PostMapping("/AddAndUpdate")
	 public String saveProduct(
	           @ModelAttribute Product product,
	            @RequestParam("image") MultipartFile imageFile) {
	        
		
		product.setImagename(imageFile.getOriginalFilename());
	         
		ps.addProduct(product);
		
		try {
			File saveFile= new ClassPathResource("static/photos").getFile();
			Path path=Paths.get(saveFile.getAbsolutePath()+File.separator+imageFile.getOriginalFilename());
			Files.copy(imageFile.getInputStream(), path,StandardCopyOption.REPLACE_EXISTING);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	            return "ProductForm";
	    }
	
	@GetMapping("/productlistmethod")
	public String getProductList(Model model) {
		
		model.addAttribute("productlist",ps.getAllProduct());
		
		return "ProductList";
	}
	
	@GetMapping("/prod/delete")
	public String deleteProduct(@RequestParam long id) {
		
		ps.deleteProduct(id);
		
		return "redirect:/productlistmethod";
	}
	
	@GetMapping("/prod/edit")
	public String editProduct(@RequestParam long id,Model model) {
		
		model.addAttribute("prodmodel",ps.findbyID(id));
		return "ProductEditForm";
			
	}
	
	@GetMapping("/car/details/{id}")
	public String carDetails(@PathVariable("id") long id,Model model) {
		
		Product p=ps.findbyID(id);
		
		model.addAttribute("p",p);
		return "Cardetails";
	}
	
	@PostMapping("/search")
	public String SearchProduct(@RequestParam("keyword") String keyword,Model model) {
		
		List<Product> products=ps.SearchProducts(keyword);
		model.addAttribute("products",products);
		return "SearchResults";
	}
	
	
	
	@GetMapping("/dashboard/display/{id}")
	public String displayProductToDb(@PathVariable("id") long id,Model model) {
		
		Product p=ps.findbyID(id);
		model.addAttribute("productlist",p);
		
		return "Dashboard";
	}
}


