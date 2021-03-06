package fr.iutvalence.info.dut.m2107;

/**
 * The menu, where to change game's parameters
 * @author simon
 *
 */
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
	/**
	 * On right key pressed on menu
	 */
	public void rightKeyPressed(){
		/**
		 * Look at the kind of the selection to choose what to do
		 */
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
	/**
	 * On left key pressed on menu
	 */
	public void leftKeyPressed(){
		/**
		 * Look at the kind of the selection to choose what to do
		 */
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
	/**
	 * On down key pressed on menu
	 */
	public void downKeyPressed() {
		/**
		 * Look at the kind of the selection to choose what to do
		 */
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
	/**
	 * On up key pressed on menu
	 */
	public void upKeyPressed() {
		/**
		 * Look at the kind of the selection to choose what to do
		 */
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



}