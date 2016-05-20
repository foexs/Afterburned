package fr.iutvalence.info.dut.m2107;


public class Ship {
	
	//attributes
	private Weapon currentWeapon;
	private Hull currentHull;
	private Dot position;
	private int baseDamage;
	private int healthPoint;
	private float angle;
	
	//shipSize will be used to calculate its hitbox.
	private int size;
	//private Hitbox shipHitBox; Removed, direct use of getHitbox instead
	public Ship(Weapon currentWeapon, Hull currentHull,Dot shipPosition , int baseDamage, int healthPoint, float angle, int shipSize, Hitbox shipHitBox)
	{
		//Set the default values and constructors
		//Weapon must have an ID!
		this.currentWeapon = currentWeapon;
		this.currentHull = currentHull;
		this.position = shipPosition;
		this.baseDamage = baseDamage;		
		this.healthPoint = healthPoint;
		this.angle = angle;
		this.size = shipSize;
	}
	//
	//methods
	public void Fire() {
		// TODO - implement Ship.Fire
		throw new UnsupportedOperationException();
	}

	public void Aim() {
		// TODO - implement Ship.Aim
		//Angle 'll be set by the player.
		this.setAngle(angle);
		throw new UnsupportedOperationException();
	}
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
	
	public void Move(Dot newCoordinates){
		this.position=newCoordinates;
	}
	
	
	//getters and setters
	
	public Hitbox getHitBox(int sizeMult)
	{
		return new Hitbox(sizeMult,sizeMult,sizeMult,sizeMult);
	}
	
	public Weapon getCurrentWeapon() {
		return this.currentWeapon;
	}

	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	public Hull getCurrentHull() {
		return this.currentHull;
	}

	public void setCurrentHull(Hull currentHull) {
		this.currentHull = currentHull;
	}


	public int getBaseDamage() {
		return this.baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getHealthPoint() {
		return this.healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
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