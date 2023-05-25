package ex1;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class Modele extends Observable implements Runnable{

	private Case[][] tab;
	private ArrayList<Legume> recolte;
	private int size;
	private static Random rd = new Random();
	private Meteo meteo;
	private int select = 0;
	
	public Modele(int size, Meteo meteo) {
		recolte = new ArrayList<Legume>();
		this.meteo = meteo;
		this.size = size;
		tab = new Case[size][size];
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				tab[i][j] = new Case(meteo);
			}
		}
		
	}
	
	public void vider() {
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				if(tab[i][j].hasLegume()) {
					maj(i,j);
				}
				
			}
		}
	}
	
	public Case[][] getTab(){
		return tab;
	}
	
	public Meteo getMet() {
		return meteo;
	}
	
	public int getSize() {
		return size;
	}
	public int getNb() {
		return recolte.size();
	}
	
	public void maj(int i, int j) {
		if(tab[i][j].hasLegume()) {
			if(tab[i][j].getLegume().getMure()) {
				recolte.add(tab[i][j].getLegume());
				tab[i][j] = new Case();
			}
		}
		else {
			tab[i][j] = new Case(new Legume()); 
		}
	}
	
	public void run() {
		
		while(true) {
			
			try {
				for(int i=0; i<size;i++) {
					for(int j=0; j<size;j++) {
						if(tab[i][j].hasLegume()) {
							tab[i][j].getLegume().estMure();
							tab[i][j].getLegume().setTmp(tab[i][j].getLegume().getTmp()+1);
						}
						
					}
				}
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setChanged();
			notifyObservers();
		}
	}
}
