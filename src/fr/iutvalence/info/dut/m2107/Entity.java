package fr.iutvalence.info.dut.m2107;

public class Entity {

	private int health;
	private Hitbox entityPosition;
	
	public Entity(int health, Hitbox entityPosition)
	{
		this.health=health;
		this.entityPosition=entityPosition;
	}
	
	public String modHealth(int hp)
	{
		this.health=hp;
		return "done";
	}

	public String modHitbox(Hitbox newhb)
	{
		this.entityPosition=newhb;
		return "done";
	}
}