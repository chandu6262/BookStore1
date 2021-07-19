package com.example.demo.Controller;

import java.util.List;

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

import com.example.demo.Entity.Author;
import com.example.demo.service.AddResponse;
import com.example.demo.service.AuthorService;

@RestController
@RequestMapping
public class AuthorController {
	public static Logger logger = Logger.getLogger(AuthorController.class);
	
	@Autowired
	AuthorService authorService;

	@GetMapping("/authors")
	public List<Author> getauthor()
	{
		return authorService.getAllAuthors();
	}
	@PostMapping("/authors/add")
	public Author addauthor(@RequestBody Author author)
	{
		return authorService.addAllAuthor(author);
	}
	@PutMapping("/authors/update/{author_id}")    //Update books
	public Author updateBook(@PathVariable(value="author_id") int author_id, @RequestBody Author au)
	{
		Author existingAuthor = authorService.getAuthors(author_id);
		existingAuthor.setAuthor_name(au.getAuthor_name());
		existingAuthor.setDate_of_birth(au.getDate_of_birth());
		authorService.updateAuthors(existingAuthor);
		return existingAuthor;
	}

	@DeleteMapping("/authors/delete/{author_id}")   

	public AddResponse deleteAuthor(@PathVariable(value = "author_id") int author_id)
	{
		logger.info("Author with author_id:"+" "+author_id+" "+"is deleted");
		return authorService.deleteAuthors(author_id);    //Delete books
	}

}
