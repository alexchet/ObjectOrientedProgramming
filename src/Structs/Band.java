package Structs;

import java.util.ArrayList;
import java.util.List;

public class Band extends Artist {
	
	private List<Musician> members;

	public Band() { 
		this.members = new ArrayList<Musician>();
	}
	
	public Band(String name) {
		this.setName(name);
		this.members = new ArrayList<Musician>();
	}
	
	public Band(String name, List<Musician> members) {
		this.setName(name);
		if (this.members == null) this.members = new ArrayList<Musician>();
		this.setMembers(members);
	}
	
	public void addMember(Musician musician) {
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
