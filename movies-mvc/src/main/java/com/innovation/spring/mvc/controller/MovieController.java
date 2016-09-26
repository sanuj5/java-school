package com.innovation.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.innovation.spring.mvc.movies.MovieAPI;
import com.innovation.spring.mvc.service.MovieRepository;

@Controller
@RequestMapping("/")
public class MovieController {

	@Autowired
	@Qualifier("movieRepo")
	MovieRepository movieRepo;

	@Autowired
	@Qualifier("movieOperation")
	MovieAPI movieAPI;

	@RequestMapping(method = RequestMethod.GET)
	public String getMoviesList(final Model map) {
		map.addAttribute("moviesList", movieAPI.getMovieList());
		return "movies";
	}

	@RequestMapping(method = RequestMethod.GET, value = "movie/{title:.+}")
	public String getMoviesByTitle(@PathVariable final String title, final Model map) {
		map.addAttribute("movie", movieAPI.getMovieByTitle(title));
		return "singleMovie";
	}

}
