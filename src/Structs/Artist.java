package Structs;

import java.util.Date;

public class Artist {
	
	private String name;
	private Date dateBorn;
	
	public Artist() {
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
	 * @return the dateBorn
	 */
	public Date getDateBorn() {
		return dateBorn;
	}

	/**
	 * @param dateBorn the dateBorn to set
	 */
	public void setDateBorn(Date dateBorn) {
		this.dateBorn = dateBorn;
	}
}
