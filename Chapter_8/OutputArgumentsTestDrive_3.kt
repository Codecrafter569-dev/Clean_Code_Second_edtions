class StatsHolder{ var mean: Double = 0.0 ; var sum: Double = 0.0}

fun calculateStateBad(numbers: List<Double> , holder: StatsHolder){
  holder.sum = numbers.sum()
  holder.mean = holder.sum / numbers.size
}

data class Stats_1(val mean: Double , val sum: Double)
fun calculateStats(numbers: List<Double>): Stats_1{
  val sum = numbers.sum()
  val mean = sum / numbers.size
  return Stats_1(mean, sum)
}

fun main(){
  val holder = StatsHolder()
  calculateStateBad(listOf(1.0,2.0,3.0),holder)
  println("${holder.mean} , ${holder.sum}")
  
  val stats = calculateStats(listOf(1.0,2.0,3.0))
  println("${stats.mean} , ${stats.sum}")
}