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
    
    Cane dog1 = new Cane(nome,eta,razza);

		// dog.makeNoise();
		// dog.makeNoise();
		System.out.println("La classe dell'oggetto 'dog' è: "+dog1.getClass());
		System.out.println("L'hashCode è: "+ dog1.hashCode());
		System.out.println("La stringa di output è: "+ dog1.toString());

		Cane dog2 = new Cane();
		System.out.println("Il cane dog2 è: "+ dog2.toString());
	}
	
}
