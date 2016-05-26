package fr.iutvalence.info.dut.m2107;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;


public class HullSet {
	
	public List hulls=new LinkedList();
	
	void getHullFromFile(String filename){
		Scanner scan = null;
		try {
			try {
				boolean recordColor=false;
				boolean recordProtection=false;
				int i=0;

				scan = new Scanner(new File(filename));
				
				int protection=1;
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
					if (line.equalsIgnoreCase("}")){
						
						hulls.add(new Hull(color, protection));
						
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
		for(int j=0;hulls.get(j)!=null;j++){
			s=s+"\nHull "+j+":\nProtection= "+((Hull) hulls.get(j)).getProtectionLevel()+"\nColor="+((Hull) hulls.get(j)).getHullColor();
		}
		return s;
		
	}


}