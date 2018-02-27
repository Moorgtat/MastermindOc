package com.mastermind.oc;

import java.util.Random;
import java.util.Scanner;
import com.mastermind.oc.Parametre;

public class Recherche {

	private static final char EGAL = '=';
	private static final char PLUS = '+';
	private static final char MOIN = '-';
	
	
	static void Attaque() {
		int totalCorrespondant = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***********RECHERCHE MODE ATTAQUE***********");
		System.out.println("Trouve la bonne combinaison de " + Parametre.getNUM_TOTAL_CHIFF()
				+ " chiffres entre 0 et " + Parametre.getMAX_CHIFF() + ".");
		System.out
				.println("Attention, tu as droit à " + Parametre.getMAX_ESSAIS() + " essais");

		int count = 0;
        
		int[] CombiOrdi = new int[Parametre.getNUM_TOTAL_CHIFF()];

		Random r = new Random();

		for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
			CombiOrdi[i] = r.nextInt(Parametre.getMAX_CHIFF() + 1);

		}

		int[] CombiJoueur = new int[Parametre.getNUM_TOTAL_CHIFF()];

		boolean victoire = false;

		do {
			System.out.println("\nEssai n° " + (count + 1) + "/" + Parametre.getMAX_ESSAIS()
					+ " :");
			int nombreSaisi = sc.nextInt();

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++)
				CombiJoueur[i] = (int) (nombreSaisi / (Math.pow(10,
						(Parametre.getNUM_TOTAL_CHIFF() - i - 1)))) % 10;

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++)
				System.out.print(CombiJoueur[i] + " ");

			System.out.println();

		 totalCorrespondant = 0;

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (CombiJoueur[i] == CombiOrdi[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondant++;

					if (totalCorrespondant == Parametre.getNUM_TOTAL_CHIFF()) {
						victoire = true;
					}

				} else if (CombiJoueur[i] < CombiOrdi[i]) {
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

		} while (!victoire && (count < Parametre.getMAX_ESSAIS()));

		if (victoire) {
			System.out.println();
			System.out.println("Bravo tu as gagné en " + count + " coups!");

		} else {
			System.out.println();
			System.out.println("Tu as épuisé tes " + Parametre.getMAX_ESSAIS()
					+ " essais, l'ordinateur a gagné! La solution était "
					+ CombiOrdi[0] + " " + CombiOrdi[1] + " " + CombiOrdi[2]
					+ " " + CombiOrdi[3] + " !");

		}
	}
	
	static void Defense() {
		
		int totalCorrespondant = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("***********RECHERCHE MODE DEFENSE***********");
		System.out.println("Entre une combinaison de " + Parametre.getNUM_TOTAL_CHIFF()
				+ " chiffres entre 0 et " + Parametre.getMAX_CHIFF() + ".");
		System.out.println("L'ordinateur aura " + Parametre.getMAX_ESSAIS()
				+ " essais pour trouver ta combinaison et te battre.");
		System.out.println();
		System.out.println("Entre ta combinaison secrète: ");

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
			System.out.println("\nEssai n° " + (count + 1) + "/" + Parametre.getMAX_ESSAIS()
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
			totalCorrespondant = 0;

			for (int i = 0; i < Parametre.getNUM_TOTAL_CHIFF(); i++) {
				if (RechercheOrdi[i] == TirageJoueur[i]) {
					System.out.print(EGAL + " ");
					totalCorrespondant++;
					numCorrespondant[i] = true;

					if (totalCorrespondant == Parametre.getNUM_TOTAL_CHIFF()) {
						victoire = true;
					}

				} else if (RechercheOrdi[i] < TirageJoueur[i]) {
					System.out.print(PLUS + " ");
				}

				else if (RechercheOrdi[i] > TirageJoueur[i]) {
					System.out.print(MOIN + " ");
				}

				else {
					System.out.print("E");
				}
			}

			System.out.println();

			count++;

		} while (!victoire && (count < Parametre.getMAX_ESSAIS()));
		
		if (victoire) {
			System.out.println();
			System.out.println("L'ordinateur a gagné en " + count
					+ " coups, tu as perdu!");
		} 
		else {
			System.out.println();
			System.out.println("Bravo, l'ordinateur a epuisé ses " + Parametre.getMAX_ESSAIS()
					+ " essais, c'est gagné!");
		}
	}

	
	static void Duel() {
      }

}

