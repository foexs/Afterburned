package fr.iutvalence.info.dut.m2107;

public class Game {

	private int score;
	private Environment environment;
	
	public Game(int score, Environment environment)
	{
		this.score=score;
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

	
}