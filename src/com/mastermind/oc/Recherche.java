package com.mastermind.oc;

import java.util.Random;
import java.util.Scanner;

public class Recherche extends Menu{

	private static final char EGAL = '=';
	private static final char PLUS = '+';
	private static final char MOIN = '-';

	
	
	static void Attaque() {
		
		int totalCorrespondant = 0;
		sc = new Scanner(System.in);
		
		System.out.println("***********RECHERCHE MODE ATTAQUE***********\n"
		+"Trouve la bonne combinaison de " + parametre.getNUM_TOTAL_CHIFF()
				+ " chiffres entre 0 et " + parametre.getMAX_CHIFF() + ".\n"
		+"Attention, tu n'as droit qu'à " + parametre.getMAX_ESSAIS() + " essais!");
		
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

		    totalCorrespondant = 0;

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (CombiJoueur[i] == CombiOrdi[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondant++;

					if (totalCorrespondant == parametre.getNUM_TOTAL_CHIFF()) {
						victoire = true;
				    	}
				     }
				
				else if (CombiJoueur[i] < CombiOrdi[i]) {
					System.out.print(PLUS + " ");
				      }

				else if (CombiJoueur[i] > CombiOrdi[i]) {
					System.out.print(MOIN + " ");
				      } 
				else {
					System.out.print("E");
				     }
			}
			System.out.println();
			count++;

		} while (!victoire && (count < parametre.getMAX_ESSAIS()));
     
		if (victoire) {
			System.out.println();
			System.out.println("Bravo tu as gagné en " + count + " coups!");
	     	} 
		
		else {
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
		
		int totalCorrespondant = 0;
		sc = new Scanner(System.in);
		
		System.out.println("***********RECHERCHE MODE DEFENSE***********\n"
	        	+"Entre une combinaison de " + parametre.getNUM_TOTAL_CHIFF()
				+ " chiffres entre 0 et " + parametre.getMAX_CHIFF() + ".\n"
        		+"L'ordinateur aura " + parametre.getMAX_ESSAIS()
				+ " essais pour trouver ta combinaison et te battre.");
		System.out.println();
		System.out.println("Entre ta combinaison secrète: ");

		int count = 0;

		int[] CombiJoueur = new int[parametre.getNUM_TOTAL_CHIFF()];

		boolean[] numCorrespondant = new boolean[parametre.getNUM_TOTAL_CHIFF()];

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
				if (!numCorrespondant[i]) {
					RechercheOrdi[i] = r.nextInt(parametre.getMAX_CHIFF() + 1);
			     	}
		     	}

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				System.out.print(RechercheOrdi[i] + " ");
		    	}
 
			System.out.println();
			totalCorrespondant = 0;

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (RechercheOrdi[i] == CombiJoueur[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondant++;
					numCorrespondant[i] = true;

				if (totalCorrespondant == parametre.getNUM_TOTAL_CHIFF()) {
						victoire = true;
					 }
			     	} 
				
				else if (RechercheOrdi[i] < CombiJoueur[i]) {
					System.out.print(PLUS + " ");
			     	}

				else if (RechercheOrdi[i] > CombiJoueur[i]) {
					System.out.print(MOIN + " ");
			    	}

				else {
					System.out.print("E");
			    	}
			  }

			System.out.println();

			count++;

		} while (!victoire && (count < parametre.getMAX_ESSAIS()));
		
		if (victoire) {
			System.out.println();
			System.out.println("L'ordinateur a gagné en " + count
					+ " coups, tu as perdu!");
	     	} 
		
		else {
			System.out.println();
			System.out.println("Bravo, l'ordinateur a epuisé ses " + parametre.getMAX_ESSAIS()
					+ " essais, c'est gagné!");
		     }
     	}

	
	static void Duel() {
		
		int totalCorrespondantJoueur;
		int totalCorrespondantOrdinateur;
		
		sc = new Scanner(System.in);
		
		System.out.println("***********RECHERCHE MODE DUEL***********\n"
		+"Trouve la bonne combinaison de " + parametre.getNUM_TOTAL_CHIFF()
		+" chiffres entre 0 et " + parametre.getMAX_CHIFF() + " avant l'ordinateur!\n"
		+"Commence par entrer ta combinaison secrète puis trouve celle de l'ordinateur.\n"
		+"Attention, tu n'as droit qu'à " + parametre.getMAX_ESSAIS()+ " essais.");
		System.out.println();
		System.out.println("Entre ta combinaison secrète: ");

		int count = 0;
		
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

			totalCorrespondantJoueur = 0;

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (RechercheJoueur[i] == CombiOrdi[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondantJoueur++;

				if (totalCorrespondantJoueur == parametre.getNUM_TOTAL_CHIFF()) {
						victoireJoueur = true;
					  }
			     	} 
				
				else if (RechercheJoueur[i] < CombiOrdi[i]) {
					System.out.print(PLUS + " ");
				     }

				else if (RechercheJoueur[i] > CombiOrdi[i]) {
					System.out.print(MOIN + " ");
				     }

				else {
					System.out.print("E");
			       	}
			  }

			System.out.println();
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

			totalCorrespondantOrdinateur = 0;

			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (RechercheOrdi[i] == CombiJoueur[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondantOrdinateur++;
					numCorrespondantOrdinateur[i] = true;

				if (totalCorrespondantOrdinateur == parametre.getNUM_TOTAL_CHIFF()) {
					victoireOrdinateur = true;
					 }
			    	} 
				
				else if (RechercheOrdi[i] < CombiJoueur[i]) {
					System.out.print(PLUS + " ");
				     }

				else if (RechercheOrdi[i] > CombiJoueur[i]) {
					System.out.print(MOIN + " ");
			      	}

				else {
					System.out.print("E");
				    }
			}
			
			System.out.println();

			count++;

		} while (!victoireJoueur && !victoireOrdinateur && (count < parametre.getMAX_ESSAIS()));
        
		if (victoireJoueur && victoireOrdinateur) {
			System.out.println();
			System.out.println("Le joueur et l'ordinateur ont trouvé la combinaison en " + count
					+ " coups. Il y a donc égalité!");
		}
		
		else if (victoireJoueur) {
			System.out.println();
			System.out.println("Bravo tu as gagné en " + count
					+ " coups! L'ordinateur a perdu!");
		    }
		
		else if (victoireOrdinateur) {
			System.out.println();
			String str = new String();
			for (int i = 0; i < parametre.getNUM_TOTAL_CHIFF(); i++){
				str += CombiOrdi[i] + " " ;
			}
			System.out.println("L'ordinateur a gagné en " + count
					+ " coups! Vous avez perdu! La solution était "
					+str);		
		    }
		
		else {
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
