package com.innovation.java.stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.innovation")
public class SpringConfig {

	@Bean(name = "filePath")
	public String getFilePath() {
		return "movies.csv";
	}

}
