package com.revature.controllers;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.*;
import com.revature.services.*;






@RestController
@RequestMapping("/users")
public class UserController	{

@Autowired
UserService userService;


	@GetMapping
public List<UserServiceLayer> findAllUsers(){
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
public UserServiceLayer findUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id);
	}

	@PostMapping
public UserServiceLayer addUser(@Valid @RequestBody UserServiceLayer u) {
		return userService.addUser(u);
	}

	@PutMapping("/{id}")
public UserServiceLayer updateUser(@Valid @PathVariable("id") Integer id,
@RequestBody UserServiceLayer u)	{
		u.setUserId(id);
		return userService.updateUser(u);
	}

	@DeleteMapping("/{id}")
public UserServiceLayer deleteUser(@PathVariable Integer id) {
		UserServiceLayer user = new UserServiceLayer();
		user.setUserId(id);
		return userService.deleteUser(user);
	}

 
}
