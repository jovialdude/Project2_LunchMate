package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.daos.UserDaoImp;



public class TestUserDaoImp	{

static UserDaoImp ud = new UserDaoImp();

@Rule
public ExpectedException expectedException = ExpectedException.none();



@Test
public void invalidLogin()	{
	expectedException.expect(Exception.class);
	ud.getUserLogin("15", "15");	}


@Test
public void nullAllUser() {
	assertNotEquals(ud.getAllUser(), null);	}


@Test(timeout=500)
public void nullUser() {
	expectedException.expect(Exception.class);
	ud.createUser(null);	}


@Test
public void nullUpdateUser() {
	expectedException.expect(Exception.class);
	ud.updateUser(null);
}

















}