public class RentalMenagerTest_1{
  private java.util.List<String> rentals = new java.util.ArrayList<>();
  
  public void addRental(String rental){
    rentals.add(rental);
  }
  public static void main(String args[]){
    RentalMenagerTest_1 rm = new RentalMenagerTest_1();
    rm.addRental("Movie A");
    System.out.println(rm.rentals);
  }
}