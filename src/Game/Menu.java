package Game;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

public class Menu extends BasicGameState {
        Input input;
        
        InstanceImage Background;
        InstanceImage PlayButton;
        InstanceImage PlayButtonH;
        InstanceImage PlayButtonS;
        InstanceImage ExitButton;
        InstanceImage ExitButtonH;
        InstanceImage ExitButtonS;
    
	public Menu(int state){
	}
        
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException{
            //Declaration of Inputs
            input = gc.getInput();
            
            //Declaration of Background
            Background = new InstanceImage("res/background.png",1 ,0, 0);
            
            //Declaration of Buttons
            PlayButton = new InstanceImage("res/buttons/play.png",1, 343, 343);
            PlayButtonH = new InstanceImage("res/buttons/playh.png",1, 343, 343);
            PlayButtonS = new InstanceImage("res/buttons/play.png",1, 343, 343);
            ExitButton = new InstanceImage("res/buttons/exit.png",1, 343, 438);
            ExitButtonH = new InstanceImage("res/buttons/exith.png",1, 343, 438);
            ExitButtonS = new InstanceImage("res/buttons/exit.png",1, 343, 438);
        }

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException{
            Background.drawInstance();
            ExitButton.drawInstance();
            PlayButton.drawInstance();
            
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException{
            if(PlayButton.mouseHover(gc)){
                PlayButton = PlayButtonH;
                if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    sbg.enterState(1);
                }
            }else{PlayButton = PlayButtonS;}
            
            if(ExitButton.mouseHover(gc)){
                ExitButton = ExitButtonH;
                if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                    System.exit(0);
                }
            }else{ExitButton = ExitButtonS;}
                
            
                
        }

	public int getID() {
		return 0;
	}
        
}
