fun totalPriceOriginal(prices: List<Double>): Double{
  var total = 0.0
  for(p in prices){
    total += p
  }
  return total
}

fun totalPriceRefectored(prices: List<Double>): Double{
  return prices.sum()
}

fun main(){
val prices = listOf(10.0,20.0,30.0,50.0)
val original = totalPriceOriginal(prices)
val refectored = totalPriceRefectored(prices)

  println(totalPriceOriginal(prices))
  println(totalPriceRefectored(prices))
  
  println("Original: ${original} , Refactored: ${refectored}")
  check(original == refectored) { "Refactor changed behavior — reject it!" }
    println("Verified: refactor is safe")
    
    
}