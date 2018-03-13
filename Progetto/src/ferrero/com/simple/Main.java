package ferrero.com.simple;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
	  
    System.out.print("Inserisci il nome del cane: ");
    String nome = sc.nextLine();
    System.out.print("Inserisci l'età del cane: ");
    String eta = sc.nextLine();
    System.out.print("Inserisci la razza del cane: ");
    String razza = sc.nextLine();
    
    Cane dog1 = new Cane(nome,eta,razza);

		// System.out.println("La classe dell'oggetto 'dog' è: "+dog1.getClass());
		// System.out.println("L'hashCode è: "+ dog1.hashCode());
		// System.out.println("La stringa di output è: "+ dog1.toString());
		// dog1.makeNoise();

		Cane dog2 = new Cane();
		System.out.println("\nIl cane dog2 è: "+ dog2.toString());


		Lion leone1 = new Lion("Mufasa","35");
		System.out.println("\n"+leone1.toString());

		// Utilizzo della sola e unica istanza appartenete alla classe "CustomMath" = SINGLETON PATTERN 
		Zoo zoo = Zoo.setInstance(new ArrayList<>(Arrays.asList(dog1,leone1)));
		System.out.println("\nL'istanza ritorna è: "+ zoo);
		System.out.println("L'istanza della classe appena creata è: "+ Zoo.getInstance());
		System.out.println("Lo zoo è formato da: "+ zoo.getAnimali());
		// Aggiunta di un cane allo Zoo
		zoo.addAnimale(dog2);
		System.out.println("Lo zoo è formato da: "+ zoo.getAnimali());
	}

}
