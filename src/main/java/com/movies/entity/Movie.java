package com.movies.entity;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
public class Movie {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	@Min(2)
	@Max(20)
	private int age;
	
	
	@Column(unique=true, nullable = false)
	private String name;
	
	@Column
	private String director;
	
	@Column
	private Double rating;
	
	
	public Movie() {}
	
	
	public Movie(@Min(2) @Max(20) int age, String name, String director, Double rating) {
		super();
		this.age = age;
		this.name = name;
		this.director = director;
		this.rating = rating;
	}
		
		
	public Movie(long id, @Min(2) @Max(20) int age, String name, String director, Double rating) {
		super();
		this.id = id;
		this.age = age;
		this.name = name;
		this.director = director;
		this.rating = rating;		
	}


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getdirector() {
		return director;
	}

	public void setdirector(String director) {
		this.director = director;
	}

	public Double getrating() {
		return rating;
	}

	public void setrating(Double rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", age=" + age + ", name=" + name + ", director=" + director + ", rating=" + rating
				+ "]";
		}


	@Override
	public int hashCode() {
		return Objects.hash(age, director, name, rating);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Movie other = (Movie) obj;
		return age == other.age && Objects.equals(director, other.director) && Objects.equals(name, other.name)
				&& Objects.equals(rating, other.rating);
	}
	
	
		
	
	
		
}