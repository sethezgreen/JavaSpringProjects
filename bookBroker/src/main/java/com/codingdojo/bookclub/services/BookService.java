package com.codingdojo.bookclub.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.repositories.BookRepository;

import jakarta.servlet.http.HttpSession;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	// returns all books
	public List<Book> allBooks() {
		return bookRepo.findAll();
	}
	
	// gets one book
	public Book getBook(Long id) {
		Optional<Book> optionalBook = bookRepo.findById(id);
		return optionalBook.isPresent() ? optionalBook.get() : null;
	}
	
	// creates a book
	public Book createBook(Book book) {
		book.setUser(userService.getUserById((Long) session.getAttribute("userId")));
		return bookRepo.save(book);
	}
	
	// updates a book
	public Book updateBook(Book book) {
		book.setUser(userService.getUserById((Long) session.getAttribute("userId")));
		return bookRepo.save(book);
	}
	
	// deletes a book
	public void deleteBook(Long id) {
		bookRepo.deleteById(id);
	}
}
