package fr.iutvalence.info.dut.m2107;

public class Main {
	public static final String CONFIG_FILE = "Perso.cfg" ;
	public static WeaponSet ws;
	public static HullSet hs;
	public static ItemSet is;
	public static EnemySet es;
	
	public static void main(String[] args) {
		loadGame();
		// TODO Auto-generated method stub

	}
	public void launchMainMenu() {
		// TODO - implement Main.LaunchMainMenu
		throw new UnsupportedOperationException();
	}
	
	public static void loadGame(){
		/**
		 * Load weapons
		 */
		ws = new WeaponSet();
		ws.getWeaponFromFile(CONFIG_FILE);
		
		/**
		 * Load hulls
		 */
		HullSet hs = new HullSet();
		hs.getHullFromFile(CONFIG_FILE);
		
		/**
		 * Load items
		 */
		ItemSet is = new ItemSet();
		is.getItemFromFile(CONFIG_FILE);
		
		/**
		 * Load enemies
		 */
		EnemySet es = new EnemySet();
		es.getEnnemyFromFile(CONFIG_FILE);
	}

	

}
