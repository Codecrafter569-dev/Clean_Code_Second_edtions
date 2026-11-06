import java.time.LocalDate;
import java.time.DayOfWeek;

public class PreviousWeekOfDays_4 {
  
  static class Date{
    private final LocalDate localDate;
    
    
    public Date(LocalDate localDate){
      this.localDate = localDate;
    }
    
    public Date(int year,int month , int day){
      this.localDate = LocalDate.of(year,month,day);
    }
    
    public int getDayOfWeek(){
      int value = localDate.getDayOfWeek().getValue();
      
      return (value % 7)+1;
    }
    
    public static Date addDays(int days , Date from){
      return new Date(from.localDate.plusDays(days));
    }
    
    @Override
    public String toString(){
      return localDate.toString();
    }
  }
  
  private static boolean  isValidWeekdayCode(int weekday){
    return weekday >= 1 && weekday <= 7;
  }
  
  public static Date getPreviousDayOfWeek(int weekday , Date from){
    if(!isValidWeekdayCode(weekday)){
      throw new IllegalArgumentException("Invalid day-of-the-week code.");
    }
  
  final int adjust;
  final int baseDow = from.getDayOfWeek();
  if(baseDow  > weekday){
    adjust = Math.min(0 , weekday - baseDow);
    
  }else{
    adjust = -7+Math.max(0,weekday - baseDow);
  }
  return Date.addDays(adjust,from);
  }
  public static void main(String[] args) {
    Date today = new Date(2026,2,8);
    
    System.out.println("From date:"+today+" (DOW= "+today.getDayOfWeek()+")");
    
            int[] weekdaysToTest = {1, 2, 3, 4, 5, 6, 7};
        String[] names = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


for(int wd : weekdaysToTest){
  Date result = getPreviousDayOfWeek(wd,today);
  
  System.out.println("Previous "+names[wd-1]+" before "+today+" = "+result);
}

try{
  getPreviousDayOfWeek(9,today);
}catch(IllegalArgumentException e){
  System.out.println("Caught expected error: " + e.getMessage());
  
}
  }
}