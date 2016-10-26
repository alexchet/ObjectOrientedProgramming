

import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * <p>This class extends the class <i>SuperTrack</i>. By doing this this class
 * can make use of all the properties inherited and can be set in the constructor
 * of this class.
 * 
 * This class is still a basic track so it does not have any other additional 
 * properties. However the method <i>toString</i> is being overridden to 
 * change it's functionality and output only what it needs to output.
 * 
 * @author Alexander Chetcuti
 *
 */
public class Track extends SuperTrack {

	/**
	 * <p>Empty constructor. This is required for the Jackson JSON mapping to work.
	 */
	public Track() { }
	
	/**
	 * <p>This constructor initialises an object of type track, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param title The title of the track.
	 * @param artist The artist of the track.
	 * @param released The date released of the track
	 * @param length The length in seconds of the track.
	 * @param rating The rating from 0 to 5 of the track.
	 * @param size The size in KiloBytes of the track.
	 * @param guest The guest artist of the track.
	 * @param countPlayed The count played for this track.
	 * @param album The album of this track.
	 */
	public Track(String title, Artist artist, Date released, int length, int rating,
			double size, Artist guest, int countPlayed, Album album) {
		setTitle(title);
		setArtist(artist);
		setReleased(released);
		setLength(length);
		setRating(rating);
		setSize(size);
		setGuest(guest);
		setCountPlayed(countPlayed);
		setAlbum(album);
	}
	
	/**
	 * <p>This method overrides the method <i>toString</i> and outputs only the necessary 
	 * information. First we create a simple date format for the date to be converted to a 
	 * proper string. Then a calculation for the amount of minuted and seconds in done on 
	 * the property length. The method then return a concatenated string of the most important
	 * information found in this class.
	 */
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int minutes = super.getLength() / 60;
		int seconds = super.getLength() - minutes * 60;
		
		return "Title: " + super.getTitle() + ", Artist: " + super.getArtist().getName() +
		(super.getAlbum() != null ? ", Album: " + super.getAlbum().getTitle() : "") + ", Released: " +  
		formatter.format(super.getReleased()) + ", Duration: " + minutes + ":" + seconds + 
		", Times Played: " + super.getCountPlayed() + ", Rating: " + super.getRating();
	}
}
