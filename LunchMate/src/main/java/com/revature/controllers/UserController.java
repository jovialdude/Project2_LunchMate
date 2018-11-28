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
public List<User> findAllUsers(){
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
public User findUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id);
	}

	@PostMapping
public User addUser(@Valid @RequestBody User u) {
		return userService.addUser(u);
	}

	@PutMapping("/{id}")
public User updateUser(@Valid @PathVariable("id") Integer id,
@RequestBody User u)	{
		u.setId(id);
		return userService.updateUser(u);
	}

	@DeleteMapping("/{id}")
public User deleteUser(@PathVariable Integer id) {
		User user = new User();
		user.setId(id);
		return userService.deleteUser(user);
	}

 
}
