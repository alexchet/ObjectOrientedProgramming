

import java.util.ArrayList;
import java.util.List;

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
public class Band extends Artist {
	
	/**
	 * Private field, members of the musician
	 */
	private List<Musician> members;
	
	/**
	 * <p>This constructor initialises an object of type band and initialises 
	 * the list of members.
	 */
	public Band() { 
		this.members = new ArrayList<Musician>();
	}
	
	/**
	 * <p>This constructor initialises an object of type band and initialises 
	 * the list of members.
	 * 
	 * @param name The name of the band.
	 */
	public Band(String name) {
		this.setName(name);
		this.members = new ArrayList<Musician>();
	}
	
	/**
	 * <p>This constructor initialises an object of type band and initialises 
	 * the list of members.
	 * 
	 * @param name The name of the band.
	 * @param members The members of the band.
	 */
	public Band(String name, List<Musician> members) {
		this.setName(name);
		if (this.members == null) this.members = new ArrayList<Musician>();
		this.setMembers(members);
	}
	
	/**
	 * This method add a member to the band. The member should be of type
	 * <i>Musician</i>. The method also checks if the list of members is
	 * already initialised.
	 * 
	 * @param musician The member that is being added to the band.
	 */
	public void addMember(Musician musician) {
		if (this.members == null) this.members = new ArrayList<Musician>();
		this.members.add(musician);
	}

	/**
	 * Method will return the members of the band object.
	 * 
	 * @return The list of the musicians in the band.
	 */
	public List<Musician> getMembers() {
		return members;
	}

	/**
	 * Method will set the list of the musicians for the band object.
	 * 
	 * @param members The musicians to be set as members for the band.
	 */	
	public void setMembers(List<Musician> members) {
		this.members = members;
	}

	/**
	 * <p>This method overrides the method <i>toString</i>, and will output a string with 
	 * the properties of the band.
	 * 
	 * <p>The method will loop every member of the band and append it to a string to 
	 * be returned with the rest of the results.
	 * 
	 * @return The final concatenated string.
	 */
	@Override
	public String toString() {
		String sMembers = "";
		
		for (Musician m : this.getMembers()) {
			sMembers += (sMembers != "" ? ", " : "");
			sMembers += m.getName();
		}
		
		return "Band: " + this.getName() + "\nMusicians: " + sMembers;
	}
}
