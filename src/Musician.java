
/**
 * <p>This class extends the class <i>Artist</i>. By doing this this class
 * can make use of all the properties inherited and can be set in the constructor
 * of this class.
 * 
 * <p>The method <i>toString</i> is being overridden to 
 * change it's functionality and output only what it needs to output.
 * 
 * @author Alexander Chetcuti
 *
 */
public class Musician extends Artist  {
	
	/**
	 * Private field, band id of the musician
	 */
	private int bandID;
	
	/**
	 * <p>Empty constructor. This is required for the Jackson JSON mapping to work.
	 */
	public Musician() {	}
	
	/**
	 * <p>This constructor initialises an object of type musician, and sets all the 
	 * required data in their appropriate fields.
	 * 
	 * @param name The name of the musician.
	 */
	public Musician(String name) {
		this.setName(name);
	}

	/**
	 * Method will return the band id of the musician object.
	 * 
	 * @return The band id of the musician.
	 */
	public int getBandID() {
		return bandID;
	}

	/**
	 * Method will set the band id of the musician object.
	 * 
	 * @param bandID The band id to be set for the track.
	 */	
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}

	/**
	 * <p>This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the musician.
	 */
	@Override
	public String toString() {
		return "Musician: " + this.getName();
	}
}
