package Game;



public class GridElement {
    
    private int state;
    
    public final int CIRCLE = 1;
    public final int CROSS = 2;
    public final int UNASSIGNED = 3;
    
    public GridElement(int state){
        this.state = state;
    }
    
    public int getState(){
        return state;
    }
    
    public void setState(int state){
        this.state = state;
    }
    
    public void drawState(){
        switch(state){
            case(0):{
                System.out.println("-");
            }break;
            case(1):{
                System.out.println("O");
            }break;
            case(2):{
                System.out.println("X");
            }break;
            case(3):{
                System.out.println("~");
            }break;
        }
    }
    
    public String returnStringState(){
        String sState = "";
        switch(state){
            case(0):{
                sState=("-");
            }break;
            case(1):{
                sState=("O");
            }break;
            case(2):{
                sState=("X");
            }break;
            case(3):{
                sState=("~");
            }break;
        }
        return sState;
    }
}
