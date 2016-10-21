package Structs;

import java.util.Comparator;
import java.util.Date;
import java.util.List;

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
	private List<Integer> albumIDs;
	private int guestBandID;
	private int guestMusicianID;
	
	public Track () { }
	
	public Track(String title, Artist artist, Date released, int length, int rating,
			String path, double size, Artist guest, int countPlayed, int bandID,
			int musicianID, List<Integer> albumIDs, int guestBandID, int guestMusicianID) {
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
		this.albumIDs = albumIDs;
		this.guestBandID = guestBandID;
		this.guestMusicianID = guestMusicianID;
	}
	
	public static Comparator<Track> COMPARE_RATING = new Comparator<Track>() {
        public int compare(Track t1, Track t2) {
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

	/**
	 * @return the albumIDs
	 */
	public List<Integer> getAlbumIDs() {
		return albumIDs;
	}

	/**
	 * @param albumIDs the albumIDs to set
	 */
	public void setAlbumIDs(List<Integer> albumIDs) {
		this.albumIDs = albumIDs;
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

}
