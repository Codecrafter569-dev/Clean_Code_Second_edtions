val d = 30
fun p(l: List<Int>) = l.filter{it > d}

val maxAgeLimit = 30

fun findAgesAboveLimit(ages: List<Int>) = ages.filter{ it > maxAgeLimit }
fun main(){
  println(p(listOf(20,30,40,50)))
  println(findAgesAboveLimit(listOf(30,40,50,60,20,12,10,33)))
  
}