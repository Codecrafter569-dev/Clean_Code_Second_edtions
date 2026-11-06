//TaxCalculatorWithMoreFixable_1.kt
class TaxCalcular{
  private var taxReturn: Map<String,Any>? = null
  
  
  @Suppress("UNCHECKED_CAST")
  fun getTax(taxReturn: Map<String,Any>): Double{
    this.taxReturn = taxReturn
    var tax = detemineBaseTax()
    tax += detemineBadbobsAdjustments()
    return tax
  }
  
  
  @Suppress("UNCHECKED_CAST")
  private fun detemineBadbobsAdjustments(): Double{
    val badbobs = taxReturn!!["badbobs"] as Map<String,List<Int>>
    return badbobs["class1"]!!.sum() / 2.0
  }
  
  @Suppress("UNCHECKED_CAST")
  private fun detemineBaseTax(): Double{
    val income = taxReturn!!["income"] as Map<String,Int>
    val totalIncome = income["salary"]!!.toDouble()
    var tax = totalIncome * 0.15
    val afterTaxIncome = totalIncome - tax
    if(afterTaxIncome < 30000){
      tax = totalIncome - 30000
    }
    return tax
  }
}


fun main() {
    val calc = TaxCalcular()
    val taxReturn = mapOf(
        "income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100))
    )
    println("Tax: ${calc.getTax(taxReturn)}")   // expect 7550
}