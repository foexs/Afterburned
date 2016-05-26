package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class WeaponSet {

	public List weapons=new LinkedList();
	
	void getWeaponFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordColor=false;
				boolean recordDamage=false;
				int i=0;

				scan = new Scanner(new File(filename));
				
				int damage=1;
				Color color=Color.grey;
				
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
						
						weapons.add(new Weapon(color, damage));
						
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
		for(int j=0;weapons.get(j)!=null;j++){
			s=s+"\nWeapon "+j+":\nDamage= "+((Weapon) weapons.get(j)).getDamageLevel()+"\nColor="+((Weapon) weapons.get(j)).getWeaponColor();
		}
		return s;
		
	}

}