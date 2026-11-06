import java.time.LocalDate;

public class PreviousDayOfWeekExampleTestDrive_2 {
  
  static class Date{
    private final LocalDate localDate;
    
    public Date(LocalDate localDate){
      this.localDate = localDate;
      
    }
    
    public Date(int year , int month , int day){
      this.localDate  = LocalDate.of(year,month,day);
    }
    
    public int getDayOfWeek(){
      int value = localDate.getDayOfWeek().getValue();
      
      return (value % 7) +1;
    }
    
    @Override
    public String toString(){
      return localDate.toString();
    }
  }
  
  private static boolean isValidWeekdayCode(int weekday){
    return weekday  >= 1 && weekday  <= 7;
  }
  
  private static void checkWeekdayArgument(int weekday){
    if(!isValidWeekdayCode(weekday)){
      throw new IllegalArgumentException("Invalid day-of-week code.");
    }
  }
  
  private static int daysBefore(int targetWeekday , Date from){
    int fromWeekday = from.getDayOfWeek();
    int diff = fromWeekday  - targetWeekday ;
    return diff +(diff > 0 ? 0 : 7);
  }
  
  private static Date addDays(int days , Date from){
    return new Date(from.localDate.plusDays(days));
  }
  
  public static Date getPreviousDayOfWeek(int weekday , Date from){
    checkWeekdayArgument(weekday);
    return addDays(-daysBefore(weekday,from),from);
  }
  public static void main(String[] args) {
    Date today = new Date(2026,8,13);
    System.out.println("From date :"+today+" (DOW= "+today.getDayOfWeek()+")");
    
    int[] weekdaysToTest = {1,2,3,4,5,6,7};
      String[] names = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};


    for(int wd : weekdaysToTest){
      Date result = getPreviousDayOfWeek(wd,today);
      System.out.println("Previous "+names[wd-1]+" before "+today+" = "+result);
    }
    try{
      getPreviousDayOfWeek(9,today);
    }catch(IllegalArgumentException e){
      System.out.println("Caught expected error : "+e.getMessage());
    }
  }
}