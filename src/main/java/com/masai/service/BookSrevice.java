package com.masai.service;

import java.util.List;

import com.masai.model.Book;

public interface BookSrevice {

	public Book createBook(Book book);
	public List<Book> getAllBooks();
	public Book getBookById(Integer id);
	public Book deleteBookById(Integer id);
	public Book updateBook(Book book);
	
}
