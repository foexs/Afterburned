package fr.iutvalence.info.dut.m2107;
/**
 * Represents the strength of a chosen enemy, weapon or hull.
 * @author reynloui
 *
 */
public enum EasyColor {
	
	
	/**
	 * Color defines how strong an enemy is.
	 */
	
	/**
	 * Red's hexadecimal code
	 */
	red("0xff0000"),
	/**
	 * Green's hexadecimal code
	 */
	green("0x00ff00"),
	/**
	 * Blue's hexadecimal code
	 */
	blue("0x0000ff"),
	/**
	 * Gold's hexadecimal code
	 */
	gold("0xffd400"),
	/**
	 * grey's hexadecimal code
	 */
	grey("0xbbbbbb"),
	/**
	 * White's hexadecimal code
	 */
	white("0xffffff");
	
	/**
	 * the color RGB code 
	 */
	String colorCode;
	
	private EasyColor(String code)
	{
		this.colorCode=code;
	}
	
	/**
	 * @return the hexadecimal code of the color.
	 */
	public String getColorCode(){
		return this.colorCode;
	}
}