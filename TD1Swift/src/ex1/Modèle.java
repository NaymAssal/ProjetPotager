package ex1;

import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class Modèle extends Observable implements Runnable{

	private Case[][] tab;
	private int size;
	private static Random rd = new Random();
	
	public Modèle(int size) {
		this.size = size;
		tab = new Case[size][size];
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				tab[i][j] = new Case();
			}
		}
		
	}
	
	public Case[][] getTab(){
		return tab;
	}
	
	public int getSize() {
		return size;
	}
	
	public void maj(int i, int j) {
		if(tab[i][j].hasLegume()) {
			if(tab[i][j].getLegume().getMure()) {
				tab[i][j] = new Case();
			}
		}
		else {
			tab[i][j] = new Case(new Légume()); 
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
