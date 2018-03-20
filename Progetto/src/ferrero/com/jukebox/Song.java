package ferrero.com.jukebox;

import java.util.Objects;

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
  	return "La canzone '"+ title +"' cantata da '"+artist+"' ha un rating di "+rating;
  }

  public String getTitle() {
  	return title;
  }

  public String getArtist() {
    return artist;
  }

  public String getRating() {
  	return rating;
  }

  @Override
  public int compareTo(Song song) {
  	return title.compareTo(song.getTitle());
  }

  @Override
  public int hashCode() {
    return Objects.hash(getTitle(),getArtist(),getRating());
  }

  @Override
  public boolean equals(Object o) {
    Song otherSong = (Song) o;
    return (getTitle().equals(otherSong.getTitle()) && getArtist().equals(otherSong.getArtist()) && getRating().equals(otherSong.getRating()));
  }

}

