fun standardDeviations(numbers: DoubleArray): Double{
  val mean = numbers.average()
  var varianceSum = 0.0
  for( n in numbers){
    val deviations = n - mean
    varianceSum += deviations * deviations
  }
  
  val variance = varianceSum / numbers.size
  return Math.sqrt(variance)
}
fun main(){
  val data = doubleArrayOf(2.0,4.0,4.0,4.0,5.0,5.0,7.0,9.0)
  println(standardDeviations(data))
  println(standardDeviations(data))
  
}