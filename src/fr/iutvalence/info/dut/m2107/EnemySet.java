package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class EnemySet {

	public List<Enemy> enemies=new LinkedList<Enemy>();
	
	private int damage=0;
	private int health=0;
	private int size=5;
	private int speed=2;
	private Color color=Color.grey;
	

	/**
	 * Fill the item list with info in the configuration file
	 * @param filename is the configuration file's name
	 */
	void getEnnemyFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				/**
				 * if the record is true, the next line is the value to get
				 */
				boolean recordDamage=false;
				boolean recordHealth=false;
				boolean recordSize=false;
				boolean recordColor=false;
				boolean recordSpeed=false;
				scan = new Scanner(new File(filename));
				
				while (scan.hasNextLine()) {

					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					if (recordColor){
						color=Color.valueOf(line);
						recordColor=false;
					}
					if (recordHealth){
						health=Integer.parseInt(line);
						recordHealth=false;
					}
					if (recordDamage){
						damage=Integer.parseInt(line);
						recordDamage=false;
					}
					if (recordSize){
						size=Integer.parseInt(line);
						recordSize=false;
					}
					if (recordSpeed){
						speed=Integer.parseInt(line);
						recordSpeed=false;
					}
					if (line.equalsIgnoreCase("enemydamage")){
						recordDamage=true;
					}
					if (line.equalsIgnoreCase("enemyspeed")){
						recordSpeed=true;
					}
					if (line.equalsIgnoreCase("enemyhealth")){
						recordHealth=true;
					}
					if (line.equalsIgnoreCase("enemysize")){
						recordSize=true;
					}
					if (line.equalsIgnoreCase("enemycolor")){
						recordColor=true;
					}
					if (line.equalsIgnoreCase("]")){
						enemies.add(new Enemy(this.speed,this.size,this.health,this.damage,this.color));
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
	 * Display the list of Items available
	 */
	public String toString(){
		String s="";
		for(int j=0;enemies.get(j)!=null;j++){
			s=s+"\nEnemy "+j+":\nDamage = "+((Enemy) enemies.get(j)).getDamage()+"\nHealth = "+((Enemy) enemies.get(j)).getHealth()+"\nSpeed ="+((Enemy) enemies.get(j)).getSpeed()+"\nSize ="+((Enemy) enemies.get(j)).getSize()+"\nColor ="+((Enemy) enemies.get(j)).getColor();
		}
		return s;
		
	}

}