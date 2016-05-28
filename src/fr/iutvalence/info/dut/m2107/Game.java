package fr.iutvalence.info.dut.m2107;

/**
 * @author popekn
 * Represents the game itself
 */
public class Game {

	private int score;
	private Ship ship;
	public static final int DEFAULT_SHIP_SIZE=5;
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
		this.ship=new Ship(weapon, hull , new Dot(GUI.DEFAULT_WIDTH/2,GUI.DEFAULT_HEIGHT-40), DEFAULT_SHIP_SIZE);
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

	public void setScore(int score) {
		this.score = score;
	}

	
	public void rightKeyPressed(){
		System.out.println(this.getClass()+" right key pressed");
	}
	public void leftKeyPressed(){
		System.out.println(this.getClass()+" left key pressed");
	}

	public void upKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void downKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	public void enterKeyPressed() {
		// TODO Auto-generated method stub
		
	}

	
}