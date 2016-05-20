package fr.iutvalence.info.dut.m2107;

public class Entity {
	
	private int size;
	private int health;
	private Dot position;
	
	public int getSize() {
		return size;
	}
	
	public Dot getPosition(){
		return this.position;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	/**
	 * Spawn an entity using its size
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param size
	 */
	public void spawn(int maxX, int maxY, int position, int size){
		spawn(maxX, maxY, position, new Hitbox(-this.size,this.size,-this.size,this.size));
	}
	/**
	 * Spawn an entity using its size
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param size
	 */
	public void spawnEnemy(int maxX, int maxY, int position, int size, Enemy currentMonster){
		spawnEnemy(maxX, maxY, position, new Hitbox(-this.size,this.size,-this.size,this.size), currentMonster);
	}
	/**
	 * Spawn an entity using its size
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param size
	 */
	public void spawnItem(int maxX, int maxY, int position, int size, Item currentItem){
		spawnItem(maxX, maxY, position, new Hitbox(-this.size,this.size,-this.size,this.size), currentItem);
	}
	/**
	 * Spawn an entity using a custom hitbox
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param hitbox
	 */
	public void spawn(int maxX, int maxY, int position, Hitbox hitbox){
		//todo
	}
	/**
	 * Spawn an entity using a custom hitbox
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param hitbox
	 */
	public void spawnEnemy(int maxX, int maxY, int position, Hitbox hitbox, Enemy currentMonster){
		//todo
	}
	/**
	 * Spawn an entity using a custom hitbox
	 * @param maxX
	 * @param maxY
	 * @param position
	 * @param hitbox
	 */
	public void spawnItem(int maxX, int maxY, int position, Hitbox hitbox, Item currentItem){
		//todo
	}
	
}
