package fr.iutvalence.info.dut.m2107;

import org.junit.*;
import junit.framework.TestCase;

public class HitboxTest extends TestCase {
	private static final Hitbox hitbox1=new Hitbox(10,50,10,50); //A regular hitbox
	private static final Hitbox hitbox2=new Hitbox(0,0,0,0); //this is only the 0 dot
	private static final Hitbox hitbox3=new Hitbox(50,10,50,10); //Should be same than the first since the maxX and maxY should be detected
	private static final Hitbox hitbox4=new Hitbox(0,1024,0,768); //Huge hitbox(bigger than our play screen)
	private static final Hitbox hitbox5=new Hitbox(25,29,60,768); //Is not in hitbox1 but should touches it in x
	private static final Hitbox hitbox6=new Hitbox(60,768,25,29); //Is not in hitbox1 but should touches it in y
	private static final Hitbox hitbox7=new Hitbox(30,40,25,700); //Should be "in" hitbox1
	
	@Test
	public static void testEquals(){
		assertEquals(false, hitbox1.equals(hitbox2));
		assertEquals(true, hitbox1.equals(hitbox1));
		assertEquals(true, hitbox1.equals(hitbox3));
		assertEquals(false, hitbox2.equals(hitbox4));
	}
	
	@Test
	public static void testTouchesX(){
		assertEquals(false, hitbox1.touchesX(hitbox2));
		assertEquals(true, hitbox1.touchesX(hitbox3));
		assertEquals(true, hitbox1.touchesX(hitbox4));
		assertEquals(true, hitbox2.touchesX(hitbox4));
		assertEquals(true, hitbox1.touchesX(hitbox5));
		assertEquals(false, hitbox1.touchesX(hitbox6));
		assertEquals(true, hitbox1.touchesX(hitbox7));
	}
	
	@Test
	public static void testTouchesY(){
		assertEquals(false, hitbox1.touchesY(hitbox2));
		assertEquals(true, hitbox1.touchesY(hitbox3));
		assertEquals(true, hitbox1.touchesY(hitbox4));
		assertEquals(true, hitbox2.touchesY(hitbox4));
		assertEquals(false, hitbox1.touchesY(hitbox5));
		assertEquals(true, hitbox1.touchesY(hitbox6));
		assertEquals(true, hitbox1.touchesY(hitbox7));
	}
	
	@Test
	public static void testIsIn(){
		assertEquals(false, hitbox1.isIn(hitbox2));
		assertEquals(true, hitbox1.isIn(hitbox3));
		assertEquals(true, hitbox1.isIn(hitbox4));
		assertEquals(true, hitbox2.isIn(hitbox4));
		assertEquals(false, hitbox1.isIn(hitbox5));
		assertEquals(false, hitbox1.isIn(hitbox6));
		assertEquals(true, hitbox1.isIn(hitbox7));
	}
	
	
	public static void main(String[] args){
		 testEquals();
		 testTouchesX();
		 testTouchesY();
		 testIsIn();
	 }
}
