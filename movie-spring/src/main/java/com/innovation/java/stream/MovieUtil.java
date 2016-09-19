package com.innovation.java.stream;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;

@Service(value = "movieUtil")
public class MovieUtil {
	public static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy/MM/dd");

	public Stream<Movie> parseFile(final String filePath) {

		try {
			return Files.lines(Paths.get(ClassLoader.getSystemResource(filePath).toURI())).skip(1).map(line -> line.split(","))
					.map(Movie::new);
		} catch (final IOException | URISyntaxException e) {
			throw new MovieException(e);
		}

	}
}
