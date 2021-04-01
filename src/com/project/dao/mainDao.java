package com.project.dao;

import com.project.entity.User;

public interface mainDao {
	
	public User Login (String user_email, String user_password);

}
