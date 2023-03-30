package com.arteco.formacionapi.service.demo;

import com.arteco.formacionapi.model.Book;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class PracticaIntroduccionResuelta {

	private static final Book BOOK_1 = new Book(1L,
												"Optimizando Código",
												"Paco",
												"desarrollo",
												LocalDate.of(2025, 5, 25),
												15d);
	private static final Book BOOK_2 = new Book(2L,
												"Somos Ricos",
												"Juan",
												"economia",
												LocalDate.of(2017, 2, 12),
												25d);
	private static final Book BOOK_3 = new Book(3L,
												"Cogito, ergo me hago rico",
												"Juan",
												"economia",
												LocalDate.of(2017, 8, 17),
												8d);
	private static final Book BOOK_4 = new Book(4L,
												"Magos por Madrid",
												"Miguel",
												"ciencia ficción",
												LocalDate.of(2030, 10, 10),
												19d);
	private static final Book BOOK_5 = new Book(5L,
												"El tren imparable",
												"Miguel",
												"terror",
												LocalDate.of(2025, 1, 1),
												16d);


	private static final List<Book> BOOK_LIST = List.of(BOOK_1, BOOK_2, BOOK_3, BOOK_4, BOOK_5);

	/*
	 * REGLAS:
	 *  -Las variables globales NO pueden ser modificadas, en ningún caso.
	 * - La variable global BOOK_LIST será nuestra "base de datos" ficticia, se utilizará en todas las prácticas
	 * - Las prácticas vendrán con test comentados, para validar que el ejercicio está bien hecho
	 * - Por cada tarea realizada commit y push (se recomienda refactorizar una vez completada la tarea -> 2 commits x tarea)
	 */

	@Test
	@DisplayName("Obten una lista de los libros con categoria = 'economia'")
	void practica_1() {

		final List<Book> filteredBooks = BOOK_LIST.stream()
			.filter(book -> book.getCategory().equalsIgnoreCase("economia"))
			.toList();

		Assertions.assertThat(filteredBooks).containsOnly(BOOK_2, BOOK_3);
	}

	@Test
	@DisplayName("Obten una lista de libros de la categoria = \"economia\" donde el precio sea mayor que 17€ ")
	void practica_1a() {

		final List<Book> filteredBooks = BOOK_LIST.stream()
			.filter(book -> book.getCategory().equalsIgnoreCase("economia"))
			.filter(book -> book.getPrice() > 9)
			.toList();

		Assertions.assertThat(filteredBooks).containsOnly(BOOK_2);
	}

	@Test
	@DisplayName("Obten una lista de libros de la categoria = \"economia\" donde el precio sea mayor que 17€ (usando Predicate)")
	void practica_1b() {

		final Predicate<Book> categoryFilter = book -> book.getCategory().equalsIgnoreCase("economia");
		final Predicate<Book> priceFilter = book -> book.getPrice() > 17;

		final List<Book> filteredBooks = BOOK_LIST.stream()
			.filter(book -> categoryFilter.test(book))
			.filter(book -> priceFilter.test(book))
			.toList();

		Assertions.assertThat(filteredBooks).containsOnly(BOOK_2);
	}

	@Test
	@DisplayName("Obten una lista de libros ordenada por fecha de publicación (ascendente)")
	void practica_2a() {

		final List<Book> booksSortedByPublishDate = BOOK_LIST.stream()
			.sorted(Comparator.comparing(Book::getPublish))
			.toList();

		Assertions.assertThat(booksSortedByPublishDate.get(0)).isEqualTo(BOOK_2);
		Assertions.assertThat(booksSortedByPublishDate.get(1)).isEqualTo(BOOK_3);
		Assertions.assertThat(booksSortedByPublishDate.get(2)).isEqualTo(BOOK_5);
		Assertions.assertThat(booksSortedByPublishDate.get(3)).isEqualTo(BOOK_1);
		Assertions.assertThat(booksSortedByPublishDate.get(4)).isEqualTo(BOOK_4);
	}

	@Test
	@DisplayName("Obten una lista de libros ordenada por fecha de publicación (descendente)")
	void practica_2b() {

		final List<Book> booksSortedByPublishDate = BOOK_LIST.stream()
			.sorted(Comparator.comparing(Book::getPublish).reversed())
			.toList();

		Assertions.assertThat(booksSortedByPublishDate.get(0)).isEqualTo(BOOK_4);
		Assertions.assertThat(booksSortedByPublishDate.get(1)).isEqualTo(BOOK_1);
		Assertions.assertThat(booksSortedByPublishDate.get(2)).isEqualTo(BOOK_5);
		Assertions.assertThat(booksSortedByPublishDate.get(3)).isEqualTo(BOOK_3);
		Assertions.assertThat(booksSortedByPublishDate.get(4)).isEqualTo(BOOK_2);
	}


	@Test
	@DisplayName("Obten los tres libros más baratos (descente), de libros que NO han sido publicados ")
	void exercise3() {

		final List<Book> booksNoPublished = BOOK_LIST.stream()
			.filter(book -> book.getPublish().isAfter(LocalDate.now()))
			.sorted(Comparator.comparing((Book book) -> book.getPrice()).reversed())
			.limit(3)
			.toList();

		Assertions.assertThat(booksNoPublished).hasSize(3);
		Assertions.assertThat(booksNoPublished.get(0)).isEqualTo(BOOK_4);
		Assertions.assertThat(booksNoPublished.get(1)).isEqualTo(BOOK_5);
		Assertions.assertThat(booksNoPublished.get(2)).isEqualTo(BOOK_1);
	}

	@Test
	@DisplayName("Obten la suma de los precios de los libros que han sido publicados ")
	void exercise4() {

		final Double pricesPublishedBooks = BOOK_LIST.stream()
			.filter(book -> book.getPublish().isBefore(LocalDate.now()))
			.map(book -> book.getPrice())
			.mapToDouble(Double::doubleValue)
			.sum();

		Assertions.assertThat(pricesPublishedBooks).isEqualTo(33);
	}

	@Test
	@DisplayName("Obten la media de los precios de los libros que ha publicado el autor = 'Juan' (Usando BiPredicate)")
	void exercise5() {

		final BiPredicate<Book, String> biPredicate = (book, authorName) -> book.getAuthor().equals(authorName);

		final Double pricesPublishedBooks = BOOK_LIST.stream()
			.filter(book -> book.getPublish().isBefore(LocalDate.now()))
			.filter(book -> biPredicate.test(book, "Juan"))
			.mapToDouble(Book::getPrice)
			.average()
			.getAsDouble();

		Assertions.assertThat(pricesPublishedBooks).isEqualTo(16.5d);
	}

	@Test
	@DisplayName("Agrupa los libros por su autor (Map)")
	void exercise6() {

		final Map<String, List<Book>> booksGroupedByAuthor = BOOK_LIST.stream()
			.collect(Collectors.groupingBy(Book::getAuthor));

		Assertions.assertThat(booksGroupedByAuthor).hasSize(3);
		Assertions.assertThat(booksGroupedByAuthor.get("Paco")).contains(BOOK_1);
		Assertions.assertThat(booksGroupedByAuthor.get("Juan")).contains(BOOK_2, BOOK_3);
		Assertions.assertThat(booksGroupedByAuthor.get("Miguel")).contains(BOOK_5, BOOK_4);
	}

	@Test
	@DisplayName("Agrupa la media de los precios por su año de publicación (Map)")
	void exercise7() {

		final HashMap<Integer, Double> averagePricesGroupedByPublicationYear = BOOK_LIST.stream()
			.collect(Collectors.groupingBy(book -> book.getPublish().getYear(),
										   HashMap::new,
										   Collectors.mapping(Book::getPrice, Collectors.averagingDouble(Double::doubleValue))));

		Assertions.assertThat(averagePricesGroupedByPublicationYear)
			.hasSize(3)
			.containsEntry(2017, 16.5d)
			.containsEntry(2025, 15.5d)
			.containsEntry(2030, 19d);
	}
}
