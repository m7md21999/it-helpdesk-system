package com.project.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.supervisorDao;
import com.project.dao.techDao;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.techService;

@Service("tService")
public class techServiceImpl implements techService {

	@Autowired
	private techDao tDao;
	

	@Override
	@Transactional
	public User findUser(int user_id) {
		return tDao.findUser(user_id);
	}

	@Override
	@Transactional
	public void updateUser(User user) {
		tDao.updateUser(user);
	}

	@Override
	@Transactional
	public List<Request> getRequests(int user_id) {
		return tDao.getRequests(user_id);
	}

}
