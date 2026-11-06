fun appendNewLineIfMissing(content: String): String =
 if(content.endsWith("\n")) content else content  + "\n"
 
 
class Counter{
  private var count = 0
  fun increment() { count++}
  fun reset(){ count = 0}
}

fun createRentalBad(movie: String , days: Int, customer: String , discount: Double){
  println("$customer rents $movie for $days days, discount $discount")
}

data class RentalRequest(val movie: String , val days: Int , val customer: String , val discount: Double)

fun createRental(request: RentalRequest){
  println("${request.customer} rents ${request.movie} for ${request.days} days, discount ${request.discount}")
}
fun square(x: Int): Int = x * x
fun  add(a: Int , b: Int): Int = a + b
fun main(){
  val fileContent = "Hello World"
  val update = appendNewLineIfMissing(fileContent)
  
  
  val counter = Counter()
  counter.increment()
  println(square(30))
  println(add(22,45))
  println(update)
  
  
  createRentalBad("The Matrix",3,"Codecrafter",0.6)
  createRental(RentalRequest("The Matrix",4,"Codecrafter",3.9))
}