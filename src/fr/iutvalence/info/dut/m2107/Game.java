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
	
	public void shoot(){
		int x1 = this.getShip().getPosition().getX();
		int y1 = this.getShip().getHitbox().getMinY();
		float angle=this.getShip().getAngle();
		int x2= (int) Math.round((GUI.DEFAULT_HEIGHT-y1)/Math.tan(Math.toRadians(angle)))+this.getShip().getPosition().getX();
		int y2=0;
		float iX=x1;
		float iY=y1;
		int xMul=1;
		if (x2<x1)
			xMul=-1;
		/**
		 * parcours chaque point de la ligne de tir
		 */
		while (iY>1){			
			if (iX<1){
				xMul=1;
				angle=180-angle;
				x2=(int) Math.round((GUI.DEFAULT_HEIGHT-iY)/Math.tan(Math.toRadians(angle)));
			}
			
			if((iX-x1)/(x2-x1)>(iY-y1)/(y2-y1) || x1==x2){
				iY--;
				//TODO: Agir
			}
			if((iX-x1)/(x2-x1)<=(iY-y1)/(y2-y1)){
				iX=iX+xMul;
				//TODO: Agir
			}
			System.out.println("iX= "+iX+" iY= "+iY);			
		}
		System.out.println("x2= "+x2);
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
		shoot();
		
	}
	public void onMouseReleased(int x) {
		ship.setPosition(new Dot(x,ship.getPosition().getY()));
	}
	
	
	

	
}