package fr.iutvalence.info.dut.m2107;

public class Item {

	private int size;
	private int healthRestoreLevel;
	private int baseDamageLevel;
	private boolean bomb;
	
	public Item(int itemSize, int healthRestoreLevel, int baseDamageLevel, boolean bomb){
		this.size=itemSize;
		this.healthRestoreLevel=healthRestoreLevel;
		this.baseDamageLevel=baseDamageLevel;
		this.bomb=bomb;
	}
	
	public int getSize() {
		return size;
	}
	public Hitbox getHitbox(){
		return new Hitbox(-this.size,this.size,-this.size,this.size);
	}
	public boolean isBomb() {
		return bomb;
	}
	public int getBaseDamageLevel() {
		return baseDamageLevel;
	}
	public int getHealthRestoreLevel() {
		return healthRestoreLevel;
	}

}