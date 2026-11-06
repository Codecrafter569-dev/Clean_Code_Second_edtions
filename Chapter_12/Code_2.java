interface Listener{
  void onFire();
}
class Sprinkler implements Listener{
  public void onFire(){
    System.out.println("Sprinkler : water on");
  }
  
}
class Siren implements Listener{
  public void onFire(){
    System.out.println("Siren : loud Sound");
  }
}

class FireAlarm{
  private final java.util.List<Listener> listeners = new java.util.ArrayList<>();
  public void add(Listener l){
    listeners.add(l);
  }
  public void trigger(){
    for(Listener l : listeners){
      l.onFire();
    }
  }
}
public class Code_2 {
  public static void main(String[] args) {
    FireAlarm fire_1 = new FireAlarm();
    fire_1.add(new Sprinkler());
    fire_1.add(new Siren());
    fire_1.trigger();
  }
}