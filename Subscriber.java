/**
 * 
 */
package com.orion.orionlauncher;

import java.util.ArrayList;

/**
 * @author SauravSharma
 *
 */
public class Subscriber {

	String Email;

	/**
	 * @return the email
	 */
	public String getEmail() {
		return Email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		Email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return Password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		Password = password;
	}

	/**
	 * @return the token
	 */
	public String getToken() {
		return Token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		Token = token;
	}

	String Password;
	String Token;
	String FirstName;
	String LastName;
	String Country;
	Language Language;
	Genre Genre;
	Movie Movie;
	ArrayList<Movie> History;

	/**
	 * @return the history
	 */
	public ArrayList<Movie> getHistory() {
		return History;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(ArrayList<Movie> history) {
		History = history;
	}

	/**
	 * @return the movie
	 */
	public Movie getMovie() {
		return Movie;
	}

	/**
	 * @param movie
	 *            the movie to set
	 */
	public void setMovie(Movie movie) {
		Movie = movie;
	}

	/**
	 * @return the genre
	 */
	public Genre getGenre() {
		return Genre;
	}

	/**
	 * @param genre
	 *            the genre to set
	 */
	public void setGenre(Genre genre) {
		Genre = genre;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return FirstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return LastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		LastName = lastName;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return Country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		Country = country;
	}

	/**
	 * @return the language
	 */
	public Language getLanguage() {
		return Language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(Language language) {
		Language = language;
	}

}
