package Structs;

import java.util.Date;
import java.util.List;

public class Track extends SuperTrack {

	public Track() { }
	
	public Track(String title, Artist artist, Date released, int length, int rating,
			double size, Artist guest, int countPlayed, int bandID, int musicianID,
			List<Integer> albumIDs, int guestBandID, int guestMusicianID) {
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
	}
}
