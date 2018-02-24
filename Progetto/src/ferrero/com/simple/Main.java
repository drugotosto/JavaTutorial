package ferrero.com.simple;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	  
	  System.out.print("Inserisci il nome del cane: ");
    String nome = sc.nextLine();
    System.out.print("Inserisci l'età del cane: ");
    String eta = sc.nextLine();
    System.out.print("Inserisci la razza del cane: ");
    String razza = sc.nextLine();
    
    Cane dog = new Cane(nome,eta,razza);

		System.out.println("Il cane si chiama ': "+ dog.getNome() +"' di eta: "+ dog.getAnni() +" e di razza: "+ dog.getRazza());
		dog.makeNoise();
	}
	
}
