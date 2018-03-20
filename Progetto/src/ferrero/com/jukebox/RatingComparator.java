package ferrero.com.jukebox;

import java.util.*;

public class RatingComparator implements Comparator<Song> {
	
	@Override
	public int compare(Song song, Song otherSong) {
		return song.getRating().compareTo(otherSong.getRating());
	}
    
}
