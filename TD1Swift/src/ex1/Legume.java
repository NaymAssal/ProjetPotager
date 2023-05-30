package ex1;

public class Legume {

	private boolean mure;
	private int tmpM;
	private int tmp;
	private int type;
	
	public Legume(int type) {
		tmp = 0;
		mure = false;
		this.type = type;
		switch(type) {
		case 0: tmpM = 50;
		case 1: tmpM = 20;
		case 2: tmpM = 35;
		}
	}
	
	public int getType() {
		return type;
	}
	
	public boolean getMure() {
		return mure;
	}
	
	public void setMure(boolean m) {
		mure = m;
	}
	
	public int getTmp() {
		return tmp;
	}
	
	public int getTmpM() {
		return tmpM;
	}
	
	public void setTmp(int t) {
		tmp = t;
	}
	
	public void pousse(Meteo met) {
		tmp += met.fact();
	}
	
	public void estMure() {
		if(tmpM<tmp) {
			mure = true;
		}
	}
	
	
}
