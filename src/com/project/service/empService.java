package com.project.service;

import java.util.List;

import com.project.entity.Request;
import com.project.entity.User;

public interface empService {

	
//	public void createRequest(Request request);
	public User findUser(int user_id);
	public void updateUser (User user);
//	public List<Request> getRequests(int user_id);
	
}
