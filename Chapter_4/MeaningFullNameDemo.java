import java.util.ArrayList;
import java.util.List;

public class MeaningFullNameDemo{
  
  
  static List<int[]> getThem(List<int[]> theList){
    List<int[]> list1 = new ArrayList<>();
    for(int[] x : theList){
      if(x[0] == 4){
        list1.add(x);
      }
    }
    return list1;
  }
  
  
  static final int STATUS_FLAGGED = 4;
  static final int STATUS_INDEX = 0;
  
  static List<int[]> getFlaggedCells(List<int[]> gameBoard){
    List<int[]> flaggedCells = new ArrayList<>();
    
    for(int[] cell : gameBoard){
      if(cell[STATUS_INDEX] == STATUS_FLAGGED){
        flaggedCells.add(cell);
      }
    }
    return flaggedCells;
  }
  
  public static void main(String args[]){
    List<int[]> gameBoard = new ArrayList<>();
    gameBoard.add(new int[]{4,0,0});
    gameBoard.add(new int[]{0,0,1});
    gameBoard.add(new int[]{4,1,0});
    gameBoard.add(new int[]{2,1,1});
    
    System.out.println("Using the Bad version (getThem) :");
    for(int[] cell : getThem(gameBoard)){
      System.out.printf("Flagged cell at (%d , %d)%n",cell[1] , cell[2]);
    }
    
    System.out.println("\nUsing the good version (getFlaggedCells()): ");
    for(int[] cell : getFlaggedCells(gameBoard)){
      System.out.printf("Flagged cell at (%d , %d)%n",cell[1],cell[2]);
    }
  }
}