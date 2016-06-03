package fr.iutvalence.info.dut.m2107;
/**
 * An ennemy that can attack you
 * @author simon
 *
 */
public class Enemy{
	
	
	/**
	 * Each enemy has a set speed which defines how much tiles they can move after their turn
	 */
	private int speed;
	
	/**
	 * The enemy's health
	 */
	private int health;
	private int size;
	private int damage;
	private EasyColor color;
	
	public Enemy(int speed, int size, int health, int damage, EasyColor color)
	{
		this.speed=speed;
		this.health=health;
		this.size=size;
		this.damage=damage;
		this.color=color;
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
	 * @return health
	 */
	public int getHealth() {
		return health;
	}
	/**
	 * 
	 * @return Hitbox
	 */
	public Hitbox getHitbox(){
		return new Hitbox(-this.size,this.size,-this.size,this.size);
	}
	/**
	 * 
	 * @return damage they inflict to you
	 */
	public int getDamage() {
		return damage;
	}
	/**
	 * 
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}

	public EasyColor getColor() {
		return color;
	}
	
}