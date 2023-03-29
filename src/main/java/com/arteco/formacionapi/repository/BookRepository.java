package com.arteco.formacionapi.repository;

import com.arteco.formacionapi.model.Book;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findAll();
}
