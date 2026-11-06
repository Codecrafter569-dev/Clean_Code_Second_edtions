//Class2BadbobsTest_2.kt

class TaxCalculator{
  private var taxReturn: Map<String,Any>? = null
  private var totalIncome: Double = 0.0
  
  
  @Suppress("UNCHECKED_CAST")
  fun getTax(taxReturn: Map<String,Any>): Double{
    this.taxReturn = taxReturn
    var tax = determineBaseTax()
    tax += determineBadbobAdjustments()
    return tax
  }
  
  
  @Suppress("UNCHECKED_CAST")
  private fun determineBadbobAdjustments(): Double{
    val badbobs = taxReturn!!["badbobs"] as Map<String, List<Int>>
    val class1 = badbobs["class1"]!!.sum()
    val class1Adjustments = class1 / 2.0
    
    val class2 = badbobs["class2"]!!.sum()
    val class2Adjustments = when{
      class2 < 1001 -> 0.0
      class2 < 10001 -> totalIncome * 0.05
      class2 < 50001  -> totalIncome * 0.1
      else -> totalIncome * 0.15
    }
    
    return class1Adjustments  + class2Adjustments 
  }
  
  @Suppress("UNCHECKED_CAST")
  private fun determineBaseTax(): Double{
    val income = taxReturn!!["income"] as Map<String,Int>
    totalIncome = income["salary"]!!.toDouble()
    var tax = totalIncome * 0.15
    val afterTaxIncome = totalIncome - tax
    if(afterTaxIncome < 30000){
      tax = totalIncome - 30000
    }
    
    return tax
  }
}

fun main() {
    val calc = TaxCalculator()

    val t1 = mapOf("income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf<Int>(), "class2" to listOf(400, 600)))
    println("Under 1001: ${calc.getTax(t1)}")           // expect 7500.0

    val t2 = mapOf("income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf<Int>(), "class2" to listOf(10000)))
    println("Under 10001: ${calc.getTax(t2)}")          // expect 10000.0 (7500+2500)

    val t3 = mapOf("income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf<Int>(), "class2" to listOf(10000, 40000)))
    println("Under 50001: ${calc.getTax(t3)}")          // expect 12500.0 (7500+5000)

    val t4 = mapOf("income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf<Int>(), "class2" to listOf(10000, 40000, 1000)))
    println("Over 50000: ${calc.getTax(t4)}")           // expect 15000.0 (7500+7500)
}