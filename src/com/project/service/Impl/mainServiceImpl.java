package com.project.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.dao.empDao;
import com.project.dao.mainDao;
import com.project.entity.User;
import com.project.service.mainService;

@Service("mService")
public class mainServiceImpl implements mainService {

	@Autowired
	private mainDao mDao;
	
	@Override
	@Transactional
	public User Login(String user_email, String user_password) {
		return mDao.Login(user_email, user_password);
	}


}
