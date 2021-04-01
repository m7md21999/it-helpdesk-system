package com.project.service;

import java.util.List;

import com.project.entity.ReqSol;
import com.project.entity.Request;
import com.project.entity.User;

public interface supervisorService {
	
	public void createUser(User user);
	public void updateUser(User user);
	public void deleteUser (int user_id);
	public User findUser(int user_id);
	public User findUser(String user_email);
	public List<User> getUsers();
	public List<User> getUsers(String dept_name);
	
}
