package ferrero.com.simple;

public class Lion extends Animale {
    
  public void makeNoise() {
  	System.out.println("Il leone ruggisce!");
  }

  @Override
	public String toString() {
		return "Il leone '"+ getNome() +"' ha "+ getAnni()+" anni";
	}

}
