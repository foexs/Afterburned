package fr.iutvalence.info.dut.m2107;

public class Main {
	public static final String CONFIG_FILE = "Perso.cfg" ;
	public static void main(String[] args) {
		/**
		 * Load weapons
		 */
		WeaponSet ws = new WeaponSet();
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
		System.out.println(is.toString());
		
		/**
		 * Load enemies
		 */
		
		
		// TODO Auto-generated method stub

	}
	public void LaunchMainMenu() {
		// TODO - implement Main.LaunchMainMenu
		throw new UnsupportedOperationException();
	}


}
