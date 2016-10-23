package Structs;

import java.util.ArrayList;
import java.util.List;

public class Album extends SuperAlbum {
	
	private int ID;
	private Artist artist;
	private String type;
	private List<Track> tracks;
	private int bandID;
	private int musicianID;

	public Album() { }

	public Album(int ID, Artist artist, String title, String type, List<Track> tracks, int bandID, int musicianID) {
		this.ID = ID;
		this.artist = artist;
		this.setTitle(title);
		this.type = type;
		this.tracks = tracks;
		this.bandID = bandID;
		this.musicianID = musicianID;
	}
	
	public void addTrack(Track track) {
		if (this.getTracks() == null) this.setTracks(new ArrayList<Track>());
		this.getTracks().add(track);
	}

	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
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

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the bandID
	 */
	public int getBandID() {
		return bandID;
	}

	/**
	 * @param bandID the bandID to set
	 */
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * @return the musicianID
	 */
	public int getMusicianID() {
		return musicianID;
	}

	/**
	 * @param musicianID the musicianID to set
	 */
	public void setMusicianID(int musicianID) {
		this.musicianID = musicianID;
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

}
