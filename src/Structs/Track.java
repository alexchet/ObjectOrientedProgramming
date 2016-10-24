package Structs;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	@Override
	public String toString() {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		int minutes = super.getLength() / 60;
		int seconds = super.getLength() - minutes * 60;
		
		return "Title: " + super.getTitle() + ", Artist: " + super.getArtist().getName() +
		(super.getAlbum() != null ? ", Album: " + super.getAlbum().getTitle() : "") + ", Released: " +  
		formatter.format(super.getReleased()) + ", Duration: " + minutes + ":" + seconds + 
		", Times Played: " + super.getCountPlayed() + ", Rating: " + super.getRating();
	}
}
