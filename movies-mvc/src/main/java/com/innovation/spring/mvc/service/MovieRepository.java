package com.innovation.spring.mvc.service;

import java.util.List;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.innovation.spring.mvc.movies.Movie;
import com.innovation.spring.mvc.movies.MovieUtil;

@Service(value = "movieRepo")
public class MovieRepository {

	@Autowired
	@Qualifier("movieUtil")
	MovieUtil movieUtil;

	@Value("movies.csv")
	private String filePath;

	private List<Movie> movieList;

	@PostConstruct
	public void setUp() {
		this.movieList = movieUtil.parseFile(filePath);
	}

	public List<Movie> getMovieList() {
		return this.movieList;
	}

}
