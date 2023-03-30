package com.arteco.formacionapi.service;

import static org.mockito.BDDMockito.given;

import com.arteco.formacionapi.model.Book;
import com.arteco.formacionapi.repository.BookRepository;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {

	private static final Book BOOK_1 = new Book(1L,
												"Clean Code",
												"Robert Cecil Martin",
												"desarrollo",
												true,
												15d);
	private static final Book BOOK_2 = new Book(2L,
												"Padre Rico,"
													+ "padre Pobre",
												"Robert T. Kiyosaki",
												"economia",
												true,
												25d);
	private static final Book BOOK_3 = new Book(3L,
												"Piense y hágase rico ",
												"Napoleon Hill",
												"economia",
												true,
												8d);
	private static final Book BOOK_4 = new Book(4L,
												"Harry Potter y la piedra filosofal",
												"Joanne Rowling",
												"ciencia ficción",
												true,
												18d);
	private static final Book BOOK_5 = new Book(5L,
												"La chica del tren",
												"Paula Hawkins",
												"terror",
												true,
												18d);


	private static final List<Book> BOOK_LIST = List.of(BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5);

	@Mock
	private BookRepository bookRepository;

	@InjectMocks
	private BookService bookService;

	@Test
	void should_return_a_list_of_books() {

		given(this.bookRepository.findAll()).willReturn(BOOK_LIST);

		final List<Book> allBooks = this.bookService.findAll();

		Assertions.assertThat(allBooks).hasSize(5).isEqualTo(BOOK_LIST);
	}
}