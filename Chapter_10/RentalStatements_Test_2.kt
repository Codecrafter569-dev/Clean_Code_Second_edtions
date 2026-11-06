class RentalStatement(val name: String) {
    val rentals = mutableListOf<Rental>()
    var totalAmount = 0.0
    var frequentRenterPoints = 0

    fun addRental(rental: Rental) {
        rentals.add(rental)
    }

    fun makeStatement(): String {
        clearTotals()
        return makeHeader() + makeDetails() + makeFooter()
    }

    private fun clearTotals() {
        totalAmount = 0.0
        frequentRenterPoints = 0
    }

    private fun makeHeader(): String = "Rental Record for $name\n"

    private fun makeDetails(): String {
        val details = StringBuilder()
        for (rental in rentals) {
            details.append(makeDetail(rental))
        }
        return details.toString()
    }

    private fun makeDetail(rental: Rental): String {
        val amount = rental.determineAmount()
        frequentRenterPoints += rental.determinePoints()
        totalAmount += amount
        return formatDetail(rental, amount)
    }

    private fun formatDetail(rental: Rental, amount: Double): String =
        "\t${rental.getTitle()}\t${"%.1f".format(amount)}\n"

    private fun makeFooter(): String =
        "Amount owed is ${"%.1f".format(totalAmount)}\n" +
        "You earned $frequentRenterPoints frequent renter points"
}

fun main() {
    val statement = RentalStatement("Customer Name")

    val regular1 = Movie("Regular 1")
    val regular2 = Movie("Regular 2")
    val regular3 = Movie("Regular 3")

    statement.addRental(Rental(regular1, RegularRental(), 1))
    statement.addRental(Rental(regular2, RegularRental(), 2))
    statement.addRental(Rental(regular3, RegularRental(), 3))

    println(statement.makeStatement())
}
