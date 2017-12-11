/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
/**
 *
 * @author IDEAPAD
 */
public class InstanceImage extends Image {
    
    public final float StartingX;
    public final float StartingY;
    Image image;
    Shape HitBox;
    public float X;
    public float Y;
    boolean Hit;
    Graphics g = new Graphics();
    boolean Collidable;
    float Scale;
    
    public InstanceImage(String directory,float scale, float x, float y) throws SlickException{
        super(directory);
        image = this;
        Hit = false;
        StartingX = x;
        StartingY = y;
        Collidable = false;
        Scale = scale;
        X = x;
        Y = y;
        initiate(x, y);
    }
    
    public void initiate(float x, float y){
        HitBox = new Rectangle(x,y,image.getWidth(),image.getHeight());
        
    }
    
    public void drawInstance(){
        image.draw(X, Y, Scale);
        if(!Hit){
        g.setColor(Color.transparent);
        }else{}
        g.draw(HitBox);

    }

    
    public boolean IntersectsWith(Shape shape){
        boolean bool;
        if(HitBox.intersects(shape)){
            bool = true;
        }else{
            bool = false;
        }
        return bool;
    }
    
    public Shape getHitBox(){
        return HitBox;
    }
    
    public Image getInstance(){
        return this;
    }
    
    public float getX(){
        return X;
    }
    
    public float getY(){
        return Y;
    }
    
    public void setXInstance(float x){
        X = x;
    }
    
    public void setYInstance(float y){
        Y = y;
    }

    public void fillInstance() {
        throw new UnsupportedOperationException("Not supported");
    }
    
    public void setXWithHitBox(float x){
        X = x;
        HitBox.setX(x);
    }
    
    public void setYWithHitBox(float y){
        Y = y;
        HitBox.setY(y);
    }

    public float getStartX() {
        return StartingX;
    }

    public float getStartY() {
        return StartingY;
    }
    
    public int getType(){
        return 1;
    }

    public boolean Collidable() {
        return Collidable;
    }
    
    public boolean mouseHover(GameContainer gc) {
        boolean bool = false;
        Input i = gc.getInput();
        //System.out.println(i.getMouseX()+" "+i.getMouseY());
        if((i.getMouseX()>StartingX&&i.getMouseX()<StartingX+this.getWidth())
                &&(i.getMouseY()>StartingY&&i.getMouseY()<StartingY+this.getHeight())){
            bool = true;
        }
        return bool;
    }
}
