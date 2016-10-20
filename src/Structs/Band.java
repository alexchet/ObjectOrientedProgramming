package Structs;

import java.util.ArrayList;
import java.util.List;

public class Band extends Artist {
	
	private List<Musician> members;

	public Band() { 
		this.members = new ArrayList<Musician>();
	}
	
	public Band(int ID, String name) {
		this.setID(ID);
		this.setName(name);
		this.members = new ArrayList<Musician>();
	}
	
	public void addMemeber(Musician musician) {
		if (this.members == null) this.members = new ArrayList<Musician>();
		this.members.add(musician);
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
