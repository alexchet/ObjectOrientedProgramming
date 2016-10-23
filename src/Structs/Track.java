package Structs;

import java.util.Date;
import java.util.List;

public class Track extends SuperTrack {

	public Track() { }
	
	public Track(String title, Artist artist, Date released, int length, int rating,
			double size, Artist guest, int countPlayed, Album album, int bandID, int musicianID,
			int albumID, int guestBandID, int guestMusicianID) {
		setTitle(title);
		setArtist(artist);
		setReleased(released);
		setLength(length);
		setRating(rating);
		setGuest(guest);
		setCountPlayed(countPlayed);
		setAlbum(album);
		setBandID(bandID);
		setMusicianID(musicianID);
		setAlbumID(albumID);
		setGuestBandID(guestBandID);
		setGuestMusicianID(guestMusicianID);
	}
}
