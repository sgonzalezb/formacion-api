package com.arteco.formacionapi.controller;

import com.arteco.formacionapi.model.Book;
import com.arteco.formacionapi.service.BookService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BookController {

	@Autowired
	private BookService bookService;

	@GetMapping("/books")
	public List<Book> findAll() {

		return this.bookService.findAll();
	}
}
