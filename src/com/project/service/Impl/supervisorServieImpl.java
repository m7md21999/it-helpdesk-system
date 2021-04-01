package com.project.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.requestDao;
import com.project.dao.supervisorDao;
import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.supervisorService;

@Service("sService")
public class supervisorServieImpl implements supervisorService {

	@Autowired
	private supervisorDao sDao;
	
	@Autowired
	private requestDao rDao;
	
	@Override
	@Transactional
	public void createUser(User user) {
		sDao.createUser(user);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		sDao.updateUser(user);
	}

	@Override
	@Transactional
	public void deleteUser(int user_id) {
		sDao.deleteUser(user_id);
	}

	@Override
	@Transactional
	public User findUser(int user_id) {
		return sDao.findUser(user_id);
	}

	@Override
	public User findUser(String user_email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public List<User> getUsers() {
		return sDao.getUsers();
	}

	@Override
	@Transactional
	public List<User> getUsers(String dept_name) {
		return sDao.getUsers(dept_name);
	}
	
}
