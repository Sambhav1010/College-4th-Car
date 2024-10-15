package com.bway.EcommerceProject.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bway.EcommerceProject.model.Product;
import com.bway.EcommerceProject.model.ProductAtDb;

public interface ProductAtDbService {

	void addProducttoDb(ProductAtDb prod);
	void deleteProduct(long id);
	void updateProduct(MultipartFile file, String name, double price);
	ProductAtDb findproductbyid(long id);
	List<ProductAtDb> getallproductatdb();
}
