package fr.iutvalence.info.dut.m2107;

public enum Environment {
	nebula("ihm/nebulab.png",50,0,0,0.15),
	asteroidField("ihm/asteroid.png",0,0.50,0,0.15),
	sunbelt("ihm/sun.png", 0, 0, 10, 0.15),
	orbit("ihm/orbitl.png", 0, 0, 0, 0.5),
	emptySpace("ihm/empty.png", 0, 0, 0, 0.15);
	
	/**
	 * How is the visibility obscured
	 */
	int fogLevel;
	/**
	 * Asteroid spawn rate
	 */
	double asteroidSpawnRate;
	/**
	 * sunDamage will set how much damage the player takes.
	 */
	int sunDamage;
	/**
	 * enemy spawn rate
	 */
	double enemySpawnRate;
	/**
	 * The path of the background of the environment
	 */
	String backgroundPath;
	
	
	
	/**
	 * 
	 * @param backgroundPath The path of the background of the environment
	 * @param fogLevel How is the visibility obscured
	 * @param asteroidSpawnRate Asteroid spawn rate
	 * @param sunDamage sunDamage will set how much damage the player takes.
	 * @param enemySpawnRate enemy spawn rate
	 */
	private Environment(String backgroundPath, int fogLevel, double asteroidSpawnRate, int sunDamage, double enemySpawnRate){
		this.backgroundPath=backgroundPath;
		this.fogLevel=fogLevel;
		this.asteroidSpawnRate=asteroidSpawnRate;
		this.sunDamage=sunDamage;
		this.enemySpawnRate=enemySpawnRate;
	}
	/**
	 * 
	 * @return backgroundPath
	 */
	public String getBackgroundPath() {
		return backgroundPath;
	}
	/**
	 * 
	 * @return enemySpawnRate
	 */ 
	public double getEnemySpawnRate() {
		return enemySpawnRate;
	}
	/**
	 * 
	 * @return fogLevel
	 */
	public int getFogLevel() {
		return fogLevel;
	}
	/**
	 * 
	 * @return asteroidSpawnRate
	 */
	public double getAsteroidSpawnRate() {
		return asteroidSpawnRate;
	}
	/**
	 * 
	 * @return sunDamage
	 */
	public int getSunDamage() {
		return sunDamage;
	}


	
}


