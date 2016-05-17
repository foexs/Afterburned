package fr.iutvalence.info.dut.m2107;

public class Weapon {

	private final Color weaponColor;
	private final int damageLevel;
	
	public Weapon(Color color, int damage){
		this.weaponColor=color;
		this.damageLevel=damage;	
	}
	
	public Color getWeaponColor() {
		return weaponColor;
	}

	public int getDamageLevel() {
		return damageLevel;
	}


}