import java.util.ArrayList;
import java.util.List;

import CustomExceptions.TracksNotFoundException;

/**
 * <p>This class extends the class <i>SuperAlbum</i>. By doing this this class
 * can make use of all the properties inherited and can be set in the constructor
 * of this class.
 * 
 * <p>The method <i>toString</i> is being overridden to 
 * change it's functionality and output only what it needs to output.
 * 
 * @author Alexander Chetcuti
 *
 */
public class Album extends SuperAlbum {
	
	/**
	 * Private field, ID of the album
	 */
	private int id;
	
	/**
	 * Private field, artist of the album
	 */
	private Artist artist;

	/**
	 * Private field, type of the album
	 */
	private String type;

	/**
	 * Private field, tracks of the album
	 */
	private List<Track> tracks;

	/**
	 * Private field, band identification of the album
	 */
	private int bandID;

	/**
	 * Private field, musician identification of the album
	 */
	private int musicianID;
	
	/**
	 * <p>Empty constructor. This is required for the Jackson JSON mapping to work.
	 */
	public Album() { }

	/**
	 * <p>This constructor initialises an object of type album, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param artist The artist of the album.
	 * @param title The title of the album.
	 * @param type The type of the album.
	 * @param tracks the list of tracks of the album.
	 */
	public Album(Artist artist, String title, String type, List<Track> tracks) {
		this.artist = artist;
		this.setTitle(title);
		this.type = type;
		this.tracks = tracks;
	}
	
	/**
	 * This method adds a track to the list of tracks of the album. The method also
	 * ensures that the list of tracks has been initialised.
	 * 
	 * @param track The track to be added to the album.
	 * 
	 * @return The track that was just add, with the new album pointer.
	 */
	public Track addTrack(Track track) {
		if (this.getTracks() == null) this.setTracks(new ArrayList<Track>());
		this.getTracks().add(track);
		
		//set pointer for album in track object
		track.setAlbum(this);
		
		return track;
	}

	/**
	 * Method will return the ID of the album object.
	 * 
	 * @return ID The ID in the album.
	 */
	public int getID() {
		return this.id;
	}

	/**
	 * Method will set the ID of the album object.
	 * 
	 * @param id The ID to be set for the album.
	 */
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Method will return the artist of the album object.
	 * 
	 * @return The artist in the album.
	 */
	public Artist getArtist() {
		return this.artist;
	}

	/**
	 * Method will set the artist of the album object.
	 * 
	 * @param artist The artist to be set for the album.
	 */
	public void setArtist(Artist artist) {
		this.artist = artist;
	}

	/**
	 * Method will return the type of the album object.
	 * 
	 * @return The type in the album.
	 */
	public String getType() {
		return this.type;
	}

	/**
	 * Method will set the type of the album object.
	 * 
	 * @param type The type to be set for the album.
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Method will return the band ID of the album object.
	 * 
	 * @return The band ID in the album.
	 */
	public int getBandID() {
		return this.bandID;
	}

	/**
	 * Method will set the band ID of the album object.
	 * 
	 * @param bandID The band ID to be set for the album.
	 */
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * Method will return the musician ID of the album object.
	 * 
	 * @return The musician ID in the album.
	 */
	public int getMusicianID() {
		return this.musicianID;
	}

	/**
	 * Method will set the musician ID of the album object.
	 * 
	 * @param musicianID The musicianID to be set for the album.
	 */
	public void setMusicianID(int musicianID) {
		this.musicianID = musicianID;
	}

	/**
	 * Method will return the tracks of the album object.
	 * 
	 * @return The list of the tracks in the album.
	 */
	public List<Track> getTracks() {
		return this.tracks;
	}

	/**
	 * Method will set the list of the tracks for the album object.
	 * 
	 * @param tracks The tracks to be set for the album.
	 */	
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}

	/**
	 * <p>This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the album.
	 * 
	 * <p>The method calculates the total running time, the average rating of the album and
	 * the overall size of the album.
	 * 
	 * <p>The running time is calculated by looping all the tracks and adding the time of
	 * every integer. Then a calculation is done to extract minuted and seconds from the 
	 * final seconds result.
	 * 
	 * <p>The average rating is done by adding all the averages of the tracks and dividing
	 * by the size of the array of tracks.
	 * 
	 * <p>The total size is done by looping all the tracks and adding all of their sizes in
	 * a total count. Then a simple division is done to output the data in mega bytes from
	 * kilo bytes.
	 * 
	 * @return The final concatenated string.
	 */
	@Override
	public String toString() {
		try {
			if (this.getTracks() == null) {
				throw new TracksNotFoundException();
			}
			
			int iTotalRunningTime = 0, iTotalRating = 0;
			double iTotalSize = 0;
			for (Track t : this.getTracks()) {
				iTotalRunningTime += t.getLength();
				iTotalSize += t.getSize();
				iTotalRating += t.getRating();
			}
	
			int minutes = iTotalRunningTime / 60;
			int seconds = iTotalRunningTime - minutes * 60;
	
			return "Album: " + this.getTitle() + ", Artist: " + this.getArtist().toString() + 
			", Total running time: " + minutes + ":" + seconds + ", Size: " + (iTotalSize / 1024) + "MB" +
			", Average Rating: " + ((double)iTotalRating / (double)this.getTracks().size());
		} catch (TracksNotFoundException ex) {
			System.out.println(ex.getMessage());
			return "";
		} catch(NullPointerException ex) {
			System.out.println("There seems to be some kind odf problem with the data used");
			ex.printStackTrace();
			return "";
		}
	}
}
