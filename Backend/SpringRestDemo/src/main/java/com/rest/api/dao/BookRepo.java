package com.rest.api.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.api.entities.Book;


public interface BookRepo extends CrudRepository<Book, Integer>{
	public Book findById(int id);
}
