package com.revature.daos;

import java.util.List;

import com.revature.models.User;

public interface UserDao {
	public User getUser(int id);
	public boolean getUserLogin(String username, String password);
	public List<User> getAllUser();
	public void createUser(User u);
	public void updateUser(User u);
	public boolean deleteUser(int id);
}
