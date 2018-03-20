package ferrero.com.simple;

import java.util.Objects;

class Cane extends Animale implements Pet {
	
	private String razza;
	
	public Cane() {
		// Viene richiamato il costruttore di Animale che recupera almeno la specie di animale "Cane"
		super("Cane");
		razza="Razza di Default";
	}

	public Cane(String nome, String eta, String razza) {
		// Viene richiamato il costruttore di Animale che recupera tutte le info dell'animale generico più il fatto che sia della specie CANE
		super(nome,eta,"Cane");
		System.out.println("Chiamata al costruttore di Cane!");
		if (!razza.isEmpty() && razza!=null) {
			this.razza=razza;
		}
	}

	public String getRazza() {
		return this.razza;
	}

	public String makeNoise() {
		return "abbaia!";
	}

	// Override personalizzato del metodo (non statico) "toString()"" della clase "Object" 
	@Override
	public String toString() {
		return "Il "+ getSpecie() +" di nome '"+ getNome() +"' ha "+ getAnni() +" anni è di razza '"+ razza+"' e "+ makeNoise();
	}

	/*
		In generale per confrontare due oggetti di una data classe è buona norma fare l'override dei metodi "equals" e "hashCode" della classe "Object"
	*/
	// Override del metodo (non statico) "equals()"" della clase "Object" utilizzando il metodo statico "equals()" della utility class "Objects"
	@Override
	public boolean equals(Object o) {

		// Controllo se le due variabili puntano allo stesso oggetto sulla HEAP (concetto di uguaglianza standard)
		if (o==this) return true;

		// Ridefinisco il concetto di uguaglianza tra "Cani"
		Cane caneInput= (Cane) o;
		return getAnni()== caneInput.getAnni() &&
						Objects.equals(getNome(), caneInput.getNome()) &&
						Objects.equals(getRazza(), caneInput.getRazza());
	}

	// Override del metodo (non statico) "hashCode()" della clase "Object" utilizzando il metodo statico "hash()" della utility class "Objects"
	@Override
	public int hashCode() {
		return Objects.hash(getNome(),getAnni(), razza, this.getSpecie());
	}

	// Implementazione dei metodi che fanno parte dell'interfaccia "Pet"
	public void beFriendly() {
		System.out.println("Il Pet in quetione ovvero '"+this.getNome()+"' è un Pet amichevole!");	
	}

	public void play() {	
		System.out.println("Il Pet in quetione ovvero '"+this.getNome()+"' sta giocando!");	
	}

}
