package fr.iutvalence.info.dut.m2107;

/**
 * @author Popek
 * The ship the player controls has an hull. It defines how resistant his ship is and also the color of the ship
 */
public class Hull {

	
	private final EasyColor hullColor;
	private final float protectionLevel;
	private final String name;
	private String hullPath;
	
	/**
	 * @param color : Defines what is the hull color.
	 * @param protection : Defines what is the hull resistance. Higher rate will reduce the damages taken by the player.
	 * @param name : Each hull has a name.
	 */
	public Hull(EasyColor color, int protection, String name) {
		this.hullColor=color;
		this.protectionLevel=protection;
		this.name=name;
		switch (hullColor)
		{
		case white:
			this.hullPath="ihm/aperçu vaisseau blanc.png";
			break;
		case grey:
			this.hullPath="ihm/aperçu vaisseau gris.png";
			break;
		case red:
			this.hullPath="ihm/aperçu vaisseau rouge.png";
			break;
		case gold:
			this.hullPath="ihm/aperçu vaisseau or.png";
			break;
		case blue:
			this.hullPath="ihm/aperçu vaisseau bleu.png";
			break;
		case green:
			this.hullPath="ihm/aperçu vaisseau vert.png";
			break;
		}
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
	public EasyColor getHullColor() {
		return this.hullColor;
	}
	
	public String getHullPath() {
		return this.hullPath;
	}

	/**
	 * @return name, the name of the current hull equipped by the player.
	 */
	public String getName() {
		return name;
	}

}