package Structs;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Musician extends Artist implements Serializable {
	
	public Musician(String name) {
		this.setName(name);
	}
	
	public static void serialize(Musician musician)
	{
		ObjectOutput output = null;
		try {
		      OutputStream file = new FileOutputStream("musicians.ser", true);
		      OutputStream buffer = new BufferedOutputStream(file);
		      output = new ObjectOutputStream(buffer);
		      output.writeBoolean(true);
			  output.writeObject(musician);
		} catch(IOException ex){

	    } finally {
	    	try {
	            if (output != null) {
	            	output.close();
	            }
	    	} catch (IOException ioException) {
	    		System.err.println("Error closing file.");
	        }
	    }
	}
	
	public static void deserialize()
	{
		try{
			InputStream file = new FileInputStream("musicians.ser");
			InputStream buffer = new BufferedInputStream(file);
		    ObjectInputStream input = null;
		    List<Musician> musicians = new ArrayList<Musician>();
			try{
		        input = new ObjectInputStream(buffer);
		        Musician readMusician = null;
		        while (input.readBoolean()) {
		        	readMusician = (Musician) input.readObject();
		            if(readMusician != null){
		            	musicians.add(readMusician);
		            	System.out.println(readMusician.getName());
		            } 
		        }   
			}
			finally{
				try {
		            if (input != null) {
		            	input.close();
		            }
		    	} catch (IOException ioException) {
		    		System.err.println("Error closing file.");
		        }
			}
		}
		catch(ClassNotFoundException ex){

		}
		catch(IOException ex){

		}
	}

}
