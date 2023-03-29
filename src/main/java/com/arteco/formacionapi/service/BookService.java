package com.arteco.formacionapi.service;

import com.arteco.formacionapi.model.Book;
import com.arteco.formacionapi.repository.BookRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> findAll(){

		return bookRepository.findAll();
	}

}
