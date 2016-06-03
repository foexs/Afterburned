package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * A weapon for the ship
 * 
 * @author simon
 *
 */
public class WeaponSet {
	/**
	 * List the existing weapons
	 */
	public List<Weapon> weapons=new LinkedList<Weapon>();
	/**
	 * Get the weapon from the config file
	 * @param filename of the config file
	 */
	void getWeaponFromFile(String filename){
		/**
		 * Scanner used to read from the file
		 */
		Scanner scan = null;
		try {
			try {
				/**
				 * If true the next information is a color
				 */
				boolean recordColor=false;
				/**
				 * If true the next information damage level
				 */
				boolean recordDamage=false;
				/**
				 * If true the next information is a name
				 */
				boolean recordName=false;
				
				
				String name="Default";
				int damage=1;
				EasyColor color=EasyColor.grey;
				scan = new Scanner(new File(filename));
				
				/**
				 * While we're before the end of the file, reads informations
				 */
				while (scan.hasNextLine()) {
					
					String line="";
					/**
					 * Reads the next word
					 */
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					
					if (recordColor){
						color=EasyColor.valueOf(line);
						recordColor=false;
					}
					if (recordDamage){
						damage=Integer.parseInt(line);
						recordDamage=false;
					}
					if (recordName){
						name=line;
						recordName=false;
					}
					if (line.equalsIgnoreCase("weaponcolor")){
						recordColor=true;
					}
					if (line.equalsIgnoreCase("weapondamage")){
						recordDamage=true;
					}
					if (line.equalsIgnoreCase("weaponname")){
						recordName=true;
					}
					if (line.equalsIgnoreCase("}")){
						/**
						 * Add the created weapon to the set
						 */
						weapons.add(new Weapon(color, damage, name));
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
	/**
	 * Gives informations about all weapons
	 */
	public String toString(){
		String s="";
		for(int j=0;true;j++){
			try{			
				s=s+"\nWeapon "+j+":\nDamage= "+((Weapon) weapons.get(j)).getDamageLevel()+"\nColor="+((Weapon) weapons.get(j)).getWeaponColor()+"Nom: "+((Weapon) weapons.get(j)).getName();
			}
			catch (IndexOutOfBoundsException e){
				break;
			}
		}
		return s;
		
	}

}