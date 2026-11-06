fun trimInput(input: String): String{
  return input.trim()
}

fun calculateCompundInterest(principal: Double,rate: Double , years: Int): Double = 
principal * Math.pow(1 + rate , years.toDouble())

fun calc(a: Int,b:Int): Int{
  return a * b + 1
}



fun calculateAdjustProduct(a: Int, b: Int): Int = a * b + 1

fun roundDown(x: Double): Int{
  return x.toInt()
}
fun truncateToInt(x: Double): Int = x.toInt()

fun double(x: Int): Int = x * 2
fun doubleValue(x: Int): Int = x * 2

fun absoluteValue(x: Int): Int = if(x < 0) -x else x
fun absValue(x: Int): Int = if(x < 0) -x else x
fun criticalCalc(x: Int) = x * 2

fun criticalCalculations(x: Int): Int{
  return x * 2
}
fun main(){
var i = 20
i++
  println(absValue(20))
  println(absoluteValue(-90))
  println(trimInput("   vikash   kumar   "))
  println(calculateAdjustProduct(20,33))
  println(calculateCompundInterest(1000.0,0.9,3))
  println(criticalCalculations(33))
  
  
  var counter = 0
  counter++

println("Counter :$counter ")

println(roundDown(100.6))
println(truncateToInt(120.3))

println(double(20))
println(doubleValue(30))


val name1 = "Codecrafter"
println(criticalCalc(20))
println(name1)
}