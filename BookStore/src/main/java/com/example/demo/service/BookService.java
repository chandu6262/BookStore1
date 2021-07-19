package com.example.demo.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.example.demo.Entity.Books;
import com.example.demo.Exception.BookNotFoundException;
import com.example.demo.Respository.BooksRepository;

@Component
@Service
public class BookService {
	public static Logger logger = Logger.getLogger(BookService.class);
	@Autowired
	BooksRepository booksRepo;

	public List<Books> getAllBooks()   //Get Books
	{
		return booksRepo.findAll();
	}
	public Books getBooks(int book_id)
	{
		List<Books> book =booksRepo.findAll();
		logger.info("Checking condition");       //logging
		for(Books bk:book)
		{
			if(bk.getBook_id()!=book_id) {
				logger.info("Exception occured");    //logging
				throw new BookNotFoundException("Invalid Book id:"+" " +book_id);	// find by id
			}
			else { 
				logger.info("Book with book id:"+" "+book_id+" "+"is updated succesfully");  //logging
				return booksRepo.findById(book_id).get();}
		}
		return null;
	}
	public Books addAllBooks(Books books)
	{
		booksRepo.save(books);          //Add Book
		return books;
	}
	public Books updateBooks(Books b)
	{

		booksRepo.save(b);     //update
		return b;

	}

	public AddResponse deleteBooks(int book_id)
	{
		List<Books> book =booksRepo.findAll();
		logger.info("Checking condition");       //logging
		for(Books bk:book)
		{
			if(bk.getBook_id()!=book_id) {
				logger.info("Exception occured");    //logging
				throw new BookNotFoundException("Invalid Book id:"+" " +book_id);	// find by id
			}
			else { 
				logger.info("Book with book id:"+" "+book_id+" "+"is updated succesfully");  //logging
				booksRepo.deleteById(book_id);    //delete
				AddResponse res =  new AddResponse();
				res.setId(book_id);
				res.setMsge("Book deleted succesfully");
				return res; }
		}
		return null;
	}

}
