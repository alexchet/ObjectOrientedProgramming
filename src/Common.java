

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.ObjectWriter;
import org.codehaus.jackson.type.TypeReference;

/**
 * <p>This class just consists of static methods that make either some kind
 * of operation, manipulate data to create objects, return of object lists
 * and print of properties when a list of object is passed.
 * 
 * <p>The <i>static final</i> variables are mostly there to be used by 
 * the bin packing problem as a parameter when the method is called. These
 * properties are declared as final since the size of CD and DVD are 
 * widely known and mostly remain as a constant figure.
 * 
 * <p>This class catches exception of the kind <i>NullPointerException</i>
 * This is because it's one of the most common exceptions when using lists.
 * <i>IOException</i> is also used to catch exception that are thrown from
 * calling the <i>readLine()</i> method.
 * 
 * <p>References: Bin packing problem (First Fit) 
 * <br/>Author: Bastian Rieck
 * <br/>Title: Basic Analysis of Bin-Packing Heuristics
 * <br/>Page 2
 * 
 * @author Alexander Chetcuti
 *
 */
public abstract class Common {

	
	/**
	 * Size of a CD in KiloBytes
	 */
	public static final int CD_SIZE = 716800;

	
	/**
	 * Size of a CD in KiloBytes
	 */
	public static final int DVD_SIZE = 4928307;
	
