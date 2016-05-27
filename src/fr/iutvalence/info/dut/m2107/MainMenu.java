package fr.iutvalence.info.dut.m2107;

public class MainMenu {
	public static final String CONFIG_FILE = "Perso.cfg" ;
	public WeaponSet ws;
	public int currentWeapon;
	public HullSet hs;
	public int currentHull;
	public ItemSet is;
	public EnemySet es;
	public Selection selection;
	public Environment currentEnvironment;
	
	
	public MainMenu(){
		/**
		 * Load weapons
		 */
		ws = new WeaponSet();
		ws.getWeaponFromFile(CONFIG_FILE);
		currentWeapon=0;
		/**
		 * Load hulls
		 */
		hs = new HullSet();
		hs.getHullFromFile(CONFIG_FILE);
		currentHull=0;
		/**
		 * Load items
		 */
		is = new ItemSet();
		is.getItemFromFile(CONFIG_FILE);
		
		/**
		 * Load enemies
		 */
		es = new EnemySet();
		es.getEnnemyFromFile(CONFIG_FILE);
		
		/**
		 * set default cursor position
		 */
		selection=Selection.weapon;
		
		this.currentEnvironment=Environment.emptySpace;
	}
	
	public void rightKeyPressed(){
		switch(this.selection){
		case weapon:
			if (currentWeapon>=ws.weapons.size()-1){
				this.currentWeapon=0;
			}else{
				this.currentWeapon++;
			}	
			break;
		case hull:
			if (this.currentHull>=hs.hulls.size()-1){
				this.currentHull=0;
			}else{
				this.currentHull++;
			}
			break;
		case environment:
			try {
				currentEnvironment=Environment.values()[currentEnvironment.ordinal()+1];
				}catch(ArrayIndexOutOfBoundsException e)
			{
					//Do nothing
			}
			break;
		}
		System.out.println(this.getClass()+" right key pressed");
	}
	public void leftKeyPressed(){
		switch(this.selection){
		case weapon:
			if (this.currentWeapon<=0){
				this.currentWeapon=this.ws.weapons.size()-1;
			}else{
				this.currentWeapon--;
			}
		break;
		case hull:
			if (this.currentHull<=0){
				this.currentHull=this.hs.hulls.size()-1;
			}else{
				this.currentHull--;
			}
		break;
		case environment:
			try {
				currentEnvironment=Environment.values()[currentEnvironment.ordinal()-1];
				}catch(ArrayIndexOutOfBoundsException e)
			{
					//Do nothing
			}
			break;
		}
		System.out.println(this.getClass()+" left key pressed");
	}

	public void downKeyPressed() {
		switch(this.selection){
		case weapon:
			this.selection=Selection.hull;
			break;
		case hull:
			this.selection=Selection.environment;
			break;
		case environment:
			this.selection=Selection.weapon;
			break;
		}
	}
	public void upKeyPressed() {
		switch(this.selection){
		case weapon:
			this.selection=Selection.environment;
			break;
		case hull:
			this.selection=Selection.weapon;
			break;
		case environment:
			this.selection=Selection.hull;
			break;
		}
	}

	public void enterKeyPressed() {
		// TODO Auto-generated method stub
		
	}


}