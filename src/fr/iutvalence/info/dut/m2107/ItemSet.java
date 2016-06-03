package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ItemSet {
	/**
	 * List of usable items in the game
	 */
	private List<Item> items=new LinkedList<Item>();
	
	private int damageIncrease=0;
	private int healthIncrease=0;
	private int size=10;
	private boolean bomb=false;
	

	/**
	 * Fill the item list with info in the configuration file
	 * @param filename is the configuration file's name
	 */
	void getItemFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				/**
				 * if the record is true, the next line is the value to get
				 */
				boolean recordDamageIncrease=false;
				boolean recordHealthIncrease=false;
				boolean recordSize=false;
				scan = new Scanner(new File(filename));
				
				while (scan.hasNextLine()) {

					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					
					if (recordHealthIncrease){
						healthIncrease=Integer.parseInt(line);
						recordHealthIncrease=false;
					}
					if (recordDamageIncrease){
						damageIncrease=Integer.parseInt(line);
						recordDamageIncrease=false;
					}
					if (recordSize){
						size=Integer.parseInt(line);
						recordSize=false;
					}
					
					if (line.equalsIgnoreCase("itemdamageincrease")){
						recordDamageIncrease=true;
					}
					if (line.equalsIgnoreCase("itemhealthincrease")){
						recordHealthIncrease=true;
					}
					if (line.equalsIgnoreCase("itemsize")){
						recordSize=true;
					}
					if (line.equalsIgnoreCase("isabomb")){
						bomb=true;
					}
					if (line.equalsIgnoreCase(";")){
						
						items.add(new Item(this.size,this.healthIncrease,this.damageIncrease,this.bomb));
						bomb=false;
						damageIncrease=0;
						healthIncrease=0;
						size=5;
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
	public List<Item> getItems() {
		return items;
	}
	/**
	 * Display the list of Items available
	 */
	public String toString(){
		String s="";
		for(int j=0;items.get(j)!=null;j++){
			s=s+"\nItem "+j+":\nDamage Increase= "+((Item) items.get(j)).getBaseDamageLevel()+"\nHealth Restore= "+((Item) items.get(j)).getHealthRestoreLevel()+"\nIs a bomb ="+((Item) items.get(j)).isBomb()+"\nSize ="+((Item) items.get(j)).getSize();
		}
		return s;
		
	}


}