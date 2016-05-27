package fr.iutvalence.info.dut.m2107;

public class Weapon {

	private final Color weaponColor;
	private final int damageLevel;
	private final String name;
	
	public Weapon(Color color, int damage, String name){
		this.weaponColor=color;
		this.damageLevel=damage;	
		this.name=name;
	}
	
	public Color getWeaponColor() {
		return weaponColor;
	}

	public int getDamageLevel() {
		return damageLevel;
	}

	public String getName() {
		return name;
	}


}