package com.bway.EcommerceProject.service;

import com.bway.EcommerceProject.model.Admin;

public interface Adminservice {

	Admin login(String un, String psw);
	void signup(Admin ad);
}
