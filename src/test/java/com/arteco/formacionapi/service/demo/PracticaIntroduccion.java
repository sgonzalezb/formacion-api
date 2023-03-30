package com.arteco.formacionapi.service.demo;

import com.arteco.formacionapi.model.Book;
import java.time.LocalDate;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Slf4j
class PracticaIntroduccion {

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

	/*TODO:
	 *  -Las variables globales NO pueden ser modificadas, en ningún caso.
	 * - La variable global BOOK_LIST será nuestra "base de datos" ficticia, se utilizará en todas las prácticas
	 * - Las prácticas vendrán con test comentados, para validar que el ejercicio está bien hecho.
	 * - Por cada práctica hacer commit y push (se recomienda refactorizar una vez completada la tarea -> 2 commits x práctica)
	 */

	@Test
	@DisplayName("Obten una lista de los libros con categoria = 'economia'")
	void practica_1() {
		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		// Assertions.assertThat(tuResultado).containsOnly(BOOK_2, BOOK_3);
	}

	@Test
	@DisplayName("Obten una lista de libros de la categoria = \"economia\" donde el precio sea mayor que 17€ ")
	void practica_1a() {
		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		// Assertions.assertThat(tuResultado).containsOnly(BOOK_2);
	}

	@Test
	@DisplayName("Obten una lista de libros de la categoria = \"economia\" donde el precio sea mayor que 17€ (usando Predicate)")
	void practica_1b() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		// Assertions.assertThat(tuResultado).containsOnly(BOOK_2);
	}

	@Test
	@DisplayName("Obten una lista de libros ordenada por fecha de publicación (ascendente)")
	void practica_2a() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado.get(0)).isEqualTo(BOOK_2);
		//		Assertions.assertThat(tuResultado.get(1)).isEqualTo(BOOK_3);
		//		Assertions.assertThat(tuResultado.get(2)).isEqualTo(BOOK_5);
		//		Assertions.assertThat(tuResultado.get(3)).isEqualTo(BOOK_1);
		//		Assertions.assertThat(tuResultado.get(4)).isEqualTo(BOOK_4);
	}

	@Test
	@DisplayName("Obten una lista de libros ordenada por fecha de publicación (descendente)")
	void practica_2b() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado.get(0)).isEqualTo(BOOK_4);
		//		Assertions.assertThat(tuResultado.get(1)).isEqualTo(BOOK_1);
		//		Assertions.assertThat(tuResultado.get(2)).isEqualTo(BOOK_5);
		//		Assertions.assertThat(tuResultado.get(3)).isEqualTo(BOOK_3);
		//		Assertions.assertThat(tuResultado.get(4)).isEqualTo(BOOK_2);
	}


	@Test
	@DisplayName("Obten los tres libros más baratos (descente), de libros que NO han sido publicados ")
	void exercise3() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado).hasSize(3);
		//		Assertions.assertThat(tuResultado.get(0)).isEqualTo(BOOK_4);
		//		Assertions.assertThat(tuResultado.get(1)).isEqualTo(BOOK_5);
		//		Assertions.assertThat(tuResultado.get(2)).isEqualTo(BOOK_1);
	}

	@Test
	@DisplayName("Obten la suma de los precios de los libros que han sido publicados ")
	void exercise4() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado).isEqualTo(33);
	}

	@Test
	@DisplayName("Obten la media de los precios de los libros que ha publicado el autor = 'Juan' (Usando BiPredicate)")
	void exercise5() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado).isEqualTo(16.5d);
	}

	@Test
	@DisplayName("Agrupa los libros por su autor (Map)")
	void exercise6() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado).hasSize(3);
		//		Assertions.assertThat(tuResultado.get("Paco")).contains(BOOK_1);
		//		Assertions.assertThat(tuResultado.get("Juan")).contains(BOOK_2, BOOK_3);
		//		Assertions.assertThat(tuResultado.get("Miguel")).contains(BOOK_5, BOOK_4);
	}

	@Test
	@DisplayName("Agrupa la media de los precios por su año de publicación (Map)")
	void exercise7() {

		//Fixme: descomentar el assert y realizar prueba (susituir la variable tuResultado)
		//		Assertions.assertThat(tuResultado).hasSize(3);
		//		Assertions.assertThat(tuResultado.get(2017)).isEqualTo(16.5d);
		//		Assertions.assertThat(tuResultado.get(2025)).isEqualTo(15.5d);
		//		Assertions.assertThat(tuResultado.get(2030)).isEqualTo(19d);
	}
}
