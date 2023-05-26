package ex1;

import java.util.Random;

public class Meteo {
	int jour;
	int mois;
	int annee;
	String saison;
	int temp;
	int ensol;
	int humid;
	Random r = new Random();
	
	public Meteo() {
		jour = 1;
		mois = 1;
		annee = 2023;
		saison = "hiver";
		temp = 20;
		ensol = 50;
		humid = 50;
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
	
	public String getDate() {
		String str ="";
		str += jour + "/" + mois +"/" + annee;
		return str;
	}
	
	public String getStat() {
		String str ="";
		str += "Temperature : " + temp + "°C\n";
		str += "Ensoleilement : " + ensol + "%\n";
		str += "Humidite : " + humid + "%\n";
		return str;
	}
	
	//public void getTemps() {
	//	return temps;
	//}
	
	public void temps() {
		if(r.nextDouble()<0.5)
	        temp+=1;
	    else
	        temp-=1;
		
		if(r.nextDouble()<0.5)
	        ensol = Math.max(0,ensol-5);
	    else
	    	ensol = Math.max(100,ensol+5);
		
		if(r.nextDouble()<0.5)
	        humid = Math.max(0,humid-5);
	    else
	    	humid = Math.max(100,humid+5);
		
		
	}

}
