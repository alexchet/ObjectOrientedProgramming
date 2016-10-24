package Structs;

import java.util.Comparator;
import java.util.Date;

public abstract class SuperTrack {
	private String title;
	private Artist artist;
	private Date released;
	private int length;
	private int rating;
	private double size;
	private Artist guest;
	private int countPlayed;
	private Album album;
	
	private int bandID;
	private int musicianID;
	private int albumID;
	private int guestBandID;
	private int guestMusicianID;
	
	public SuperTrack () { }
	
	public static Comparator<SuperTrack> COMPARE_RATING = new Comparator<SuperTrack>() {
        public int compare(SuperTrack t1, SuperTrack t2) {
            return new Integer(t1.rating).compareTo(t2.rating);
        }
    };
	
	public void play() {
		this.countPlayed++;
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

	/**
	 * @return the albumID
	 */
	public int getAlbumID() {
		return albumID;
	}

	/**
	 * @param albumIDs the albumID to set
	 */
	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	/**
	 * @return the guestBandID
	 */
	public int getGuestBandID() {
		return guestBandID;
	}

	/**
	 * @param guestBandID the guestBandID to set
	 */
	public void setGuestBandID(int guestBandID) {
		this.guestBandID = guestBandID;
	}

	/**
	 * @return the guestMusicianID
	 */
	public int getGuestMusicianID() {
		return guestMusicianID;
	}

	/**
	 * @param guestMusicianID the guestMusicianID to set
	 */
	public void setGuestMusicianID(int guestMusicianID) {
		this.guestMusicianID = guestMusicianID;
	}

	/**
	 * @return the album
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * @param album the album to set
	 */
	public void setAlbum(Album album) {
		this.album = album;
	}

}
