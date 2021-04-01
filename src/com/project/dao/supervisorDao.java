package com.project.dao;

import java.util.List;

import com.project.entity.Request;
import com.project.entity.User;

public interface supervisorDao {
	
	public void createUser(User user);
	public void updateUser(User user);
	public User editUser(int user_id);
	public void deleteUser (int user_id);
	public User findUser(int user_id);
	public List<User> getUsers();
	public List<User> getUsers(String dept_name);

	
}
