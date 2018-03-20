package ferrero.com.jukebox;

import java.util.*;

public class ArtistComparator implements Comparator<Song> {
	
	@Override
	public int compare(Song song, Song otherSong) {
		return song.getArtist().compareTo(otherSong.getArtist());
	}
    
}
