package fr.iutvalence.info.dut.m2107;

/**
 * @author Popek
 * The ship the player controls has an hull. It defines how resistant his ship is and also the color of the ship
 */
public class Hull {

	
	private final Color hullColor;
	private final float protectionLevel;
	private final String name;
	
	/**
	 * @param color : Defines what is the hull color.
	 * @param protection : Defines what is the hull resistance. Higher rate will reduce the damages taken by the player.
	 * @param name : Each hull has a name.
	 */
	public Hull(Color color, int protection, String name) {
		this.hullColor=color;
		this.protectionLevel=protection;
		this.name=name;
	}
	
	/**
	 * @return protectionLevel, the rate which reduces the damages taken by the player's ship.
	 */
	public float getProtectionLevel() {
		return this.protectionLevel;
	}
	/**
	 * @return hullColor, the current color of the ship.
	 */
	public Color getHullColor() {
		// TODO Auto-generated method stub
		return this.hullColor;
	}

	/**
	 * @return name, the name of the current hull equipped by the player.
	 */
	public String getName() {
		return name;
	}

}