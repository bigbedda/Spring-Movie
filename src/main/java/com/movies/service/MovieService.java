package com.movies.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.movies.entity.Movie;
import com.movies.repo.MovieRepo;



@Service
public class MovieService implements ServiceMethods<Movie> {
	
	
	private MovieRepo repo;
	
	
	
	
	public MovieService(MovieRepo repo) {
		this.repo=repo;		
	}
		

	@Override
	public Movie create(Movie movie) {
		return this.repo.save(movie);
	}

	@Override
	public List<Movie> readAll() {
		return this.repo.findAll();
	}

	@Override
	public Movie readById(long id) {
		Optional<Movie> getMovie = this.repo.findById(id);
		if(getMovie.isPresent()) {
			return getMovie.get();
		}
		return null;
	}

	
	@Override
	public Movie update(long id, Movie movie) {
		Optional<Movie> existingMovie = this.repo.findById(id);
		if(existingMovie.isPresent()) {
			Movie exists = existingMovie.get();
			exists.setAge(movie.getAge());
			exists.setrating(movie.getrating());
			exists.setdirector(movie.getdirector());
			exists.setName(movie.getName());
			
			return this.repo.saveAndFlush(exists);
		}
		return null;
	}

	
	@Override
	public boolean delete(long id) {
		this.repo.deleteById(id);
		return !this.repo.existsById(id);
	}

	
	
}
