package fr.iutvalence.info.dut.m2107;

import org.newdawn.slick.*;


/**
 * Define a gui, to execute you need to have the natives in your build path and this argument:"Djava.library.path=lib/natives"
 * @author simon
 *
 */
public class GUI extends BasicGame {
	
		public static GameContainer container;
		/**
		 * Contains all setup and parameters, can display itself too
		 */
		Game game;
		Environment currentEnvironment;
		MainMenu menu;
		
		/**
		 * if false, the app is on menu
		 */
		boolean playing;
		
		
	    public GUI() {
	        super("Afterburned");
	    }

	    @Override
	    public void init(GameContainer container) throws SlickException {
	        GUI.container = container;
	        this.menu=new MainMenu();
	        this.game=new Game(currentEnvironment);
	    }

	    @Override
	    public void render(GameContainer container, Graphics g) throws SlickException {
	    	if (this.playing){
	    	
	    	}
	    	
	    	else{
	    		
	    	}
	    	
	    }

	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	    	
	    }
	    
	    @Override
	    public void keyReleased(int key, char c){
	    	/*
	    	 *General keyReleased 
	    	 */
	        if (Input.KEY_ESCAPE == key) {
	            container.exit();
	        }
	        if (Input.KEY_F11== key){
	        	try{
        			if (container.isFullscreen())
        			{
        					container.setFullscreen(false);	
        			}
	        		else
	        			container.setFullscreen(true);
	        	}
        		catch (SlickException e)
        		{
        		
        		}
	        }
	        if (Input.KEY_RIGHT== key){
	        	if(this.playing){
	        		game.rightKeyPressed();
	        	}
	        	else{
	        		menu.rightKeyPressed();
	        	}
	        }
	        
	        if (Input.KEY_LEFT== key){
	        	if(this.playing){
	        		game.leftKeyPressed();
	        	}
	        	else{
	        		menu.leftKeyPressed();
	        	}
	        	
	        }
	        
			if (Input.KEY_UP== key){
				if(this.playing){
	        		game.upKeyPressed();
	        	}
	        	else{
	        		menu.upKeyPressed();
	        	}
	
			}
			
			if (Input.KEY_DOWN== key){
				if(this.playing){
	        		game.downKeyPressed();
	        	}
	        	else{
	        		menu.downKeyPressed();
	        	}
	        }
			
			if (Input.KEY_ENTER== key){
				if(this.playing){
	        		game.enterKeyPressed();
	        	}
	        	else{
	        		menu.enterKeyPressed();
	        	}
	        }
			
			
	    }
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new GUI(), 1024, 768, false).start();
	}

}
