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

}