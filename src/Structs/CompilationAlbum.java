package Structs;

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum extends SuperAlbum {

	private List<Artist> artist;
	private List<CompilationTrack> CompilationTracks;
	

	public CompilationAlbum() { }

	public CompilationAlbum(String title) {
		this.setTitle(title);
	}
	
	public void addCompilationTrack(CompilationTrack CompilationTrack) {
		if (this.getCompilationTracks() == null) this.setCompilationTracks(new ArrayList<CompilationTrack>());
		this.getCompilationTracks().add(CompilationTrack);
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

	/**
	 * @return the compilationTracks
	 */
	public List<CompilationTrack> getCompilationTracks() {
		return CompilationTracks;
	}

	/**
	 * @param compilationTracks the compilationTracks to set
	 */
	public void setCompilationTracks(List<CompilationTrack> compilationTracks) {
		CompilationTracks = compilationTracks;
	}
	
	@Override
	public String toString() {
		return "Compilation Title: " + super.getTitle() + ", No of Tracks: " + this.getCompilationTracks().size();
	}
}
