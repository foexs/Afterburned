package fr.iutvalence.info.dut.m2107;


public class Ship {
	
	//attributes
	private Weapon currentWeapon;
	private Hull currentHull;
	private Dot shipPosition;
	private int baseDamage;
	private int healthPoint;
	private float angle;
	
	//shipSize will be used to calculate its hitbox.
	private int shipSize;
	private Hitbox shipHitBox;
	public Ship(Weapon currentWeapon, Hull currentHull,Dot shipPosition , int baseDamage, int healthPoint, float angle, int shipSize, Hitbox shipHitBox)
	{
		//Set the default values and constructors
		//Weapon must have an ID!
		currentWeapon = new Weapon(null, 1);
		currentHull = new Hull();
		shipPosition = new Dot(1,1);
		baseDamage = 1;		
		healthPoint = 1;
		angle = 0;
		shipSize = 1;
		shipHitBox = shipSize(shipSize);
		
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

	public void Move() {
		//TODO
		//if the player wants to go right
		setPosition(new Dot(this.shipPosition.getX()+1,this.shipPosition.getY()));
		//if the player wants to go left
		setPosition(new Dot(this.shipPosition.getX()-1,this.shipPosition.getY()));
		//if the player wants to go up
		setPosition(new Dot(this.shipPosition.getX(),this.shipPosition.getY()-1));
		//if the player wants to go down
		setPosition(new Dot(this.shipPosition.getX(),this.shipPosition.getY()+1));
		throw new UnsupportedOperationException();
	}

	
	
	//getters and setters
	
	public Hitbox shipSize(int sizeMult)
	{
		new Hitbox(sizeMult,sizeMult,sizeMult,sizeMult);
		return shipHitBox;
	}
	
	public Weapon getCurrentWeapon() {
		return currentWeapon;
	}

	public void setCurrentWeapon(Weapon currentWeapon) {
		this.currentWeapon = currentWeapon;
	}

	public Hull getCurrentHull() {
		return currentHull;
	}

	public void setCurrentHull(Hull currentHull) {
		this.currentHull = currentHull;
	}


	public int getBaseDamage() {
		return baseDamage;
	}

	public void setBaseDamage(int baseDamage) {
		this.baseDamage = baseDamage;
	}

	public int getHealthPoint() {
		return healthPoint;
	}

	public void setHealthPoint(int healthPoint) {
		this.healthPoint = healthPoint;
	}

	public float getAngle() {
		return angle;
	}

	public void setAngle(float angle) {
		this.angle = angle;
	}
	
	public void setPosition(Dot position)
	{
		this.shipPosition=position;
	}

}