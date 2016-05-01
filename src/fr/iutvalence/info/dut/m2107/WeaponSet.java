package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class WeaponSet {

	protected Weapon[] weapons;
	
	void getWeaponFromFile(String filename){
		File file = new File(filename);
		try {
			FileInputStream fileInput = new FileInputStream(file);
			String cc = new String(" ");
			while ()
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
	}

}