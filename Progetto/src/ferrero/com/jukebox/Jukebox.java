package ferrero.com.jukebox;

import java.util.*;
import java.io.*;

public class Jukebox {
		
	// campo che contiene la lista delle canzoni recuperate da file
	ArrayList<Song> songList = new ArrayList<Song>();
  
  public static void main(String[] args) {
		new Jukebox().go();
	}

	public void go() {
		getSongs();
		System.out.println("\nLa lista di canzoni recuperate è: "+ songList);
		// L'ordinamento fatto da Collections.sort(...) sfrutta il metodo "compareTo(...)" presente all'interno dell'interfaccia "Comparable" implementata dalla classe "Song"
		Collections.sort(songList);
		System.out.println("\nLa lista di canzoni ordinata per titolo è: "+ songList);
		// L'ordinamento fatto da Collections.sort(...) sfrutta il metodo "compare(...)" definito dalla classe "ArtistComparator" che implementa l'interfaccia "Comparator"
		Collections.sort(songList,new ArtistComparator());
		System.out.println("\nLa lista di canzoni ordinata per artista è: "+ songList);
		
		HashSet<Song> songSet = new HashSet<Song>(songList);
		// songSet.addAll(songList)
		System.out.println("\nL'insieme delle canzoni recuperate che formano il 'SET' è: ");
		for (Song song : songSet) {
			System.out.println("Artista:" + song.toString());
		}

		System.out.println("\nL'insieme delle canzoni recuperate che formano il 'SET' ordinato secondo i titoli è: ");
		TreeSet<Song> songOrderSet = new TreeSet<Song>(new TitleComparator());
		songOrderSet.addAll(songList); 
		for (Song song : songOrderSet) {
			System.out.println("Canzone:" + song.getTitle());
		}

		System.out.println("\nL'insieme delle canzoni recuperate che formano il 'SET' ordinato secondo il rating è: ");
		songOrderSet = new TreeSet<Song>(new RatingComparator());
		songOrderSet.addAll(songList); 
		for (Song song : songOrderSet) {
			System.out.println("Canzone:" + song.getTitle()+ " - rating: "+song.getRating());
		}

		HashMap<String,String> mapSong = new HashMap<String,String>();
		for (Song song: songOrderSet) {
			mapSong.put(song.getTitle(),song.getRating());
		}

		System.out.println("\nL'entrySet (disordinato) recuperato dalla 'MAP' appena creata: "+ mapSong.entrySet()+"\n");

		for (Map.Entry<String,String> entry : mapSong.entrySet()) {
			System.out.println("Chiave: "+entry.getKey()+" Valore: "+entry.getValue());
		}
	}

	// Si è deciso si fare il "duck" della possibile eccezione lanciata da 'readLine()'
	public void getSongs() {
		// Utilizzo del "try-with-resources" di Java 7 per fare in modo che la risorsa BufferedReader (che implementa 'AutoCloseable') venga chiusa a prescindere che il metodo 'readLine()' lanci o meno l'eccezione.
		try(BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\drugo\\SublimeTextProjects\\JavaTutorial\\Progetto\\src\\ferrero\\com\\jukebox\\songList.txt"))) {
			String line=null;
			// La chiamata del metodo 'readLine()' può generare l'eccezione 'IOexception'
			while((line=reader.readLine()) != null) {
				addSongs(line);
			} 
		} catch(IOException ex) {
			System.err.format("IOException %s%n", ex);
		}
	}

	public void addSongs(String lineToParse) {
		String[] tokens =lineToParse.split("/");
		songList.add(new Song(tokens));
	}
}
