package ex1;

import java.util.Random;

public class Meteo {
	int jour;
	int mois;
	int annee;
	String saison;
	double temps;
	Random r = new Random();
	
	public Meteo() {
		jour = 1;
		mois = 1;
		annee = 2023;
		saison = "hiver";
		temps = 0;
	}
	
	public void increment() {
		jour++;
		if(jour==32) {
			jour=1;
			mois++;
		}
		if(mois==13) {
			mois=1;
			annee++;
		}
	}
	
	public void temps() {
		temps = r.nextDouble();
	}

}
