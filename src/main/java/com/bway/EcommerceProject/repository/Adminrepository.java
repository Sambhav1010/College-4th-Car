package com.bway.EcommerceProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bway.EcommerceProject.model.Admin;

public interface Adminrepository extends JpaRepository<Admin, Integer>{

	Admin findByUsernameAndPassword(String un, String psw);
}
