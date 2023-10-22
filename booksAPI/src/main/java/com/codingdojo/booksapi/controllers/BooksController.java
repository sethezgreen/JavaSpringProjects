package com.codingdojo.booksapi.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.booksapi.models.Book;
import com.codingdojo.booksapi.services.BookService;

import jakarta.validation.Valid;

@Controller
public class BooksController {

	@Autowired
	BookService bookService;
	
	@GetMapping("/books/{bookId}")
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		Book book = bookService.findBook(bookId);
		
		model.addAttribute("book", book);
		
		return "index.jsp";
	}
	
	@GetMapping("/books")
	public String allBooks(Model model) {
		List<Book> books = bookService.allBooks();
		model.addAttribute("books", books);
		return "all_books.jsp";
	}
	
	@GetMapping("/books/new")
	public String newBook() {
		return "new.jsp";
	}
	
	// Note: We'll be altering this a bit after we introduce data binding.
	@PostMapping("/books")
	public String create(
	    @RequestParam("title") String title,
	    @RequestParam("description") String description,
	    @RequestParam("language") String language,
	    @RequestParam("pages") Integer pages) 
	{
	    // CODE TO MAKE A NEW BOOK AND SAVE TO THE DB
	    Book book = new Book(title, description, language, pages);
	    bookService.createBook(book);
	    return "redirect:/dashboard";
	}
	
	@RequestMapping("/books/{id}/edit")
	    public String edit(@PathVariable("id") Long id, Model model) {
	        Book book = bookService.findBook(id);
	        model.addAttribute("book", book);
	        return "/books/edit.jsp";
	    }
	    
	@RequestMapping(value="/books/{id}", method=RequestMethod.PUT)
	    public String update(@Valid @ModelAttribute("book") Book book, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("book", book);
	            return "/books/edit.jsp";
	        } else {
	            bookService.updateBook(book);
	            return "redirect:/books";
	        }
	    }

}
