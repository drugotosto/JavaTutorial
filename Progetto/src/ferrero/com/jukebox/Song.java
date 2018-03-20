package ferrero.com.jukebox;

public class Song  implements Comparable<Song> {
  private String title;
  private String artist;
  private String rating;

  public Song(String[] fields) { 
  	this.artist=fields[0];
  	this.title=fields[1];
  	this.rating=fields[2];
  }

  public String toString() {
  	return this.title;
  }

  public String getTitle() {
  	return title;
  }

  public String getArtist() {
  	return artist;
  }

  @Override
  public int compareTo(Song song) {
  	return title.compareTo(song.getTitle());
  }

}

