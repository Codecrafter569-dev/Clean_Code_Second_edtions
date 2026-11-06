import java.util.*;

class Space {
    double width, length;
    Space(double w, double l) { width = w; length = l; }
}
class Floor {
    List<Space> spaces = new ArrayList<>();
}
class Building {
    List<Floor> floors = new ArrayList<>();
}

// BAD: duplicated loop structure
class SpaceFeatureBad {
    int score(Building building) {
        int spaces = 0;
        for (Floor floor : building.floors) {
            for (Space space : floor.spaces) {
                spaces++;
            }
        }
        return spaces;
    }
}
class AreaFeatureBad {
    double score(Building building) {
        double area = 0;
        for (Floor floor : building.floors) {
            for (Space space : floor.spaces) {
                area += space.width * space.length;
            }
        }
        return area;
    }
}

public class duplicateCodeTest_1{
  public static void main(String args[]){
    
  }
}