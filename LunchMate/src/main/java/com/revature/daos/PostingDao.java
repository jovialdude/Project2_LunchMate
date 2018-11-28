package com.revature.daos;

import java.util.List;

import com.revature.models.PostingServiceLayer;

public interface PostingDao {
	public List<PostingServiceLayer> getAllPosting();
	public PostingServiceLayer getPosting(int id);
	public void createPosting(PostingServiceLayer p);
	public void updatePosting(PostingServiceLayer p);
	public boolean deletePosting(int id);
}
