package com.revature.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.revature.daos.UserDao;
import com.revature.daos.UserDaoImp;
import com.revature.models.User;
import com.revature.services.UserService;


@RestController
@RequestMapping("login")
public class HomeController {

	UserDao udao = new UserDaoImp();
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping
	public User getLogin(@RequestBody User u)
	{	
		List<User> user = new UserService().findAllUsers();
		
		for(int i = 0; i < user.size(); i++)
		{
			if(user.get(i).getUsername().equals(u.getUsername()) && user.get(i).getPassword().equals(u.getPassword()))
			{
				//.out.println("confirm");
				return udao.getUser(user.get(i).getId());
			}
		}
		
		return u;	
	}

}
