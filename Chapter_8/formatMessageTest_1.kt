fun formatMessage(template: String, vararg args: Any): String{
  var result = template
  args.forEachIndexed{index , arg -> result = result.replaceFirst("{}",arg.toString()) }
  
  return result
}
fun createRental(movie: String , daysRented: Int, discountApplied: Boolean = false , isPriority: Boolean = false){
  println("$movie for $daysRented days , discount= $discountApplied , priority=$isPriority")
}
fun sumAll(vararg numbers: Int): Int = numbers.sum()
fun getMonths(shortened: Boolean): List<String> = if(shortened) listOf("Jan","Feb","Mar") else listOf("January","February","March")
fun getLongMonthNames(): List<String> = listOf("January","February","March")
fun getShortMonthNames(): List<String> = listOf("Jan","Feb","Mar")

fun main(){
  println(formatMessage("Hello {}, you have {} message","Codecrafter",20))
  println(sumAll(1,2,3,4,5))
  
  createRental(daysRented = 3 , movie = "Hello Bro",isPriority = true , discountApplied = false)
  
println(getMonths(false))
println(getLongMonthNames())
println(getShortMonthNames())
}