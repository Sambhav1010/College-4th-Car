package com.bway.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.EcommerceProject.model.Userdetails;

public interface Userrepository extends JpaRepository<Userdetails, Integer>{

	Userdetails findByUsernameAndPassword(String un,String psw);
}
