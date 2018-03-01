package com.mastermind.mode;

import java.util.Scanner;


public class TestMode {

public static char ModeChoisi;
public static Boolean marqueurMode = false;

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
			System.out.println("Choisissez : \n"
			+"Mode Dévellopeur(D) ou Mode Utilisateur(U)");
			ModeChoisi = sc.next().charAt(0);

			if (ModeChoisi != 'D' && ModeChoisi != 'U') {
			System.out
					.println("Reponse non valide. Le programme se lance en mode Utilisateur");
			};
			
			if (ModeChoisi == 'D'){
				marqueurMode = true;
			}	

    System.out.println();	
	Mode.Voir();
	
        }
    }



