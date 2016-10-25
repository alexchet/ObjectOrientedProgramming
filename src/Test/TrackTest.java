/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Test;

import Structs.Album;
import Structs.Artist;
import Structs.Band;
import Structs.Musician;
import Structs.SuperTrack;
import Structs.Track;

/**
 * @author Alexander Chetcuti
 *
 */
public class TrackTest {

	@Test
	public void testInstanceOfTrack() {
		Track track = new Track("Title", new Musician("John Doe"), 
				Date.from(LocalDate.of(2016, 06, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				320, 3, 34.0, null, 2, null);
		assertTrue("Testing Instance of Track is of Track", track instanceof Track);
	}

	/**
	 * Test method for {@link Structs.SuperTrack#play()}.
	 */
	@Test
	public void testPlay() {
		int countPlayed = 2;
		Track track = new Track("Title", new Musician("John Doe"), 
				Date.from(LocalDate.of(2016, 06, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				320, 3, 34.0, null, countPlayed, null);
		
		track.play();
		
		assertEquals("Track add one more play", 3, track.getCountPlayed());
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		Track track = new Track("Title", new Musician("John Doe"), 
				Date.from(LocalDate.of(2016, 06, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				320, 3, 34.0, null, 2, null);
		
		assertEquals("Get title of track", "Title", track.getTitle());
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		Track track = new Track("Not a title", new Musician("John Doe"), 
				Date.from(LocalDate.of(2016, 06, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				320, 3, 34.0, null, 2, null);
		
		track.setTitle("Title");
		
		assertEquals("Set title of track", "Title", track.getTitle());
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getArtist()}.
	 */
	@Test
	public void testGetArtist() {
		Musician musician = new Musician("John Doe");
		
		Track track = new Track("Not a title", musician, 
				Date.from(LocalDate.of(2016, 06, 07).atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
				320, 3, 34.0, null, 2, null);
		
		assertEquals("Get artist of track", musician, track.getArtist());
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setArtist(Structs.Artist)}.
	 */
	@Test
	public void testSetArtist() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getReleased()}.
	 */
	@Test
	public void testGetReleased() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setReleased(java.util.Date)}.
	 */
	@Test
	public void testSetReleased() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getLength()}.
	 */
	@Test
	public void testGetLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setLength(int)}.
	 */
	@Test
	public void testSetLength() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getRating()}.
	 */
	@Test
	public void testGetRating() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setRating(int)}.
	 */
	@Test
	public void testSetRating() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getSize()}.
	 */
	@Test
	public void testGetSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setSize(double)}.
	 */
	@Test
	public void testSetSize() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getGuest()}.
	 */
	@Test
	public void testGetGuest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setGuest(Structs.Artist)}.
	 */
	@Test
	public void testSetGuest() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getCountPlayed()}.
	 */
	@Test
	public void testGetCountPlayed() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setCountPlayed(int)}.
	 */
	@Test
	public void testSetCountPlayed() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#getAlbum()}.
	 */
	@Test
	public void testGetAlbum() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link Structs.SuperTrack#setAlbum(Structs.Album)}.
	 */
	@Test
	public void testSetAlbum() {
		fail("Not yet implemented");
	}

}
