package Structs;

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum extends SuperAlbum {

	private List<Artist> artist;

	public CompilationAlbum() { }

	public CompilationAlbum(String title) {
		this.setTitle(title);
		this.setTracks(new ArrayList<Track>());
	}

	/**
	 * @return the artist
	 */
	public List<Artist> getArtist() {
		return artist;
	}

	/**
	 * @param artist the artist to set
	 */
	public void setArtist(List<Artist> artist) {
		this.artist = artist;
	}
}
