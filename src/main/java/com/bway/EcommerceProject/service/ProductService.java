package com.bway.EcommerceProject.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bway.EcommerceProject.model.Product;

public interface ProductService {

	void addProduct(Product pd);
	void deleteProduct(long id);
	void updateProduct(MultipartFile file,String name, double price);
	Product findbyID(long id);
	List<Product> getAllProduct();
	List<Product> SearchProducts(String keyword);
}
