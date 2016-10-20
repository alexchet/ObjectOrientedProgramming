package Default;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
		
	}

}
