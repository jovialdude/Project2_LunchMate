package com.revature.test;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.revature.daos.*;

public class TestPostingDaoImp {

	static PostingDao pd = new PostingDaoImp();
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void nullPosting() {
		expectedException.expect(Exception.class);
		pd.createPosting(null);
	}

	@Test
	public void nullUpdate() {
		expectedException.expect(Exception.class);
		pd.updatePosting(null);
	}

	@Test
	public void nullAllPosts() {
		assertNotEquals(pd.getAllPosting(), null);
		;
	}

















}
