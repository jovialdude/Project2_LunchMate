package com.revature.daos;

import java.util.List;

import com.revature.models.Posting;

public interface PostingDao {
	public List<Posting> getAllPosting();
	public Posting getPosting(int id);
	public void createPosting(Posting p);
	public void updatePosting(Posting p);
	public boolean deletePosting(int id);
}
