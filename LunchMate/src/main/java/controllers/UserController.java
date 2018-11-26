//	package *.controllers

//	imports




@RestController
@RequestMapping("/users")
public class UserController	{

@Autowired
UserService userService;


	@GetMapping
public List<User> findAllUsers(){
		return userService.findAllUsers();
	}

	@GetMapping("/{id}")
public User findUserById(@PathVariable("id") Integer id) {
		return userService.findUserById(id);
	}

	@PostMapping
public User addUser(@Valid @RequestBody User u) {
		return userService.addUser(u);
	}

	@PutMapping("/{id}")
public User updateUser(@Valid @PathVariable("id") Integer id,
@RequestBody User u)	{
		u.setUserId(id);
		return userService.updateUser(u);
	}

	@DeleteMapping("/{id}")
public User deleteUser(@PathVariable Integer id) {
		User user = new User();
		user.setUserId(id);
		return userService.deleteUser(user);
	}
  
}
