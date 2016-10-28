import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class MusicOrganiser {
	
	public static void main(String[] args) {
		System.out.println("*********************************************");
		System.out.println("*** CSC8406 - Object Oriented Programming ***");
		System.out.println("*********************************************");
		System.out.println("");

		//Loading some data from JSON files
		List<Musician> musicians = Common.loadMusicians();
		List<Band> bands = Common.loadBands(musicians);
	    List<Track> tracks = Common.loadTracks(bands, musicians);
		List<Album> albums = Common.loadAlbums(tracks, bands, musicians);
	    tracks = Common.setAlbumsForTracks(tracks, albums);
		
		//STARTING BASICS 1
		System.out.println("***************** Basics 1 ******************");
		
		//Adding a new artist. In this case a Musician/Soloist
		Musician musician = new Musician("The D.O.C.");
		System.out.println(musician.toString());
		System.out.println("");
		
		//Adding a new Band.
		List<Musician> membersNWA = new ArrayList<Musician>();
		membersNWA.add(new Musician("Arabian Prince"));
		membersNWA.add(new Musician("DJ Yella"));
		membersNWA.add(new Musician("DR. Dre"));
		membersNWA.add(new Musician("Eazy-E"));
		membersNWA.add(new Musician("Ice Cube"));
		membersNWA.add(new Musician("MC Ren"));
		Band bandNWA = new Band("N.W.A", membersNWA);
		System.out.println(bandNWA.toString());
		System.out.println("");
		
		//Adding a new Track 
		Track trackNWA5 = new Track("Parental Discretion Iz Advised", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				315, 5, 181440, null, 0, null);
		
		//Adding a guest to a track
		trackNWA5.setGuest(musician);
		
		//Get a list of all individuals of the track including guests
		System.out.println(trackNWA5.toString());
		System.out.println(trackNWA5.getArtist().toString());
		System.out.println("Guest " + trackNWA5.getGuest().toString());
		System.out.println("");

		//Adding to the play count of the track
		trackNWA5.play();
		trackNWA5.play();
		
		//Get the play count
		System.out.println("Count Played for '" + trackNWA5.getTitle() + "' is: " + trackNWA5.getCountPlayed());
		System.out.println("");

		//STARTING BASICS 2
		System.out.println("***************** Basics 2 ******************");
		
		//create a new album
		Album albumNWA = new Album(bandNWA, "Straight Outta Compton", "Studio Album", null);
		
		//get details of album
		System.out.println("Album: " + albumNWA.getTitle() + ",  Type: " + albumNWA.getType() +
				", " + albumNWA.getArtist().toString());
		System.out.println("");
		
		//set tracks for the album
		albumNWA.addTrack(new Track("Straight Outta Compton", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				258, 5, 148608, null, 0, null));
		albumNWA.addTrack(new Track("F*** tha Police", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				345, 5, 198720, null, 0, null));
		albumNWA.addTrack(new Track("Gangsta Gangsta", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				336, 5, 193536, null, 0, null));
		albumNWA.addTrack(new Track("If It Ain't Ruff", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				204, 5, 117504, null, 0, null));
		albumNWA.addTrack(trackNWA5);
		albumNWA.addTrack(new Track("8 Ball (Remix)", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				292, 5, 168192, null, 0, null));
		albumNWA.addTrack(new Track("Something Like That", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				215, 5, 123840, null, 0, null));
		albumNWA.addTrack(new Track("Express Yourself", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				285, 5, 164160, null, 0, null));
		albumNWA.addTrack(new Track("Compton's n the House (Remix)", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				320, 5, 184320, null, 0, null));
		albumNWA.addTrack(new Track("I Ain't tha 1", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				294, 5, 169344, null, 0, null));
		albumNWA.addTrack(new Track("Dopeman (Remix)", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				320, 5, 184320, null, 0, null));
		albumNWA.addTrack(new Track("Quiet on tha Set", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				239, 5, 137664, null, 0, null));
		albumNWA.addTrack(new Track("Something 2 Dance 2", bandNWA, Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				203, 5, 116928, null, 0, null));

		//Output data
		System.out.println(albumNWA.toString());
		System.out.println("");
		

		//STARTING BASICS 3
		System.out.println("***************** Basics 3 ******************");
		//Create a library
		MusicLibrary musicLibrary = new MusicLibrary("My Favourite Music");
		
		//Add tracks or albums to library
		musicLibrary.addTrack(tracks.get(8));
		musicLibrary.addTrack(tracks.get(9));
		musicLibrary.addTracks(albums.get(0).getTracks());
		
		//sorting tracks with lowest rating first
		Collections.sort(musicLibrary.getTracks(), Track.COMPARE_RATING);
		Common.printMusicLibrary(musicLibrary);

		/************ Extension 1 ************/
		System.out.println("**************** Extension 1 ****************");
		CompilationAlbum compAlbum = new CompilationAlbum("Various Artist VOL 1");
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(0), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(2), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(4), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(5), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(7), compAlbum));
		compAlbum.addCompilationTrack(new CompilationTrack(tracks.get(9), compAlbum));
		Common.printCompilationAlbum(compAlbum);
		
		/************ Extension 2 ************/
		System.out.println("");
		System.out.println("**************** Extension 2 ****************");
		//insert more tracks in main track list
		for (Track t : albumNWA.getTracks()) {
			tracks.add(t);
		}
		List<List<Track>> cds = Common.backupBestFit(tracks, Common.CD_SIZE);
		System.out.println("No of CDs needed: " + cds.size());
		
		List<List<Track>> dvds = Common.backupBestFit(tracks, Common.DVD_SIZE);
		System.out.println("No of DVDs needed: " + dvds.size());
		
		
		//-----------------------------------------------------------------------------//
		//Testing
		System.out.println("");
		System.out.println("**************** Testing ****************");
		Test.testCases();
	}
}
