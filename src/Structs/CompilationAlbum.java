package Structs;

import java.util.ArrayList;
import java.util.List;

public class CompilationAlbum {
	private String title;
	private Artist artist;
	private List<Track> tracks;

	public CompilationAlbum() { }

	public CompilationAlbum(String title) {
		this.title = title;
		this.tracks = new ArrayList<Track>();
	}
}
