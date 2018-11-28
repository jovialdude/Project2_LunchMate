package com.revature.daos;

import java.util.List;

import com.revature.models.UserServiceLayer;

public interface UserDao {
	public UserServiceLayer getUser(int id);
	public boolean getUserLogin(String username, String password);
	public List<UserServiceLayer> getAllUser();
	public void createUser(UserServiceLayer u);
	public void updateUser(UserServiceLayer u);
	public boolean deleteUser(int id);
}
