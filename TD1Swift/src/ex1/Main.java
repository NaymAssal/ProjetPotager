package ex1;

public class Main {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		Modèle m = new Modèle(8);
		Vue v = new Vue(m);
		m.addObserver(v);
		new Thread(m).start();
	}

}
