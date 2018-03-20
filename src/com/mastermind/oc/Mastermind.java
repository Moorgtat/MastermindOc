package com.mastermind.oc;

import java.util.Random;
import java.util.Scanner;

public class Mastermind extends Menu{
	
	private static int BIEN_PLACE;
	private static int PRESENT;
	private static int BIEN_PLACE_JOUEUR;
	private static int PRESENT_JOUEUR;
	private static int BIEN_PLACE_ORDINATEUR;
	private static int PRESENT_ORDINATEUR;

	
	static void Attaque() {
		
		sc = new Scanner(System.in);

		System.out.println("***********MASTERMIND MODE ATTAQUE***********\n"
		+"Trouve la bonne combinaison de " + parametre.getMAX_CHIFF()+ 
		" chiffres entre 0 et " + parametre.getMAX_CHIFF() + ".\n"
		+"Attention, tu n'as droit qu'à " + parametre.getMAX_ESSAIS() + " essais.");

		int count = 0;
		
		int[] CombiOrdi = new int[parametre.getNUM_TOTAL_CHIFF()];

		Random r = new Random();

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			CombiOrdi[i] = r.nextInt(parametre.getMAX_CHIFF() + 1);
		}
		
		int[] CombiJoueur = new int[parametre.getNUM_TOTAL_CHIFF()];

		boolean victoire = false;

		do {
		    if(marqueurMode){
		    	
		    	System.out.println();
				String str = new String();
				for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
					str += CombiOrdi[i] + " " ;
				 }
				System.out.println ("Mode Devellopeur - Solution : "
					+ str);
		    }
		    
