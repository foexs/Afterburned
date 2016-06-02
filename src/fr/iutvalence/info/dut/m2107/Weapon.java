package fr.iutvalence.info.dut.m2107;

public class Weapon {

	private final Easy_Color weaponColor;
	private final int damageLevel;
	private final String name;
	
	public Weapon(Easy_Color color, int damage, String name){
		this.weaponColor=color;
		this.damageLevel=damage;	
		this.name=name;
	}
	
	public Easy_Color getWeaponColor() {
		return weaponColor;
	}

	public int getDamageLevel() {
		return damageLevel;
	}

	public String getName() {
		return name;
	}


}