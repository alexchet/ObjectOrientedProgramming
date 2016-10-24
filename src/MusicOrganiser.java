import java.util.Collections;
import java.util.List;

import Structs.Track;
import Structs.Album;
import Structs.Band;
import Structs.CompilationAlbum;
import Structs.CompilationTrack;
import Structs.MusicLibrary;
import Structs.Musician;
import Data.Common;
import Data.FileProvider;

public class MusicOrganiser {
	
	//Size are in KiloBytes
	public static final int CD_SIZE = 716800;
	public static final int DVD_SIZE = 4928307;

	public MusicOrganiser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*** CSC8406 - Object Oriented Programming ***");
		System.out.println("*********************************************");
		System.out.println("");
		
		List<Musician> musicians = FileProvider.readMusician();
		List<Band> bands = FileProvider.readBand();
		List<Track> tracks = FileProvider.readTrack();
		List<Album> albums = FileProvider.readAlbum();
		
		//Create bands from musicians
		for (Musician m : musicians) {
			for (Band b : bands) { 
				if (m.getBandID() == b.getID()) {
					b.addMemeber(m);
					break;
				}
			}
		}
		
		//Create tracks
		for (Track t : tracks) {
			for (Band b : bands) {
				if (b.getID() == t.getBandID()) {
					t.setArtist(b);
				}
				if (b.getID() == t.getGuestBandID()) {
					t.setGuest(b);
				}
			}
			for (Musician m : musicians) {
				if (m.getID() == t.getMusicianID()) {
					t.setArtist(m);
				}
				if (m.getID() == t.getGuestMusicianID()) {
					t.setGuest(m);
				}
			}
		}
		
		//Insert the tracks in albums
		for (Album a : albums) {
			for (Track t : tracks) {
				if (a.getID() == t.getAlbumID()) {
					a.addTrack(t);
					t.setAlbum(a);
				}
			}
			for (Band b : bands) {
				if (b.getID() == a.getBandID()) {
					a.setArtist(b);
				}
			}
			for (Musician m : musicians) {
				if (m.getID() == a.getMusicianID()) {
					a.setArtist(m);
				}
			}
		}
		
		//FileProvider.write(tracks, "tracks");

		
		/************ BASICS 1 ************/

		System.out.println("***************** Basics 1 ******************");
		tracks.get(2).play();
		tracks.get(3).play();
		tracks.get(4).play();
		tracks.get(2).play();

		//Print Tracks
		printTrackMusicians(tracks);
		
		/************ BASICS 2 ************/
		System.out.println("");
		System.out.println("***************** Basics 2 ******************");

		//Print Albums
		printAlbums(albums);	
		
		/************ BASICS 3 ************/
		System.out.println("");
		System.out.println("***************** Basics 3 ******************");
		MusicLibrary musicLibrary = new MusicLibrary("My Favourite Music");
		musicLibrary.addTrack(tracks.get(8));
		musicLibrary.addTrack(tracks.get(9));
		musicLibrary.addTracks(albums.get(0).getTracks());
		Collections.sort(musicLibrary.getTracks(), Track.COMPARE_RATING);
		printMusicLibrary(musicLibrary);

		/************ Extension 1 ************/
		System.out.println("**************** Extension 1 ****************");
		CompilationAlbum compAlbum = new CompilationAlbum("Various Artist VOL 1");
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(0), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(2), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(4), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(5), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(7), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(9), compAlbum));
		printCompilationAlbum(compAlbum);
		
		/************ Extension 2 ************/
		System.out.println("");
		System.out.println("**************** Extension 2 ****************");
		List<List<Track>> cds = Common.bestFit(tracks, CD_SIZE);
		System.out.println("No of CDs needed: " + cds.size());
		
		List<List<Track>> dvds = Common.bestFit(tracks, DVD_SIZE);
		System.out.println("No of DVDs needed: " + dvds.size());
	}
	
	public static void printMusicLibrary(MusicLibrary musicLibrary) {
		System.out.println(musicLibrary.toString());
		printTrackMusicians(musicLibrary.getTracks());
	}
	
	public static void printTrackMusicians(List<Track> tracks) {
		for (Track t : tracks) {
			System.out.println(t.toString());
			System.out.println(t.getArtist().toString());
			if (t.getGuest() != null) {
				System.out.println("Guest Artist: " + t.getGuest().getName());
				System.out.println("Guest " + t.getGuest().toString());
			}
			System.out.println("");
		}
	}
	
	public static void printAlbums(List<Album> albums) {
		for (Album a : albums) {
			System.out.println(a.toString());	
			System.out.println("");		
		}
	}

	public static void printCompilationAlbum(CompilationAlbum compAlbum) {
		System.out.println(compAlbum.toString());
		for (CompilationTrack compTrack : compAlbum.getCompilationTracks()) {
			System.out.println(compTrack.toString());
		}
	}
}
