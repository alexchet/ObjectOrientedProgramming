package Structs;

import java.util.ArrayList;
import java.util.List;

public class MusicLibrary {
	private String title;
	private List<Track> tracks;

	public MusicLibrary() { }

	public MusicLibrary(String title) {
		this.title = title;
		this.tracks = new ArrayList<Track>();
	}
	
	public void addTrack (Track track) {
		this.tracks.add(track);
	}
	
	public void addTracks (List<Track> tracks) {
		for (Track t : tracks) {
			this.tracks.add(t);
		}
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the tracks
	 */
	public List<Track> getTracks() {
		return tracks;
	}

	/**
	 * @param tracks the tracks to set
	 */
	public void setTracks(List<Track> tracks) {
		this.tracks = tracks;
	}
	
	@Override
	public String toString() {
		return "Music Library: " + this.getTitle() + ", No of Tracks: " + this.getTracks().size();
	}
}
