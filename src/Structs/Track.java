package Structs;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;

public class Track {

	private String title;
	private Artist artist;
	private LocalDate released;
	private Duration length;
	private int rating;
	private String path;
	private double size;
	private List<Artist> guests;
	private int countPlayed;
	
	public Track(String title, Artist artist, LocalDate released, Duration length, int rating,
			String path, double size, List<Artist> guests, int countPlayed) {
		this.title = title;
		this.artist = artist;
		this.released = released;
		this.length = length;
		this.rating = rating;
		this.path = path;
		this.guests = guests;
		this.countPlayed = countPlayed;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the artist
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	/**
	 * @return the released
	 */
	public LocalDate getReleased() {
		return released;
	}

	/**
	 * @param released the released to set
	 */
	public void setReleased(LocalDate released) {
		this.released = released;
	}

	/**
	 * @return the length
	 */
	public Duration getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(Duration length) {
		this.length = length;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}

	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}

	/**
	 * @return the size
	 */
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * @return the guests
	 */
	public List<Artist> getGuests() {
		return guests;
	}

	/**
	 * @param guests the guests to set
	 */
	public void setGuests(List<Artist> guests) {
		this.guests = guests;
	}

	/**
	 * @return the countPlayed
	 */
	public int getCountPlayed() {
		return countPlayed;
	}

	/**
	 * @param countPlayed the countPlayed to set
	 */
	public void setCountPlayed(int countPlayed) {
		this.countPlayed = countPlayed;
	}

}
