

public class Musician extends Artist  {
	
	private int bandID;
	
	public Musician() {	}
	
	public Musician(String name) {
		this.setName(name);
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
