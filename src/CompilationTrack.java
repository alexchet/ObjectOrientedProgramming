/**
 * <p>This class extends the class <i>SuperTrack</i>. By doing this this class
 * can make use of all the properties inherited and can be set in the constructor
 * of this class.
 * 
 * <p>The method <i>toString</i> is being overridden to 
 * change it's functionality and output only what it needs to output.
 * 
 * @author Alexander Chetcuti
 *
 */
public class CompilationTrack extends SuperTrack {
	
	/**
	 * Private field, album of type <i>CompilationAlbum</i> of the track
	 */
	private CompilationAlbum compilationAlbum;
	
	/**
	 * <p>Empty constructor. This is required for the Jackson JSON mapping to work.
	 */
	public CompilationTrack() { }

	/**
	 * <p>This constructor initialises an object of type compilation track, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param track This is an object of type track. All the properties of this
	 * parameter will be mapped to the object being created.
	 * @param compilationAlbum The album that the track will be part of.
	 */
	public CompilationTrack(Track track, CompilationAlbum compilationAlbum) {
		setTitle(track.getTitle());
		setArtist(track.getArtist());
		setReleased(track.getReleased());
		setLength(track.getLength());
		setRating(track.getRating());
		setGuest(track.getGuest());
		setCountPlayed(track.getCountPlayed());
		setAlbum(track.getAlbum());
		this.compilationAlbum = compilationAlbum;
	}

	/**
	 * Method will return the album of the track object.
	 * 
	 * @return The title of the track.
	 */
	public CompilationAlbum getCompilationAlbum() {
		return compilationAlbum;
	}

	/**
	 * Method will set the album of the track object.
	 * 
	 * @param compilationAlbum The album to be set for the track.
	 */	
	public void setCompilationAlbum(CompilationAlbum compilationAlbum) {
		this.compilationAlbum = compilationAlbum;
	}

	/**
	 * <p>This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the musician.
	 */
	@Override
	public String toString() {
		return "Title: " +  super.getTitle() + ", Album: " + super.getAlbum().getTitle();
	}
}
