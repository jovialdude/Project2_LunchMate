package com.revature.services;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.revature.daos.*;
import com.revature.models.User;

@Service
public class UserService {


	UserDao udao = new UserDaoImp();

	public List<User> findAllUsers() {
return udao.getAllUser();
//		return null;
	}

	public User findUserById(int id) {
return udao.getUser(id);
//		return null;
	}

	public void addUser(@Valid User u) {
udao.createUser(u);
//		return null;
	}

	public void updateUser(User u) {
udao.updateUser(u);
//		return null;
	}

	public boolean deleteUser(int id) {
return udao.deleteUser(id);
//		return null;
	}

public boolean getUserLogin	(String username, String password)
{	return udao.getUserLogin(username, password);	}














/*
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}
	public User findUserById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	public User addUser(@Valid User u) {
		// TODO Auto-generated method stub
		return null;
	}
	public User updateUser(User u) {
		// TODO Auto-generated method stub
		return null;
	}
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}
*/
}
