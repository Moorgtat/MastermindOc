package com.mastermind.oc;

import java.util.Random;
import java.util.Scanner;

public class Mastermind {
	
	private static int BIEN_PLACE;
	private static int PRESENT;
	private static int BIEN_PLACE_JOUEUR;
	private static int PRESENT_JOUEUR;
	private static int BIEN_PLACE_ORDINATEUR;
	private static int PRESENT_ORDINATEUR;
	
	static void Attaque() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("***********MASTERMIND MODE ATTAQUE***********\n"
		+"Trouve la bonne combinaison de " + Parametre.getMAX_CHIFF()+ 
		" chiffres entre 0 et " + Parametre.getMAX_CHIFF() + ".\n"
		+"Attention, tu n'as droit qu'� " + Parametre.getMAX_ESSAIS() + " essais");

		int count = 0;
		
		int[] CombiOrdi = new int[Parametre.getNUM_TOTAL_CHIFF()];

		Random r = new Random();

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			CombiOrdi[i] = r.nextInt(Parametre.getMAX_CHIFF() + 1);
		}

		int[] CombiJoueur = new int[Parametre.getNUM_TOTAL_CHIFF()];

		boolean victoire = false;

		do {
			System.out.println("\nEssai n� " + (count + 1) + "/" + Parametre.getMAX_ESSAIS()
					+ " :");
			int nombreSaisi = sc.nextInt();

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++)
				CombiJoueur[i] = (int) (nombreSaisi / (Math.pow(10,
						(Parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++)
				System.out.print(CombiJoueur[i] + " ");

			System.out.println();

			BIEN_PLACE = 0;
			PRESENT = 0;       
            
			boolean[] BIEN_PLACE_Test = new boolean[Parametre.getNUM_TOTAL_CHIFF()];
			boolean[] PRESENT_Test = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {

				if (CombiJoueur[i] == CombiOrdi[i]) {
					BIEN_PLACE++;
					BIEN_PLACE_Test[i] = true;
					PRESENT_Test[i] = true;
			        	}
			}
			        
			    if (BIEN_PLACE == Parametre.getNUM_TOTAL_CHIFF()) {
				victoire = true;
			}

			else {
				for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
					for (int j = 0; j < Parametre.getNUM_TOTAL_CHIFF(); j++) {
						if (CombiJoueur[i] == CombiOrdi[j] 
								&& !BIEN_PLACE_Test[i] && !PRESENT_Test[j] ) {
							PRESENT++;
							BIEN_PLACE_Test[i] = true;
							PRESENT_Test[i] = true;
						}
					}
				}
			}

			if (BIEN_PLACE >= 0)
				System.out.println(+BIEN_PLACE + " de bien plac�");

			if (PRESENT >= 0)
				System.out.println(+PRESENT + " pr�sent mais mal plac�");

			count++;

		} while (!victoire && count < Parametre.getMAX_ESSAIS());
		if (victoire) {
			System.out.println();
			System.out.println("Bravo tu as gagn� en " + count + " coups!");

		} else {
			System.out.println();
			System.out.println("Tu as �puis� tes " + Parametre.getMAX_ESSAIS()
					+ " essais, l'ordinateur a gagn�! La solution �tait "
					+ CombiOrdi[0] + " " + CombiOrdi[1] + " " + CombiOrdi[2]
					+ " " + CombiOrdi[3] + " !");

		}
	}
		
	
	static void Defense() {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("***********MASTERMIND MODE DEFENSE***********\n"
		  +"Entre une combinaison de " + Parametre.getNUM_TOTAL_CHIFF()
		  + " chiffres entre 0 et " + Parametre.getMAX_CHIFF() + ".\n"
		  +"L'ordinateur aura " + Parametre.getMAX_ESSAIS()+ " essais " 
		  +"pour trouver ta combinaison et te battre.");
		System.out.println();
		System.out.println("Entre ta combinaison secr�te: ");

		int count = 0;

		int[] TirageJoueur = new int[Parametre.getNUM_TOTAL_CHIFF()];

		boolean[] numCorrespondant = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

		int nombresSaisi = sc.nextInt();

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			TirageJoueur[i] = (int) (nombresSaisi / (Math.pow(10,
					(Parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
			numCorrespondant[i] = false;
		}

		Random r = new Random();

		int[] RechercheOrdi = new int[Parametre.getNUM_TOTAL_CHIFF()];

		boolean victoire = false;

		do {
			System.out.println("\nEssai n� " + (count + 1) + "/" + Parametre.getMAX_ESSAIS()
					+ " :");

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (!numCorrespondant[i]) {
					RechercheOrdi[i] = r.nextInt(Parametre.getMAX_CHIFF() + 1);
				}

			}

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				System.out.print(RechercheOrdi[i] + " ");
			}

			System.out.println();
			BIEN_PLACE = 0;
			PRESENT = 0;

			boolean[] BIEN_PLACE_Test = new boolean[Parametre.getNUM_TOTAL_CHIFF()];
			boolean[] PRESENT_Test = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (TirageJoueur[i] == RechercheOrdi[i]) {
					BIEN_PLACE++;
					BIEN_PLACE_Test[i] = true;
					PRESENT_Test[i] = true;
					numCorrespondant[i] = true;
				}
			}
			if (BIEN_PLACE == Parametre.getNUM_TOTAL_CHIFF()) {
				victoire = true;
			}

			else {
				for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
					for (int j = 0; j < Parametre.getNUM_TOTAL_CHIFF(); j++) {
						if (TirageJoueur[i] == RechercheOrdi[j]
								&& !BIEN_PLACE_Test[i] && !PRESENT_Test[j]) {
							PRESENT++;
							BIEN_PLACE_Test[i] = true;
							PRESENT_Test[i] = true;
						}
					}
				}
			}

			if (BIEN_PLACE >= 0)
				System.out.println(+BIEN_PLACE + " de bien plac�");

			if (PRESENT >= 0)
				System.out.println(+PRESENT + " pr�sent mais mal plac�");

			count++;

		} while (!victoire && count < Parametre.getMAX_ESSAIS());
		if (victoire) {
			System.out.println();
			System.out.println("L'ordinateur a gagn� en " + count
					+ " coups, tu as perdu!");
		} else {
			System.out.println();
			System.out.println("Bravo, l'ordinateur a epuis� ses " + Parametre.getMAX_ESSAIS()
					+ " essais, c'est gagn�!");
		}
	}
	
	static void Duel() {int count = 0;
	
	Scanner sc = new Scanner(System.in);
	
	System.out.println("***********MASTERMIND MODE DUEL***********\n"
	+"Trouve la bonne combinaison de " +Parametre.getNUM_TOTAL_CHIFF()+ " " 
	+"chiffres entre 0 et "+Parametre.getMAX_CHIFF() +"\n" 
	+"avant l'ordinateur! Commence par entrer ta combinaison \n"
	+"secr�te puis trouve celle de l'ordinateur.\n"
	+"Attention, tu n'as droit qu'� " +Parametre.getMAX_ESSAIS()+ " essais.");
	System.out.println();
	System.out.println("Entre ta combinaison secr�te: ");

	int[] CombiOrdi = new int[Parametre.getNUM_TOTAL_CHIFF()];
	
    Random r = new Random();
    
	for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
		CombiOrdi[i] = r.nextInt(Parametre.getMAX_CHIFF() + 1);
	}

	boolean[] numCorrespondantOrdinateur = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

	int[] CombiJoueur = new int[Parametre.getNUM_TOTAL_CHIFF()];

	int nombresSaisi = sc.nextInt();

	for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
		CombiJoueur[i] = (int) (nombresSaisi / (Math.pow(10,
				(Parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
	}

	boolean victoireJoueur = false;
	boolean victoireOrdinateur = false;
	
	do {
		System.out.println("\nRecherche Joueur essai n� " + (count + 1)
				+ "/" + Parametre.getMAX_ESSAIS() + " :");
		
        int nombreSaisi2 = sc.nextInt();
        
		int[] RechercheJoueur = new int[Parametre.getNUM_TOTAL_CHIFF()];	
		
		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			RechercheJoueur[i] = (int) (nombreSaisi2 / (Math.pow(10,
					(Parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
		}
		
		BIEN_PLACE_JOUEUR = 0;
		PRESENT_JOUEUR = 0;       
        
		boolean[] BIEN_PLACE_J = new boolean[Parametre.getNUM_TOTAL_CHIFF()];
		boolean[] PRESENT_J = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {

			if (RechercheJoueur[i] == CombiOrdi[i]) {
				BIEN_PLACE_JOUEUR++;
				BIEN_PLACE_J[i] = true;
				PRESENT_J[i] = true;
		        	}
		}
		        
		    if (BIEN_PLACE_JOUEUR == Parametre.getNUM_TOTAL_CHIFF()) {
			victoireJoueur = true;
		}

		else {
			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				for (int j = 0; j < Parametre.getNUM_TOTAL_CHIFF(); j++) {
					if (RechercheJoueur[i] == CombiOrdi[j] 
							&& !BIEN_PLACE_J[i] && !PRESENT_J[j] ) {
						PRESENT_JOUEUR++;
						BIEN_PLACE_J[i] = true;
						PRESENT_J[i] = true;
					}
				}
			}
		}

		if (BIEN_PLACE_JOUEUR >= 0)
			System.out.println(+BIEN_PLACE_JOUEUR + " de bien plac�");

		if (PRESENT_JOUEUR >= 0)
			System.out.println(+PRESENT_JOUEUR + " pr�sent mais mal plac�");
		
		System.out.println();
		
		System.out.println("Recherche Ordinateur essai n� " + (count + 1)
				+ "/" + Parametre.getMAX_ESSAIS() + " :");

		int[] RechercheOrdi = new int[Parametre.getNUM_TOTAL_CHIFF()];

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			if (!numCorrespondantOrdinateur[i]) {
				RechercheOrdi[i] = r.nextInt(Parametre.getMAX_CHIFF() + 1);
			}
		}

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			System.out.print(RechercheOrdi[i] + " ");
		}

		System.out.println();

		BIEN_PLACE_ORDINATEUR = 0;
		PRESENT_ORDINATEUR = 0;       
        
		boolean[] BIEN_PLACE_O = new boolean[Parametre.getNUM_TOTAL_CHIFF()];
		boolean[] PRESENT_O = new boolean[Parametre.getNUM_TOTAL_CHIFF()];

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			if (RechercheOrdi[i] == CombiJoueur[i]) {
				BIEN_PLACE_ORDINATEUR++;
				BIEN_PLACE_O[i] = true;
				PRESENT_O[i] = true;
				numCorrespondantOrdinateur[i] = true;
		        	}
		}
		if (BIEN_PLACE_ORDINATEUR == Parametre.getNUM_TOTAL_CHIFF()) {
			victoireOrdinateur = true;
		}

		else {
			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				for (int j = 0; j < Parametre.getNUM_TOTAL_CHIFF(); j++) {
					if (RechercheOrdi[i] == CombiJoueur[j]
							&& !BIEN_PLACE_O[i] && !PRESENT_O[j]) {
						PRESENT_ORDINATEUR++;
						BIEN_PLACE_O[i] = true;
						PRESENT_O[i] = true;
					}
				}
			}
		}

		if (BIEN_PLACE_ORDINATEUR >= 0)
			System.out.println(+BIEN_PLACE_ORDINATEUR + " de bien plac�");

		if (PRESENT_ORDINATEUR >= 0)
			System.out.println(+PRESENT_ORDINATEUR + " pr�sent mais mal plac�");
		

		count++;

	} while (!victoireJoueur && !victoireOrdinateur && (count < Parametre.getMAX_ESSAIS()));

	if (victoireJoueur && victoireOrdinateur) {
		System.out.println();
		System.out.println("Le joueur et l'ordinateur ont trouv� la combinaison en " + count
				+ " coups. Il y a donc �galit�!");

	}else if (victoireJoueur) {
		System.out.println();
		System.out.println("Bravo tu as gagn� en " + count
				+ " coups! L'ordinateur a perdu!");

	}else if (victoireOrdinateur) {
		System.out.println();
		System.out.println("L'ordinateur a gagn� en " + count
				+ " coups! Vous avez perdu! La solution de l'ordinateur �tait "
				+ CombiOrdi[0] + " " + CombiOrdi[1] + " " + CombiOrdi[2]
				+ " " + CombiOrdi[3] + " !");
		
	}else {
		System.out.println();
		System.out
				.println("L'ordinateur et le joueur ont �puis� leurs "
						+ Parametre.getMAX_ESSAIS()
						+ " essais. Personne ne gagne! La solution de l'ordinateur �tait "
				+ CombiOrdi[0] + " " + CombiOrdi[1] + " " + CombiOrdi[2]
				+ " " + CombiOrdi[3] + " !");
	  }
   }
}

