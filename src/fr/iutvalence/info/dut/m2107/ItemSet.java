package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ItemSet {

	public ItemSet() {
	
	}

	public static int maxSetSize=99;
	
	private Item[] items=new Item[maxSetSize];
	private int damageIncrease=0;
	private int healthIncrease=0;
	private int size=5;
	private boolean bomb=false;
	

	void getItemFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordDamageIncrease=false;
				boolean recordHealthIncrease=false;
				boolean recordSize=false;
				int i=0;

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
						
						items[i]=new Item(this.size,this.healthIncrease,this.damageIncrease,this.bomb);
						bomb=false;
						damageIncrease=0;
						healthIncrease=0;
						size=5;
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
		for(int j=0;items[j]!=null;j++){
			s=s+"\nItem "+j+":\nDamage Increase= "+items[j].getBaseDamageLevel()+"\nHealth Restore= "+items[j].getHealthRestoreLevel()+"\nIs a bomb ="+items[j].isBomb()+"\nSize ="+items[j].getSize();
		}
		return s;
		
	}


}