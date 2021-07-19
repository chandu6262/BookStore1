package com.example.demo.service;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.User;
import com.example.demo.Exception.UserNotFoundException;
import com.example.demo.Respository.UserRepository;

@Component
@Service
public class UserService {
	public static Logger logger = Logger.getLogger(UserService.class);

	@Autowired
	UserRepository userRepo;

	public List<User> getAllUsers()   //Get user
	{
		return userRepo.findAll(); 
	}

	public User getUser(int user_id)          // find by id
	{
		try {
			logger.info("User with user_id:"+" "+user_id+" "+"is updated succesfully");  //logging
			return userRepo.findById(user_id).get(); 
		}
		catch(Exception e) {
			logger.info("Exception occured");    //logging
			throw new UserNotFoundException("Invalid user id:"+" "+user_id); 
		}

	}
	public User addAllUser(User user)
	{
		userRepo.save(user);    //add user
		return user;
	}

	public User updateUsers(User u)
	{
		userRepo.save(u);     //update
		return u;
	}

	public AddResponse deleteUsers(int user_id)
	{

		try {
			logger.info("User with user_id:"+" "+user_id+" "+"is deleted succesfully");
			userRepo.deleteById(user_id);    //delete
			AddResponse res =  new AddResponse();
			res.setId(user_id);
			res.setMsge("user deleted succesfully");
			return res;
		}
		catch(Exception e){
			logger.info("Exception occured");
			throw new UserNotFoundException("not valid");

		}


	}
}

