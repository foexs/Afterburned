package fr.iutvalence.info.dut.m2107;

/**
 * @author Popek
 * This class defines what an item is and what are their impacts on the player.
 */
public class Item {

	private int size;
	private int healthRestoreLevel;
	private int baseDamageLevel;
	private boolean bomb;
	
	/**
	 * @param itemSize : A multiplier which set the size of the item
	 * @param healthRestoreLevel : Set the amount of health the player regenerates, if it does
	 * @param baseDamageLevel : Increase the amount of damages the player does
	 * @param bomb : 
	 */
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