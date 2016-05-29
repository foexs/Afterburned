package fr.iutvalence.info.dut.m2107;


public class Ship {
	
	//attributes
	private Weapon weapon;
	private Hull hull;
	private Dot position;
	private float angle;
	private int health;
	private int damageBonus;
	
	//shipSize will be used to calculate its hitbox.
	private int size;
	//private Hitbox shipHitBox; Removed, direct use of getHitbox instead
	public Ship(Weapon currentWeapon, Hull currentHull,Dot shipPosition , int shipSize)
	{
		//Set the default values and constructors
		//Weapon must have an ID!
		this.weapon = currentWeapon;
		this.hull = currentHull;
		this.position = shipPosition;
		this.angle = 0;
		this.damageBonus=0;
		this.size = shipSize;
	}
	//
	/**
	 * Move the ship?
	 * Might have a parameter to set the direction,
	 * this one looks not usable for turn based game, but if the game evolve to real time it could be useful
	 */
	public void Move() {
		//TODO
		//if the player wants to go right
		setPosition(new Dot(this.position.getX()+1,this.position.getY()));
		//if the player wants to go left
		setPosition(new Dot(this.position.getX()-1,this.position.getY()));
		//if the player wants to go up
		setPosition(new Dot(this.position.getX(),this.position.getY()-1));
		//if the player wants to go down
		setPosition(new Dot(this.position.getX(),this.position.getY()+1));
		throw new UnsupportedOperationException();
	}
		
	//getters and setters
	public Weapon getCurrentWeapon() {
		return this.weapon;
	}

	public Hull getCurrentHull() {
		return this.hull;
	}

	public int getDamage() {
		return this.weapon.getDamageLevel()+this.damageBonus;
	}
	public void increaseDamage(int dmg){
		this.damageBonus=this.damageBonus+dmg;
	}
	public int getHealth()
	{
		return this.health;
	}
	public void heal(int hp){
		this.health=this.health+hp;
	}
	public float getProtection(){
		return this.hull.getProtectionLevel();
	}
	public float getAngle() {
		return this.angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	public void setPosition(Dot position)
	{
		this.position=position;
	}
	
	public Hitbox getHitbox(){
		return new Hitbox(this.position.getX()-this.size, this.position.getX()+this.size , this.position.getY()-this.size , this.position.getY()+this.size);
	}

}