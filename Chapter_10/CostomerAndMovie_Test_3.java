
import java.util.*;
class Customer {
    String name;
    List<Rental> rentals = new ArrayList<>();
    double totalAmount;              // now a field, not a local variable
    int frequentRenterPoints;        // now a field, not a local variable

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    String statement() {
        totalAmount = 0.0;
        frequentRenterPoints = 0;
        StringBuilder result = new StringBuilder("Rental Record for " + name + "\n");

        for (Rental rental : rentals) {
            double thisAmount = 0.0;
            switch (rental.movie.movieType) {
                case Movie.NEW_RELEASE:
                    thisAmount += rental.daysRented * 3;
                    break;
                case Movie.REGULAR:
                    thisAmount += 2;
                    if (rental.daysRented > 2) {
                        thisAmount += (rental.daysRented - 2) * 1.5;
                    }
                    break;
                case Movie.CHILDRENS:
                    thisAmount += 1.5;
                    if (rental.daysRented > 3) {
                        thisAmount += (rental.daysRented - 3) * 1.5;
                    }
                    break;
            }
            frequentRenterPoints++;
            if (rental.movie.movieType == Movie.NEW_RELEASE && rental.daysRented > 1) {
                frequentRenterPoints++;
            }
            result.append(String.format("\t%s\t%.1f\n", rental.movie.title, thisAmount));
            totalAmount += thisAmount;
        }
        result.append(String.format("Amount owed is %.1f\nYou earned %d frequent renter points",
                totalAmount, frequentRenterPoints));
        return result.toString();
    }

    
}

//CostomerAndMovie_Test_3.java
public class CostomerAndMovie_Test_3{
  public static void main(String args[]){
    
            // Simulating the new test style
        Customer customer = new Customer("Customer Name");
        Movie regular1 = new Movie("Regular 1", Movie.REGULAR);
        Movie regular2 = new Movie("Regular 2", Movie.REGULAR);
        Movie regular3 = new Movie("Regular 3", Movie.REGULAR);

        customer.addRental(new Rental(regular1, 1));
        customer.addRental(new Rental(regular2, 2));
        customer.addRental(new Rental(regular3, 3));

        customer.statement(); // triggers the calculation

        System.out.println("Total owed: " + customer.totalAmount);       // check the VALUE
        System.out.println("Points: " + customer.frequentRenterPoints);   // check the VALUE
        System.out.println("---");
        System.out.println(customer.statement());                        // check FORMAT (only once)
  }
}
