package ferrero.com.simple;

import ferrero.com.annotations.*;

import java.util.List;
@MyClassInfoAnnotation(
	date="13/03/2018",
	comment="	Classe che implementa il SINGLETON PATTERN. Tramite l'utilizzo combinato delle parole chiave 'static' e 'private' viene definita una classe che permette la creazione di una sola istanza/oggetto 'Zoo' per l'intera applicazione e che attraverso gli altri metodi non statici permette di implementare la logica della sudetta classe"
)
public class Zoo {
	
	private static Zoo instance = new Zoo();
	private List<Animale> animali;

	private Zoo() {
	}

	// Una volta inizializzato l'unica istanza "Zoo" con la lista passata l'oggetto appena creato viene restituito
	public static Zoo setInstance(List<Animale> animali) {
		instance.animali = animali;
		return instance;
	}

	public static Zoo getInstance() {
		return instance;
	}

	public List<Animale> getAnimali() {
		return instance.animali;
	}

	public void addAnimale(Animale animale) {
		instance.animali.add(animale);
	}

}
