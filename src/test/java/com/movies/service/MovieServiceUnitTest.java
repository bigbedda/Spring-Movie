package com.movies.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.movies.entity.Movie;
import com.movies.repo.MovieRepo;


@SpringBootTest

public class MovieServiceUnitTest {

	
	@Autowired
	private MovieService service;
	
	
	@MockBean
	private MovieRepo repo;
	
	@Test
	public void createMovieTest() {
		Movie input = new Movie(3, "Jake b dummer","the dark tomorrow", 7.8);
		Movie output = new Movie(1L, 3, "Jake b dummer","the dark tomorrow", 7.8);
		
		
		Mockito.when(this.repo.save(input)).thenReturn(output);
		
		
		assertEquals(output, this.service.create(input));
		
		
		Mockito.verify(this.repo, Mockito.times(1)).save(input);
	}
	
	@Test
	public void readByIdTest() {
		
		Optional<Movie> optionalOutput = Optional.of(new Movie(1L, 3, "Jake b dummer","the dark tomorrow", 7.8));
		Movie output = new Movie(3, "Jake b dummer","the dark tomorrow", 7.8);
		
	
		Mockito.when(this.repo.findById(Mockito.anyLong())).thenReturn(optionalOutput);
		
		assertEquals(output, this.service.readById(Mockito.anyLong()));
		
		Mockito.verify(this.repo, Mockito.times(1)).findById(Mockito.anyLong());
	}
	
	@Test
	public void deleteTrueTest() {
		Mockito.when(this.repo.existsById(1L)).thenReturn(false);
		
		assertTrue(this.service.delete(1L));
		
		Mockito.verify(this.repo, Mockito.times(1)).deleteById(1L);
		Mockito.verify(this.repo, Mockito.times(1)).existsById(1L);
		
	}

}
