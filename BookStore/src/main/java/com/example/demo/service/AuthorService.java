package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Author;
import com.example.demo.Exception.AuthorNotFoundException;
import com.example.demo.Respository.AuthorRepository;

@Component
@Service
public class AuthorService {
	public static Logger logger = Logger.getLogger(AuthorService.class);
	@Autowired
	AuthorRepository authorRepo;


	public List<Author> getAllAuthors()
	{
		return authorRepo.findAll();
	}
	public Author getAuthors(int author_id)
	{
		List<Author> author =authorRepo.findAll();
		logger.info("Checking condition");       //logging  
		for(Author au:author)
		{
			if(au.getAuthor_id()!=author_id) {
				logger.info("Exception occured");    //logging
				throw new AuthorNotFoundException("Invalid author id:"+" "+author_id);	// find by id
			}
			else { 
				logger.info("Author with author id:"+" "+author_id+" "+"is updated succesfully");  //logging
				return authorRepo.findById(author_id).get();}
		}
		return null;
	}
	public Author addAllAuthor(Author author)
	{
		authorRepo.save(author);        //Add author details
		return author;
	}
	public Author updateAuthors(Author a)
	{

		authorRepo.save(a);     //update
		return a;
	}
	public AddResponse deleteAuthors(int author_id)
	{
		List<Author> author =authorRepo.findAll();
		logger.info("Checking condition");       //logging  
		for(Author au:author)
		{
			if(au.getAuthor_id()!=author_id) {
				logger.info("Exception occured");    //logging
				throw new AuthorNotFoundException("Invalid author id:"+" "+author_id);	// find by id
			}
			else { 
				logger.info("Author with author id:"+" "+author_id+" "+"is updated succesfully");  //logging
				authorRepo.deleteById(author_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(author_id);
				res.setMsge("Author deleted succesfully");
				return res; }
		}
		return null;
	}

}
