package com.innovation.java.stream;

import java.time.LocalDate;
import java.util.List;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfigTest.class)
public class MovieAPITest {

	@Autowired
	@Qualifier("movieOperation")
	MovieAPI movieAPI;

	//
	// @Before
	// public void setUp() {
	// final AnnotationConfigApplicationContext ctx = new
	// AnnotationConfigApplicationContext();
	// ctx.register(SpringConfigTest.class);
	// ctx.refresh();
	// movieAPI = ctx.getBean("movieOperation", MovieAPI.class);
	// }

	@Test
	public void testGetMovieNamesByReleaseDate() {
		final LocalDate date = LocalDate.of(2009, 12, 25);
		final List<String> movies = movieAPI.getMovieNamesByReleaseDate(date);
		System.out.println(movies);
		Assert.assertEquals(1, movies.size());

	}

	@Test
	public void testGetMovieNamesByGenre() {
		final List<String> movies = movieAPI.getMovieNamesByGenre("Action");
		System.out.println(movies);
		Assert.assertEquals(1, movies.size());
	}

	@Test
	public void testGetCollectionOfActor() {
		final Double collection = movieAPI.getCollectionOfActor("Salman Khan");
		System.out.println(collection);
		Assert.assertEquals(584.0, collection);
	}

	@Test
	public void testGetBoxOfficeCollection() {
		final Double collection = movieAPI.getBoxOfficeCollection();
		System.out.println(collection);
		Assert.assertEquals(947.5, collection);
	}

}
