package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class WeaponSet {
	public static int maxSetSize=99;
	
	public final Weapon[] weapons=new Weapon[maxSetSize];
	void getWeaponFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordColor=false;
				boolean recordDamage=false;
				int i=0;

				scan = new Scanner(new File(filename));
				
				int damage=1;
				Color color=Color.black;
				
				while (scan.hasNextLine()) {
					
					
					
					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					
					if (recordColor){
						color=Color.valueOf(line);
						recordColor=false;
					}
					if (recordDamage){
						damage=Integer.parseInt(line);
						recordDamage=false;
					}
					if (line.equalsIgnoreCase("weaponcolor")){
						recordColor=true;
					}
					if (line.equalsIgnoreCase("weapondamage")){
						recordDamage=true;
					}
					if (line.equalsIgnoreCase("}")){
						
						weapons[i]=new Weapon(color, damage);
						
						i++;
					}
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
	public String toString(){
		String s="";
		for(int j=0;weapons[j]!=null;j++){
			s=s+"\nWeapon "+j+":\nDamage= "+weapons[j].getDamageLevel()+"\nColor="+weapons[j].getWeaponColor();
		}
		return s;
		
	}

}