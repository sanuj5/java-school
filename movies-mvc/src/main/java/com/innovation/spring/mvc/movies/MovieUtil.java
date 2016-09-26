package com.innovation.spring.mvc.movies;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service(value = "movieUtil")
public class MovieUtil {
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public List<Movie> parseFile(final String filePath) {

		try {
			return Files.lines(Paths.get(ClassLoader.getSystemResource(filePath).toURI())).skip(1)
					.map(line -> line.split(",")).map(Movie::new).collect(Collectors.toList());
		} catch (final IOException | URISyntaxException e) {
			throw new MovieException(e);
		}

	}
}
