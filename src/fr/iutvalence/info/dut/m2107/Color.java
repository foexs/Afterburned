package fr.iutvalence.info.dut.m2107;
/**
 * Represents the strength of a chosen enemy, weapon or hull.
 * @author reynloui
 *
 */
public enum Color {
	red(0xff0000),
	green(0x00ff00),
	blue(0x0000ff),
	gold(0xffd400),
	black(0),
	white(0xffffff);
	
	/**
	 * the color RGB code 
	 */
	int colorCode;
	
	private Color(int code)
	{
		this.colorCode=code;
	}
	
	public int getColorCode(){
		return this.colorCode;
	}
}