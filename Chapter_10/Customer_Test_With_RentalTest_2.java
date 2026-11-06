import java.util.*;
class Rental{
  Movie movie;
  int daysRented;
  
  Rental(Movie movie , int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }
  String getTitle(){
    return movie.title;
  }
  double determineAmount(){
    double amount = 0.0;
    switch(movie.movieType){
      case Movie.NEW_RELEASE:
        amount += daysRented * 3;
        break;
        
      case Movie.REGULAR:
        amount += 2;
        if(daysRented > 2){
          amount += (daysRented - 2) * 1.9;
        }
        break;
        
      case Movie.CHILDRENS:
        amount += 1.5;
        if(daysRented > 3){
          amount += (daysRented - 3) * 1.5;
        }
        break;
    }
    return amount;
  }
  int determinePoints(){
    if(movie.movieType == Movie.NEW_RELEASE && daysRented > 1){
      return 2;
    }
    return 1;
  }
}
class Customer{
  String name;
  List<Rental> rentals = new ArrayList<>();
  double totalAmount;
  int frequentRenterPoints;
  
  Customer(String name){
    this.name = name;
  }
  void addRental(Rental rental){
    rentals.add(rental);
  }
  
  String makeStatements(){
    clearTotals();
    return makeHeader() + makeDetails() + makeFooter();
  }
  
  void clearTotals(){
    totalAmount = 0.0;
    frequentRenterPoints = 0;
  }
  
  String makeHeader(){
    return "Rental Record for "+name+"\n";
  }
  
  String makeDetails(){
    StringBuilder details = new StringBuilder();
    for(Rental rental : rentals){
      details.append(makeDetail(rental));
    }
    return details.toString();
  }
  String makeDetail(Rental rental){
    double amount = rental.determineAmount();
    frequentRenterPoints += rental.determinePoints();
    totalAmount += amount;
    return formatDetail(rental,amount);
  }
  String formatDetail(Rental rental , double amount){
    return String.format("\t%s\t%.1f\n",rental.getTitle(),amount);
  }
  String makeFooter(){
    return String.format("Amount owend is %.1f\nYou earned %d frequent rental Poins",totalAmount , frequentRenterPoints);
  }
}
public class Customer_Test_With_RentalTest_2{
  public static void main(String args[]){
    Customer customer = new Customer("Vikash kumar");
    customer.addRental(new Rental(new Movie("Regular 1",Movie.NEW_RELEASE),1));
    
    customer.addRental(new Rental(new Movie("Regular 3",Movie.REGULAR),3));
    
    customer.addRental(new Rental(new Movie("Regular 2",Movie.REGULAR),2));
    
    
    System.out.println(customer.makeStatements());
  }
}