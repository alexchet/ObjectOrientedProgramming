package Structs;

public class CompilationTrack extends SuperTrack {
	
	private CompilationAlbum compilationAlbum;
	
	public CompilationTrack() { }

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
	 * @return the compilationAlbum
	 */
	public CompilationAlbum getCompilationAlbum() {
		return compilationAlbum;
	}

	/**
	 * @param compilationAlbum the compilationAlbum to set
	 */
	public void setCompilationAlbum(CompilationAlbum compilationAlbum) {
		this.compilationAlbum = compilationAlbum;
	}
	
	@Override
	public String toString() {
		return "Title: " +  super.getTitle() + ", Album: " + super.getAlbum().getTitle();
	}
}
