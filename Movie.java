/**
 * 
 */
package com.orion.orionlauncher;

/**
 * @author sachithanandham palaniswamy
 *
 */
public class Movie {
	String title;

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the inland_release_time
	 */
	public String getInland_release_time() {
		return inland_release_time;
	}

	/**
	 * @param inland_release_time
	 *            the inland_release_time to set
	 */
	public void setInland_release_time(String inland_release_time) {
		this.inland_release_time = inland_release_time;
	}

	/**
	 * @return the production_house
	 */
	public String getProduction_house() {
		return production_house;
	}

	/**
	 * @param production_house
	 *            the production_house to set
	 */
	public void setProduction_house(String production_house) {
		this.production_house = production_house;
	}

	/**
	 * @return the language
	 */
	public int getLanguage() {
		return Language;
	}

	/**
	 * @param language
	 *            the language to set
	 */
	public void setLanguage(int language) {
		Language = language;
	}

	/**
	 * @return the length
	 */
	public String getLength() {
		return Length;
	}

	/**
	 * @param length
	 *            the length to set
	 */
	public void setLength(String length) {
		Length = length;
	}

	/**
	 * @return the starCast
	 */
	public String getStarCast() {
		return StarCast;
	}

	/**
	 * @param starCast
	 *            the starCast to set
	 */
	public void setStarCast(String starCast) {
		StarCast = starCast;
	}

	/**
	 * @return the movie_id
	 */
	public int getMovie_id() {
		return movie_id;
	}

	/**
	 * @param movie_id
	 *            the movie_id to set
	 */
	public void setMovie_id(int movie_id) {
		this.movie_id = movie_id;
	}

	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}

	/**
	 * @param poster
	 *            the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}

	String inland_release_time;
	String production_house;
	int Language;
	String Length;
	String StarCast;
	int movie_id;
	String transaction_id;
	String transaction_date;
	
	/**
	 * @return the transaction_date
	 */
	public String getTransaction_date() {
		return transaction_date;
	}

	/**
	 * @param transaction_date the transaction_date to set
	 */
	public void setTransaction_date(String transaction_date) {
		this.transaction_date = transaction_date;
	}

	/**
	 * @return the transaction_id
	 */
	public String getTransaction_id() {
		return transaction_id;
	}

	/**
	 * @param transaction_id the transaction_id to set
	 */
	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	/**
	 * @return the amount
	 */
	public String getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(String amount) {
		this.amount = amount;
	}

	String amount;
	/**
	 * @return the video_url
	 */
	public String getVideo_url() {
		return video_url;
	}

	/**
	 * @param video_url the video_url to set
	 */
	public void setVideo_url(String video_url) {
		this.video_url = video_url;
	}

	/**
	 * @return the trailer
	 */
	public String getTrailer() {
		return trailer;
	}

	/**
	 * @param trailer the trailer to set
	 */
	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	/**
	 * @return the release_type
	 */
	public int getRelease_type() {
		return release_type;
	}

	/**
	 * @param release_type the release_type to set
	 */
	public void setRelease_type(int release_type) {
		this.release_type = release_type;
	}

	/**
	 * @return the pricing_id
	 */
	public int getPricing_id() {
		return pricing_id;
	}

	/**
	 * @param pricing_id the pricing_id to set
	 */
	public void setPricing_id(int pricing_id) {
		this.pricing_id = pricing_id;
	}

	/**
	 * @return the movie_price
	 */
	public String getMovie_price() {
		return movie_price;
	}

	/**
	 * @param movie_price the movie_price to set
	 */
	public void setMovie_price(String movie_price) {
		this.movie_price = movie_price;
	}

	String poster;
	String video_url;
	String trailer;
	int release_type;
	int pricing_id;
	String movie_price;
}
