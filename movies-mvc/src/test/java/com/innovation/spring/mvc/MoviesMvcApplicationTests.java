package com.innovation.spring.mvc;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class MoviesMvcApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void getTitleTest() throws Exception {
		final String bodyResponse = restTemplate.getForObject("/movie/3 Idiots", String.class);
		System.out.println(bodyResponse);
		assertThat(bodyResponse).contains("3 Idiots");
	}

	@Test
	public void getAllMoviesTest() throws Exception {
		final String bodyResponse = restTemplate.getForObject("/", String.class);
		System.out.println(bodyResponse);
		assertThat(bodyResponse).contains("Sholay");
	}

}
