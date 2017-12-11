package Game;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TicTacToe {
    private List<GridElement> gridBoard = new ArrayList<GridElement>();
    private GridElement gridElement;
    private int width;
    private int height;
    private int required;
    private boolean allowThirdState;
    private int turn=0;
    
    private boolean winner = false;
    private boolean draw = false;
    
    public TicTacToe(int width, int height, int required, boolean allowThirdState){
        this.width = width;
        this.height = height;
        if(required>width||required>height){
            if(width>height){
                required = width;
            }else{
                required = height;
            }
        }else{
            this.required = required;
        }
        this.allowThirdState = allowThirdState;
        for(int i=0; i<(width*height); i++){
            gridBoard.add(new GridElement(0));
        }
    }
    
    public boolean checkDraw(){
        return winner;
    }
    
    public void writeGridElementByOrder(int position){
        GridElement ge = new GridElement(getTurn());
        if(gridBoard.get(position).getState()==0){
            if(ge.getState()==ge.UNASSIGNED){
                if(allowThirdState){
                    gridBoard.set(position, ge);
                    turn++;
                }else{
                    System.out.println("Game does not allow third state!");
                }
            }else{
                gridBoard.set(position, ge);
                turn++;
            }
        }else{
            System.out.println("Grid element is occupied!");
        }
    }

    public void writeGridElement(GridElement ge, int position){
        if(gridBoard.get(position).getState()==0){
            if(ge.getState()==ge.UNASSIGNED){
                if(allowThirdState){
                    gridBoard.set(position, ge);
                }else{
                    System.out.println("Game does not allow third state!");
                }
            }else{
                gridBoard.set(position, ge);
            }
        }else{
            System.out.println("Grid element is occupied!");
        }
    }
    
    public GridElement getGridElement(int position){
        return gridBoard.get(position);
    }
    
    public int getTurn(){
        return (turn%2)+1;
    }
    
    public void printGridBoard(){
        Iterator<GridElement> it = gridBoard.iterator();
        for(int i=0; i<width; i++){
            for(int j=0; j<height; j++){
                System.out.print(it.next().returnStringState());
            }
            System.out.println();
        }
    }
    
    public boolean detectWinner(){
        if(detectVertical()){
            winner = true;
        }else if(detectHorizontal()){
            winner = true;
        }else if(detectDiagonal()){
            winner = true;
        }else if(detectAntiDiagonal()){
            winner = true;
        }else{
            if(gridBoard.size()==(width*height)){
                draw = true;
            }
        }
        return winner;
    }
    
    public boolean detectVertical(){
        boolean detected = false;
        for(int i=0; i<(width*height); i++){
            for(int j=1; j<required; j++){
                //(i+(width*j)<(width*height))?i+(width*j):(i+(width*j))-(width*height);
                if((gridBoard.get(i).getState()==gridBoard.get((i+(width*j)<(width*height))?i+(width*j):(i+(width*j))-(width*height)).getState())
                &&(gridBoard.get(i).getState()!=0)){
                    detected = true;
                }else{
                    detected = false;
                    break;
                }
            }
            if(detected==true){
                break;
            }    
        }
        
        return detected;
    }
    
    public boolean detectHorizontal(){
        boolean detected = false;
        
        for(int i=0; i<(width*height); i++){
            for(int j=1; j<required; j++){
                //(i+(1*j)<(width*height))?i+(1*j):(i+(1*j))-(width*height);
                if((gridBoard.get(i).getState()==gridBoard.get((i+(1*j)<(width*height))?i+(1*j):(i+(1*j))-(width*height)).getState())
                &&(gridBoard.get(i).getState()!=0)){
                    detected = true;
                }else{
                    detected = false;
                    break;
                }
            }
            if(detected==true){
                break;
            }    
        }
        
        return detected;
    }
    
    public boolean detectDiagonal(){
        boolean detected = false;
        for(int i=0; i<(width*height); i++){
            for(int j=1; j<required; j++){
                if((gridBoard.get(i).getState()==gridBoard.get((i+(width*j)+1*j<(width*height))?i+(width*j)+1*j:(i+(width*j)+1*j)-(width*height)).getState())
                &&(gridBoard.get(i).getState()!=0)){
                    detected = true;
                }else{
                    detected = false;
                    break;
                }
            }
            if(detected==true){
                break;
            }    
        }
        
        return detected;
    }
    
    public boolean detectAntiDiagonal(){
        boolean detected = false;
        for(int i=0; i<(width*height); i++){
            for(int j=1; j<required; j++){
                if((gridBoard.get(i).getState()==gridBoard.get((i+(width*j)-1*j<(width*height))?i+(width*j)-1*j:(i+(width*j)-1*j)-(width*height)).getState())
                &&(gridBoard.get(i).getState()!=0)){
                    detected = true;
                }else{
                    detected = false;
                    break;
                }
            }
            if(detected==true){
                break;
            }    
        }
        
        return detected;
    }
}
