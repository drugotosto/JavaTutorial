package ferrero.com.simple;

import java.util.Objects;

class Cane extends Animale {
	
	private String razza="Razza di Default";
	
	
	public Cane() {
	}

	public Cane(String nome, String eta, String razza) {
		super(nome,eta);
		if (!razza.isEmpty() && razza!=null) {
			this.razza=razza;
		}
	}

	public String getRazza() {
		return this.razza;
	}

	public void makeNoise() {
		System.out.println("Il cane "+this.getNome() +" sta abbaiando!");
	}


	// Override personalizzato del metodo (non statico) "toString()"" della clase "Object" asse "Objects"
	@Override
	public String toString() {
		return "Il cane '"+ getNome() +"' ha "+ getAnni() +" anni  ed è di razza '"+ razza;
	}

	/*
		In generale per confrontare due oggetti di una data classe è buona norma fare l'override dei metodi "equals" e "hashCode" della classe "Object"
	*/
	// Override del metodo (non statico) "equals()"" della clase "Object" utilizzando il metodo statico "equals()" della classe "Objects"
	@Override
	public boolean equals(Object o) {

		if (o==this) return true;

		Cane caneInput= (Cane) o;
		return getAnni()== caneInput.getAnni() &&
						Objects.equals(getNome(), caneInput.getNome()) &&
						Objects.equals(getRazza(), caneInput.getRazza());
	}

	// Override del metodo (non statico) "hashCode()" della clase "Object" utilizzando il metodo statico "hash()" della classe "Objects"
	@Override
	public int hashCode() {
		return Objects.hash(getNome(),getAnni(), razza);
	}

}
