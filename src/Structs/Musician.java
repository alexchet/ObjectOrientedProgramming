package Structs;

import java.util.Date;

public class Musician extends Artist {

	private Date dateBorn;
	
	public Musician() {
		// TODO Auto-generated constructor stub
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
