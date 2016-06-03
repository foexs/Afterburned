package fr.iutvalence.info.dut.m2107;

/**
 * The player's ship
 * @author simon
 *
 */
public class Ship {
	
	private Weapon weapon;
	private Hull hull;
	private Dot position;
	private float angle;
	private int health;
	private int damageBonus;
	private int size;
	
	/**
	 * 
	 * @param currentWeapon weapon
	 * @param currentHull hull
	 * @param shipPosition start position
	 * @param shipSize size in (pixels/2)-1
	 */
	public Ship(Weapon currentWeapon, Hull currentHull,Dot shipPosition , int shipSize)
	{
		this.weapon = currentWeapon;
		this.hull = currentHull;
		this.position = shipPosition;
		this.angle = 90;
		this.damageBonus=0;
		this.size = shipSize;
		this.health=(int)this.hull.getProtectionLevel();
	}
	
	/**
	 * 
	 * @return ship's weapon
	 */
	public Weapon getCurrentWeapon() {
		return this.weapon;
	}
	
	/**
	 * 
	 * @return path of the file used to display the ship
	 */
	public String getShipPath(){
		return this.hull.getHullPath();
	}
	
	/**
	 * 
	 * @return ship's hull
	 */
	public Hull getCurrentHull() {
		return this.hull;
	}
	
	/**
	 * 
	 * @return Ship's damage the laser does
	 */
	public int getDamage() {
		return this.weapon.getDamageLevel()+this.damageBonus;
	}
	
	/**
	 * Increase the laser's damage
	 * @param dmg the amount of damage the ship will gain
	 */
	public void increaseDamage(int dmg){
		this.damageBonus=this.damageBonus+dmg;
	}
	/**
	 * 
	 * @return Health
	 */
	public int getHealth()
	{
		return this.health;
	}
	/**
	 * 
	 * @param hp the hp to add to the actual ship's health
	 */
	public void heal(int hp){
		this.health=this.health+hp;
	}
	/**
	 * 
	 * @return hull protection
	 */
	public float getProtection(){
		return this.hull.getProtectionLevel();
	}
	/**
	 * 
	 * @return ship position
	 */
	public Dot getPosition() {
		return this.position;
	}
	/**
	 * 
	 * @param ship aiming angle
	 */
	public void setAngle(float angle) {
		if (angle>=180){
			this.angle = angle-180;
		}
		if (angle<=0.0){
			this.angle=1;
		}
		if (angle>0 && angle<180){
			this.angle=angle;
		}	
		
		this.angle=angle;
	}
	
	/**
	 * 
	 * @return ship aiming angle
	 */
	public float getAngle() {
		return this.angle;
	}
	
	/**
	 * 
	 * @param position
	 */
	public void setPosition(Dot position)
	{
		this.position=position;
	}
	/**
	 * 
	 * @return a Hitbox generated from the size and position of the ship
	 */
	public Hitbox getHitbox(){
		return new Hitbox(this.position.getX()-this.size, this.position.getX()+this.size , this.position.getY()-this.size , this.position.getY()+this.size);
	}

}