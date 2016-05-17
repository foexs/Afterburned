package fr.iutvalence.info.dut.m2107;

public class Ship {
	
	//attributes
	private Weapon currentWeapon;
	private Hull currentHull;
	private Hitbox shipPosition;
	private int baseDamage;
	private int healthPoint;
	private float angle;
	
	//methods
	public void Fire() {
		// TODO - implement Ship.Fire
		throw new UnsupportedOperationException();
	}

	public void Aim() {
		// TODO - implement Ship.Aim
		throw new UnsupportedOperationException();
	}

	public void Move() {
		// TODO - implement Ship.Move
		throw new UnsupportedOperationException();
	}

	
	
	//getters and setters
	
	
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

	public Hitbox getShipPosition() {
		return shipPosition;
	}

	public void setShipPosition(Hitbox shipPosition) {
		this.shipPosition = shipPosition;
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

}