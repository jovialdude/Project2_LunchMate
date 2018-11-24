//	package *.controllers;

//	imports



@RestController
@RequestMapping("/postings")
public class PostingController	{

	@Autowired
PostingService postingService;


@GetMapping
public List<Posting> findAllPostings()
{	return postingService.findAllPostings();	};


@GetMapping("/{id}")
public Posting findPostingById(@PathVariable("id") Integer id)
{	return postingService.findPostingById(id);	}



@PostMapping
public Posting addPosting(@Valid @RequestBody Posting p)
{	return postingService.addPosting(p);	}



@PutMapping("/{id}")
public Posting updatePosting(
	@Valid @PathVariable("id") Integer id, @RequestBody Posting p){
//	what are we trying to update here?
//	more implementation details needed?
p.setPostingId(id);
return postingService.updatePosting(p);	}


@DeleteMapping("/{id}")
public Posting deletePosting(@PathVariable Integer id){
Posting posting = new Posting();
posting.setPostingId(id);
return postingService.deletePosting(posting);	}



}






