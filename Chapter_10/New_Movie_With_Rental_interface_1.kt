//New_Movie_With_Rental_interface_1.kt

interface RentalType{
  fun determineAmount(daysRented : Int): Double
  fun determinePoints(daysRented: Int): Int
}

class NewReleaseRental : RentalType {
  override fun determineAmount(daysRented : Int): Double = daysRented * 3.0
  
  override fun determinePoints(daysRented : Int): Int = 
     if(daysRented > 1) 2 else 1
}

class RegularRental : RentalType {
  override fun determineAmount(daysRented : Int): Double {
    var amount = 2.0
    if(daysRented > 2){
      amount += (daysRented - 2) * 1.5
    }
    return amount
  }
  
  override fun determinePoints(daysRented: Int): Int = 1
}

class ChildrensRental : RentalType {
  override fun determineAmount(daysRented : Int): Double {
    var amount = 1.5
    if(daysRented > 3){
      amount += (daysRented - 3) * 1.5
    }
    return amount
  }
  override fun determinePoints(daysRented : Int): Int = 1
}

class Movie(val title : String)

class Rental(val movie: Movie , val rentalType : RentalType, val daysRented: Int){
  fun getTitle(): String = movie.title
  fun determineAmount(): Double = rentalType.determineAmount(daysRented)
  fun determinePoints(): Int = rentalType.determinePoints(daysRented)
}

fun main(){
  val newRelease1 = Movie("New Release 1")
  val rental = Rental(newRelease1,NewReleaseRental(),3)
  
  
  println("Amount : ${rental.determineAmount()}")
  println("Points : ${rental.determinePoints()}")
}

