package com.movies.service;

import java.util.List;

public interface ServiceMethods<T> {

	//Create
	T create(T movie);
	
	
	// Read all
	List<T> readAll();
	
	//Read by ID
	T readById(long id);
	
	//Update
	T update(long id, T movie);
	
	//Delete
	boolean delete(long id);

}

