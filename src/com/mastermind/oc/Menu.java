package com.mastermind.oc;

import java.util.InputMismatchException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import domaine.properties.ChargerConfiguration;

public class Menu {
	
	private static final Logger logger = LogManager.getLogger(Menu.class);
	protected static ChargerConfiguration cc = new ChargerConfiguration();
	protected static Parametre parametre = new Parametre(cc.getPropNumTotal(),cc.getPropMaxChiff(),cc.getPropMaxEssai());

	public static Boolean marqueurMode = false;
	
	  public static void main(String[] args) {
		
	    int SELECTION;
		char Reponse;

		logger.info("Ouverture du programme Mastermind OC");
		
		System.out.println();
		
		Scanner sc = new Scanner(System.in);		
			
		if (args.length > 0) {
			if (args[0].equals("D")) {
				marqueurMode = true;
				logger.info("            *Mode Développeur*");
			}
		} else {
			marqueurMode = false;
			logger.info("            *Mode Utilisateur*");
		}

  try {
	
		do {
				
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
									.println("Votre réponse n'est pas valide");
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
			
		System.out.println(" Merci d'avoir jouer. Au revoir.");
		
		}catch (InputMismatchException e) {	
			
			logger.warn(" Saisi non valide ");
			
		}
  
  logger.info("Fermeture du programme Mastermind OC");
  
	}
}
