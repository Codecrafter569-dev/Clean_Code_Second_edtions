fun chk(x: Int) = x > 86400

const val SECOND_IN_A_DAY = 86400
fun exceedsDailyLimit(seconds: Int) = seconds > SECOND_IN_A_DAY
fun isEligible(age: Int) = age >= 21
const val ELIGIBLE_AGE = 21
fun isEligibleUser(age: Int) = age >= ELIGIBLE_AGE

fun process(x: Int): Boolean{
  return x % 2 == 0 && x > 0
}
fun isPositiveEvenNumber(x: Int): Boolean = x % 2 == 0 && x > 0

val isoDatePattern = Regex("""\d{4}-\d{2}-\d{2}""")


fun compareByPriorityThenAge(a: Pair<Int, Int>, b: Pair<Int, Int>): Int {
    // Higher priority sorts first; if priorities tie, older items go first
    // (intent isn't obvious from the raw comparator math alone)
    return if (a.first != b.first) b.first - a.first else a.second - b.second
}


fun handleStatusCode(code: Int){
  if(code == 0){
    println("Payment succeeded ...")
  }
}
fun puregeAllSessions(){
  println("All sessions cleared...")
}

fun main(){
puregeAllSessions()
handleStatusCode(0)

val list = listOf(1 to 5 , 2 to 3 , 1 to 2)
println(list.sortedWith(::compareByPriorityThenAge))
  println(isoDatePattern.matches("2026-09-04"))
  println(chk(90000))
  println(exceedsDailyLimit(90000))
  
  println(isEligible(20))
  println(isEligibleUser(30))
  
  println(process(40))
  println(isPositiveEvenNumber(-30))
  
  println("App starting .... ")
  
}