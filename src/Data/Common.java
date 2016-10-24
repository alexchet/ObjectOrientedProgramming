package Data;

import java.util.ArrayList;
import java.util.List;

import Structs.Track;

public abstract class Common {
	
	public static List<List<Track>> bestFit(List<Track> tracks, int diskSize) {
		List<List<Track>> bins = new ArrayList<List<Track>>();
		
		for (Track t : tracks) {
			if (bins.size() == 0) {
				bins.add(new ArrayList<Track>());
			}
			
			for (List<Track> inputBin : bins) {
				if (getSizeBin(inputBin) + t.getSize() > diskSize) {
					inputBin.add(t);
					break;
				}
			}
			
			//Means it didn't break
			List<Track> newBin = new ArrayList<Track>();
			newBin.add(t);
			bins.add(newBin);
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
}
