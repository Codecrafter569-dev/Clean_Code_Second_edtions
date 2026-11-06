public class Book{
  private final String title;
  private boolean borrowed;
  
  public Book(String title){
    this.title = title;
    this.borrowed = false;
  }
  public String getTitle(){
    return title;
  }
  public boolean isBorrowed(){
    return borrowed;
  }
  public void marksAsBorrowed(){
    this.borrowed = true;
  }
  public void marksAsReturned(){
    this.borrowed = false;
  }
  
  @Override
  public String toString(){
    return title+" - "+(borrowed ? "borrowed" : "available");
  }
  
  
}