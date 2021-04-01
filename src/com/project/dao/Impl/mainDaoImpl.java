package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.mainDao;
import com.project.entity.User;

@Repository("mDao")
public class mainDaoImpl implements mainDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public User Login(String user_email, String user_password) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = null;
		List<User> list = currentSession.createQuery("from User where user_email='"+user_email+ "' AND user_password='"+user_password+"'").getResultList();
		if ((list != null) && (list.size()> 0)){
			for (User u : list){
				user = u;
			}
			
			return user;
		}
		
		return null;
	}



}
