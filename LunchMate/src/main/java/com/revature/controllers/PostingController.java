package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.*;
import com.revature.services.*;


@RestController
@RequestMapping("/postings")
public class PostingController	{

	@Autowired
PostingService postingService;


@GetMapping
public List<PostingServiceLayer> findAllPostings()
{	return postingService.findAllPostings();	};


@GetMapping("/{id}")
public PostingServiceLayer findPostingById(@PathVariable("id") Integer id)
{	return postingService.findPostingById(id);	}



@PostMapping
public PostingServiceLayer addPosting(@Valid @RequestBody PostingServiceLayer p)
{	return postingService.addPosting(p);	}



@PutMapping("/{id}")
public PostingServiceLayer updatePosting(
	@Valid @PathVariable("id") Integer id, @RequestBody PostingServiceLayer p){
//	what are we trying to update here?
//	more implementation details needed?
p.setPostingId(id);
return postingService.updatePosting(p);	}


@DeleteMapping("/{id}")
public PostingServiceLayer deletePosting(@PathVariable Integer id){
PostingServiceLayer posting = new PostingServiceLayer();
posting.setPostingId(id);
return postingService.deletePosting(posting);	}



}






