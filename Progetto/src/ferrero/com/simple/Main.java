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
    
    // Cane dog1 = new Cane(nome,eta,razza);

		// System.out.println("La classe dell'oggetto 'dog' è: "+dog1.getClass());
		// System.out.println("L'hashCode è: "+ dog1.hashCode());
		// System.out.println("La stringa di output è: "+ dog1.toString());
		// dog1.makeNoise();

		Cane dog2 = new Cane();
		System.out.println("\nIl cane dog2 è: "+ dog2.toString());


		Lion leone1 = new Lion("Mufasa","35");
		System.out.println("\n"+leone1.toString());
	}
	
}
