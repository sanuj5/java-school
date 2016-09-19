package com.innovation.java.stream;

import java.time.LocalDate;
import java.util.List;

public interface MovieAPI {
	String BEAN_ID = "movieOperation";

	List<String> getMovieNamesByReleaseDate(final LocalDate releaseDate);

	List<String> getMovieNamesByGenre(final String Genre);

	Double getCollectionOfActor(final String Actor);

	Double getBoxOfficeCollection();
}
