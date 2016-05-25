package fr.iutvalence.info.dut.m2107;

public class Game {

	private int score;
	private Environment environment;
	
	public Game(Environment environment)
	{
		this.score=0;
		this.environment=environment;
	}

	//getters and setters
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Environment getEnvironment() {
		return environment;
	}

	public void setEnvironment(Environment environment) {
		this.environment = environment;
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