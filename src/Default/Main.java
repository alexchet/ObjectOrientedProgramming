package Default;

import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Structs.Track;
import Structs.Artist;
import Structs.Band;
import Structs.Musician;

public class Main {

	public Main() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Musician musician1 = new Musician("David Bowie");
		Musician musician2 = new Musician("Nick Mason");
		Musician musician3 = new Musician("Roger Waters");
		Musician musician4 = new Musician("Richard Wright");
		Musician musician5 = new Musician("Syd Barrett");
		Musician musician6 = new Musician("David Gilmour");
		
		List<Musician> pinkFloydMembers = new ArrayList<Musician>();
		pinkFloydMembers.add(musician2);
		pinkFloydMembers.add(musician3);
		pinkFloydMembers.add(musician4);
		pinkFloydMembers.add(musician5);
		pinkFloydMembers.add(musician6);
		Band band1 = new Band(pinkFloydMembers);

		Track track1 = new Track("Another Brick in the Wall Part 1", band1, LocalDate.of(1979, 11, 30),
				Duration.parse("PT3M21S"), 0, "", 2.00, null, 0);
		Track track2 = new Track("Space Oddity", musician1, LocalDate.of(1969, 07, 11),
				Duration.parse("PT5M15S"), 0, "", 2.00, null, 0);
		
		List<Track> tracks = new ArrayList<Track>();
		tracks.add(track1);
		tracks.add(track2);
		
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
		}
	}

}
