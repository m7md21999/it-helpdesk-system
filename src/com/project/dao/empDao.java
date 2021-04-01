package com.project.dao;

import java.util.List;

import com.project.entity.Request;
import com.project.entity.User;

public interface empDao {
	
	public User findUser(int user_id);
	public void updateUser (User user);
	

}
