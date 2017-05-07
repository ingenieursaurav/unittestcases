/**
 * 
 */
package com.orion.orionlauncher;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sauravsharma
 *
 */
public class ServiceController extends CommunicationController {

	public ArrayList<Service> GetService(Subscriber subscriber) {
		ArrayList<Service> list = new ArrayList<Service>();
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("token", subscriber.getToken());
			CommunicationController communicationcontroller = new CommunicationController();
			String response = communicationcontroller.Communicate(parameters, "get-app-menu", "GET");
			JSONObject result = new JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				JSONArray services = result.getJSONArray("data");
				for (Object obj : services) {
					JSONObject serviceobj = (JSONObject) obj;
					Service service = new Service();
					service.setId(Integer.parseInt(serviceobj.getString("id")));
					service.setName(serviceobj.getString("name"));
					service.setDescription(serviceobj.getString("description"));
					service.setImage(serviceobj.getString("image"));
					list.add(service);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return list;
	}

	public ArrayList<Genre> GetGenres(Subscriber subscriber) {
		ArrayList<Genre> genres = new ArrayList<Genre>();
		try {
			// get-app-categories
			Map<String, String> parameters = new HashMap<String, String>();
			parameters.put("token", subscriber.getToken());
			CommunicationController communicationcontroller = new CommunicationController();
			String response = communicationcontroller.Communicate(parameters, "get-app-categories", "GET");
			JSONObject result = new JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				JSONArray genresobj = result.getJSONArray("data");
				for (Object obj : genresobj) {
					JSONObject genreobj = (JSONObject) obj;
					Genre genre = new Genre();
					genre.setId(genreobj.getInt("id"));
					genre.setName(genreobj.getString("name"));
					genre.setDescription(genreobj.getString("description"));
					genre.setImage(genreobj.getString("image"));
					genres.add(genre);
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return genres;
	}

	public ArrayList<Language> GetSubscriberLanguages(Subscriber subscriber) {
		ArrayList<Language> languages = new ArrayList<Language>();
		try {
			if (subscriber != null && subscriber.getToken() != null) {
				Map<String, String> parameters = new HashMap<String, String>();
				parameters.put("token", subscriber.getToken());
				CommunicationController communicationcontroller = new CommunicationController();
				String response = communicationcontroller.Communicate(parameters, "get-subscriber-languages", "GET");
				JSONObject result = new JSONObject(response);
				if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
					JSONArray lngsobj = result.getJSONArray("data");
					for (Object obj : lngsobj) {
						// iterate over movies object
						JSONObject lngobj = (JSONObject) obj;
						Language language = new Language();
						language.setId(lngobj.getInt("id"));
						language.setName(lngobj.getString("name"));
						language.setImage(lngobj.getString("image_link"));
						languages.add(language);
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return languages;
	}

	/**
	 * get available movies for given subscriber for selected language
	 *
	 * @param subscriber
	 * @return
	 */
	public ArrayList<Movie> getMovies(Subscriber subscriber) {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		try {
			if (subscriber != null && subscriber.getToken() != null) {
				Map<String, String> parameters = new HashMap<String, String>();
				parameters.put("token", subscriber.getToken());
				// converting to string
				parameters.put("category_id", subscriber.getGenre().getId() + "");
				// converting to string
				parameters.put("language_id", subscriber.getLanguage().getId() + "");
				CommunicationController communicationcontroller = new CommunicationController();
				String response = communicationcontroller.Communicate(parameters, "get-movies-list", "GET");
				JSONObject result = new JSONObject(response);
				if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
					JSONArray moviesobj = result.getJSONArray("data");
					for (Object obj : moviesobj) {
						JSONObject movieobj = (JSONObject) obj;
						Movie movie = new Movie();
						movie.setMovie_id(movieobj.getInt("movie_id"));
						movie.setLanguage(movieobj.getInt("language"));
						movie.setInland_release_time(movieobj.getString("inland_release_time"));
						movie.setTitle(movieobj.getString("title"));
						movie.setLength(movieobj.getString("length"));
						movie.setPoster(movieobj.getString("poster"));
						movie.setProduction_house(movieobj.getString("production_house"));
						movie.setStarCast(movieobj.getString("starcast"));
						movies.add(movie);
					}
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return movies;
	}

	/**
	 * get single movie information
	 *
	 * @param subscriber
	 * @return Movie
	 */
	public Movie getSingleMovie(Subscriber subscriber) {
		Movie singlemovie = new Movie();
		try {
			// get-single-movie
			if (subscriber != null && subscriber.getToken() != null) {
				Map<String, String> parameters = new HashMap<String, String>();
				parameters.put("token", subscriber.getToken());
				// string conversion
				parameters.put("movie_id", subscriber.getMovie().getMovie_id() + "");
				CommunicationController communicationcontroller = new CommunicationController();
				String response = communicationcontroller.Communicate(parameters, "get-single-movie", "GET");
				JSONObject result = new JSONObject(response);
				if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
					JSONArray moviesobj = result.getJSONArray("data");
					for (Object obj : moviesobj) {
						JSONObject movieobj = (JSONObject) obj;
						Movie movie = subscriber.getMovie();
						movie.setMovie_price(movieobj.getString("movie_price"));
						movie.setPoster(movieobj.getString("poster"));
						movie.setPricing_id(movieobj.getInt("pricing_id"));
						movie.setRelease_type(movieobj.getInt("release_type"));
						movie.setTrailer(movieobj.getString("trailer"));
						movie.setVideo_url(movieobj.getString("video_url"));
						singlemovie = movie;
					}
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return singlemovie;
	}

	public void getAvailableLanguages(Subscriber subscriber) {

		try {
			if (subscriber != null && subscriber.getToken() != null) {
				Map<String, String> parameters = new HashMap<String, String>();
				parameters.put("token", subscriber.getToken());
				CommunicationController communicationcontroller = new CommunicationController();
				String response = communicationcontroller.Communicate(parameters, "getSelectedMovieLanguages", "GET");
				JSONObject result = new JSONObject(response);
				if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
					JSONArray languagesobj = result.getJSONArray("data");
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Get list of countries our service available
	 */
	public ArrayList<Country> getAvailableCountries() {
		ArrayList<Country> countries = new ArrayList<Country>();
		try {
			// http://oriondigi.net/getselectedcountry
			Map<String, String> parameters = new HashMap<String, String>();
			CommunicationController communicationcontroller = new CommunicationController();
			String response = communicationcontroller.Communicate(parameters, "getselectedcountry", "GET");
			JSONObject result = new JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				JSONArray countriesobj = result.getJSONArray("data");
				for (Object obj : countriesobj) {
					JSONObject countryobj = (JSONObject) obj;
					Country country = new Country();
					country.setId(countryobj.getInt("id"));
					country.setName(countryobj.getString("name"));
					countries.add(country);
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return countries;
	}

	public void getHistory(Subscriber subscriber) {
		ArrayList<Movie> watched=new ArrayList<Movie>();
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			CommunicationController communicationcontroller = new CommunicationController();
			parameters.put("token", subscriber.getToken());
			String response = communicationcontroller.Communicate(parameters, "get_history", "GET");
			JSONObject result = new JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				JSONArray historiesobject = result.getJSONArray("data");
				if(subscriber.getHistory()==null){
					subscriber.setHistory(watched);
				}else{
					watched=subscriber.getHistory();
				}
				for(Object obj:historiesobject){
					JSONObject historyobj =(JSONObject)obj;
					Movie movie=new Movie();
					movie.setTitle("movie_name");
					movie.setAmount(historyobj.getString("amount"));
					movie.setTransaction_id(historyobj.getString("transaction_id"));
					movie.setPoster(historyobj.getString("poster"));
					movie.setTransaction_date(historyobj.getString("created_date"));
					watched.add(movie);
				}
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * gethelpinfo
	 *
	 * @param subscriber
	 * @return
	 */
	public String getHelp(Subscriber subscriber) {
		String help = "";
		try {
			Map<String, String> parameters = new HashMap<String, String>();
			CommunicationController communicationcontroller = new CommunicationController();
			parameters.put("token", subscriber.getToken());
			String response = communicationcontroller.Communicate(parameters, "gethelpinfo", "GET");
			JSONObject result = new JSONObject(response);
			if (result.getString("message").trim().compareTo(SUCCESS) == 0) {
				JSONArray helpsobject = result.getJSONArray("data");
				for (Object obj : helpsobject) {
					JSONObject helpobj = (JSONObject) obj;
					help = helpobj.getString("description");
				}
			}

		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return help;
	}
	//TODO:lang_change,distributor_details,download_via_mail
}
