/**
 * 
 */
package com.orion.orionlauncher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * @author admin
 *
 */
public class AuthUnitTestCase {

	Subscriber subscriber = null;

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link }.
	 */
	// @Test
	public void testAuthenticate() {
		try {
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
		} catch (Exception exception) {

		}
	}

	// @Test
	public void testServiceController() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			servicecontroller.GetService(subscriber);

		} catch (Exception exception) {

		}
	}

	@Test
	public void testLanguageServiceController() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			ArrayList<Language> langauges = servicecontroller.GetSubscriberLanguages(subscriber);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void getHelp() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			String help = servicecontroller.getHelp(subscriber);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void getHistory() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			servicecontroller.getHistory(subscriber);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void testgetSelectedMovieLanguages() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			servicecontroller.getAvailableLanguages(subscriber);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Test
	public void testMoviesServiceController() {
		try {
			// authentication
			AuthenticationController controller = new AuthenticationController();
			subscriber = new Subscriber();
			subscriber.setEmail("sauravsharma@oriondigi.com");
			subscriber.setPassword("indian");
			controller.Authenticate(subscriber);
			// service controller
			ServiceController servicecontroller = new ServiceController();
			ArrayList<Language> langauges = servicecontroller.GetSubscriberLanguages(subscriber);
			ArrayList<Genre> genres = servicecontroller.GetGenres(subscriber);
			for (Genre genre : genres) {
				for (Language language : langauges) {
					subscriber.setGenre(genre);
					subscriber.setLanguage(language);
					ArrayList<Movie> movies = servicecontroller.getMovies(subscriber);
					for (Movie movie : movies) {
						subscriber.setMovie(movie);
						Movie singlemovie = servicecontroller.getSingleMovie(subscriber);
					}
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

}