			System.out.println("\nEssai n° " + (count + 1) + "/" + parametre.getMAX_ESSAIS()
					+ " :");
			int nombreSaisi = sc.nextInt();

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++)
				CombiJoueur[i] = (int) (nombreSaisi / (Math.pow(10,
						(parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++)
				System.out.print(CombiJoueur[i] + " ");

			System.out.println();

			BIEN_PLACE = 0;
			PRESENT = 0;       
            
			boolean[] BIEN_PLACE_Test = new boolean[parametre.getNUM_TOTAL_CHIFF()];
			boolean[] PRESENT_Test = new boolean[parametre.getNUM_TOTAL_CHIFF()];

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {

				if (CombiJoueur[i] == CombiOrdi[i]) {
					BIEN_PLACE++;
					BIEN_PLACE_Test[i] = true;
					PRESENT_Test[i] = true;
			        	}
			}
			        
			    if (BIEN_PLACE == parametre.getNUM_TOTAL_CHIFF()) {
				victoire = true;
			}

			    else {
					for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
						if (!PRESENT_Test[i]) {
							for (int j = 0; j < parametre.getNUM_TOTAL_CHIFF(); j++) {
								if (!BIEN_PLACE_Test[j]) {
									if (CombiJoueur[i] == CombiOrdi[j]) {
										PRESENT++;
										BIEN_PLACE_Test[j] = true;
									}
								}
							}
						}
					}
				}

			if (BIEN_PLACE >= 0)
				System.out.println(+BIEN_PLACE + " de bien placé");

			if (PRESENT >= 0)
				System.out.println(+PRESENT + " présent mais mal placé");

			count++;

		} while (!victoire && count < parametre.getMAX_ESSAIS());
		if (victoire) {
			System.out.println();
			System.out.println("Bravo tu as gagné en " + count + " coups!");

		} else {
			System.out.println();
			String str = new String();
			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
				str += CombiOrdi[i] + " " ;
			}
			System.out.println ("Tu as épuisé tes " + parametre.getMAX_ESSAIS()
					+ " essais, l'ordinateur a gagné! La solution était "
				+ str);
		}
	}
		
	
	static void Defense() {
		
		sc = new Scanner(System.in);

		System.out.println("***********MASTERMIND MODE DEFENSE***********\n"
		  +"Entre une combinaison de " + parametre.getNUM_TOTAL_CHIFF()
		  + " chiffres entre 0 et " + parametre.getMAX_CHIFF() + ".\n"
		  +"L'ordinateur aura " + parametre.getMAX_ESSAIS()+ " essais " 
		  +"pour trouver ta combinaison et te battre.");
		System.out.println();
		System.out.println("Entre ta combinaison secrète: ");

		int count = 0;

		int[] CombiJoueur = new int[parametre.getNUM_TOTAL_CHIFF()];

		boolean[] numCorrespondantOrdinateur = new boolean[parametre.getNUM_TOTAL_CHIFF()];

		int nombresSaisi = sc.nextInt();

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			CombiJoueur[i] = (int) (nombresSaisi / (Math.pow(10,
					(parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
		}

		Random r = new Random();

		int[] RechercheOrdi = new int[parametre.getNUM_TOTAL_CHIFF()];

		boolean victoire = false;

		do {
			System.out.println("\nEssai n° " + (count + 1) + "/" + parametre.getMAX_ESSAIS()
					+ " :");

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (!numCorrespondantOrdinateur[i]) {
					RechercheOrdi[i] = r.nextInt(parametre.getMAX_CHIFF() + 1);
				}

			}

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				System.out.print(RechercheOrdi[i] + " ");
			}

			System.out.println();
			BIEN_PLACE = 0;
			PRESENT = 0;

			boolean[] BIEN_PLACE_Test = new boolean[parametre.getNUM_TOTAL_CHIFF()];
			boolean[] PRESENT_Test = new boolean[parametre.getNUM_TOTAL_CHIFF()];

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (CombiJoueur[i] == RechercheOrdi[i]) {
					BIEN_PLACE++;
					BIEN_PLACE_Test[i] = true;
					PRESENT_Test[i] = true;
					numCorrespondantOrdinateur[i] = true;
				}
			}
			if (BIEN_PLACE == parametre.getNUM_TOTAL_CHIFF()) {
				victoire = true;
			}

			else {
				for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
					for (int j = 0; j < parametre.getNUM_TOTAL_CHIFF(); j++) {
						if (CombiJoueur[i] == RechercheOrdi[j]
								&& !BIEN_PLACE_Test[i] && !PRESENT_Test[j]) {
							PRESENT++;
							BIEN_PLACE_Test[i] = true;
							PRESENT_Test[i] = true;
						}
					}
				}
			}

			if (BIEN_PLACE >= 0)
				System.out.println(+BIEN_PLACE + " de bien placé");

			if (PRESENT >= 0)
				System.out.println(+PRESENT + " présent mais mal placé");

			count++;

		} while (!victoire && count < parametre.getMAX_ESSAIS());
		if (victoire) {
			System.out.println();
			System.out.println("L'ordinateur a gagné en " + count
					+ " coups, tu as perdu!");
		} else {
			System.out.println();
			System.out.println("Bravo, l'ordinateur a epuisé ses " + parametre.getMAX_ESSAIS()
					+ " essais, c'est gagné!");
		}
	}
	
	
	static void Duel() {int count = 0;
	
	sc = new Scanner(System.in);
	
	System.out.println("***********MASTERMIND MODE DUEL***********\n"
	+"Trouve la bonne combinaison de " +parametre.getNUM_TOTAL_CHIFF()+ " " 
	+"chiffres entre 0 et "+parametre.getMAX_CHIFF() +"\n" 
	+"avant l'ordinateur! Commence par entrer ta combinaison \n"
	+"secrète puis trouve celle de l'ordinateur.\n"
	+"Attention, tu n'as droit qu'à " +parametre.getMAX_ESSAIS()+ " essais.");
	System.out.println();
	System.out.println("Entre ta combinaison secrète: ");

	int[] CombiOrdi = new int[parametre.getNUM_TOTAL_CHIFF()];
	
    Random r = new Random();
    
	for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
		CombiOrdi[i] = r.nextInt(parametre.getMAX_CHIFF() + 1);
	}

	boolean[] numCorrespondantOrdinateur = new boolean[parametre.getNUM_TOTAL_CHIFF()];

	int[] CombiJoueur = new int[parametre.getNUM_TOTAL_CHIFF()];

	int nombresSaisi = sc.nextInt();

	for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
		CombiJoueur[i] = (int) (nombresSaisi / (Math.pow(10,
				(parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
	}

	int[] RechercheOrdi = new int[parametre.getNUM_TOTAL_CHIFF()];
	
	boolean victoireJoueur = false;
	boolean victoireOrdinateur = false;
	
	do {
	    if(marqueurMode){
	    	System.out.println();
			String str = new String();
			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
				str += CombiOrdi[i] + " " ;
			 }
			System.out.println ("Mode Devellopeur - Solution : "
				+ str);
	     }
		System.out.println("\nRecherche Joueur essai n° " + (count + 1)
				+ "/" + parametre.getMAX_ESSAIS() + " :");
		
        int nombreSaisi2 = sc.nextInt();
        
		int[] RechercheJoueur = new int[parametre.getNUM_TOTAL_CHIFF()];	
		
		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			RechercheJoueur[i] = (int) (nombreSaisi2 / (Math.pow(10,
					(parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;
		}
		
		BIEN_PLACE_JOUEUR = 0;
		PRESENT_JOUEUR = 0;       
        
		boolean[] BIEN_PLACE_J = new boolean[parametre.getNUM_TOTAL_CHIFF()];
		boolean[] PRESENT_J = new boolean[parametre.getNUM_TOTAL_CHIFF()];

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {

			if (RechercheJoueur[i] == CombiOrdi[i]) {
				BIEN_PLACE_JOUEUR++;
				BIEN_PLACE_J[i] = true;
				PRESENT_J[i] = true;
		        	}
		}
		        
		    if (BIEN_PLACE_JOUEUR == parametre.getNUM_TOTAL_CHIFF()) {
			victoireJoueur = true;
		}

		    else {
						for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
							if (!PRESENT_J[i]) {
								for (int j = 0; j < parametre.getNUM_TOTAL_CHIFF(); j++) {
									if (!BIEN_PLACE_J[j]) {
										if (RechercheJoueur[i] == CombiOrdi[j]) {
											PRESENT_JOUEUR++;
											BIEN_PLACE_J[j] = true;
										}
									}
								}
							}
						}
					}

		if (BIEN_PLACE_JOUEUR >= 0)
			System.out.println(+BIEN_PLACE_JOUEUR + " de bien placé");

		if (PRESENT_JOUEUR >= 0)
			System.out.println(+PRESENT_JOUEUR + " présent mais mal placé");
		
		System.out.println();
		
		System.out.println("Recherche Ordinateur essai n° " + (count + 1)
				+ "/" + parametre.getMAX_ESSAIS() + " :");

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			if (!numCorrespondantOrdinateur[i]) {
				RechercheOrdi[i] = r.nextInt(parametre.getMAX_CHIFF() + 1);
			}
		}

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			System.out.print(RechercheOrdi[i] + " ");
		}

		System.out.println();

		BIEN_PLACE_ORDINATEUR = 0;
		PRESENT_ORDINATEUR = 0;       
        
		boolean[] BIEN_PLACE_O = new boolean[parametre.getNUM_TOTAL_CHIFF()];
		boolean[] PRESENT_O = new boolean[parametre.getNUM_TOTAL_CHIFF()];

		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
			if (RechercheOrdi[i] == CombiJoueur[i]) {
				BIEN_PLACE_ORDINATEUR++;
				BIEN_PLACE_O[i] = true;
				PRESENT_O[i] = true;
				numCorrespondantOrdinateur[i] = true;
		        	}
		}
		if (BIEN_PLACE_ORDINATEUR == parametre.getNUM_TOTAL_CHIFF()) {
			victoireOrdinateur = true;
		}

	    else {
					for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
						if (!PRESENT_O[i]) {
							for (int j = 0; j < parametre.getNUM_TOTAL_CHIFF(); j++) {
								if (!BIEN_PLACE_O[j]) {
									if (RechercheOrdi[i] == CombiJoueur[j]) {
										PRESENT_ORDINATEUR++;
										BIEN_PLACE_O[j] = true;
									}
								}
							}
						}
					}
				}

		if (BIEN_PLACE_ORDINATEUR >= 0)
			System.out.println(+BIEN_PLACE_ORDINATEUR + " de bien placé");

		if (PRESENT_ORDINATEUR >= 0)
			System.out.println(+PRESENT_ORDINATEUR + " présent mais mal placé");
		

		count++;

	} while (!victoireJoueur && !victoireOrdinateur && (count < parametre.getMAX_ESSAIS()));

	if (victoireJoueur && victoireOrdinateur) {
		System.out.println();
		System.out.println("Le joueur et l'ordinateur ont trouvé la combinaison en " + count
				+ " coups. Il y a donc égalité!");

	}else if (victoireJoueur) {
		System.out.println();
		System.out.println("Bravo tu as gagné en " + count
				+ " coups! L'ordinateur a perdu!");

	}else if (victoireOrdinateur) {
		System.out.println();
		String str = new String();
		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
			str += CombiOrdi[i] + " " ;
		}
		System.out.println("L'ordinateur a gagné en " + count
				+ " coups! Vous avez perdu! La solution était "
				+str);	
		
	}else {
		System.out.println();
		String str = new String();
		for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
			str += CombiOrdi[i] + " " ;
		}
		System.out.println ("L'ordinateur et le joueur ont épuisé leur " + parametre.getMAX_ESSAIS()
				+ " essais ! La combinaison de l'ordinateur était "
			+ str);
	  }
   }
}

