

import java.util.ArrayList;
import java.util.List;

/**
 * <p>This class represents a Music library. The library consists of a title
 * and an list of tracks.
 * 
 * <p>The method <i>toString</i> is being overridden to output a string in a 
 * format that is human readable.
 * 
 * @author Alexander Chetcuti
 *
 */
public class MusicLibrary {

	/**
	 * Private field, title of the music library
	 */
	private String title;
	
	/**
	 * Private field, list of tracks of the music library
	 */
	private List<Track> tracks;

	/**
	 * <p>This constructor initialises an object of type music library, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param title The title of the music library.
	 */
	public MusicLibrary(String title) {
		this.title = title;
		this.tracks = new ArrayList<Track>();
	}
	
	/**
	 * <p>This method adds a track to the list of tracks in the music library.
	 * 
	 * @param track The track that is going to be added to the music library.
	 */
	public void addTrack (Track track) {
		this.tracks.add(track);
	}
	
	/**
	 * <p>This method adds a list tracks to the list of tracks in the music library.
	 * 
	 * @param tracks The track list that is going to be added to the music library.
	 */
	public void addTracks (List<Track> tracks) {
		for (Track t : tracks) {
			this.tracks.add(t);
		}
	}

	/**
	 * Method will return the title of the music library object.
	 * 
	 * @return The title of the track.
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Method will set the title of the music library object.
	 * 
	 * @param title The title to be set for the music library.
	 */	
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * Method will return the tracks of the music library object.
	 * 
	 * @return The tracks of the music library.
	 */
	public List<Track> getTracks() {
		return tracks;
	}

	/**
	 * Method will set the list of tracks of the music library object.
	 * 
	 * @param tracks The tracks to be set for the music library.
	 */	
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	/**
	 * This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the music library.
	 */
	@Override
	public String toString() {
		return "Music Library: " + this.getTitle() + ", No of Tracks: " + this.getTracks().size();
	}
}
