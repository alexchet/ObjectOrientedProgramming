import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import Structs.Track;
import Structs.Album;
import Structs.Artist;
import Structs.Band;
import Structs.CompilationAlbum;
import Structs.CompilationTrack;
import Structs.MusicLibrary;
import Structs.Musician;

import Data.FileProvider;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*** CSC8406 - Object Oriented Programming ***");
		System.out.println("*********************************************");
		System.out.println("");
		
		/************ BASICS 1 ************/

		System.out.println("***************** Basics 1 ******************");
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
		MusicLibrary myPlaylist = new MusicLibrary("My Favourite Music");
		myPlaylist.addTrack(tracks.get(8));
		myPlaylist.addTrack(tracks.get(9));
		myPlaylist.addTracks(albums.get(0).getTracks());
		Collections.sort(myPlaylist.getTracks(), Track.COMPARE_RATING);
		printTrackMusicians(myPlaylist.getTracks());

		/************ Extension 1 ************/
		System.out.println("**************** Extension 1 ****************");
		CompilationAlbum compAlbum = new CompilationAlbum("Various Artist VOL 1");
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(0), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(2), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(4), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(5), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(7), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(9), compAlbum));
		
	}
	
	public static void printTrackMusicians(List<Track> tracks) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		for (Track t : tracks) {
			System.out.println(t.toString());
			System.out.print("Musicians: ");
			Artist a = t.getArtist();
			if (a instanceof Band) {
				Band b = (Band) a;
				for (Musician m : b.getMembers()) {
					System.out.print(m.getName() + " ");
				}
			} else if (a instanceof Musician) {
				Musician m = (Musician) a;
				System.out.print(m.getName());
			}
			System.out.println("");
			if (t.getGuest() != null) {
				System.out.println("Guest Artist: " + t.getGuest().getName());
				System.out.print("Guest Musicians: ");
				Artist ga = t.getGuest();
				if (ga instanceof Band) {
					Band b = (Band) ga;
					for (Musician m : b.getMembers()) {
						System.out.print(m.getName() + " ");
					}
				} else if (ga instanceof Musician) {
					Musician m = (Musician) ga;
					System.out.print(m.getName());
				}
			}
			System.out.println("");
			System.out.println("");
		}
	}
	
	public static void printAlbums(List<Album> albums) {
		for (Album a : albums) {
			int iTotalRunningTime = 0, iTotalSize = 0, iTotalRating = 0;
			for (Track t : a.getTracks()) {
				iTotalRunningTime += t.getLength();
				iTotalSize += t.getSize();
				iTotalRating += t.getRating();
			}
			
			int minutes = iTotalRunningTime / 60;
			int seconds = iTotalRunningTime - minutes * 60;
			System.out.println("Album: " + a.getTitle());
			System.out.println("Artist: " + a.getArtist().getName());
			System.out.println("Total running time: " + minutes + ":" + seconds);
			System.out.println("Size: " + iTotalSize + "MB");
			System.out.println("Average Rating: " + ((double)iTotalRating / (double)a.getTracks().size()));
			System.out.println("");
		}
	}

}
