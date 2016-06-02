package fr.iutvalence.info.dut.m2107;

public class Enemy{

	private int speed;
	private int health;
	private int size;
	private int damage;
	private Easy_Color color;
	
	public Enemy(int speed, int size, int health, int damage, Easy_Color color)
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

	public Easy_Color getColor() {
		return color;
	}
	
}