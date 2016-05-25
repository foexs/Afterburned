package fr.iutvalence.info.dut.m2107;

public enum Environment {
	nebula("ihm/environnement brouillard nébuleuse",50,0,0,50),
	asteroidField("ihm/environnement brouillard nébuleuse",0,50,0,50),
	sunbelt("ihm/environnement brouillard nébuleuse", 0, 0, 10, 50),
	orbit("ihm/environnement brouillard nébuleuse", 0, 0, 0, 80),
	emptySpace("ihm/environnement brouillard nébuleuse", 0, 0, 0, 50);
	
	
	//Nebula
	int fogLevel;
	//asteroidField
	int asteroidSpawnRate;
	//sunBelt
	/*
	 * sunDamage will set how much damage the player takes. I'll increase as the player gets closer to it.
	 */
	int sunDamage;

	int enemySpawnRate;
	
	String backgroundPath;
	
	//emptySpace
	//This environment will have no effect on the player.
	
	
	
	private Environment(String backgroundPath, int fogLevel, int asteroidSpawnRate, int sunDamage, int enemySpawnRate){
		
	}
	//getters
	
	public String getBackgroundPath() {
		return backgroundPath;
	}
	public int getEnemySpawnRate() {
		return enemySpawnRate;
	}
	public int getFogLevel() {
		return fogLevel;
	}
	public int getAsteroidSpawnRate() {
		return asteroidSpawnRate;
	}
	public int getSunDamage() {
		return sunDamage;
	}


	
}


