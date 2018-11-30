package com.revature.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping
public List<Posting> findAllPostings()
{	return postingService.findAllPostings();	};

@CrossOrigin(origins = "http://localhost:4200")
@GetMapping("/{id}")
public Posting findPostingById(@PathVariable("id") Integer id)
{	return postingService.findPostingById(id);	}


@CrossOrigin(origins = "http://localhost:4200")
@PostMapping
public void addPosting(@Valid @RequestBody Posting p)
{	postingService.addPosting(p);	}


@CrossOrigin(origins = "http://localhost:4200")
@PutMapping("/{id}")
public void updatePosting(
	@Valid @PathVariable("id") Integer id, @RequestBody Posting p){
//	what are we trying to update here?
//	more implementation details needed?
p.setId(id);
postingService.updatePosting(p);	}

@CrossOrigin(origins = "http://localhost:4200")
@DeleteMapping("/{id}")
public boolean deletePosting(@PathVariable int id){
Posting posting = new Posting();
posting.setId(id);
return postingService.deletePosting(id);	}



}






