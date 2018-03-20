package ferrero.com.simple;

import ferrero.com.annotations.*;
import java.util.Comparator;

@MyClassInfoAnnotation (
	date="26/02/2018",
	comment="SuperClasse Astratta per le diverse sottocategorie di Animali"
)
abstract class Animale {
	
	private String nome;
	private int anni;
	private String specie; 


	public Animale(String specie) {
		// Vado a richiamare il costruttore sottostante passando i valori di default per tutti i campi tranne che per la specie
		this("Nome Animale di Default","1", specie);	
	}

	/*
		Costruttore che implementa il "vero lavoro" di tutta la classe (richiamato da tutti gli altri costruttori)
		quando occorre instanziare i nuovi oggetti
	*/
	public Animale (String nome, String eta, String specie) {
		System.out.println("Chiamata al costruttore di Animale!");
		if (!nome.isEmpty() && nome!=null) {
			this.nome=nome;
		}
		if (!eta.isEmpty() && eta!=null) {
			this.anni=Integer.parseInt(eta);
		}
		this.specie=specie;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome=nome;
	}

	public int getAnni() {
		return this.anni;
	}

	public void setAnni(int anni) {
		this.anni=anni;
	}

	public String getSpecie() {
		return this.specie;
	}

	public void setSpecie(String specie) {
		this.specie=specie;
	}

	/* 
		Definizione di una variabile statica (una per l'intera classe) attraverso la definizione di
		una classe anonima (senza nome) che implementa "Comparator" e che servirà per garantire un
		ordinamento degli oggetti "Animale" attraverso il loro nome.
	*/
	public static Comparator<Animale> nameComparator = new Comparator<Animale>() {
		@Override
		public int compare(Animale animale, Animale otherAnimale) {
			return animale.getNome().compareTo(otherAnimale.getNome());
		}
	};

	/* 
		Definizione di una variabile statica (una per l'intera classe) attraverso la definizione di
		una classe anonima (senza nome) che implementa "Comparator" e che servirà per garantire un
		ordinamento degli oggetti "Animale" attraverso la loro età.
	*/
	public static Comparator<Animale> ageComparator = new Comparator<Animale>() {
		@Override
		public int compare(Animale animale, Animale otherAnimale) {
			return (animale.getAnni()<otherAnimale.getAnni() ? -1 :
				     (animale.getAnni()>otherAnimale.getAnni() ? 1 : 0));
			// return new Integer(animale.getAnni()).compareTo(new Integer(otherAnimale.getAnni()));
		}
	};

	// Override personalizzato del metodo (non statico) "toString()"" della clase "Object" asse "Objects"
	@Override
	public String toString() {
		return "Il "+ getSpecie() +" '"+ getNome() +"' ha "+ getAnni() +" anni e "+ makeNoise();
	}

	public void eat() {
		System.out.print("Animale sta mangiando!");
	}

	public abstract String makeNoise();

}
