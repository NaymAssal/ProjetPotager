package ex1;

public class Case {
	private boolean hasL;
	private Légume leg;
	
	public Case() {
		hasL = false;
	}
	
	public Case(Légume leg) {
		hasL = true;
		this.leg = leg;
	}
	
	public Légume getLegume() {
		return leg;
	}
	
	public void setLegume(Légume a) {
		leg = a;
	}
	
	public boolean hasLegume() {
		return hasL;
	}
}
