package ex1;

public class Case {
	private boolean hasL;
	private L�gume leg;
	
	public Case() {
		hasL = false;
	}
	
	public Case(L�gume leg) {
		hasL = true;
		this.leg = leg;
	}
	
	public L�gume getLegume() {
		return leg;
	}
	
	public void setLegume(L�gume a) {
		leg = a;
	}
	
	public boolean hasLegume() {
		return hasL;
	}
}
