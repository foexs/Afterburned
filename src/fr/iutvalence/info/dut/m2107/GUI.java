package fr.iutvalence.info.dut.m2107;

import org.newdawn.slick.*;

/**
 * Define a gui, to execute you need to have the natives in your build path and this argument:"Djava.library.path=lib/natives"
 * @author simon
 *
 */
public class GUI extends BasicGame {
	
		public static final int DEFAULT_HEIGHT=768;
		public static final int DEFAULT_WIDTH=1024;
		public static final int LINE_SIZE=20;
		
	
		Font font;
		public Image backgroundGame;
		
		public final String backgroundMenu = ("ihm/background menu_1.png");
		
		public static GameContainer container;
		/**
		 * Contains all setup and parameters, can display itself too
		 */
		Game game;
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
	        this.game=new Game(menu);	 
	        }

	    @Override
	    public void render(GameContainer container, Graphics g) throws SlickException {
	    	/**
	    	 * when playing
	    	 */
	    	if (this.playing)
	    	{
	    		g.drawImage(new Image(menu.currentEnvironment.getBackgroundPath()), 0, 0);//Draw background
	    		g.drawString("Weapon: "+menu.ws.weapons.get(menu.currentWeapon).getName(),DEFAULT_WIDTH/2 + DEFAULT_WIDTH/4 , LINE_SIZE*1);
	    		g.drawString("Hull: "+menu.hs.hulls.get(menu.currentHull).getName(),DEFAULT_WIDTH/2 + DEFAULT_WIDTH/4, LINE_SIZE*2);
	    		g.drawString("Environment: "+menu.currentEnvironment.name(),DEFAULT_WIDTH/2 + DEFAULT_WIDTH/4,LINE_SIZE*3);
	    		
	    	}
	    	/**
	    	 * when on menu
	    	 */
	    	else
	    	{
	    		g.drawImage(new Image (backgroundMenu), 0, 0);
	    		drawBox(new Dot(330,490),260,35,g);
	    		if(menu.selection==Selection.weapon)
	    			g.drawString("Weapon: "+menu.ws.weapons.get(menu.currentWeapon).getName(), DEFAULT_WIDTH/4+DEFAULT_WIDTH/12 , DEFAULT_HEIGHT/2+DEFAULT_HEIGHT/8+LINE_SIZE*1);
	    		if(menu.selection==Selection.hull)
	    			g.drawString("Hull: "+menu.hs.hulls.get(menu.currentHull).getName(), DEFAULT_WIDTH/4+DEFAULT_WIDTH/12 , DEFAULT_HEIGHT/2+DEFAULT_HEIGHT/8+LINE_SIZE*1);
	    		if(menu.selection==Selection.environment)
	    			g.drawString("Environment: "+menu.currentEnvironment.name(), DEFAULT_WIDTH/4+DEFAULT_WIDTH/12, DEFAULT_HEIGHT/2+DEFAULT_HEIGHT/8+LINE_SIZE*1);
	    		drawBox(new Dot(330,690),260,35,g);
	    		g.drawString("Press enter to play.", DEFAULT_WIDTH/4+DEFAULT_WIDTH/12, DEFAULT_HEIGHT/2+DEFAULT_HEIGHT/4+DEFAULT_HEIGHT/8+DEFAULT_HEIGHT/128+LINE_SIZE*1);
	    	}
	    	
	    }

	    @Override
	    public void update(GameContainer container, int delta) throws SlickException {
	    		
	    }
	    
	    @Override
	    public void keyReleased(int key, char c){/*
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
	        		this.playing=true;
	        		
	        	}
	        }
			
			
	    }
	public static void main(String[] args) throws SlickException {
		new AppGameContainer(new GUI(), DEFAULT_WIDTH, DEFAULT_HEIGHT, false).start();
	}
	public static void drawBox(Dot position, int width, int height, Graphics g){
		
		
		g.drawRect(position.getX(), position.getY(), width+2, height+2);
		g.drawRect(position.getX()+1, position.getY()+1, width, height);
		
	}

}
