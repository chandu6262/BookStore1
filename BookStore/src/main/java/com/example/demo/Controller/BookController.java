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
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.Entity.Books;
import com.example.demo.service.AddResponse;
import com.example.demo.service.BookService;

@RestController
public class BookController {
	public static Logger logger = Logger.getLogger(BookController.class);
	
	@Autowired
	BookService bookService;

	@GetMapping("/books")
	public List<Books> getbooks()
	{
		return bookService.getAllBooks();
	}
	@PostMapping("/books/add")
	public Books addbooks(@RequestBody Books books)
	{
		return bookService.addAllBooks(books);
	}

	@PutMapping("/books/update/{book_id}")    //Update books
	public Books updateBook(@PathVariable(value="book_id") int book_id, @RequestBody Books bk)
	{
		Books existingBook = bookService.getBooks(book_id);
		existingBook.setBook_name(bk.getBook_name());
		existingBook.setPrice(bk.getPrice());
		bookService.updateBooks(existingBook);
		return existingBook;

	}

	@DeleteMapping("/books/delete/{book_id}")   

	public AddResponse deleteBook(@PathVariable(value = "book_id") int book_id)
	{
		logger.info("Book with book_id:"+" "+book_id+" "+"is deleted");
		return bookService.deleteBooks(book_id);    //Delete books
	}

}
