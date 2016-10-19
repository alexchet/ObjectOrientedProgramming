package Structs;

import java.util.List;

public class Band {
	
	private String name;
	private List<Artist> members;

	public Band() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the members
	 */
	public List<Artist> getMembers() {
		return members;
	}

	/**
	 * @param members the members to set
	 */
	public void setMembers(List<Artist> members) {
		this.members = members;
	}

}
