package fr.iutvalence.info.dut.m2107;

public class Hull {

	
	private final Color hullColor;
	private final float protectionLevel;
	private final String name;
	
	public Hull(Color color, int protection, String name) {
		this.hullColor=color;
		this.protectionLevel=protection;
		this.name=name;
	}
	
	public float getProtectionLevel() {
		return this.protectionLevel;
	}
	public Color getHullColor() {
		// TODO Auto-generated method stub
		return this.hullColor;
	}

	public String getName() {
		return name;
	}

}