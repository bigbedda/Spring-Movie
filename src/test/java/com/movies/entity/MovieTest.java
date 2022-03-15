package com.movies.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import nl.jqno.equalsverifier.EqualsVerifier;

public class MovieTest {

	
	@Test
	public void testEquals() {
		EqualsVerifier.forClass(Movie.class).usingGetClass().verify();
	}

	@Test
	public void getAndSetTest() {
		
		Movie Movie = new Movie();

		
		Movie.setId(1L);
		Movie.setAge(4);
		Movie.setdirector("Kat");
		Movie.setrating(7.3);
		Movie.setName("Kochanski");

		
		assertNotNull(Movie.getAge());
		assertNotNull(Movie.getId());
		assertNotNull(Movie.getdirector());
		assertNotNull(Movie.getName());
		assertNotNull(Movie.getrating());

		
		assertEquals(Movie.getAge(), 4);
		assertEquals(Movie.getId(), 1L);
		assertEquals(Movie.getdirector(), "Kat");
		assertEquals(Movie.getName(), "Kochanski");
		assertEquals(Movie.getrating(), 7.3);
	}

	@Test
	public void allArgsConstructor() {
		Movie Movie = new Movie(1L, 18, "Mr Lister", "Red Dwarf", 8.8);

		
		assertNotNull(Movie.getAge());
		assertNotNull(Movie.getId());
		assertNotNull(Movie.getdirector());
		assertNotNull(Movie.getName());
		assertNotNull(Movie.getrating());

		
		assertEquals(Movie.getAge(), 18);
		assertEquals(Movie.getId(), 1L);
		assertEquals(Movie.getdirector(), "Red Dwarf");
		assertEquals(Movie.getName(), "Mr Lister");
		assertEquals(Movie.getrating(), 8.8);
	}
}

