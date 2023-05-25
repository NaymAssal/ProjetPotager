package ex1;

public class Case {
	private boolean hasL;
	private Legume leg;
	private Meteo meteo;
	
	public Case() {
		hasL = false;
	}
	
	public Case(Meteo meteo) {
		hasL = false;
		this.meteo = meteo;
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
	
	public boolean hasLegume() {
		return hasL;
	}
}