	/**
	 * <p>This method uses the first fit algorithm to calculate how many
	 * disks are needed to backup all the tracks in the music library.
	 * Although this algorithm does not provide the smallest amount of
	 * disks needed, it was chosen to preserve the order of the tracks 
	 * when they are going to be backed up.
	 * 
	 * @param tracks The list of tracks to be backed up.
	 * @param diskSize The size of the disk that is going to be used for
	 * backup.
	 * @return The multi-dimensional list of track lists representing 
	 * a list of disks needed each with a list of tracks to be written.
	 */
	public static List<List<Track>> backupFirstFit(List<Track> tracks, int diskSize) {
		List<List<Track>> bins = new ArrayList<List<Track>>();

		try {
			for (Track t : tracks) {
				if (bins.size() == 0) {
					bins.add(new ArrayList<Track>());
				}
				
				boolean inserted = false;
				for (List<Track> inputBin : bins) {
					if (getSizeBin(inputBin) + t.getSize() < diskSize) {
						inputBin.add(t);
						inserted = true;
					}
				}
				
				if (!inserted) {
					List<Track> newBin = new ArrayList<Track>();
					newBin.add(t);
					bins.add(newBin);
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you have passed the tracks you want to set up, and the size of the disk");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
		
		return bins;
	}
	
	/**
	 * <p>Gets the size of the current bin or disk in this case.
	 * 
	 * @param bin The list of tracks in this particular bin.
	 * @return The total size of the bin that has already been used.
	 * @throws NullPointerException The list of tracks might be empty. Throwing 
	 * a null pointer exception means the method calling it, should this 
	 * exception.
	 */
	private static double getSizeBin(List<Track> bin) throws NullPointerException {
		double totalSize = 0;
		
		for (Track t : bin) {
			totalSize += t.getSize();
		}
		
		return totalSize;
	}
	
	/**
	 * <p>Loads the JSON data saved in musicians.txt. The method reads the 
	 * mentioned file and maps the loaded data using an external library.
	 * The library will initialise the class passed with the correct data in
	 * every property held in that class.
	 * 
	 * @return The list of musicians that have been loaded from the JSON file.
	 */
	public static List<Musician> loadMusicians() {
		return readMusician();
	}
	
	private static List<Musician> readMusician() {
		BufferedReader buffer = null;
		
		try {
			File file = new File("musicians.txt");
			
			buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String json = buffer.readLine();
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<Musician>>() { });
		} catch (IOException ex) {
			System.out.println("Problem occured while reading");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Problem occured while closing buffer");
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * <p>Loads the JSON data saved in bands.txt. The method reads the 
	 * mentioned file and maps the loaded data using an external library.
	 * The library will initialise the class passed with the correct data in
	 * every property held in that class.
	 * 
	 * <p>The method will also iterate a list of musicians to assign them 
	 * to there bands if they require so.
	 * 
	 * @param musicians The list of musicians to be checked to be added 
	 * to a band.
	 * @return The list of bands that have been loaded from the JSON file.
	 */
	public static List<Band> loadBands(List<Musician> musicians) {
		List<Band> bands = readBand();
		
		try {
			//Create bands from musicians
			for (Musician m : musicians) {
				for (Band b : bands) { 
					if (m.getBandID() == b.getID()) {
						b.addMember(m);
						break;
					}
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
		
		return bands;
	}
	
	private static List<Band> readBand() {
		BufferedReader buffer = null;
		
		try {
			File file = new File("bands.txt");
			
			buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String json = buffer.readLine();
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<Band>>() { });
		} catch (IOException ex) {
			System.out.println("Problem occured while reading");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Problem occured while closing buffer");
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * <p>Loads the JSON data saved in tracks.txt. The method reads the 
	 * mentioned file and maps the loaded data using an external library.
	 * The library will initialise the class passed with the correct data in
	 * every property held in that class.
	 * 
	 * <p>The method will also iterate a list of bands and musicians to set
	 * the artist of each track in the list.
	 * 
	 * @param bands The list of bands to be checked to be added 
	 * to as an artist.
	 * @param musicians The list of musicians to be checked to be added 
	 * to as an artist.
	 * @return The list of bands that have been loaded from the JSON file.
	 */
	public static List<Track> loadTracks(List<Band> bands, List<Musician> musicians) {
		List<Track> tracks = readTrack();
		
		try {
			//Create tracks
			for (Track t : tracks) {
				for (Band b : bands) {
					if (b.getID() == t.getBandID()) {
						t.setArtist(b);
					}
					if (b.getID() == t.getGuestBandID()) {
						t.setGuest(b);
					}
				}
				for (Musician m : musicians) {
					if (m.getID() == t.getMusicianID()) {
						t.setArtist(m);
					}
					if (m.getID() == t.getGuestMusicianID()) {
						t.setGuest(m);
					}
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
		
		return tracks;
	}
	
	private static List<Track> readTrack() {
		BufferedReader buffer = null;
		
		try {
			File file = new File("tracks.txt");
			
			buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String json = buffer.readLine();
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<Track>>() { });
		} catch (IOException ex) {
			System.out.println("Problem occured while reading");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Problem occured while closing buffer");
				e.printStackTrace();
			}
		}
		
		return null;
	}

	/**
	 * <p>Loads the JSON data saved in albums.txt. The method reads the 
	 * mentioned file and maps the loaded data using an external library.
	 * The library will initialise the class passed with the correct data in
	 * every property held in that class.
	 * 
	 * <p>The method will also iterate a list of bands and musicians to set
	 * the artist of each track in the list.
	 * 
	 * <p>The method will also iterate a list of tracks to be set as part
	 * of an album.
	 * 
	 * @param tracks The list of tacks to be checked to be added 
	 * as a track in the album.
	 * @param bands The list of musicians to be checked to be added 
	 * as an artist.
	 * @param musicians The list of musicians to be checked to be added 
	 * as an artist.
	 * @return The list of bands that have been loaded from the JSON file.
	 */
	public static List<Album> loadAlbums(List<Track> tracks, List<Band> bands, List<Musician> musicians) {
		List<Album> albums = readAlbum();
		
		try {
			//Insert the tracks in albums
			for (Album a : albums) {
				for (Track t : tracks) {
					if (a.getID() == t.getAlbumID()) {
						a.addTrack(t);
						t.setAlbum(a);
					}
				}
				for (Band b : bands) {
					if (b.getID() == a.getBandID()) {
						a.setArtist(b);
					}
				}
				for (Musician m : musicians) {
					if (m.getID() == a.getMusicianID()) {
						a.setArtist(m);
					}
				}
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
		
		return albums;
	}
	
	private static List<Album> readAlbum() {
		BufferedReader buffer = null;
		
		try {
			File file = new File("albums.txt");
			
			buffer = new BufferedReader(new FileReader(file.getAbsolutePath()));
			String json = buffer.readLine();
			
			ObjectMapper mapper = new ObjectMapper();
			return mapper.readValue(json, new TypeReference<List<Album>>() { });
		} catch (IOException ex) {
			System.out.println("Problem occured while reading");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Problem occured while closing buffer");
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	/**
	 * <p>This Methods uses the same external library as the read method, to
	 * write and store information to a text file in a JSON format. The method
	 * <i>ObjectMapper</i> is used to handle the conversion of an object
	 * into JSON format.
	 * 
	 * <p>After the conversion is done the returned string is written to a file
	 * using the <i>FileWriter</i> class.
	 * 
	 * @param object The object that needs to be written to a file.
	 * @param fileName The name of the file excluding the extension of 
	 * the file.
	 */
	public static void write(Object object, String fileName) {
		BufferedWriter buffer = null;
		
		try {
			ObjectWriter objectWritter = new ObjectMapper().writer();
			String json = objectWritter.writeValueAsString(object);
			
			File file = new File(fileName + ".txt");
	
			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
	
			FileWriter writer = new FileWriter(file.getAbsoluteFile());
			buffer = new BufferedWriter(writer);
			buffer.write(json);
			System.out.println("Done"); 
		} catch (JsonGenerationException e) {
			System.out.println("Something went wrong while generating JSON");
			e.printStackTrace();
		} catch (JsonMappingException e) {
			System.out.println("Something went wrong while mapping JSON");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Something went wrong with the file reader");
			e.printStackTrace();
		} finally {
		
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				System.out.println("Problem occured while closing buffer");
				e.printStackTrace();
			}
		}
	}
	
	public static void printMusicLibrary(MusicLibrary musicLibrary) {
		try {
			System.out.println(musicLibrary.toString());
			printTrackMusicians(musicLibrary.getTracks());
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed all the parameters");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
	}
	
	public static void printTrackMusicians(List<Track> tracks) {
		try {
			for (Track t : tracks) {
				System.out.println(t.toString());
				System.out.println(t.getArtist().toString());
				if (t.getGuest() != null) {
					System.out.println("Guest Artist: " + t.getGuest().getName());
					System.out.println("Guest " + t.getGuest().toString());
				}
				System.out.println("");
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
	}
	
	public static void printAlbums(List<Album> albums) {
		try {
			for (Album a : albums) {
				System.out.println(a.toString());	
				System.out.println("");		
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
	}

	public static void printCompilationAlbum(CompilationAlbum compAlbum) {
		try {
			System.out.println(compAlbum.toString());
			for (CompilationTrack compTrack : compAlbum.getCompilationTracks()) {
				System.out.println(compTrack.toString());
			}
		} catch (NullPointerException ex) {
			System.out.println("Please make sure you passed the musicians");
			ex.printStackTrace();
		} catch (Exception ex) {
			System.out.println("Something went wrong while processing");
			ex.printStackTrace();
		}
	}
}
