package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.User;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.service.AddResponse;
import com.example.demo.service.UserService;

@RestController
@RequestMapping
public class UserController {
	public static Logger logger = Logger.getLogger(UserController.class);
	@Autowired
	UserService userService;

	@GetMapping("/users")
	public List<User> getusers()
	{
		return userService.getAllUsers();
	}
	@GetMapping("/users/{id}")
	public User getuserByid(@PathVariable(value="id") int id)
	{

		return userService.getUser(id);
	}
	@PostMapping("/users/add")
	public User addusers(@Valid @RequestBody User user)
	{
		return userService.addAllUser(user);
	}


	@PutMapping("/users/update/{user_id}")
	public User updateUser(@PathVariable(value="user_id") int user_id, @RequestBody User use) throws UserNotFoundException
	{

		User existingUser = userService.getUser(user_id);
		existingUser.setPassword(use.getPassword());
		existingUser.setUser_type(use.getUser_type());
		existingUser.setFirst_name(use.getFirst_name());
		existingUser.setLast_name(use.getLast_name());
		existingUser.setContact(use.getContact());
		existingUser.setEmail(use.getEmail());
		userService.updateUsers(existingUser);
		return existingUser;


	}

	@DeleteMapping("/users/delete/{user_id}")

	public AddResponse deleteUser(@PathVariable(value = "user_id") int user_id)
	{
		logger.info("User with user_id:"+" "+user_id+" "+"is deleted");
		return userService.deleteUsers(user_id);
	}


}
