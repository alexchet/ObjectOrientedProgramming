package Structs;

import java.util.List;

public class Band extends Artist {
	
	private List<Musician> members;

	public Band() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the members
	 */
	public List<Musician> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Musician> members) {
		this.members = members;
	}

}
