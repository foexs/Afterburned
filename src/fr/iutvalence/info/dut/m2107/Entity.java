package fr.iutvalence.info.dut.m2107;

public class Entity {

	private int health;
	private Hitbox entityPosition;
	
	public Entity(int health, Hitbox entityPosition)
	{
		this.health=health;
		this.entityPosition=entityPosition;
	}

}