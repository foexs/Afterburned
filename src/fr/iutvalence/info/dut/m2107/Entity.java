package fr.iutvalence.info.dut.m2107;
/**
 * Something on the game screen, can  contain an object
 * @author simon
 *
 */
public class Entity {
	
	public static final int DEFAULT_SPEED=50;
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
	/**
	 * 
	 * @return size
	 */
	public int getSize() {
		return size;
	}
	/**
	 * 
	 * @return position
	 */
	public Dot getPosition(){
		return this.position;
	}
	/**
	 * Set the middle position
	 * @param position
	 */
	public void setPosition(Dot position) {
		this.position = position;
	}
	
	/**
	 * 
	 * @return health
	 */
	public int getHealth(){
		return this.health;
	}
	/**
	 * 
	 * @param heal add health point to the entity, you can add negative values
	 */
	public void heal(int heal){
		this.health=this.health+heal;
	}
	/**
	 * 
	 * @return Hitbox of the entity, where it actually is
	 */
	public Hitbox getHitbox(){
		return new Hitbox(this.position.getX()-this.size,this.position.getX()+this.size,this.position.getY()-this.size,this.position.getY()+this.size);
	}
	/**
	 * 
	 * @return type of the entity
	 */
	public EntityType getType() {
		return type;
	}
	/**
	 * 
	 * @return the item contained in the entity
	 */
	public Item getItem() {
		return item;
	}
	/**
	 * 
	 * @return the enemy contained in the entity
	 */
	public Enemy getEnemy() {
		return enemy;
	}
	/**
	 * @return the angle the entity is flying to and it's 0<=angle<=180
	 */
	public int getDirection() {
		return direction;
	}
	/**
	 * Choose where the entity is heading to
	 * @param direction
	 */
	public void setDirection(int direction) {
		this.direction = direction;
	}
	/**
	 * 
	 * @return speed
	 */
	public int getSpeed() {
		return speed;
	}
	/**
	 * 
	 * @return color
	 */
	public EasyColor getColor(){
		if (this.type==EntityType.GENERAL)
			return EasyColor.green;
		
		if (this.type==EntityType.ITEM)
			return EasyColor.blue;
		
		if (this.type==EntityType.ENEMY)
			return enemy.getColor();
		
		return EasyColor.grey;
		
		
	}
}
