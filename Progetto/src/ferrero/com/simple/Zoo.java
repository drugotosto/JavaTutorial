package ferrero.com.simple;

import ferrero.com.annotations.*;

import java.util.List;
import java.util.Collections;

@MyClassInfoAnnotation(
	date="13/03/2018",
	comment="	Classe che implementa il SINGLETON PATTERN. Tramite l'utilizzo combinato delle parole chiave 'static' e 'private' viene definita una classe che permette la creazione di una sola istanza/oggetto 'Zoo' per l'intera applicazione e che attraverso gli altri metodi non statici permette di implementare la logica della sudetta classe"
)
public class Zoo {
	
	private static Zoo instance = new Zoo();
	private List<Animale> animali;

	private Zoo() {
	}

	public List<Animale> getAnimali() {
		return instance.animali;
	}

	// Una volta inizializzato l'unica istanza "Zoo" con la lista passata l'oggetto appena creato viene restituito
	public static Zoo setInstance(List<Animale> animali) {
		instance.animali = animali;
		return instance;
	}

	public static Zoo getInstance() {
		return instance;
	}

	public void addAnimale(Animale animale) {
		instance.animali.add(animale);
	}

	// Utilizzo della variabile di statica "ageComparator" (rappresenta una istanza di Comparator) per ordinare la lista di animali tramite "Collactions.sort" secondo età
	public List<Animale> sortAnimalByAge() {
		Collections.sort(instance.animali,Animale.ageComparator);
		return instance.animali;
	}

	// Utilizzo della variabile di statica "ageComparator" (rappresenta una istanza di Comparator) per ordinare la lista di animali tramite "Collactions.sort" secondo nome
	public List<Animale> sortAnimalByName() {
		Collections.sort(instance.animali,Animale.nameComparator);
		return instance.animali;
	}
}
	