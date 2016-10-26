/**
 * <p>This is an abstract class which describes the most basic details
 * of an Album. Since all version of album have the same common properties
 * it was decided that having a super class for an album is appropriate.
 * 
 * @author Alexander Chetcuti
 *
 */
public abstract class SuperAlbum {

	/**
	 * Private field, title of the album
	 */
	private String title;


	/**
	 * Method will return the title of the album object.
	 * 
	 * @return The title of the album.
	 */
	public String getTitle() {
		return this.title;
	}

	/**
	 * Method will set the title of the album object.
	 * 
	 * @param title The title to be set for the album.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
}
