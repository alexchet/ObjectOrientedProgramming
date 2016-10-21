package Structs;

public class CompilationTrack {
	
	private Track track;
	private Album album;
	
	public CompilationTrack() { }
	
	public CompilationTrack(Track track, Album album) {
		this.setTrack(track);
		this.setAlbum(album);
	}

	/**
	 * @return the track
	 */
	public Track getTrack() {
		return track;
	}

	/**
	 * @param track the track to set
	 */
	public void setTrack(Track track) {
		this.track = track;
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
