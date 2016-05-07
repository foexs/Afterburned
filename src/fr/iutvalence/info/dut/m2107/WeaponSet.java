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
				boolean record=false;
				scan = new Scanner(new File(filename));
				while (scan.hasNextLine()) {
					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					if (record){
						Integer.parseInt(line);
						record=false;
					}
					if (line.equalsIgnoreCase(WEAPON_ID)){
						
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
		/**
		File file = new File(filename);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			fileInput.read(1)
			String cc = new String(" ");
			while (cc != "")
			{
				
			}
			try {
				fileInput.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("File not found\n");
			e.printStackTrace();
		}
	**/}

}