package fr.iutvalence.info.dut.m2107;

public class Main {
	public static final String CONFIG_FILE = "Perso.cfg" ;
	public static void main(String[] args) {
		/**
		 * Load weapons
		 */
		WeaponSet ws = new WeaponSet();
		ws.getWeaponFromFile(CONFIG_FILE);
		System.out.println(ws.toString());
		
		HullSet hs = new HullSet();
		hs.getHullFromFile(CONFIG_FILE);
		System.out.println(hs.toString());
		
		// TODO Auto-generated method stub

	}
	public void LaunchMainMenu() {
		// TODO - implement Main.LaunchMainMenu
		throw new UnsupportedOperationException();
	}


}
