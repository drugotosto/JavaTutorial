package ferrero.com.jukebox;

import java.util.*;
import java.io.*;

public class Jukebox1 {
		
		// campo che contiene la lista delle canzoni recuperate da file
		ArrayList<Song> songList = new ArrayList<Song>();
  
  public static void main(String[] args) {
		new Jukebox1().go();
	}	public void go() {
		getSongs();
		System.out.println("La lista di canzoni recuperate è: "+ songList);
		// L'ordinamento fatto da Collections.sort(...) sfrutta il metodo "compareTo(...)" presente all'interno dell'interfaccia "Comparable" implementata dalla classe "Song"
		Collections.sort(songList);
		System.out.println("La lista di canzoni ordinata per titolo è: "+ songList);
		// L'ordinamento fatto da Collections.sort(...) sfrutta il metodo "compare(...)" definito dalla classe "ArtistComparator" che implementa l'interfaccia "Comparator"
		Collections.sort(songList,new ArtistComparator());
		System.out.println("La lista di canzoni ordinata per artista è: "+ songList);

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
