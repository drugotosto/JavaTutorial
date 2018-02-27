package ferrero.com.simple;

import ferrero.com.annotations.*;

@MyClassInfoAnnotation (
	date="26/02/2018",
	comment="SuperClasse Astratta per le diverse sottocategorie di Animali"
)
abstract class Animale {
	
	private String nome= "Nome Animale di Default";
	private int anni=1;

	public Animale(){
	}

	public Animale (String nome, String eta) {
		if (!nome.isEmpty() && nome!=null) {
			this.nome=nome;
		}
		if (!eta.isEmpty() && eta!=null) {
			this.anni=Integer.parseInt(eta);
		}
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

	public void eat() {
		System.out.print("Animale sta mangiando!");
	}

	public abstract void makeNoise();

}
