package com.codingdojo.bookclub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.codingdojo.bookclub.models.Book;
import com.codingdojo.bookclub.models.User;
import com.codingdojo.bookclub.services.BookService;
import com.codingdojo.bookclub.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	HttpSession session;
	
	@GetMapping("/books")
	public String dashboard(Model model) {
//		Long userId = (Long) session.getAttribute("userId");
		if (this.checkLoginStatus() == null) {return "redirect:/";}
		User user = userService.getUserById(this.checkLoginStatus());
		model.addAttribute("loggedUser", user);
		model.addAttribute("books", bookService.allBooks());
		return "dashboard.jsp";
	}
	
	@GetMapping("/books/{bookId}")
	public String viewBook(@PathVariable("bookId") Long bookId, Model model) {
		if (this.checkLoginStatus() == null) { return "redirect:/";}
		model.addAttribute("book", bookService.getBook(bookId));
		return "one_book.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook(@ModelAttribute("book") Book book) {
		if (this.checkLoginStatus() == null) {return "redirect:/";}
		return "new_book.jsp";
	}
	
	@PostMapping("/books/edit/{bookId}")
	public String editBook(@PathVariable("bookId") Long bookId, Model model) {
		if (this.checkLoginStatus() == null) {return "redirect:/";}
		model.addAttribute("book", bookService.getBook(bookId));
		return "edit_book.jsp";
	}
	
	@PostMapping("/books/new")
	 public String createBook(@Valid @ModelAttribute("book") Book book, BindingResult result) {
		if(result.hasErrors()) {
			return "new_book.jsp";
		} else {
			bookService.createBook(book);
			return "redirect:/books";
		}
	}
	
	@PutMapping("/books/edit/{id}")
	public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("book", book);
			return "edit_book.jsp";
		} else {
			bookService.updateBook(book);
			return "redirect:/books/{id}";
		}
	}
	
	// checks if the user is logged in
	public Long checkLoginStatus() {
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return null;
		}
		return userId;
	}
}
