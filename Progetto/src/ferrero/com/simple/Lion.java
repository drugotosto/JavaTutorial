package ferrero.com.simple;

public class Lion extends Animale {
  

  public Lion () {
		// Viene richiamato il costruttore di Animale che recupera almeno la specie di animale "Leone"
  	super("Leone");
  }

  public Lion(String nome, String eta) {
		// Viene richiamato il costruttore di Animale che recupera tutte le info dell'animale generico più il fatto che sia della specie "Lion"
		super(nome,eta,"Leone");
	}

  public String makeNoise() {
  	return "ruggisce!";
  }

}
