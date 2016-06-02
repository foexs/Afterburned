package fr.iutvalence.info.dut.m2107;

import org.junit.*;
import junit.framework.TestCase;

public class ShipTest extends TestCase {
	
	private static final int SIZE=10;
	Ship ship;
	
	public ShipTest(){
		this.ship = new Ship(new Weapon(Color.blue, 10, "Arme"),new Hull(Color.blue, 10, "Bouclier"),new Dot(600, 200),SIZE);
	}
	
	 @Test
	    public void testShipHeal() {
	        ship.heal(190);
	        assertEquals(200, ship.getHealth());
	        ship.heal(-50);
	        assertEquals(150, ship.getHealth());
	        ship.heal(500000);
	        assertEquals(500150, ship.getHealth());
	        ship.heal(-500150);
	        assertEquals(0, ship.getHealth());
	    }
	 
	 @Test
	    public void testShipPosition() {
		 	Dot testPosition= new Dot(600,200);
	        assertEquals(true, this.ship.getPosition().getX()==testPosition.getX()&&ship.getPosition().getY()==testPosition.getY());
	        ship.setPosition(new Dot(0,0));
	        testPosition=new Dot(0,0);
	        assertEquals(true, this.ship.getPosition().getX()==testPosition.getX()&&ship.getPosition().getY()==testPosition.getY());
	 }
	 
	 @Test
	 	public void testShipHitbox(){
		 	Hitbox testHitbox=new Hitbox(665-SIZE,665+SIZE,20-SIZE,20+SIZE);
	        ship.setPosition(new Dot(665,20));
	        assertEquals(true, testHitbox.equals(this.ship.getHitbox()));
	        
	        testHitbox=new Hitbox(32-SIZE,32+SIZE,2221-SIZE,2221+SIZE);
	        ship.setPosition(new Dot(32,2221));
	        assertEquals(true, testHitbox.equals(this.ship.getHitbox()));
	        
	        testHitbox=new Hitbox(0-SIZE,0+SIZE,0-SIZE,0+SIZE);
	        ship.setPosition(new Dot(0,1));
	        assertEquals(false, testHitbox.equals(this.ship.getHitbox()));
	        

	 }
	 
	 public static void main(String[] args){
		 ShipTest test= new ShipTest();
		 test.testShipHeal();
		 test.testShipPosition();
		 test.testShipHitbox();
	 }
}
