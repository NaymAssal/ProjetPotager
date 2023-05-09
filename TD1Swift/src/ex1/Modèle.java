package ex1;

import java.util.Observable;
import java.util.Random;

@SuppressWarnings("deprecation")
public class Modèle extends Observable implements Runnable{

	private boolean[][] tab;
	private int size;
	private static Random rd = new Random();
	
	public Modèle(int size) {
		this.size = size;
		tab = new boolean[size][size];
		for(int i=0; i<size;i++) {
			for(int j=0; j<size;j++) {
				tab[i][j] = rd.nextBoolean();
			}
		}
		
	}
	
	public boolean[][] getTab(){
		return tab;
	}
	
	public int getSize() {
		return size;
	}
	
	public void maj(int i, int j) {
			tab[i][j] = !tab[i][j];
		
	}
	
	public void run() {
		
		while(true) {
			
			try {
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
