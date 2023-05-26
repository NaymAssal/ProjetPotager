package ex1;

public class Legume {

	private boolean mure;
	private int tmpM;
	private int tmp;
	private int type;
	
	public Legume(int type) {
		tmp = 0;
		mure = false;
		tmpM = 50;
		this.type = type;
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
	
	public void setTmp(int t) {
		tmp = t;
	}
	
	//public void pousse(Meteo met) {
	//	tmp += met.get;
	//}
	
	public void estMure() {
		if(tmpM<tmp) {
			mure = true;
		}
	}
	
	
}
