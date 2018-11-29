package com.revature.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.revature.daos.*;
import com.revature.models.Posting;

@Service
public class PostingService {

	PostingDao pdao = new PostingDaoImp();

	public List<Posting> findAllPostings() {
		return pdao.getAllPosting();
//		return null;
	}


	public void addPosting(Posting p) {
pdao.createPosting(p);
//		return null;
	}

	public boolean deletePosting(int id) {
return pdao.deletePosting(id);
//		return null;
	}

	public Posting findPostingById(int id) {
return pdao.getPosting(id);
//		return null;
	}

	public void updatePosting(Posting p) {
pdao.updatePosting(p);
//		return null;
	}









/*
	public Posting addPosting(Posting p) {
		// TODO Auto-generated method stub
		return null;
	}
	public Posting deletePosting(Posting posting) {
		// TODO Auto-generated method stub
		return null;
	}
	public Posting findPostingById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Posting updatePosting(Posting p) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
