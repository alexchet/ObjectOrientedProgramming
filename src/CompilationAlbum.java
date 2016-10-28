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
public class CompilationAlbum extends SuperAlbum {

	/**
	 * Private field, artists of the album
	 */
	private List<Artist> artist;
	
	/**
	 * Private field, list of the tracks of the album
	 */
	private List<CompilationTrack> CompilationTracks;
	
	/**
	 * <p>Empty constructor. This is required for the Jackson JSON mapping to work.
	 */
	public CompilationAlbum() { }

	/**
	 * <p>This constructor initialises an object of type compilation album, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param title The title of the compilation album.
	 */
	public CompilationAlbum(String title) {
		this.setTitle(title);
	}
	
	/**
	 * This method adds a track of type <i>CompilationTrack</i> to the current list
	 * of tracks in the album. If the list has not yet been initialised it will be
	 * initialised in this method when the first track is added.
	 * 
	 * @param CompilationTrack The track the is being added to the list.
	 */
	public void addCompilationTrack(CompilationTrack CompilationTrack) {
		if (this.getCompilationTracks() == null) this.setCompilationTracks(new ArrayList<CompilationTrack>());
		this.getCompilationTracks().add(CompilationTrack);
	}

	/**
	 * Method will return the artists of the album object.
	 * 
	 * @return The artist of the album.
	 */
	public List<Artist> getArtist() {
		return artist;
	}

	/**
	 * Method will set the artists of the album object.
	 * 
	 * @param artists The artists to be set for the album.
	 */	
	public void setArtist(List<Artist> artists) {
		this.artist = artists;
	}

	/**
	 * Method will return the tracks of the album object.
	 * 
	 * @return The title of the track.
	 */
	public List<CompilationTrack> getCompilationTracks() {
		return CompilationTracks;
	}

	/**
	 * Method will set the tracks of the album object.
	 * 
	 * @param compilationTracks The tracks to be set for the album.
	 */	
	public void setCompilationTracks(List<CompilationTrack> compilationTracks) {
		CompilationTracks = compilationTracks;
	}

	/**
	 * <p>This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the musician.
	 * 
	 * @return The final concatenated string.
	 */
	@Override
	public String toString() {
		try {
			if (this.getCompilationTracks() == null) {
				throw new TracksNotFoundException();
			}
			
			return "Compilation Title: " + super.getTitle() + ", No of Tracks: " + this.getCompilationTracks().size();

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
