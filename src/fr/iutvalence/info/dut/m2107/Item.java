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
	 * @param itemSize : A multiplier which is the size of the item
	 * @param healthRestoreLevel : Set the amount of health the player regenerates, if it does
	 * @param baseDamageLevel : Increase the amount of damages the player does
	 * @param bomb : If the player catch a bomb, it clear every single entity in the screen
	 */
	public Item(int itemSize, int healthRestoreLevel, int baseDamageLevel, boolean bomb){
		this.size=itemSize;
		this.healthRestoreLevel=healthRestoreLevel;
		this.baseDamageLevel=baseDamageLevel;
		this.bomb=bomb;
	}
	/**
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @return hitbox
	 */
	public Hitbox getHitbox(){
		return new Hitbox(-this.size,this.size,-this.size,this.size);
	}
	/**
	 * 
	 * @return true if it's a bomb
	 */
	public boolean isBomb() {
		return bomb;
	}
	/**
	 * 
	 * @return damage bonus
	 */
	public int getBaseDamageLevel() {
		return baseDamageLevel;
	}
	/**
	 * 
	 * @return heal amount
	 */
	public int getHealthRestoreLevel() {
		return healthRestoreLevel;
	}

}