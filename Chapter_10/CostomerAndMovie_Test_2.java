
import java.util.ArrayList;
import java.util.List;
//CostomerAndMovie_Test_2.java

class Movie{
  static final int REGULAR = 0;
  static final int NEW_RELEASE = 1;
  static final int CHILDRENS = 2;
  
  String title;
  int movieType;
  
  Movie(String title , int movieType){
    this.title = title;
    this.movieType = movieType;
  }
}

class Rental{
  Movie movie;
  int daysRented;
  
  Rental(Movie movie , int daysRented){
    this.movie = movie;
    this.daysRented = daysRented;
  }
}

class Customer{
  String name;
  List<Rental> rentals = new ArrayList<>();
  
  Customer(String name){
    this.name = name;
  }
  
  void addRental(Rental rental){
    rentals.add(rental);
  }
  
  String statement(){
    double totalAmount = 0.0;
    int frequentRentalPoints = 0;
    StringBuilder result = new StringBuilder("Rental Record for "+name+"\n");
    
    for(Rental rental : rentals){
      double thisAmount = 0.0;
      switch(rental.movie.movieType){
        case Movie.NEW_RELEASE:
          thisAmount += rental.daysRented * 3;
          break;
        case Movie.REGULAR:
          thisAmount += 2;
          if(rental.daysRented > 2){
            thisAmount += (rental.daysRented - 2)* 1.5;
          }
          break;
        case Movie.CHILDRENS:
          thisAmount += 1.5;
          if(rental.daysRented > 3 ){
            thisAmount += (rental.daysRented - 3)* 1.5;
          }
          break;
      }
      frequentRentalPoints++;
      if(rental.movie.movieType == Movie.NEW_RELEASE && rental.daysRented > 1){
        frequentRentalPoints++;
      }
      result.append(String.format("\t%s\t%.1f\n",rental.movie.title,thisAmount));
      totalAmount += thisAmount;
    }
    
    result.append(String.format("Amount owed is %.1f\nYou earned %d frequent Rental Points",totalAmount , frequentRentalPoints));
    return result.toString();
  }
}
public class CostomerAndMovie_Test_2{
  public static void main(String args[]){
    Customer customer = new Customer("Fred");
    customer.addRental(new Rental(new Movie("The Cell",Movie.NEW_RELEASE),3));
    System.out.println(customer.statement());
  }
}