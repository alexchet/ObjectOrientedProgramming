package Structs;

public class Musician extends Artist  {
	
	private int bandID;
	
	public Musician() {	}
	
	public Musician(int ID, String name, Integer bandID) {
		this.setID(ID);
		this.setName(name);
		if (bandID != null) this.setBandID(bandID.intValue());
	}

	/**
	 * @return the bandID
	 */
	public int getBandID() {
		return bandID;
	}

	/**
	 * @param bandID the bandID to set
	 */
	public void setBandID(int bandID) {
		this.bandID = bandID;
	}
	
	@Override
	public String toString() {
		return "Musician: " + this.getName();
	}
}
