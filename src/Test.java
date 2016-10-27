import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public abstract class Test {
	public static void testCases() {
		//Create empty artist and output
		System.out.println("Test 1: Create empty artist and output");
		Musician testMusician = new Musician();
		System.out.println(testMusician.toString());
		System.out.println("");
		
		//Test set name and output
		System.out.println("Test 2: Test set name and output");
		testMusician.setName("Testing name");
		System.out.println(testMusician.toString());
		System.out.println("");

		//Test new Band and output without and musicians
		System.out.println("Test 3: Test new Band and output without and musicians");
		Band testBand = new Band("Testing band");
		System.out.println(testBand.toString());
		System.out.println("");
		
		//Add new member and output band
		System.out.println("Test 4: Add new member and output band");
		testBand.addMember(testMusician);
		System.out.println(testBand.toString());
		System.out.println("");

		//Add new Track
		System.out.println("Test 5: Add new Track");
		Track testTrack = new Track("Testing track", testBand,
				Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				315, 3, 181440, null, 0, null);
		System.out.println(testTrack.toString());
		System.out.println("");

		//Set Track length to negative
		System.out.println("Test 6: Set Track length to negative");
		testTrack.setLength(-100);
		System.out.println(testTrack.toString());
		System.out.println("");
		
		//Set Track date to earlier then 1970
		System.out.println("Test 7: Set Track date to earlier then 1970");
		testTrack.setReleased(Date.from(LocalDate.of(1968, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()));
		System.out.println(testTrack.toString());
		System.out.println("");

		//Add guest to track
		System.out.println("Test 8: Add guest to track");
		Musician testMusician2 = new Musician("Testing name 2");
		testTrack.setGuest(testMusician2);
		System.out.println(testTrack.getGuest().toString());
		System.out.println("");

		//Get all artist of the track
		System.out.println("Test 9: Get all artist of the track");
		System.out.println(testTrack.getArtist().toString());
		System.out.println("");

		//Increase count played of track
		System.out.println("Test 10: Increase count played of track");
		System.out.print("Get first count: " + testTrack.getCountPlayed());
		testTrack.play();
		System.out.println(" Count increased to: " + testTrack.getCountPlayed());
		System.out.println("");

		//Create an album
		System.out.println("Test 11: Create an album");
		Album testAlbum = new Album(testBand, "Testing album", "Testing type", null);
		System.out.print(testAlbum.toString());
		System.out.println("");
		
		//Get name of album
		System.out.println("Test 12: Get name of album");
		System.out.println(testAlbum.getTitle());
		System.out.println("");

		//Get type of album
		System.out.println("Test 13: Get type of album");
		System.out.println(testAlbum.getType());
		System.out.println("");
		
		//Add track and output album, get total running time, total size and average rating
		System.out.println("Test 14: Add track and output album, get total running time, total size and average rating");
		testTrack.setLength(150);
		testTrack = testAlbum.addTrack(testTrack);
		System.out.println(testAlbum.toString());
		System.out.println("");
		
		//Create a Library
		System.out.println("Test 15: Create a library");
		MusicLibrary testMusicLibrary = new MusicLibrary("Testing Music Library");
		System.out.println(testMusicLibrary.toString());
		System.out.println("");
		
		//Add Track
		System.out.println("Test 16: Adding a single track to library");
		Track testTrack2 = new Track("Testing track 2", testBand,
				Date.from(LocalDate.of(1988, 10, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()), 
				315, 2, 181440, null, 0, null);
		testMusicLibrary.addTrack(testTrack2);
		System.out.println(testMusicLibrary.toString());
		System.out.println("");
		
		//Add Album to music library
		System.out.println("Test 17: Adding tracks from an album to a music library");
		testMusicLibrary.addTracks(testAlbum.getTracks());
		System.out.println(testMusicLibrary.toString());
		System.out.println("");
		
		//Create List of track with lowest rating
		System.out.println("Test 18: Create list of tracks with lowest rating");
		Collections.sort(testMusicLibrary.getTracks(), Track.COMPARE_RATING);
		System.out.println(testMusicLibrary.getTracks().toString());
		System.out.println("");
		
		//Adding a compilation album
		//Failed: Added try catch for null pointer in compilation album to string method
		System.out.println("Test 19: Create a new compilation album");
		CompilationAlbum testCompAlbum = new CompilationAlbum("Testing Comp Album");
		System.out.print(testCompAlbum.toString());
		System.out.println("");
		
		//Adding a compilation track
		//Failed: Returning Track object with album pointer set.
		System.out.println("Test 20: Adding a compilation track");
		CompilationTrack testCompTrack = new CompilationTrack(testTrack, testCompAlbum);
		System.out.println(testCompTrack.toString());
		System.out.println("");
		
		//Adding track to compilation album
		System.out.println("Test 21: Get to string of compilation album");
		testCompAlbum.addCompilationTrack(testCompTrack);
		System.out.print(testCompAlbum.toString());
		
		//Testing Bin Packing problem
		System.out.println("Test 21: Testing Bin Packing problem");
		List<List<Track>> cds = Common.backupFirstFit(testAlbum.getTracks(), Common.CD_SIZE);
		System.out.println("No of CDs needed: " + cds.size());
	}
}
