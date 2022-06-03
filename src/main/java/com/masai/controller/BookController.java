package com.masai.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.masai.model.Book;
import com.masai.service.BookServiceImpl;

@RestController
public class BookController {

	@Autowired
	private BookServiceImpl bService;

	@PostMapping("/books")
	public Book addBookHandler(@Valid @RequestBody Book book) {

		Book book1 = bService.createBook(book);

		return book1;
	}

	@GetMapping("/books")
	public List<Book> getAllBooksHandler() {

		List<Book> list = bService.getAllBooks();

		return list;
	}

	@GetMapping("/books/{id}")
	public Book getBookByIdHandler(@PathVariable("id") Integer id) {

		Book book = bService.getBookById(id);
		return book;
	}

	@DeleteMapping("/books/{id}")
	public Book deleteBookByIdHandler(@PathVariable("id") Integer id) {

		Book book = bService.deleteBookById(id);
		return book;

	}

	@PutMapping("/books")
	public Book updateBook(@RequestBody Book book) {

		Book book1 = bService.updateBook(book);

		return book1;
	}

}
