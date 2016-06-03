package fr.iutvalence.info.dut.m2107;

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
	
	//getters and setters
	public int getSize() {
		return size;
	}

	public int getHealth() {
		return health;
	}
	public Hitbox getHitbox(){
		return new Hitbox(-this.size,this.size,-this.size,this.size);
	}
	public int getDamage() {
		return damage;
	}

	public int getSpeed() {
		return speed;
	}

	public EasyColor getColor() {
		return color;
	}
	
}