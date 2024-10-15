package com.bway.EcommerceProject.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bway.EcommerceProject.model.ProductAtDb;
import com.bway.EcommerceProject.repository.ProductAtDbRepository;
import com.bway.EcommerceProject.service.ProductAtDbService;

@Service
public class ProductAtDbimpl implements ProductAtDbService{

	@Autowired
	private ProductAtDbRepository prr;
	
	@Override
	public void addProducttoDb(ProductAtDb pdd) {
		prr.save(pdd);
		
	}

	@Override
	public void deleteProduct(long id) {
		prr.deleteById(id);
		
	}

	@Override
	public void updateProduct(MultipartFile file, String name, double price) {
		
		
	}

	@Override
	public ProductAtDb findproductbyid(long id) {
		return prr.findById(id).get();
	}

	@Override
	public List<ProductAtDb> getallproductatdb() {
		
		return prr.findAll();
	}

}
