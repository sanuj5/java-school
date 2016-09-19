package com.innovation.java.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigTest {
	private final List<Movie> movieList = new ArrayList<Movie>();

	void init() {
		final String[] movie = { "3 Idiots", "2009/12/25", "Amir Khan", "Kareena Kapoor", "326", "Comedy", "tt1187043" };
		final Movie e = new Movie(movie);
		final String[] movie2 = { "Munna Bhai M.B.B.S.", "2003/12/19", "Sanjay Dutt", "Gracy Singh", "36", "Comedy", "tt0374887" };
		final Movie e2 = new Movie(movie2);
		final String[] movie3 = { "Sultan", "2016/07/06", "Salman Khan", "Anushka Sharma", "584", "Drama", "tt4832640" };
		final Movie e3 = new Movie(movie3);
		final String[] movie4 = { "Sholay", "1975/08/15", "Dharmendra", "Hema Malini", "1.5", "Action", "tt0073707" };
		final Movie e4 = new Movie(movie4);
		movieList.add(e);
		movieList.add(e2);
		movieList.add(e3);
		movieList.add(e4);
	}

	@Bean(name = "movieUtil")
	public MovieUtil getMovieUtil() {
		init();
		return new MovieUtil() {
			@Override
			public Stream<Movie> parseFile(final String filePath) {
				return movieList.stream();
			}
		};
	}

	@Bean(name = "filePath")
	public String getFilePath() {
		return "movies.csv";
	}

	@Bean(name = "movieOperation")
	public MovieAPI getMovieAPI() {
		return new MovieOperations();
	}
}
