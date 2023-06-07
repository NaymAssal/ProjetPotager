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
		
		tmpM = 50;
		
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
		estMure();
		setTmp(tmp+1);
	}
	
	public void estMure() {
		if(!mure) {
			if(tmpM<tmp) {
				mure = true;
			}
		}
		
	}
	
	
}
