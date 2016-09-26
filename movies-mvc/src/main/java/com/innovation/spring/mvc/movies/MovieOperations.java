package com.innovation.spring.mvc.movies;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import com.innovation.spring.mvc.service.MovieRepository;

@Component(value = MovieAPI.BEAN_ID)
public class MovieOperations implements MovieAPI {

	@Autowired
	@Qualifier("movieRepo")
	private MovieRepository movieRepository;

	@Override
	public List<String> getMovieNamesByReleaseDate(final LocalDate releaseDate) {
		return movieRepository.getMovieList().stream()
				.filter(movie -> movie.getReleaseDate().compareTo(releaseDate) == 0)
				.map(Movie::getTitle).collect(Collectors.toList());
	}

	@Override
	public List<String> getMovieNamesByGenre(final String genre) {
		return movieRepository.getMovieList().stream()
				.filter(movie -> movie.getGenre().equalsIgnoreCase(genre)).map(Movie::getTitle)
				.collect(Collectors.toList());
	}

	@Override
	public Double getCollectionOfActor(final String actor) {
		return movieRepository
				.getMovieList()
				.stream()
				.filter(movie -> movie.getLeadActor().equalsIgnoreCase(actor))
				.collect(
						Collectors.groupingBy(Movie::getLeadActor,
								Collectors.summingDouble(Movie::getCollection))).get(actor);
	}

	@Override
	public Double getBoxOfficeCollection() {
		return movieRepository.getMovieList().stream().map(Movie::getCollection)
				.mapToDouble(Double::doubleValue).sum();
	}

	@Override
	public List<Movie> getMovieList() {
		return movieRepository.getMovieList();
	}

	@Override
	public Movie getMovieByTitle(final String title) {
		return movieRepository.getMovieList().stream()
				.filter(movie -> movie.getTitle().equalsIgnoreCase(title)).findAny().get();
	}

}
