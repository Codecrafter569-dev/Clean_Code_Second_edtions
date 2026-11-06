import java.util.ArrayList;
import java.util.List;

public class LibSystemBadCode{
  List<String> b = new ArrayList<>();
  List<Integer> s = new ArrayList<>();
  List<String> m = new ArrayList<>();
  public void a(String t){
    b.add(t);
    s.add(0);
  }
  public void a2(String n){
    m.add(n);
  }
  
  public boolean d(String t , String n){
    for(int i=0; i < b.size();i++){
      if(b.get(i).equals(t) && s.get(i) == 0){
        s.set(i,1);
        System.out.println(n+" borrowed "+t);
        return true;
      }
    }
    
    System.out.println("not available.");
    return false;
  }
  
  public boolean r(String t){
    for(int i=0; i < b.size();i++){
      if(b.get(i).equals(t) && s.get(i) == 1){
        s.set(i,0);
        System.out.println(t+" returned");
        return true;
      }
    }
    return false;
  }
  
  public void p(){
    for(int i=0; i < b.size();i++){
      System.out.println(b.get(i) +" - "+(s.get(i) == 0 ? "available": "borrowed"));
    }
  }
  public static void main(String[] args){
    LibSystemBadCode ls = new LibSystemBadCode();
    ls.a("Clean Code");
    ls.a("The pragmatic Programer");
    ls.a2("Codecrater");
    
    ls.p();
    ls.d("Clean Code","Codecrater");
    ls.d("Clean Code","Codecrater");
    ls.p();
    ls.r("Clean code");
    ls.p();
  }
}