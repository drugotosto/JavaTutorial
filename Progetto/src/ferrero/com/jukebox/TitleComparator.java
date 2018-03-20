package ferrero.com.jukebox;

import java.util.*;

public class TitleComparator implements Comparator<Song> {
	
	@Override
	public int compare(Song song, Song otherSong) {
		return song.getTitle().compareTo(otherSong.getTitle());
	}
    
}