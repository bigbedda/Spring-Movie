package com.movies.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.movies.controller.MovieController;
import com.movies.entity.Movie;
import com.movies.service.MovieService;

@SpringBootTest
public class MovieControllerUnitTest {

	@Autowired
	private MovieController controller;
	
	@MockBean
	private MovieService service;
	
	@Test
	public void createMovieTest() {
		Movie movie = new Movie(15, "Rimmer", "Dwarf Tales", 6.4);
		
		
		Mockito.when(this.service.create(movie)).thenReturn(movie);
		
		
		ResponseEntity<Movie> response = new ResponseEntity<Movie>(movie, HttpStatus.CREATED);
		
		assertThat(response).isEqualTo(this.controller.createMovie(movie));
		
		Mockito.verify(this.service,times(1)).create(movie);
		
	}
	
	
}
