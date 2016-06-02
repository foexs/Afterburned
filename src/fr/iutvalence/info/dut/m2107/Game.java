package fr.iutvalence.info.dut.m2107;

import java.awt.event.MouseEvent;
import java.util.LinkedList;
import java.util.List;

/**
 * @author popekn
 * Represents the game itself
 */
public class Game {

	private int score;
	protected Ship ship;
	public static final int DEFAULT_SHIP_SIZE=62;
	private static final double MAX_ROCK_HEALTH = 100000;
	private LinkedList<Entity> entities;
	/**
	 * contains the settings
	 */
	private MainMenu menu;
	
	/**
	 * Game's algorithm. Everything related to the Game goes here. 
	 */
	public Game(MainMenu menu)
	{
		Weapon weapon=menu.ws.weapons.get(menu.currentWeapon);
		Hull hull=menu.hs.hulls.get(menu.currentHull);
		this.score=0;
		this.menu=menu;
		this.ship=(new Ship(weapon, hull , new Dot(GUI.DEFAULT_WIDTH/2,GUI.DEFAULT_HEIGHT-40), DEFAULT_SHIP_SIZE));
		entities = new LinkedList<Entity>();

	}
	public void enemyTurn(){
		
	}
	/**
	 * @return 
	 */
	//getters and setters
	public int getScore() {
		return score;
	}

	public LinkedList<Entity> getEntities() {
		return entities;
	}
	
	public void spawnRandomly(double itemRate, double enemyRate, double rockRate, ItemSet itemSet, EnemySet enemySet ){
		if(Math.random()<itemRate){
			spawnItem(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0), itemSet.getItems().get((int)Math.round(Math.random()*itemSet.getItems().size())));
		}
		
		if(Math.random()<enemyRate){
			spawnEnemy(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0), enemySet.getEnemies().get((int)Math.round(Math.random()*enemySet.getEnemies().size())));
		}
		
		if(Math.random()<rockRate){
			int solidity=(int)Math.round(Math.random()*MAX_ROCK_HEALTH);
			spawnEntity(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0),solidity/5000, solidity);
		}
	}
	
	public void spawnItem(Dot position,Item item){
		entities.add(new Entity(position,item));
	}
	public void spawnEnemy(Dot position,Enemy enemy){
		entities.add(new Entity(position,enemy));
	}
	public void spawnEntity(Dot position,int size, int health){
		entities.add(new Entity(position, size, health));
	}
	public Ship getShip() {
		return ship;
	}	
	public int getShipSize() {
		return DEFAULT_SHIP_SIZE;
	}	
	
	public void collisionUpdate(){
		for(int i=0; i<this.entities.size()-1;i++){
			/**
			 * looks if the two hitboxes touches
			 */
			if(this.ship.getHitbox().isIn(this.entities.get(i).getHitbox())){
				/**
				 * if the entity is an item
				 */
				if(this.entities.get(i).getType()==EntityType.ITEM){
					
					this.ship.heal(this.entities.get(i).getItem().getHealthRestoreLevel());
					
					this.ship.increaseDamage(this.entities.get(i).getItem().getBaseDamageLevel());
					/**
					 * clear screen if bomb
					 */
					if(this.entities.get(i).getItem().isBomb()){
						this.entities = new LinkedList<Entity>();
					}
				}
				/**
				 * the entity is an enemy or a rock
				 */
				else{
					/**
					 * deal damages to the ship
					 */
					this.ship.heal(-this.entities.get(i).getHealth());
				}
				/**
				 * destroy entity
				 */
				this.entities.remove(i);
				
			}
			
		}
	}
	
	public void shoot(float angle, int xDepart, int yDepart){
		
		int xArrivee= (int) Math.round((GUI.DEFAULT_HEIGHT-yDepart)/Math.tan(Math.toRadians(angle)))+xDepart;
		int yArrivee=0;
		double xActuel=xDepart;
		int yActuel=yDepart;
		int xAParcourir=xDepart-xArrivee;
		int yAParcourir=yDepart-yArrivee;
		System.out.println("A parcourir ("+xAParcourir+","+yAParcourir+")");
		
		while (yActuel>yArrivee){
			
			xActuel = (1/Math.tan(Math.toRadians(angle)))/Math.PI+xActuel; //avancer sur X
			yActuel--; //avancer sur Y

			for(int i=0; i<this.entities.size()-1;i++){//Parcourir les entités
				int xBuf=(int) Math.round(xActuel);
				if(new Hitbox(xBuf,yActuel,xBuf,yActuel).isIn(this.entities.get(i).getHitbox())){
					this.entities.get(i).heal(-this.getShip().getDamage());//Damage entity
					
					if(this.entities.get(i).getHealth()<=0){
						this.entities.remove(i);
					}
				}
			}
			if (Math.round(xActuel)<=0||Math.round(xActuel)>=GUI.DEFAULT_WIDTH){
				angle=180-angle;
				yActuel++; //avancer sur Y
			}
		}
		System.out.println("Actuel x,y:"+xActuel+" , "+yActuel);
		
		System.out.println("x2= "+xArrivee);
	}
	
	public void rightKeyPressed(){
		if (this.ship.getAngle()>5){
			this.ship.setAngle(this.ship.getAngle()-5);
		}
	}
	public void leftKeyPressed(){
		if (this.ship.getAngle()<175){
			this.ship.setAngle(this.ship.getAngle()+5);
		}
	}

	public void upKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void downKeyPressed() {
				
	}

	public void enterKeyPressed() {
		// TODO Auto-generated method stub
		shoot(this.getShip().getAngle(),this.getShip().getPosition().getX(),this.getShip().getHitbox().getMinY());
		
	}
	public void onMouseReleased(int x) {
		ship.setPosition(new Dot(x,ship.getPosition().getY()));
	}

}