package com.innovation.java.stream;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = MovieAPI.BEAN_ID)
public class MovieOperations implements MovieAPI {

	@Autowired
	@Qualifier("filePath")
	private String filePath;

	@Autowired
	@Qualifier("movieUtil")
	private MovieUtil movieUtil;

	@Override
	public List<String> getMovieNamesByReleaseDate(final LocalDate releaseDate) {
		return movieUtil.parseFile(filePath)
				.filter(movie -> movie.getReleaseDate().compareTo(releaseDate) == 0)
				.map(Movie::getTitle).collect(Collectors.toList());
	}

	@Override
	public List<String> getMovieNamesByGenre(final String genre) {
		return movieUtil.parseFile(filePath)
				.filter(movie -> movie.getGenre().equalsIgnoreCase(genre)).map(Movie::getTitle)
				.collect(Collectors.toList());
	}

	@Override
	public Double getCollectionOfActor(final String actor) {
		return movieUtil
				.parseFile(filePath)
				.filter(movie -> movie.getLeadActor().equalsIgnoreCase(actor))
				.collect(
						Collectors.groupingBy(Movie::getLeadActor,
								Collectors.summingDouble(Movie::getCollection))).get(actor);
	}

	@Override
	public Double getBoxOfficeCollection() {
		return movieUtil.parseFile(filePath).map(Movie::getCollection)
				.mapToDouble(Double::doubleValue).sum();
	}

}
