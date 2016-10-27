/**
 * <p>This is an abstract class which describes the most basic details
 * of an Artist. Since all version of artist have the same common properties
 * it was decided that having a super class for an artist is appropriate.
 * 
 * @author Alexander Chetcuti
 *
 */
public abstract class Artist {
	
	/**
	 * Private field, ID of the artist.
	 */
	private int id;
	
	/**
	 * Private field, name of the artist.
	 */
	private String name;

	/**
	 * Method will return the ID of the artist object.
	 * 
	 * @return The ID of the artist.
	 */
	public int getID() {
		return id;
	}

	/**
	 * Method will set the ID of the artist object.
	 * 
	 * @param ID The ID to be set for the artist.
	 */	
	public void setID(int id) {
		this.id = id;
	}

	/**
	 * Method will return the name of the artist object.
	 * 
	 * @return The name of the artist.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Method will set the name of the artist object.
	 * 
	 * @param name The name to be set for the artist.
	 */	
	public void setName(String name) {
		this.name = name;
	}
}
