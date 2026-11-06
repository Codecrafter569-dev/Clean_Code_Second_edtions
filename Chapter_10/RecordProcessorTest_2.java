public class RecordProcessorTest_2{
  public void handle(Record r){
    if(r.getType().equals("OLD") && r.getYear() < 2000){
      System.out.println("Record deleted :"+r.getYear());
    }
  }
  public static void main(String args[]){
    RecordProcessorTest_2 rp = new RecordProcessorTest_2();
    rp.handle(new Record("OLD",1995));
  }
  
}

class Record{
  private String type;
  private int year;
  Record(String type , int year){ this.type = type; this.year = year; }
  String getType(){ return type; }
  int getYear(){ return year; }
}