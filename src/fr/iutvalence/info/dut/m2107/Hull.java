package fr.iutvalence.info.dut.m2107;

public class Hull {

	
	private Color hullColor;
	private float protectionLevel;
	
	public Hull(Color color, int protection) {
		this.hullColor=color;
		this.protectionLevel=protection;
	}
	
	public float getProtectionLevel() {
		return this.protectionLevel;
	}
	public Color getHullColor() {
		// TODO Auto-generated method stub
		return this.hullColor;
	}

}