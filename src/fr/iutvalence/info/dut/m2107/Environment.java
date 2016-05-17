package fr.iutvalence.info.dut.m2107;

public enum Environment {
	nebula,
	asteroidField,
	sunbelt,
	orbit,
	emptySpace;
	//Nebula
	int fogLevel;
	//asteroidField
	int asteroidSpawnRate;
	//sunBelt
	/*
	 * sunDamage will set how much damage the player takes. I'll increase as the player gets closer to it.
	 */
	int sunDamage;
	/*
	 * sunPosition will set where the sunBelt is. I can be on the left side or the right side of the screen.
	 * Depending of where it is, it'll change how much damage the player takes as he gets closer to its Hitbox.
	 */
	Hitbox sunPosition;
	
	//Orbit
	/*
	 * Depending of where the nearby planet is, the player's shots will be attracted, and so will not have the angle expected by the player.
	 */
	int accuracyMalus;
	/*
	 * Sets where the beam'll be attracted.
	 */
	Hitbox planetPosition;
	
	//emptySpace
	//This environment will have no effect on the player.
	
	//getters and setters
	
	public int getFogLevel() {
		return fogLevel;
	}
	public void setFogLevel(int fogLevel) {
		this.fogLevel = fogLevel;
	}
	public int getAsteroidSpawnRate() {
		return asteroidSpawnRate;
	}
	public void setAsteroidSpawnRate(int asteroidSpawnRate) {
		this.asteroidSpawnRate = asteroidSpawnRate;
	}
	public int getSunDamage() {
		return sunDamage;
	}
	public void setSunDamage(int sunDamage) {
		this.sunDamage = sunDamage;
	}
	public Hitbox getSunPosition() {
		return sunPosition;
	}
	public void setSunPosition(Hitbox sunPosition) {
		this.sunPosition = sunPosition;
	}
	public int getAccuracyMalus() {
		return accuracyMalus;
	}
	public void setAccuracyMalus(int accuracyMalus) {
		this.accuracyMalus = accuracyMalus;
	}
	public Hitbox getPlanetPosition() {
		return planetPosition;
	}
	public void setPlanetPosition(Hitbox planetPosition) {
		this.planetPosition = planetPosition;
	}
	

	
}


