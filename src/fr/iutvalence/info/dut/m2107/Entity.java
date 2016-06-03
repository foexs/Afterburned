package fr.iutvalence.info.dut.m2107;

public class Entity {
	
	public static final int DEFAULT_SPEED=10;
	private int size;
	private int health;
	private int speed;
	private Dot position;
	private EntityType type;
	private Enemy enemy;
	private Item item;
	private int direction;
	
	public Entity(Dot position, Item item){
		this.position=position;
		this.size=item.getSize();
		this.health=1;
		this.type =EntityType.ITEM;
		this.item=(item);
		this.direction=(int)Math.round(Math.random()*100)+40;
		this.speed=DEFAULT_SPEED;
	}
	
	public Entity(Dot position, Enemy enemy){
		this.position=position;
		this.size=enemy.getSize();
		this.health=enemy.getHealth();
		this.type=EntityType.ENEMY;
		this.enemy=enemy;
		this.direction=(int)Math.round(Math.random()*100)+40;
		this.speed=enemy.getSpeed();

	}
	
	public Entity(Dot position,int size, int health){
		this.position=position;
		this.size=size;
		this.health=health;
		this.type=(EntityType.GENERAL);
		this.direction=(int)Math.round(Math.random()*100)+40;
		this.speed=DEFAULT_SPEED;


	}
	
	public int getSize() {
		return size;
	}
	
	public Dot getPosition(){
		return this.position;
	}
	
	public void setPosition(Dot position) {
		this.position = position;
	}
	
	public int getHealth(){
		return this.health;
	}
	
	public void heal(int heal){
		this.health=this.health+heal;
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

	public int getDirection() {
		return direction;
	}

	public void setDirection(int direction) {
		this.direction = direction;
	}

	public int getSpeed() {
		return speed;
	}
	
	public EasyColor getColor(){
		if (this.type==EntityType.GENERAL)
			return EasyColor.white;
		
		if (this.type==EntityType.ITEM)
			return EasyColor.blue;
		
		if (this.type==EntityType.ENEMY)
			return enemy.getColor();
		
		return EasyColor.grey;
		
		
	}
}
