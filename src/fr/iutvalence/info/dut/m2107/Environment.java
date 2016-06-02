package fr.iutvalence.info.dut.m2107;

public enum Environment {
	nebula("ihm/nebulab.png",50,0,0,0.15),
	asteroidField("ihm/asteroid.png",0,0.50,0,0.15),
	sunbelt("ihm/sun.png", 0, 0, 10, 0.15),
	orbit("ihm/orbitl.png", 0, 0, 0, 0.5),
	emptySpace("ihm/empty.png", 0, 0, 0, 0.15);
	
	
	//Nebula
	int fogLevel;
	//asteroidField
	double asteroidSpawnRate;
	//sunBelt
	/*
	 * sunDamage will set how much damage the player takes. I'll increase as the player gets closer to it.
	 */
	int sunDamage;

	double enemySpawnRate;
	
	String backgroundPath;
	
	//emptySpace
	//This environment will have no effect on the player.
	
	
	
	private Environment(String backgroundPath, int fogLevel, double asteroidSpawnRate, int sunDamage, double enemySpawnRate){
		this.backgroundPath=backgroundPath;
		this.fogLevel=fogLevel;
		this.asteroidSpawnRate=asteroidSpawnRate;
		this.sunDamage=sunDamage;
		this.enemySpawnRate=enemySpawnRate;
	}
	//getters
	
	public String getBackgroundPath() {
		return backgroundPath;
	}
	public double getEnemySpawnRate() {
		return enemySpawnRate;
	}
	public int getFogLevel() {
		return fogLevel;
	}
	public double getAsteroidSpawnRate() {
		return asteroidSpawnRate;
	}
	public int getSunDamage() {
		return sunDamage;
	}


	
}


