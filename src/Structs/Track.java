package Structs;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class Track {

	private String title;
	private Artist artist;
	private Date released;
	private int length;
	private int rating;
	private String path;
	private double size;
	private Artist guest;
	private int countPlayed;
	private int bandID;
	private int musicianID;
	
	public Track () { }
	
	public Track(String title, Artist artist, Date released, int length, int rating,
			String path, double size, Artist guest, int countPlayed, int bandID, int musicianID) {
		this.title = title;
		this.artist = artist;
		this.released = released;
		this.length = length;
		this.rating = rating;
		this.path = path;
		this.guest = guest;
		this.countPlayed = countPlayed;
		this.bandID = bandID;
		this.musicianID = musicianID;
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
	public Date getReleased() {
		return released;
	}

	/**
	 * @param released the released to set
	 */
	public void setReleased(Date released) {
		this.released = released;
	}

	/**
	 * @return the length
	 */
	public int getLength() {
		return length;
	}

	/**
	 * @param length the length to set
	 */
	public void setLength(int length) {
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
	public Artist getGuest() {
		return this.guest;
	}

	/**
	 * @param guests the guests to set
	 */
	public void setGuest(Artist guest) {
		this.guest = guest;
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

	public int getBandID() {
		return bandID;
	}

	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * @return the musicianID
	 */
	public int getMusicianID() {
		return musicianID;
	}

	/**
	 * @param musicianID the musicianID to set
	 */
	public void setMusicianID(int musicianID) {
		this.musicianID = musicianID;
	}

}
