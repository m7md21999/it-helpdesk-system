package com.project.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.empDao;
import com.project.entity.Request;
import com.project.entity.User;
import com.project.service.empService;

@Service("eService")
public class empServiceImpl implements empService {

	@Autowired
	private empDao eDao;
	
//	@Override
//	@Transactional
//	public void createRequest(Request request) {
//		eDao.createRequest(request);
//	}

	@Override
	@Transactional
	public void updateUser(User user) {
		eDao.updateUser(user);
	}

//	@Override
//	@Transactional
//	public List<Request> getRequests(int user_id) {
//		return eDao.getRequests(user_id);
//	}

	@Override
	@Transactional
	public User findUser(int user_id) {
		return eDao.findUser(user_id);
	}
	

}
