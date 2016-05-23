package fr.iutvalence.info.dut.m2107;

import org.newdawn.slick.*;


/**
 * Define a gui, to execute you need to have the natives in your build path and this argument:"Djava.library.path=lib/natives"
 * @author simon
 *
 */
public class GUI extends BasicGame {
		public GameContainer container;
	    public GUI() {
	        super("Afterburned");
	    }

	    @Override
	    public void init(GameContainer container) throws SlickException {
	        this.container = container;
	    }

	    @Override
	    public void render(GameContainer container, Graphics g) throws SlickException {
	    }

	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	    }
	    
	    @Override
	    public void keyReleased(int key, char c) {
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        if (Input.KEY_F11== key){
	        	try{
        			if (container.isFullscreen())
        					container.setFullscreen(false);	
	        		else
	        			container.setFullscreen(true);
	        	}
        		catch (SlickException e)
        		{
        		
        		}
	        }
	    }

	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new GUI(), 1024, 768, false).start();
	}

}
