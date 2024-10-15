package com.bway.EcommerceProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.EcommerceProject.model.Userdetails;
import com.bway.EcommerceProject.repository.Userrepository;
import com.bway.EcommerceProject.service.Userserv;

@Service
public class UserservImpl implements Userserv{

	@Autowired
	private Userrepository userrep;
	
	
	@Override
	public void signup(Userdetails user) {
		userrep.save(user);
		
	}
	@Override
	public Userdetails login(String un, String psw) {
		
		return userrep.findByUsernameAndPassword(un, psw);
		
	}


}
