package com.movies.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.movies.entity.Movie;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Long> {
	
	

}
