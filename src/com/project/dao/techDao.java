package com.project.dao;

import java.util.List;

import com.project.entity.Request;
import com.project.entity.User;



public interface techDao {
	
	public User findUser(int user_id);
	public void updateUser (User user);
	public List<Request> getRequests( int user_id);

}
