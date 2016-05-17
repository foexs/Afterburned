package fr.iutvalence.info.dut.m2107;

public class Enemy {

	private int size;
	private int speed;
	private int health;
	private int damage;
	
	public Enemy(int speed, int size, int health, int damage) extends Entity
	{
		this.speed=speed;
		this.health=health;
		this.size=size;
		this.damage=damage;
	}
	
	//getters and setters
	public int getSize() {
		return size;
	}
	

}