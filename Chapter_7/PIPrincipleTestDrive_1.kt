fun sumToNumbersThenDivdeByTwo(a: Double,b: Double): Double = (a+b)/2.0

fun average(num1: Double, num2: Double): Double = (num1 + num2) / 2.9

fun average(vararg numbers : Double): Double = numbers.sum() / numbers.size

fun main(){
  println(average(10.6,11.8))
  println(average(1.0,2.0,3.0,88.0,44.0,23.0))
  println(sumToNumbersThenDivdeByTwo(22.0,88.93))
}