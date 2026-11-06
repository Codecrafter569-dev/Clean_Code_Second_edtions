//newFileMoreInproved_1.kt

class TaxCalculator{
  @Suppress("UNCHECKED_CAST")
  fun getTax(taxReturn: Map<String,Any>): Double{
    val income = taxReturn["income"] as Map<String,Int>
    val totalIncome = income["salary"]!!.toDouble()
    var tax = determineBaseTax(totalIncome)
    tax += determineBadbobAdjustments(taxReturn)
    return tax
  }
  
  @Suppress("UNCHECKED_CAST")
  private fun determineBadbobAdjustments(taxReturn: Map<String,Any>): Double{
    val badbobs = taxReturn["badbobs"] as Map<String,List<Int>> 
    return badbobs["class1"]!!.sum()/2.0
  }
  
  private fun determineBaseTax(totalIncome: Double): Double{
    var tax = totalIncome * 0.15
    val afterTaxIncome = totalIncome - tax
    if(afterTaxIncome < 30000){
      tax = totalIncome - 30000
    }
    return tax
  }
}

fun main(){
  val calc = TaxCalculator()
  val taxReturn = mapOf(
  "income" to mapOf("salary" to 50000),
  "badbobs" to mapOf("class1" to listOf(100))
  )
  
  println("Tax : ${calc.getTax(taxReturn)}")
}