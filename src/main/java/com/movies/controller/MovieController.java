package com.movies.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.entity.Movie;
import com.movies.service.MovieService;


@RestController
@RequestMapping("/Movie")
public class MovieController {
	
	private MovieService service;
	
	private MovieController(MovieService service) {
		this.service = service;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
		return new ResponseEntity<Movie>(this.service.create(movie), HttpStatus.CREATED);
	}
	
	
	@GetMapping("/readAll")
	public ResponseEntity<List<Movie>> readAllMovies() {
		
		return new ResponseEntity<List<Movie>>(this.service.readAll(), HttpStatus.OK);
	}
		
	
	
	@GetMapping("/readById/{id}")
	public ResponseEntity<Movie> readById(@PathVariable long id) {
		return new ResponseEntity<Movie>(this.service.readById(id), HttpStatus.OK);
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Movie> updateMovie(@PathVariable long id, @RequestBody Movie movie) {
		return new ResponseEntity<Movie>(this.service.update(id, movie), HttpStatus.ACCEPTED);
	}
	
	
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Boolean> deleteMovie(@PathVariable long id) {
		return (this.service.delete(id)) ? new ResponseEntity<Boolean>(HttpStatus.NO_CONTENT) :
			new ResponseEntity<Boolean>(HttpStatus.NOT_FOUND);
	}
	
}