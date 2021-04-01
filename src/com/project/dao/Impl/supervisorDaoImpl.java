package com.project.dao.Impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.project.dao.supervisorDao;
import com.project.entity.Request;
import com.project.entity.User;

@Repository("sDao")
public class supervisorDaoImpl implements supervisorDao {

	// inject
	@Autowired
	private SessionFactory sessionFactory;
	
	
	@Override
	public List<User> getUsers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User" , User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}


	@Override
	public void createUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.save(user);
	}


	@Override
	public void updateUser(User user) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.update(user);
	}


	@Override
	public User editUser(int user_id) {
		return findUser(user_id);
	}


	@Override
	public void deleteUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = findUser(user_id);
		currentSession.delete(user);
	}


	@Override
	public User findUser(int user_id) {
		Session currentSession = sessionFactory.getCurrentSession();
		User user = currentSession.get(User.class, user_id);
		return user;
	}





	@Override
	public List<User> getUsers(String dept_name) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<User> theQuery = currentSession.createQuery("from User where dept_name='"+dept_name+"'" , User.class);
		List<User> users = theQuery.getResultList();
		return users;
	}


}
