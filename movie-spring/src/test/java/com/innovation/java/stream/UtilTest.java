package com.innovation.java.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class UtilTest {

	private MovieUtil movieUtil;

	@Before
	public void setUp() {
		final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(SpringConfig.class);
		ctx.register(SpringConfigTest.class);
		ctx.refresh();
		movieUtil = ctx.getBean("movieUtilTest", MovieUtil.class);
	}

	@Test
	public void testParseFile() {
		final Stream<Movie> movieList = movieUtil.parseFile("movies.csv");
		final List<Movie> movies = movieList.collect(Collectors.toList());
		System.out.println(movies);
		Assert.assertEquals(movies.size(), 1);
	}

}
