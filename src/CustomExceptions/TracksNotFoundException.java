package CustomExceptions;

/**
 * This class represents a custom exception used when the list of tracks
 * is equal to null. The class extends Exception class.
 * 
 * @author Alexander Chetcuti
 *
 */
public class TracksNotFoundException extends Exception {

	/**
	 * The constructor passes a message to the super class to set the 
	 * string which will be returned when calling the get message method.
	 */
	public TracksNotFoundException() {
		super("Sorry, please input some tracks.");
	}
}
