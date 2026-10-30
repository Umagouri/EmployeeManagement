package com.flm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.dao.AdminDAO;
import com.flm.model.Admin;

@Component
public class AdminService {
	
    @Autowired
	AdminDAO adminDAO;
    
	public Admin loginAdmin(String userName,String password) {
		
	Admin admin	= adminDAO.findAdminByUserName(userName);
	
	    //checking whether admin with userName exists..list storing obj type 
	       if(admin!=null && admin.getPassword().equals(password)) {
	    	   return admin;
	       }
	       //if doesnt exist ..list is empty nd returns null
		   return null;	
	}
	public String signupAdmin(String userName,String password) {
		Admin admin=new Admin(userName,password);
	         return adminDAO.signup(admin);
		
	}
}
