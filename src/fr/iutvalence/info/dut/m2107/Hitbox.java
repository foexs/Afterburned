package fr.iutvalence.info.dut.m2107;

public class Hitbox {

	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	public Hitbox(int xmin, int xmax, int ymin, int ymax)
	{
		this.minX=xmin;
		this.maxX=xmax;
		this.minY=ymin;
		this.maxY=ymax;
	}

	public int getMinX() {
		return minX;
	}

	public void setMinX(int minX) {
		this.minX = minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}

	public int getMinY() {
		return minY;
	}

	public void setMinY(int minY) {
		this.minY = minY;
	}

	public int getMaxY() {
		return maxY;
	}

	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}

}