/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Structs.Musician;

/**
 * @author Alexander Chetcuti
 *
 */
public class MusicianTest {

	@Test
	public void testInstanceOfMusician() {
		Musician musician = new Musician("Testing Musician");
		assertTrue("Instance of Musician", musician instanceof Musician);
	}

	@Test
	public void testGetName() {
		Musician musician = new Musician("Testing Musician");
		assertEquals("Get name of musician", "Testing Musician", musician.getName());
	}

	@Test
	public void testSetName() {
		Musician musician = new Musician("Not a Musician");
		musician.setName("Testing Musician");
		assertEquals("Set name of musician", "Testing Musician", musician.getName());
	}
}
