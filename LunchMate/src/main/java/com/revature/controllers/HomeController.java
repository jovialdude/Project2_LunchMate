package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.models.User;
import com.revature.services.UserService;



@Controller
public class HomeController {

	@RequestMapping(method=RequestMethod.GET, value="/home")
public String getHomePage()
	{	return "Home";	}


	@GetMapping("/")
	public String goLogin()
	{	return "Login";	}

	@PostMapping("/login")
	public User getLogin(@RequestBody User u)
	{	
		List<User> user = new UserService().findAllUsers();
		
		for(int i = 0; i < user.size(); i++)
		{
			if(user.get(i).getUsername().equals(u.getUsername()) && user.get(i).getPassword().equals(u.getPassword()))
			{
				return user.get(i);
			}
		}
		
		return u;	
	}



	// Grab posting preferences by ID

	// Respond to a posting

	
	@Autowired
	UserService userService;
	


/*
//	I HAVE NO IDEA IF THIS WOULD WORK
	@PostMapping("/login")
	public String loggedInUser(@RequestParam("username") String user,
	@RequestParam("password")String pass) {
		if (userService.getUserLogin(user, pass)) {
			return "Home";
		}
		return "";
}
*/










}
