package com.innovation.spring.mvc.movies;

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
public class UtilTest {

	@Autowired
	@Qualifier("movieUtil")
	private MovieUtil movieUtil;

	@Test
	public void testParseFile() {
		final List<Movie> movieList = movieUtil.parseFile("movies.csv");
		System.out.println(movieList);
		Assert.assertEquals(movieList.size(), 4);
	}

}
