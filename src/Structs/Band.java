package Structs;

import java.util.List;

public class Band extends Artist {
	
	private List<Musician> members;

	public Band(List<Musician> members) {
		this.members = members;
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
