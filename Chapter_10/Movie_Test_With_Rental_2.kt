class Movie(val title: String)

const val REGULAR = 0;
const val NEW_RELEASE = 1;
const val CHILDRENS  = 2;

class Rental(val movie: Movie, val rentalType: Int , val daysRental: Int){
  fun getTitle(): String = movie.title
}

fun main(){
  val tigger = Movie("The Tigger Movie")
  val firstRental = Rental(tigger,NEW_RELEASE,3)
  val secondRental = Rental(tigger,CHILDRENS,3)
  
  println("First rental type :${firstRental.rentalType}")
  println("Second rental type :${secondRental.rentalType}")
}
