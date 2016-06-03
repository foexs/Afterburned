package fr.iutvalence.info.dut.m2107;

/**
 * A ship's weapon
 * @author simon
 *
 */
public class Weapon {
	/**
	 * Color
	 */
	private final EasyColor weaponColor;
	/**
	 * Power
	 */
	private final int damageLevel;
	/**
	 * Name
	 */
	private final String name;
	
	/**
	 * 
	 * @param color
	 * @param damage
	 * @param name
	 */
	public Weapon(EasyColor color, int damage, String name){
		this.weaponColor=color;
		this.damageLevel=damage;	
		this.name=name;
	}
	
	/**
	 * 
	 * @return color
	 */
	public EasyColor getWeaponColor() {
		return weaponColor;
	}
	
	/**
	 * 
	 * @return power
	 */
	public int getDamageLevel() {
		return damageLevel;
	}
	/**
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
	}


}