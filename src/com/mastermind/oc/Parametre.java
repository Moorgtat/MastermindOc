package com.mastermind.oc;

public class Parametre {
	
	private int NUM_TOTAL_CHIFF;
	private int MAX_CHIFF;
	private int MAX_ESSAIS;
	
	public Parametre(){
		
	}
	
	public Parametre(int NUM_TOTAL_CHIFF, int MAX_CHIFF, int MAX_ESSAIS) {
		this.NUM_TOTAL_CHIFF = NUM_TOTAL_CHIFF;
		this.MAX_CHIFF = MAX_CHIFF;
		this.MAX_ESSAIS = MAX_ESSAIS;
	}
	
	public int getNUM_TOTAL_CHIFF() {
		return NUM_TOTAL_CHIFF;
	}

	public void setNUM_TOTAL_CHIFF(int NUM_TOTAL_CHIFF) {
		this.NUM_TOTAL_CHIFF = NUM_TOTAL_CHIFF;
	}
	
	public int getMAX_CHIFF() {
		return MAX_CHIFF;
	}

	public void setMAX_CHIFF(int MAX_CHIFF) {
		this.MAX_CHIFF = MAX_CHIFF;
	}
	
	public int getMAX_ESSAIS() {
		return MAX_ESSAIS;
	}

	public void setMAX_ESSAIS(int MAX_ESSAIS) {
		this.MAX_ESSAIS = MAX_ESSAIS;
	}
	
	public void afficher() {

		System.out.println("MAX_ESSAIS : " + this.getMAX_ESSAIS()
				+ " MAX_CHIFF : " + this.getMAX_CHIFF() + " NUM_TOTAL_CHIFF : "
				+ this.getNUM_TOTAL_CHIFF() + " .");
	}

}

