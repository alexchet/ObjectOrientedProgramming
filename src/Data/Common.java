package Data;

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

import Structs.Album;
import Structs.Band;
import Structs.CompilationAlbum;
import Structs.CompilationTrack;
import Structs.MusicLibrary;
import Structs.Musician;
import Structs.Track;

public abstract class Common {

	//Size are in KiloBytes
	public static final int CD_SIZE = 716800;
	public static final int DVD_SIZE = 4928307;
	
	public static List<List<Track>> bestFit(List<Track> tracks, int diskSize) {
		List<List<Track>> bins = new ArrayList<List<Track>>();

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
		
		return bins;
	}
	
	private static double getSizeBin(List<Track> bin) {
		double totalSize = 0;
		
		for (Track t : bin) {
			totalSize += t.getSize();
		}
		return totalSize;
	}
	
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static List<Band> loadBands(List<Musician> musicians) {
		List<Band> bands = readBand();
		
		//Create bands from musicians
		for (Musician m : musicians) {
			for (Band b : bands) { 
				if (m.getBandID() == b.getID()) {
					b.addMember(m);
					break;
				}
			}
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static List<Track> loadTracks(List<Band> bands, List<Musician> musicians) {
		List<Track> tracks = readTrack();
		
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
	public static List<Album> loadAlbums(List<Track> tracks, List<Band> bands, List<Musician> musicians) {
		List<Album> albums = readAlbum();
		
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
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return null;
	}
	
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
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {	
			e.printStackTrace();
		} finally {
		
			try {
				if (buffer != null) {
					buffer.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void printMusicLibrary(MusicLibrary musicLibrary) {
		System.out.println(musicLibrary.toString());
		printTrackMusicians(musicLibrary.getTracks());
	}
	
	public static void printTrackMusicians(List<Track> tracks) {
		for (Track t : tracks) {
			System.out.println(t.toString());
			System.out.println(t.getArtist().toString());
			if (t.getGuest() != null) {
				System.out.println("Guest Artist: " + t.getGuest().getName());
				System.out.println("Guest " + t.getGuest().toString());
			}
			System.out.println("");
		}
	}
	
	public static void printAlbums(List<Album> albums) {
		for (Album a : albums) {
			System.out.println(a.toString());	
			System.out.println("");		
		}
	}

	public static void printCompilationAlbum(CompilationAlbum compAlbum) {
		System.out.println(compAlbum.toString());
		for (CompilationTrack compTrack : compAlbum.getCompilationTracks()) {
			System.out.println(compTrack.toString());
		}
	}
}
