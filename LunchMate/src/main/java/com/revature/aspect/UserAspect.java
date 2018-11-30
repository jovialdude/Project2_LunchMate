package com.revature.aspect;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import com.revature.models.User;

@Aspect
@Component
public class UserAspect {

	private Logger log = Logger.getRootLogger();

	// TODO Auto-generated method stub
	@AfterReturning(pointcut = "execution( * com.revature.controllers.HomeController.getLogin(..))", returning = "r")
	public void userLogin(JoinPoint jp, Object r) {
		if (r==null) {
			log.info("Uncessful login for user "+jp.getArgs()[0]);
		}
		else {
			log.info("Successful login for username "+((User)r).getUsername());
		}
	}
	
	@AfterReturning(pointcut = "execution( * com.revature.controllers.UserController.addUser(..))")
	public void userCreation(JoinPoint jp) {
		log.info("Adding user "+((User)jp.getArgs()[0]).getUsername());
	}
	
	@AfterReturning(pointcut = "execution( * com.revature.controllers.UserController.findUserById(..))", returning = "r")
	public void userGetSingle(JoinPoint jp, Object r) {
		log.info("User "+((User) r).getUsername()+" successfully retrieved");
	}
	
	@Before("execution(* com.revature.controllers.UserController.findAllUsers())")
	public void userGetAll(JoinPoint jp) {
		log.info("Retrieving all user info");
	}
}
