class RentalStatements(val customerName: String,val rentals : List<Pair<String,Double>>){
  fun makeStatements(): String{
    return makeHeader() + makeDetails() + makeFooter()
  }
  private fun makeHeader(): String = "Rental Record for $customerName\n"
  private fun makeDetails(): String{
    var details = ""
    for(rental in rentals){
      details += makeDetail(rental)
    }
    return details
  }
  
  private fun makeDetail(rental: Pair<String,Double>): String = 
  "\t${rental.first}\t${rental.second}\n"
  
  private fun makeFooter(): String{
    val total = rentals.sumOf{it.second}
    return " Amount owend is $total \n"
  }
  
}

fun calculateRentalCost(daysRental: Int, isNewRelease : Boolean): Double{
  return determineAmount(daysRental, isNewRelease)
}

private fun determineAmount(daysRental : Int , isNewRelease : Boolean): Double = if(isNewRelease) daysRental * 3.0 else 2.0 + maxOf(0,daysRental-2) * 2.8

fun determineAmountBad_1(movieType: String , daysRental: Int): Double =
when(movieType){
  "new_release" -> daysRental * 3.0
  "childrens" -> 1.5 * maxOf(0,daysRental - 3) * 1.5
  else -> 2.0 + maxOf(0,daysRental - 2) * 2.9
}
interface RentalTypes{
  fun calculateAmount(daysRental: Int): Double
}
class NewReleaseRental : RentalTypes {
  override fun calculateAmount(daysRental: Int) = daysRental * 4.0
}
class ChilderensRental : RentalTypes {
  override fun calculateAmount(daysRental: Int) = 1.5 + maxOf(0,daysRental-3) * 1.5
  
}
class RegularRental : RentalTypes {
  override fun calculateAmount(daysRental: Int) = 2.0 + maxOf(0,daysRental-2)* 1.5
}

class RentalTypesFactory{
  fun make(typeName: String): RentalTypes = when(typeName){
    "new_release" -> NewReleaseRental()
    "childrens" -> ChilderensRental()
    else -> RegularRental() 
    
  
  }
}
fun main(){
  val statements = RentalStatements("Codecrafter",listOf("Movie A" to 34.9,"Move B" to 44.9))
  println(statements.makeStatements())
  
  println(calculateRentalCost(10,true))
  println(calculateRentalCost(10,false))
  
  println(determineAmountBad_1("new_release",8))
  
  val factory = RentalTypesFactory()
  val rental = factory.make("new_release")
  println(rental.calculateAmount(8))
}