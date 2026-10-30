package com.flm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.SelectionQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flm.model.Admin;

import jakarta.transaction.Transactional;

@Component
public class AdminDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public String login(Admin admin) {
		   Session session =sessionFactory.getCurrentSession();
		  return null;	
	}
	@Transactional
	public String signup(Admin admin) {
		      Session session =sessionFactory.getCurrentSession();
		      session.persist(admin);
			  return admin.getUsername();
		      
	}
	@Transactional
	public Admin findAdminByUserName(String userName) {
		
		Session session=sessionFactory.getCurrentSession();
		SelectionQuery<Admin>  query =session.createSelectionQuery("from Admin where username=?1",Admin.class);
		              
		                query.setParameter(1,userName);
		                
		                     List<Admin> list=query.list();
		                     if(list.isEmpty()) {
		                    	    return null;
		                    	}

		                    	return list.get(0);
		      
	}
	
	
}
