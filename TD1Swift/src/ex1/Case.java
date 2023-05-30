package ex1;

public class Case {
	private boolean hasL;
	private Legume leg;
	private boolean arrose;
	
	
	
	public Case() {
		hasL = false;
		arrose = false;
	}
	
	public Case(Legume leg) {
		hasL = true;
		this.leg = leg;
	}
	
	public Legume getLegume() {
		return leg;
	}
	
	public void setLegume(Legume a) {
		leg = a;
	}
	
	public boolean getArr() {
		return arrose;
	}
	
	public void setArr(boolean arr) {
		arrose = arr;
	}
	
	
	public boolean hasLegume() {
		return hasL;
	}
}
