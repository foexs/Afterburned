package fr.iutvalence.info.dut.m2107;

/**
 * @author popekn
 * Represents the game itself
 */
public class Game {

	private int score;
	
	/**
	 * Game's algorithm. Everything related to the Game goes here. 
	 */
	public Game()
	{
		this.score=0;
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