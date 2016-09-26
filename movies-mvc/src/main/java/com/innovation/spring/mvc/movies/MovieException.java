package com.innovation.spring.mvc.movies;

public class MovieException extends RuntimeException {

	private static final long serialVersionUID = -775247713264300257L;

	public MovieException(final Throwable e) {
		super(e);
	}

}
