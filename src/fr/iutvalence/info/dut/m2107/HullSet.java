package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class HullSet {
	
	public List<Hull> hulls=new LinkedList<Hull>();
	
	void getHullFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordColor=false;
				boolean recordProtection=false;
				boolean recordName=false;
				
				scan = new Scanner(new File(filename));
				
				int protection=1;
				Color color=Color.grey;
				String name="Default";
				
				while (scan.hasNextLine()) {
					
					String line="";
					for (char cc : scan.next().toCharArray()) {
						line= line+cc;
					}
					if (recordName){
						name=line;
						recordName=false;
					}
					if (recordColor){
						color=Color.valueOf(line);
						recordColor=false;
					}
					if (recordProtection){
						protection=Integer.parseInt(line);
						recordProtection=false;
					}
					if (line.equalsIgnoreCase("hullcolor")){
						recordColor=true;
					}
					if (line.equalsIgnoreCase("hullprotection")){
						recordProtection=true;
					}
					if (line.equalsIgnoreCase("hullname")){
						recordName=true;
					}
					if (line.equalsIgnoreCase("}")){
						
						hulls.add(new Hull(color, protection, name));
						
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
		for(int j=0;true;j++){
			try{
				s=s+"\nHull "+j+":\nProtection= "+((Hull) hulls.get(j)).getProtectionLevel()+"\nColor="+((Hull) hulls.get(j)).getHullColor()+"Nom: "+((Hull) hulls.get(j)).getName();
			}
			catch (IndexOutOfBoundsException e){
				break;
			}
		}
		return s;
		
	}


}