package Game;

import java.io.File;
import java.util.Random;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

	public static final String gamename = "Ultimate Tic-Tac-Toe";
        public static final int menu = 0;
        public static final int play = 1;

	public Game(String gamename) {
		super(gamename);
		this.addState(new Menu(menu));
                this.addState(new Play(play));
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// Need to add the states
		this.getState(menu).init(gc, this);
                this.getState(play).init(gc, this);
		// What state to go to first
		this.enterState(menu);
	}

	public static void main(String[] args) {
                System.setProperty("org.lwjgl.librarypath", new File("natives").getAbsolutePath());
            
		AppGameContainer appgc;
		try {
			appgc = new AppGameContainer(new Game(gamename));
			appgc.setDisplayMode(950, 570, false);
                        appgc.setTargetFrameRate(35);
                        appgc.setIcon("res/logo32.png");
			appgc.start();
                        
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}