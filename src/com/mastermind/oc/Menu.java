package com.mastermind.oc;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		int SELECTION;
		char Reponse;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println();
			System.out
					.println("*********PROJET 3 - OPENCLASSROOM*********\n"
							+ "Selectionner le jeu en mode Recherche attaque (1)\n"
							+ "Selectionner le jeu en mode Recherche defense (2)\n"
							+ "Selectionner le jeu en mode Recherche duel (3)\n"
							+ "Selectionner le jeu en mode Mastermind attaque (4)\n"
							+ "Selectionner le jeu en mode Mastermind defense (5)\n"
							+ "Selectionner le jeu en mode Mastermind duel (6)\n"
							+ "Quitter le programme (7)\n"
							+ "Taper le chiffre entre parenthése pour faire un choix :");

			SELECTION = sc.nextInt();

			
			if (SELECTION == 1) {
				do {
					Recherche.Attaque();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');
			}

			
			if (SELECTION == 2) {
				do {
					Recherche.Defense();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');
			}

			
			if (SELECTION == 3) {
				do {
					Recherche.Duel();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');
			}
			
			
			if (SELECTION == 4) {
				do {
					Mastermind.Attaque();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');
			}
			
			
			if (SELECTION == 5) {
				do {
					Mastermind.Defense();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');	
			}
			
			if (SELECTION == 6) {
				do {
					Mastermind.Duel();

					do {
						System.out.println("Veux tu rejouer? (O/N)");
						Reponse = sc.next().charAt(0);

						if (Reponse != 'O' && Reponse != 'N') {
							System.out
									.println("Votre réponse n'est pas valide.");
						};

					} while (Reponse != 'O' && Reponse != 'N');

				} while (Reponse != 'N');
			}
			
			
		} while (SELECTION != 7);

		System.out.println("Merci d'avoir jouer. Au revoir.");
	}
}
