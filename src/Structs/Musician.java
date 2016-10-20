package Structs;

import java.io.Serializable;

public class Musician extends Artist implements Serializable {
	
	public Musician(String name) {
		this.setName(name);
	}
}
