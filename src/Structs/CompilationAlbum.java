package Structs;

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum extends SuperAlbum {

	private Artist artist;

	public CompilationAlbum() { }

	public CompilationAlbum(String title) {
		this.setTitle(title);
		this.setTracks(new ArrayList<Track>());
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
}
