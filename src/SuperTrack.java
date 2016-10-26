import java.util.Comparator;
import java.util.Date;

/**
 * <p>This is an abstract class which describes the most basic details
 * of a Track. Since all version of track have the same common properties
 * it was decided that having a super class for a track is appropriate.
 * 
 * @author Alexander Chetcuti
 *
 */
public abstract class SuperTrack {
	
	/**
	 * Private field, title of the track
	 */
	private String title;
	
	/**
	 * Private field, artist of the track
	 */
	private Artist artist;
	
	/**
	 * Private field, released date of the track
	 */
	private Date released;
	
	/**
	 * Private field, length in seconds of the track
	 */
	private int length;
	
	/**
	 * Private field, rating from 0 to 5 of the track
	 */
	private int rating;
	
	/**
	 * Private field, size in KiloBytes of the track
	 */
	private double size;
	
	/**
	 * Private field, guest artist of the track
	 */
	private Artist guest;
	
	/**
	 * Private field, count of plays of the track
	 */
	private int countPlayed;
	
	/**
	 * Private field, album of the track
	 */
	private Album album;

	
	/**
	 * Private field, band identification of the track
	 */
	private int bandID;
	
	/**
	 * Private field, musician identification of the track
	 */
	private int musicianID;
	
	/**
	 * Private field, album identification of the track
	 */
	private int albumID;
	
	/**
	 * Private field, guest band identification of the track
	 */
	private int guestBandID;
	
	/**
	 * Private field, guest musician identification of the track
	 */
	private int guestMusicianID;
	
	/**
	 * <p>Re-arranges the list of tracks into an order list by rating. Thus is done by comparing 
	 * the rating of tracks. The method compare will return a negative if the comparing object
	 * is smaller, a zero if they are the same or a positive if the value is greater.
	 * 
	 * <p>The method is called on an object of Type <i>SuperTrack</i> or from a class that inherits
	 * this class.
	 */
	public static Comparator<SuperTrack> COMPARE_RATING = new Comparator<SuperTrack>() {
        public int compare(SuperTrack t1, SuperTrack t2) {
            return new Integer(t1.rating).compareTo(t2.rating);
        }
    };
	
    /**
     * This method increases the count play of the object that it is called upon.
     */
	public void play() {
		this.countPlayed++;
	}

	/**
	 * Method will return the title of the track object.
	 * 
	 * @return The tile of the track.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method will set the title of the track object.
	 * 
	 * @param title The title to be set for the track.
	 */	
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method will return the artist of the track object.
	 * 
	 * @return The artist of the track.
	 */
	public Artist getArtist() {
		return artist;
	}

	/**
	 * Method will set the artist of the track object.
	 * 
	 * @param artist The artist to be set for the track.
	 */	
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	/**
	 * Method will return the date released of the track object.
	 * 
	 * @return The date released of the track.
	 */
	public Date getReleased() {
		return released;
	}

	/**
	 * Method will set the date released of the track object.
	 * 
	 * @param released The date released to be set for the track.
	 */	
	public void setReleased(Date released) {
		this.released = released;
	}

	/**
	 * Method will return the length in seconds of the track object.
	 * 
	 * @return The length of the track.
	 */
	public int getLength() {
		return length;
	}

	/**
	 * Method will set the length in seconds of the track object.
	 * 
	 * @param length The length in seconds to be set for the track.
	 */	
	public void setLength(int length) {
		this.length = length;
	}

	/**
	 * Method will return the rating of the track object.
	 * 
	 * @return The rating of the track.
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * Method will set the rating of the track object.
	 * 
	 * @param rating The rating to be set for the track.
	 */	
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * Method will return the size of the track object.
	 * 
	 * @return The size of the track.
	 */
	public double getSize() {
		return this.size;
	}

	/**
	 * Method will set the size in kilobytes of the track object.
	 * 
	 * @param size The size in kilobytes to be set for the track.
	 */	
	public void setSize(double size) {
		this.size = size;
	}

	/**
	 * Method will return the artist guest of the track object.
	 * 
	 * @return The artist guest of the track.
	 */
	public Artist getGuest() {
		return this.guest;
	}

	/**
	 * Method will set the guest artist of the track object.
	 * 
	 * @param guest The guest artist to be set for the track.
	 */	
	public void setGuest(Artist guest) {
		this.guest = guest;
	}

	/**
	 * Method will return the count played of the track object.
	 * 
	 * @return The count played of the track.
	 */
	public int getCountPlayed() {
		return countPlayed;
	}

	/**
	 * Method will set the count played of the track object.
	 * 
	 * @param countPlayed The count played to be set for the track.
	 */	
	public void setCountPlayed(int countPlayed) {
		this.countPlayed = countPlayed;
	}
	
	/**
	 * Method will return the band id of the track object.
	 * 
	 * @return The band id of the track.
	 */
	public int getBandID() {
		return bandID;
	}

	/**
	 * Method will set the band id of the track object.
	 * 
	 * @param bandID The band id to be set for the track.
	 */	
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * Method will return the musician id of the track object.
	 * 
	 * @return The musician id of the track.
	 */
	public int getMusicianID() {
		return musicianID;
	}

	/**
	 * Method will set the musician id of the track object.
	 * 
	 * @param musicianID The musician id to be set for the track.
	 */	
	public void setMusicianID(int musicianID) {
		this.musicianID = musicianID;
	}

	/**
	 * Method will return the album id of the track object.
	 * 
	 * @return The album id of the track.
	 */
	public int getAlbumID() {
		return albumID;
	}

	/**
	 * Method will set the album id of the track object.
	 * 
	 * @param albumID The album id to be set for the track.
	 */	
	public void setAlbumID(int albumID) {
		this.albumID = albumID;
	}

	/**
	 * Method will return the guest band id of the track object.
	 * 
	 * @return The guest band id of the track.
	 */
	public int getGuestBandID() {
		return guestBandID;
	}

	/**
	 * Method will set the guest band id of the track object.
	 * 
	 * @param guestBandID The guest band id to be set for the track.
	 */	
	public void setGuestBandID(int guestBandID) {
		this.guestBandID = guestBandID;
	}

	/**
	 * Method will return the guest musician id of the track object.
	 * 
	 * @return The guest musician id of the track.
	 */
	public int getGuestMusicianID() {
		return guestMusicianID;
	}

	/**
	 * Method will set the guest musician id of the track object.
	 * 
	 * @param guestMusicianID The guest musician id to be set for the track.
	 */	
	public void setGuestMusicianID(int guestMusicianID) {
		this.guestMusicianID = guestMusicianID;
	}

	/**
	 * Method will return the album of the track object.
	 * 
	 * @return The album of the track.
	 */
	public Album getAlbum() {
		return album;
	}

	/**
	 * Method will set the album of the track object.
	 * 
	 * @param album The album to be set for the track.
	 */	
	public void setAlbum(Album album) {
		this.album = album;
	}

}
