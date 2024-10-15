package com.bway.EcommerceProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bway.EcommerceProject.model.Product;

@Repository
public interface Productrepository extends JpaRepository<Product, Long>{

	
	  @Query("SELECT p from Product p WHERE p.name LIKE %:keyword%")
	   List<Product> SearchProducts(@Param("keyword") String keyword);
	

}
