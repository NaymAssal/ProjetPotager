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
	private ArrayList<Integer> inventaireRecolte;
	private ArrayList<Integer> inventaireGraine;
	private int speed;
	private int argent = 0;
	
	public Modele(int size, Meteo meteo) {
		recolte = new ArrayList<Legume>();
		inventaireRecolte = new ArrayList<Integer>();
		inventaireGraine = new ArrayList<Integer>();
		for(int i=0; i<3; i++) {
			inventaireGraine.add(3);
		}
		this.meteo = meteo;
		this.size = size;
		tab = new Case[size][size];
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				tab[i][j] = new Case();
			}
		}
		
	}
	
	public int getArg() {
		return argent;
	}
	
	public void vendre(int a) {
		if(inventaireRecolte.get(a)>0) {
			argent+=10;
			inventaireRecolte.set(a, inventaireRecolte.get(a)-1);
			int i = 0;
			boolean cond = false;
			while(!cond && i<recolte.size()) {
				if(recolte.get(i).getType()==a) {
					recolte.remove(i);
				}
				i++;
			}
		}
	}
	
	public void setSpeed(int s) {
		this.speed = s;
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
	
	public void select(int a) {
		select = a;
	}
	
	public int getSelect() {
		return select;
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
		if(tab[i][j].getArr()) {
			if(tab[i][j].hasLegume()) {
				if(tab[i][j].getLegume().getMure()) {
					recolte.add(tab[i][j].getLegume());
					inventaireRecolte.set(tab[i][j].getLegume().getType(), 1 +inventaireRecolte.get(tab[i][j].getLegume().getType()));
					tab[i][j] = new Case();
				}
			}
			else {
				tab[i][j] = new Case(new Legume(select));
				
			}
		}
		else {
			tab[i][j].setArr(true);
		}
		
	}
	
	public int getInv(int a) {
		return inventaireRecolte.get(a);
		}
	
	public void run() {
		for(int i=0; i<3; i++) {
			inventaireRecolte.add((Integer)0);
		}
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
				meteo.increment();
				meteo.temps();
				Thread.sleep(1000/(speed+1));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			setChanged();
			notifyObservers();
		}
	}
}
