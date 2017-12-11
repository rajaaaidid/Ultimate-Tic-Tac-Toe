package Game;

import java.util.ArrayList;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {
    int turn = 1;
    Input input;
    
    InstanceImage Background;
    
    //TicTacToe Mechanism
    TicTacToe Grids[] = new TicTacToe[10];
    ArrayList<Integer> Occupied = new ArrayList<Integer>();
    ArrayList<Integer> Win = new ArrayList<Integer>();
    
    //Grid 1
    InstanceImage SmallSquare[] = new InstanceImage[81];
    InstanceImage SmallSquareH[] = new InstanceImage[81];
    InstanceImage SmallSquareS[] = new InstanceImage[81];
    InstanceImage SmallSquareR[] = new InstanceImage[81];
    InstanceImage SmallSquareB[] = new InstanceImage[81];
    
    //Cross and Circle
    InstanceImage Cross[] = new InstanceImage[81];
    InstanceImage Circle[] = new InstanceImage[81];
    
    
    public Play(int state) {
    }

    public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
        //Declaration of Inputs
        input = gc.getInput();
        
        //Declaration of Background
        Background = new InstanceImage("res/play.png",1 ,0, 0);
        
        //Declaration of Grid
        /*for(int i=0; i<81; i++){
            SmallSquare[i] = new InstanceImage("res/square.png",1, 239+(163*((i-(i/9*9))/3))+(((i-(i/9*9))-((i-(i/9*9))/3*3)-0)*51), 74+(162*(i/27))+51*((i-(i/27*27))/9));
        }*/
        for(int i=0; i<81; i++){
            SmallSquare[i] = new InstanceImage("res/square.png",1, 239+(163*((i-(i/27*27))/9))+((i%3)*51), 74+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            SmallSquareH[i] = new InstanceImage("res/squareh.png",1, 239+(163*((i-(i/27*27))/9))+((i%3)*51), 74+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            SmallSquareS[i] = new InstanceImage("res/square.png",1, 239+(163*((i-(i/27*27))/9))+((i%3)*51), 74+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            SmallSquareR[i] = new InstanceImage("res/squarer.png",1, 239+(163*((i-(i/27*27))/9))+((i%3)*51), 74+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            SmallSquareB[i] = new InstanceImage("res/squareb.png",1, 239+(163*((i-(i/27*27))/9))+((i%3)*51), 74+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            Circle[i] = new InstanceImage("res/circle.png",0, 246+(163*((i-(i/27*27))/9))+((i%3)*51), 81+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        for(int i=0; i<81; i++){
            Cross[i] = new InstanceImage("res/cross.png",0, 246+(163*((i-(i/27*27))/9))+((i%3)*51), 81+(162*(i/27))+(51*((i-(i/9*9))/3)));
        }
        
        //Declaration of TicTacToe Mechanism
        for(int i=0; i<10; i++){
            Grids[i] = new TicTacToe(3, 3, 3, (i<9)?false:true);
        }
        
        
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
        Background.drawInstance();
        
        //Grid 1
        for(int i=0; i<81; i++){
            SmallSquare[i].drawInstance();
            Circle[i].drawInstance();
            Cross[i].drawInstance();
        }
        
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
        for(int i=0; i<9;i ++){
            if(Grids[i].detectWinner()){
                if(i==0){
                    for(int j=0; j<9; j++){
                        Win.add(j);
                    }
                }
            }
        }
        
        for(int i=0; i<81; i++){
            if(SmallSquare[i].mouseHover(gc)){
               SmallSquare[i] = SmallSquareH[i];
                if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)){
                   if(!Occupied.contains(i)){
                        if(turn==1){
                            setXO(i, turn);
                            Circle[i].Scale = 1;
                            Occupied.add(i);
                            turn = 2;
                        }else{
                            setXO(i, turn);
                            Cross[i].Scale = 1;
                            Occupied.add(i);
                            turn = 1;
                        }
                   }else{
                       System.out.println("Space is already occupied");
                   }
                   System.out.println(turn);
                }
           }else{
               SmallSquare[i] = SmallSquareS[i];
           }
       }
    }
    
    //Inefficient Way, Rushing for time
    public void setXO(int i, int x){
        Grids[i/9].writeGridElement(new GridElement(x), i%9);
    }

    public int getID() {
        return 1;
    }
}