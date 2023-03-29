package com.arteco.formacionapi;

import com.arteco.formacionapi.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class OnLaunchApp implements CommandLineRunner {

	@Autowired
	BookRepository repository;

	@Override
	public void run(final String... args) throws Exception {

		this.repository.findAll()
			.forEach(b -> log.info(b.toString()));
	}
}
