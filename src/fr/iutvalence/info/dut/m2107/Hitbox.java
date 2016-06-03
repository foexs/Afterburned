package fr.iutvalence.info.dut.m2107;

public class Hitbox {

	private int minX;
	private int maxX;
	private int minY;
	private int maxY;
	
	/**
	 * Makes an hitbox with two coordinates
	 * 
	 * @param xmin the x of the top left
	 * @param xmax the x of the bottom right
	 * @param ymin the y of the top left
	 * @param ymax the y of the bottom right
	 */
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
	
	/**
	 * 
	 * @return minX
	 */
	public int getMinX() {
		return minX;
	}
	

	public int getMaxX() {
		return maxX;
	}


	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}
	
	/**
	 * 
	 * @param hitbox
	 * @return true if a part of the hitbox touches an other
	 */
	public boolean isIn(Hitbox hitbox){
		return (touchesX(hitbox) && touchesY(hitbox));
	}
	/**
	 * 
	 * @param hitbox of the second object
	 * @return true if the two hitoxes are aligned in x
	 */
	public boolean touchesX(Hitbox hitbox){
		if (this.minX<hitbox.minX && this.maxX<hitbox.minX){
			return false;
		}
		if (this.maxX>hitbox.maxX && this.minX>hitbox.maxX){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param hitbox of the second object
	 * @return true if the two hitoxes are aligned in y
	 */
	public boolean touchesY(Hitbox hitbox){
		if (this.minY<hitbox.minY && this.maxY<hitbox.minY){
			return false;
		}
		if (this.maxY>hitbox.maxY && this.minY>hitbox.maxY){
			return false;
		}
		return true;
	}
	
	/**
	 * 
	 * @param hitbox of the second object
	 * @return true if the two hitboxes are absolutly the same
	 */
	public boolean equals(Hitbox hitbox){
		return(this.maxX==hitbox.maxX && this.minX==hitbox.minX && this.maxY==hitbox.maxY && this.minY==hitbox.minY);
	}

}