package ex1;

public class Legume {

	private boolean mure;
	private int tmpM;
	private int tmp;
	
	public Legume() {
		tmp = 0;
		mure = false;
		tmpM = 50;
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
	
	public void estMure() {
		if(tmpM<tmp) {
			mure = true;
		}
	}
	
	
}
