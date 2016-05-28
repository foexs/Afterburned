package fr.iutvalence.info.dut.m2107;

public class Entity {
	
	private int size;
	private int health;
	private Dot position;
	private EntityType type;
	private Enemy enemy;
	private Item item;
	
	public Entity(Dot position, Item item){
		this.position=position;
		this.size=item.getSize();
		this.health=1;
		this.type =EntityType.ITEM;
		this.item=(item);
	}
	
	public Entity(Dot position, Enemy enemy){
		this.position=position;
		this.size=enemy.getSize();
		this.health=enemy.getHealth();
		this.type=EntityType.ENEMY;
		this.enemy=enemy;
	}
	
	public Entity(Dot position,int size, int health){
		this.position=position;
		this.size=size;
		this.health=health;
		this.type=(EntityType.GENERAL);

	}
	
	public int getSize() {
		return size;
	}
	
	public Dot getPosition(){
		return this.position;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public Hitbox getHitbox(){
		return new Hitbox(this.position.getX()-this.size,this.position.getX()+this.size,this.position.getY()-this.size,this.position.getY()+this.size);
	}

	public EntityType getType() {
		return type;
	}

	public Item getItem() {
		return item;
	}

	public Enemy getEnemy() {
		return enemy;
	}
}
