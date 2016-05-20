package fr.iutvalence.info.dut.m2107;

public class Enemy{

	private int speed;
	private int health;
	private int size;
	private int damage;
	private Color color;
	
	public Enemy(int speed, int size, int health, int damage, Color color)
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

	public int getDamage() {
		return damage;
	}

	public int getSpeed() {
		return speed;
	}

	public Color getColor() {
		return color;
	}
	
}