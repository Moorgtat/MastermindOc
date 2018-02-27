package com.mastermind.oc;

public class Parametre {
	
	private static int NUM_TOTAL_CHIFF = 4;
	private static int MAX_CHIFF = 4;
	private static int MAX_ESSAIS = 8;
	
	public Parametre(){
		
	}
	public Parametre(int NUM_TOTAL_CHIFF, int MAX_CHIFF, int MAX_ESSAIS) {
		Parametre.NUM_TOTAL_CHIFF = NUM_TOTAL_CHIFF;
		Parametre.MAX_CHIFF = MAX_CHIFF;
		Parametre.MAX_ESSAIS = MAX_ESSAIS;
	}
	
	public static int getNUM_TOTAL_CHIFF() {
		return NUM_TOTAL_CHIFF;
	}

	public void setNUM_TOTAL_CHIFF(int NUM_TOTAL_CHIFF) {
		Parametre.NUM_TOTAL_CHIFF = NUM_TOTAL_CHIFF;
	}
	
	public static int getMAX_CHIFF() {
		return MAX_CHIFF;
	}

	public void setMAX_CHIFF(int MAX_CHIFF) {
		Parametre.MAX_CHIFF = MAX_CHIFF;
	}
	
	public static int getMAX_ESSAIS() {
		return MAX_ESSAIS;
	}

	public void setMAX_ESSAIS(int MAX_ESSAIS) {
		Parametre.MAX_ESSAIS = MAX_ESSAIS;
	}
}
