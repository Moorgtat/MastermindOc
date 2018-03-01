package com.mastermind.mode;


public class Mode extends TestMode {
	
	public static void Voir() {
		if (marqueurMode){
			System.out.println("Mode Developeur.");
		}
		else
			System.out.println("Mode Utilisateur.");
	  }
	
	}