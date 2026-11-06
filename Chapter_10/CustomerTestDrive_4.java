import java.util.*;
class Customer {
    String name;
    List<Rental> rentals = new ArrayList<>();
    double totalAmount;
    int frequentRenterPoints;

    Customer(String name) {
        this.name = name;
    }

    void addRental(Rental rental) {
        rentals.add(rental);
    }

    // HIGH-LEVEL function — reads like plain English
    String makeStatement() {
        clearTotals();
        return makeHeader() + makeDetails() + makeFooter();
    }

    void clearTotals() {
        totalAmount = 0.0;
        frequentRenterPoints = 0;
    }

    String makeHeader() {
        return "Rental Record for " + name + "\n";
    }

    String makeDetails() {
        StringBuilder details = new StringBuilder();
        for (Rental rental : rentals) {
            details.append(makeDetail(rental));
        }
        return details.toString();
    }

    String makeDetail(Rental rental) {
        double amount = determineAmount(rental);
        frequentRenterPoints += determinePoints(rental);
        totalAmount += amount;
        return formatDetail(rental, amount);
    }

    double determineAmount(Rental rental) {
        double amount = 0.0;
        switch (rental.movie.movieType) {
            case Movie.NEW_RELEASE:
                amount += rental.daysRented * 3;
                break;
            case Movie.REGULAR:
                amount += 2;
                if (rental.daysRented > 2) {
                    amount += (rental.daysRented - 2) * 1.5;
                }
                break;
            case Movie.CHILDRENS:
                amount += 1.5;
                if (rental.daysRented > 3) {
                    amount += (rental.daysRented - 3) * 1.5;
                }
                break;
        }
        return amount;
    }

    int determinePoints(Rental rental) {
        if (rental.movie.movieType == Movie.NEW_RELEASE && rental.daysRented > 1) {
            return 2;
        }
        return 1;
    }

    String formatDetail(Rental rental, double amount) {
        return String.format("\t%s\t%.1f\n", rental.movie.title, amount);
    }

    String makeFooter() {
        return String.format("Amount owed is %.1f\nYou earned %d frequent renter points",
                totalAmount, frequentRenterPoints);
    }

}


public class CustomerTestDrive_4{
  public static void main(String[] args) {
        Customer customer = new Customer("Customer Name");
        customer.addRental(new Rental(new Movie("New Release 1", Movie.NEW_RELEASE), 3));
        System.out.println(customer.makeStatement());
    }
}