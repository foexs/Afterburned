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
	public static final double ITEM_SPAWN_RATE=0.15;
	private static final double MAX_ROCK_HEALTH = 100000;
	protected LinkedList<Entity> entities;
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
	/**
	 * 
	 * @param itemRate >=0 and <1 rate of itemSpawn, "normal value" should be around 0.15
	 * @param enemyRate >=0 and <1 rate of itemSpawn, "normal value" should be around 0.15
	 * @param rockRate >=0 and <1 rate of itemSpawn, "normal value" should be around 0.15
	 * @param itemSet where to find the items to spawn
	 * @param enemySet where to find the enemies to spawn
	 */
	public void spawnRandomly(double itemRate, double enemyRate, double rockRate, ItemSet itemSet, EnemySet enemySet ){
		if(Math.random()<itemRate){
			spawnItem(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0), itemSet.getItems().get((int)Math.round(Math.random()*(itemSet.getItems().size()-1))));
		}
		
		if(Math.random()<enemyRate){
			spawnEnemy(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0), enemySet.getEnemies().get((int)Math.round(Math.random()*(enemySet.getEnemies().size()-1))));
		}
		
		if(Math.random()<rockRate){
			int solidity=(int)Math.round(Math.random()*MAX_ROCK_HEALTH);
			spawnEntity(new Dot((int)Math.round(Math.random()*GUI.DEFAULT_WIDTH), 0),solidity/5000, solidity);
		}
	}
	
	/**
	 * Move all the entities on the screen
	 */
	public void moveEntities(){
		for(int i=0; i<this.entities.size(); i++){
			this.entities.get(i).setPosition(new Dot( (int) ((1/Math.tan(Math.toRadians(this.entities.get(i).getDirection())))/Math.PI+this.entities.get(i).getPosition().getX()) , this.entities.get(i).getPosition().getY()+this.entities.get(i).getSpeed()));
		}
	}
	
	/**
	 * Add an entity containing an item to the game's entity list
	 * @param position
	 * @param item
	 */
	public void spawnItem(Dot position,Item item){
		entities.add(new Entity(position,item));
	}
	/**
	 * Add an entity containing an enemy to the game's entity list
	 * @param position
	 * @param item
	 */
	public void spawnEnemy(Dot position,Enemy enemy){
		entities.add(new Entity(position,enemy));
	}
	/**
	 * Add a general entity to the game's entity list
	 * @param position
	 * @param item
	 */
	public void spawnEntity(Dot position,int size, int health){
		entities.add(new Entity(position, size, health));
	}
	
	/**
	 * @return ship
	 */
	public Ship getShip() {
		return this.ship;
	}	
	
	/**
	 * Update damages caused by collisions
	 */
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
	
	/**
	 * Shoot the laser from the ship with the chosen angle, damage entities if needed
	 * 
	 * @param angle shooting angle
	 * @param xDepart ship's X
	 * @param yDepart ship's Y
	 */
	public void shoot(float angle, int xDepart, int yDepart){
		
		int yArrivee=0;
		double xActuel=xDepart;
		int yActuel=yDepart;
		while (yActuel>yArrivee){
			/**
			 * Move laser's X
			 */
			xActuel = (1/Math.tan(Math.toRadians(angle)))/Math.PI+xActuel;
			/**
			 * Move laser's Y
			 */
			yActuel--; 
			/**
			 * For all entities
			 */
			for(int i=0; i<this.entities.size()-1;i++){
				/**
				 * Look if the laser touched something
				 */
				int xBuf=(int) Math.round(xActuel);
				if(new Hitbox(xBuf,yActuel,xBuf,yActuel).isIn(this.entities.get(i).getHitbox())){
					/**
					 * Damage entity
					 */
					this.entities.get(i).heal(-this.getShip().getDamage());//Damage entity
					/**
					 * Destroy entity if it's dead
					 */
					if(this.entities.get(i).getHealth()<=0){
						this.entities.remove(i);
					}
				}
			}
			/**
			 * If the laser reach the screen's border, change angle
			 */
			if (Math.round(xActuel)<=0||Math.round(xActuel)>=GUI.DEFAULT_WIDTH){
				angle=180-angle;
				yActuel++;
			}
		}
	}
	/**
	 * When right key is pressed and we're in game phase
	 */
	public void rightKeyPressed(){
		if (this.ship.getAngle()>5){
			this.ship.setAngle(this.ship.getAngle()-5);
		}
	}
	
	/**
	 * When left key is pressed and we're in game phase
	 */
	public void leftKeyPressed(){
		if (this.ship.getAngle()<175){
			this.ship.setAngle(this.ship.getAngle()+5);
		}
	}


	/**
	 * When enter key is pressed and we're in game phase
	 */
	public void enterKeyPressed() {
		// TODO Auto-generated method stub
		shoot(this.getShip().getAngle(),this.getShip().getPosition().getX(),this.getShip().getHitbox().getMinY());
		spawnRandomly(ITEM_SPAWN_RATE,this.menu.currentEnvironment.getEnemySpawnRate(),this.menu.currentEnvironment.getAsteroidSpawnRate(), this.menu.is, this.menu.es);
		moveEntities();
		collisionUpdate();
		
		
	/**
	* When mouse click is released and we're in game phase
	*/
	}
		public void onMouseReleased(int x) {
		ship.setPosition(new Dot(x,ship.getPosition().getY()));
	}

}