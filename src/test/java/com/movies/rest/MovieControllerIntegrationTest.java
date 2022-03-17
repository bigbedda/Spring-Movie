package com.movies.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.movies.entity.Movie;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc 
@ActiveProfiles("test") 
@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:Movies-schema.sql",
		"classpath:Movie-data.sql"})
public class MovieControllerIntegrationTest {

	@Autowired 
	private MockMvc mvc; 
	
	@Autowired
	private ObjectMapper mapper; 
	
	@Test
	public void test() {
		assertEquals(2,1+1);
	}
	
	
	@Test
	public void testCreate() throws Exception {
		
		Movie testMovie = new Movie(12, "Drake johnson", "War of the Worlds", 8.7);
		String testMovieAsJSON = this.mapper.writeValueAsString(testMovie);
		RequestBuilder req = post("/Movie/create").content(testMovieAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Movie testSavedMovie = new Movie(2, 12, "Drake johnson", "War of the Worlds", 8.7);
		String testSavedMovieAsJSON = this.mapper.writeValueAsString(testSavedMovie);
		
		ResultMatcher checkStatus = status().isCreated();
		
		ResultMatcher checkBody = content().json(testSavedMovieAsJSON);
		
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testCreate2() throws Exception {
		
		Movie testMovie = new Movie(18, "Arnold Rimmer", "Toon World", 6.6);
		String testMovieAsJSON = this.mapper.writeValueAsString(testMovie);
		RequestBuilder req = post("/Movie/create").content(testMovieAsJSON).contentType(MediaType.APPLICATION_JSON);
		
		Movie testSavedMovie = new Movie(2, 18, "Arnold Rimmer", "Toon World", 6.6);
		String testSavedMovieAsJSON = this.mapper.writeValueAsString(testSavedMovie);
		
		ResultMatcher checkStatus = status().isCreated();
		
		ResultMatcher checkBody = content().json(testSavedMovieAsJSON);
		
		
		this.mvc.perform(req).andExpect(checkStatus).andExpect(checkBody);
	}
	
	@Test
	public void testReadById() throws Exception {
		RequestBuilder req = get("/Movie/readById/1");
		
		ResultMatcher checkStatus = status().isOk();
		
		Movie savedMovie = new Movie(1, 15, "Jackie chan", "Rush Hour", 8.8);
		String savedMovieAsJSON = this.mapper.writeValueAsString(savedMovie);
		
		ResultMatcher checkBody = content().json(savedMovieAsJSON);
	}

}