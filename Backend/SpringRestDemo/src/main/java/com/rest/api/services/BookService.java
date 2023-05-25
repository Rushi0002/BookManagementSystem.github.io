package com.rest.api.services;

import java.util.ArrayList;
import java.util.*;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.api.dao.BookRepo;
import com.rest.api.entities.*;

@Component
public class BookService {
//	private static List<Book> list = new ArrayList<>();
//	static {
//		list.add(new Book(1, "c", "ayush"));
//		list.add(new Book(2, "c++", "yash"));
//		list.add(new Book(3, "python", "vikas"));
//	}
	
	@Autowired
	private BookRepo bookRepo;

	// get all books
	public List<Book> getAllBooks() {
		List<Book> list = (List<Book>) this.bookRepo.findAll();
		return list;
	}

	// get single book by id;
	public Book getBookById(int id) {
		Book book = null;
		try {
//			book = list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepo.findById(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}

	// add book
	public Book addBook(Book b) {
//		list.add(b);
		Book result = this.bookRepo.save(b);
		return result;
	}

	// delete book
	public void deleteBook(int bid) {
//		list = list.stream().filter(book -> book.getId() != bid).
//		collect(Collectors.toList());
		this.bookRepo.deleteById(bid);
	}
	
	//update book 
	public void updateBook(Book book, int bid) {
//		list.stream().map(b->{
//			if(b.getId()==bid)
//			{
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		
		book.setId(bid);
		this.bookRepo.save(book);
	}
}
