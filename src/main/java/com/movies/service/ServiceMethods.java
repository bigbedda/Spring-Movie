package com.movies.service;

import java.util.List;

public interface ServiceMethods<T> {

	
	T create(T movie);
	
	
	
	List<T> readAll();
	
	
	T readById(long id);
	
	
	T update(long id, T movie);
	
	
	boolean delete(long id);

}

