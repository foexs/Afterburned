package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;


public class WeaponSet {
	
	public static final String WEAPON_ID = "WEAPONID=";
	protected Weapon[] weapons;
	
	void getWeaponFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordColor=false;
				boolean recordDamage=false;

				scan = new Scanner(new File(filename));
				while (scan.hasNextLine()) {
					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					if (recordColor){
						System.out.println(Integer.parseInt(line));
						recordColor=false;
					}
					if (recordDamage){
						System.out.println(Integer.parseInt(line));
						recordDamage=false;
					}
					if (line.equalsIgnoreCase("weaponcolor")){
						recordColor=true;
					}
					if (line.equalsIgnoreCase("weapondamage")){
						recordDamage=true;
					}
					System.out.println(line);
					}
				} finally {
					if (scan != null)
						scan.close();
					}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				System.out.println("File not found");
				}
		}

}