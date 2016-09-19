package com.innovation.java.stream;

import java.time.LocalDate;

public class Movie {
	private String title;
	private LocalDate releaseDate;
	private String leadActor;
	private String leadActress;
	private Double collection;
	private String genre;
	private String imdbId;

	public Movie(final String[] values) {
		this.title = values[0];
		this.releaseDate = LocalDate.parse(values[1], MovieUtil.DATE_FORMAT);
		this.leadActor = values[2];
		this.leadActress = values[3];
		this.collection = Double.valueOf(values[4]);
		this.genre = values[5];
		this.imdbId = values[6];
	}

	public final String getTitle() {
		return title;
	}

	public final void setTitle(final String title) {
		this.title = title;
	}

	public final LocalDate getReleaseDate() {
		return releaseDate;
	}

	public final void setReleaseDate(final LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

	public final String getLeadActor() {
		return leadActor;
	}

	public final void setLeadActor(final String leadActor) {
		this.leadActor = leadActor;
	}

	public final String getLeadActress() {
		return leadActress;
	}

	public final void setLeadActress(final String leadActress) {
		this.leadActress = leadActress;
	}

	public final Double getCollection() {
		return collection;
	}

	public final void setCollection(final Double collection) {
		this.collection = collection;
	}

	public final String getGenre() {
		return genre;
	}

	public final void setGenre(final String genre) {
		this.genre = genre;
	}

	public final String getImdbId() {
		return imdbId;
	}

	public final void setImdbId(final String imdbId) {
		this.imdbId = imdbId;
	}

	@Override
	public String toString() {
		return "Movie [title=" + title + ", releaseDate=" + releaseDate + ", leadActor=" + leadActor + ", leadActress=" + leadActress
				+ ", collection=" + collection + ", genre=" + genre + ", imdbId=" + imdbId + "]";
	}

}
