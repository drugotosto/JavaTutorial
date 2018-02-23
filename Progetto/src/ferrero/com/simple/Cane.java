package ferrero.com.simple;

class Cane extends Animale {
	
	private String razza="Razza di Default";
	
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
		System.out.println("Cane sta facendo rumore!");
	}

}
