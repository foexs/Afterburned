package fr.iutvalence.info.dut.m2107;

/**
 * @author popekn
 * A Dot represents exactly where an element is.
 */
public class Dot {

	private int x;
	private int y;

	/**
	 * @param x1
	 * @param y1
	 * Dot Constructor 
	 */
	public Dot(int x1, int y1)
	{
		this.x=x1;
		this.y=y1;
	}
	

	
	/**
	 * @return X  , the 1st parameter of a Dot
	 */
	//getters and setters
	public int getX() {
		return x;
	}

	/**
	 * @param x  , set the first parameter of a Dot
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return Y, the 2nd parameter of a Dot
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y , set the second parameter of a Dot
	 */
	public void setY(int y) {
		this.y = y;
	}
}