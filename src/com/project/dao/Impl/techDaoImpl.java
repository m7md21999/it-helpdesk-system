package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.techDao;
import com.project.entity.Request;
import com.project.entity.User;

@Repository("tDao")
public class techDaoImpl implements techDao {
	
	@Autowired
	private SessionFactory sessionFactory;




	@Override
	public User findUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, user_id);
		return user;
	}

	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);		
	}


	@Override
	public List<Request> getRequests(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		List<Request> requests = currentSession.createQuery("from Request where tech_id="+ user_id).getResultList();
		return requests;
	}

}
