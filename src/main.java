
import java.io.FileReader;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Structs.Track;
import Structs.Artist;
import Structs.Band;
import Structs.Musician;

import Data.FileProvider;

public class main {

	public main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

		List<Musician> musicians = FileProvider.readMusician();
		List<Band> bands = FileProvider.readBand();
		List<Track> tracks = FileProvider.readTrack();
		
		//Create bands from musicians
		for (Musician m : musicians) {
			for (Band b : bands) { 
				if (m.getBandID() == b.getID()) {
					b.addMemeber(m);
					break;
				}
			}
			
			System.out.println("ID: " + m.getID() + ", Name: " + m.getName());
		}

		
		for (Track t : tracks) {
			System.out.println("Musicans for track: " + t.getTitle());
			Artist a = t.getArtist();
			if (a instanceof Band) {
				Band b = (Band) a;
				for (Musician m : b.getMembers()) {
					System.out.println(m.getName());
				}
			} else if (a instanceof Musician) {
				Musician m = (Musician) a;
				System.out.println(m.getName());
			}
			System.out.println("");
		}*/
	}

}
