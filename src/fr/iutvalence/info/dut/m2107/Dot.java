package fr.iutvalence.info.dut.m2107;

public class Dot {

	private int x;
	private int y;

	public Dot(int x1, int y1)
	{
		this.x=x1;
		this.y=y1;
	}
	
	public String modx(int X)
	{
		this.x=X;
		return "done";
	}
	
	public String mody(int Y)
	{
		this.y=Y;
		return "done";
	}
	

	
	//getters and setters
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}