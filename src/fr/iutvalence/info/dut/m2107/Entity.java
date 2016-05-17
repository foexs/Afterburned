package fr.iutvalence.info.dut.m2107;

public interface Entity {

	private int health;
	private Hitbox hitbox;
	
	public Entity(int health, Hitbox entityPosition)
	{
		this.health=health;
		this.hitbox=entityPosition;
	}
	
	public String modHealth(int hp)
	{
		this.health=hp;
		return "done";
	}

	public String modHitbox(Hitbox newhb)
	{
		this.hitbox=newhb;
		return "done";
	}
}