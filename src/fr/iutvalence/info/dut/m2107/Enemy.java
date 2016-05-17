package fr.iutvalence.info.dut.m2107;

public class Enemy {

	private int enemyId;
	private Hitbox size;
	
	public Enemy(int enemyId, Hitbox size)
	{
		this.enemyId=enemyId;
		this.size=size;
	}
	
	//getters and setters

	public int getEnemyId() {
		return enemyId;
	}

	public void setEnemyId(int enemyId) {
		this.enemyId = enemyId;
	}

	public Hitbox getSize() {
		return size;
	}

	public void setSize(Hitbox size) {
		this.size = size;
	}
	
	

}