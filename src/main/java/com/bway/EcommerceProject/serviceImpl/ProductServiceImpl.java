package com.bway.EcommerceProject.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bway.EcommerceProject.model.Product;
import com.bway.EcommerceProject.repository.Productrepository;
import com.bway.EcommerceProject.service.ProductService;



@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private Productrepository pr;
	
	@Override
	public void addProduct(Product pd)  {
		pr.save(pd);
		
	}

	@Override
	public void deleteProduct(long id) {
		pr.deleteById(id);
		
	}

	@Override
	public void updateProduct(MultipartFile file, String name, double price) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product findbyID(long id) {
		
		return pr.findById(id).get();
	}

	@Override
	public List<Product> getAllProduct() {
		
		return pr.findAll();
	}

	@Override
	public List<Product> SearchProducts(String keyword) {
		return pr.SearchProducts(keyword);
		
	}

	
	
	
}
