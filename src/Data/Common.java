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
import Structs.Musician;
import Structs.Track;

public abstract class Common {
	
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
	
	public static List<Musician> readMusician() {
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
	
	public static List<Band> readBand() {
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
	
	public static List<Track> readTrack() {
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
	
	public static List<Album> readAlbum() {
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
}
