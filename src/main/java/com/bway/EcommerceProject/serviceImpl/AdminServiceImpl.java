package com.bway.EcommerceProject.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bway.EcommerceProject.model.Admin;
import com.bway.EcommerceProject.repository.Adminrepository;
import com.bway.EcommerceProject.service.Adminservice;

@Service
public class AdminServiceImpl implements Adminservice{

	@Autowired
	private Adminrepository adrepo;
	
	@Override
	public Admin login(String un, String psw) {
		
		return adrepo.findByUsernameAndPassword(un, psw);
	}

	@Override
	public void signup(Admin ad) {
		
		adrepo.save(ad);
		
	}

}
