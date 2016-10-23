package Structs;

import java.util.Date;
import java.util.List;

public class CompilationTrack extends Track {
	
	private Album album;
	
	public CompilationTrack() { }

	public CompilationTrack(String title, Artist artist, Date released, int length, int rating,
			double size, Artist guest, int countPlayed, int bandID, int musicianID,
			List<Integer> albumIDs, int guestBandID, int guestMusicianID, Album album) {
		setTitle(title);
		setArtist(artist);
		setReleased(released);
		setLength(length);
		setRating(rating);
		setGuest(guest);
		setCountPlayed(countPlayed);
		setBandID(bandID);
		setMusicianID(musicianID);
		setAlbumIDs(albumIDs);
		setGuestBandID(guestBandID);
		setGuestMusicianID(guestMusicianID);
		this.album = album;
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
