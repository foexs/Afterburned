package fr.iutvalence.info.dut.m2107;

public class Hitbox {

	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	public Hitbox(int xmin, int xmax, int ymin, int ymax)
	{
		if (xmin<xmax){
			this.minX=xmin;
			this.maxX=xmax;
		}
		else{
			this.minX=xmax;
			this.maxX=xmin;
		}
		if (ymin<ymax){
			this.minY=ymin;
			this.maxY=ymax;
		}
		else{
			this.minY=ymax;
			this.maxY=ymin;
		}
		
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
	public boolean isIn(Hitbox hitbox){
		return (touchesX(hitbox) && touchesY(hitbox));
	}
	public boolean touchesX(Hitbox hitbox){
		if (this.minX<hitbox.minX && this.maxX<hitbox.minX){
			return false;
		}
		if (this.maxX>hitbox.maxX && this.minX>hitbox.maxX){
			return false;
		}
		return true;
	}
	public boolean touchesY(Hitbox hitbox){
		if (this.minY<hitbox.minY && this.maxY<hitbox.minY){
			return false;
		}
		if (this.maxY>hitbox.maxY && this.minY>hitbox.maxY){
			return false;
		}
		return true;
	}

}