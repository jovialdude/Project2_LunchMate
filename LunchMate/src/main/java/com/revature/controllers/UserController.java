package com.revature.controllers;


import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping
public List<User> findAllUsers(){
		return userService.findAllUsers();
	}

@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/{id}")
public User findUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id);
	}

@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
public void addUser(@RequestBody User u) {
		userService.addUser(u);
	}

@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/{id}")
public void updateUser(@PathVariable("id") Integer id,
@RequestBody User u)	{
		u.setId(id);
		userService.updateUser(u);
	}

@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/{id}")
public boolean deleteUser(@PathVariable Integer id) {
		User user = new User();
		user.setId(id);
		return userService.deleteUser(id);
	}


 















}
