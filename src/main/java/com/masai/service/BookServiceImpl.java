package com.masai.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.masai.exception.BookNotFoundException;
import com.masai.model.Book;
import com.masai.repository.BookDao;


@Service
public class BookServiceImpl implements BookSrevice {
	
	@Autowired
	private BookDao bDao; 
	
	@Override
	public Book createBook(Book book) {
		
		 Book addedBook =  bDao.save(book);
		
		return addedBook;
	}

	@Override
	public List<Book> getAllBooks() throws BookNotFoundException{
		
		List<Book> list = bDao.findAll();
		
		if(list.size()>0)
		return list;
		
		else
			throw new BookNotFoundException("No books in the DB..");
	}

	@Override
	public Book getBookById(Integer id) throws BookNotFoundException{
		Optional<Book> opt = bDao.findById(id);
		
		if(opt.isPresent()) {
		Book book = opt.get();
		return book;
		}
		else
			throw new BookNotFoundException("No book found with id "+id);
	}

	@Override
	public Book deleteBookById(Integer id) throws BookNotFoundException{
		
		Optional<Book> opt = bDao.findById(id);
		
		if(opt.isPresent()) {
		Book book = opt.get();
				bDao.delete(book);
		return book;
		}
		else
			throw new BookNotFoundException("No book found with id "+id);
	}

	@Override
	public Book updateBook(Book book) {
		
	   Optional<Book> opt =  bDao.findById(book.getBookId());
		
	   if(opt.isPresent()) {
	    Book Exsisting = opt.get();
		
	    Book book1 = bDao.save(book);
	    
		return book1;
	   }
	   else
		   throw new BookNotFoundException("No book found with id "+book.getBookId());
	}

}
