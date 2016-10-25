/**
 * 
 */
package Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import Structs.Band;
import Structs.Musician;

/**
 * @author Alexander Chetcuti
 *
 */
public class BandTest {

	@Test
	public void testInstanceOfBand() {
		Band band = new Band("Awesome band");
		assertTrue("Testing Instance of Band is of Band", band instanceof Band);
	}

	@Test
	public void testGetName() {
		Band band = new Band("Awesome band");
		assertEquals("Get name of band", "Awesome band", band.getName());
	}

	@Test
	public void testSetName() {
		Band band = new Band("Not an awesome band");
		band.setName("Awesome band");
		assertEquals("Set name of band", "Awesome band", band.getName());
	}

	/**
	 * Test method for {@link Structs.Band#addMember(Structs.Musician)}.
	 */
	@Test
	public void testAddMember() {
		Band band = new Band("Awesome band");
		band.addMember(new Musician("John Doe"));
		assertEquals(1, band.getMembers().size());
	}

	/**
	 * Test method for {@link Structs.Band#getMembers()}.
	 */
	@Test
	public void testGetMembers() {
		Band band = new Band("Awesome band");
		band.addMember(new Musician("John Doe"));
		assertEquals(1, band.getMembers().size());
	}

	/**
	 * Test method for {@link Structs.Band#setMembers(java.util.List)}.
	 */
	@Test
	public void testSetMembers() {
		Band band = new Band("Awesome band");
		List<Musician> members = new ArrayList<Musician>();
		members.add(new Musician("John Doe"));
		band.setMembers(members);
		assertEquals(1, band.getMembers().size());
	}

}
