package com.bway.EcommerceProject.service;
import com.bway.EcommerceProject.model.Userdetails;


public interface Userserv {

	Userdetails login(String un, String psw);
	void signup(Userdetails user);
}
