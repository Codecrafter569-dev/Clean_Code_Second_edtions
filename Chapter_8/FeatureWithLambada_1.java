import java.util.function.BiFunction;
class FeatureLambda{
  double doScore(Building building , BiFunction<Double,Space,Double> block){
    double value = 0;
    for(Floor floor : building.floors){
      for(Space space : floor.spaces){
        value = block.apply(value,space);
      }
    }
    return value;
  }
}
public class FeatureWithLambada_1{
  public static void main(String args[]){
    Building building  = new Building();
    Floor floor = new Floor();
    floor.spaces.add(new Space(20,40));
    building.floors.add(floor);
    
    FeatureLambda f = new FeatureLambda();
    double area = f.doScore(building, (value,space) -> value + (space.width * space.length));
    System.out.println("Are via lambda : "+area);
    
  }
}