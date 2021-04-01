package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.dao.empDao;
import com.project.entity.Request;
import com.project.entity.User;

@Repository("eDao")
public class empDaoImpl implements empDao {

	@Autowired
	private SessionFactory sessionFactory;
	


	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);
	}


	@Override
	public User findUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, user_id);
		return user;
	}

}
