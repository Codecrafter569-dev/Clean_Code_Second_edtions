//BadBodAdjuster_1.kt
class BadBodAdjuster(private val taxCalculator: TaxCalculator){
  fun getAdjustments(): Double{
    return class1Adjustment() + getclass2BadbodAdjustment()
  }
  private fun class1Adjustment(): Double{
    val class1 = taxCalculator.badbobsClass1().sum()
    return class1 / 2.0
  }
  private fun getclass2BadbodAdjustment(): Double{
    val class2 = taxCalculator.badbobsClass2().sum()
    val rate = getClass2Rate(class2)
    return rate * taxCalculator.totalIncomeValue()
  }
  
  private fun getClass2Rate(class2: Int): Double{
    val class2Table = listOf(
    1001 to 0.0,
    100001 to 0.05,
    50001 to 0.1,
    null to 0.15
    )
    for((upperBound,rate) in class2Table){
      if(upperBound == null || class2 < upperBound){
        return rate
      }
    }
    return 0.0
  }
}

class TaxCalculator{
  private var taxReturn : Map<String,Any>? = null
  private var totalIncome: Double = 0.0
  
  fun totalIncomeValue() = totalIncome
  
    @Suppress("UNCHECKED_CAST")
    fun badbobsClass1(): List<Int> {
        val badbobs = taxReturn!!["badbobs"] as Map<String, List<Int>>
        return badbobs["class1"]!!
    }

    @Suppress("UNCHECKED_CAST")
    fun badbobsClass2(): List<Int> {
        val badbobs = taxReturn!!["badbobs"] as Map<String, List<Int>>
        return badbobs["class2"]!!
    }

    fun getTax(taxReturn: Map<String, Any>): Double {
        this.taxReturn = taxReturn
        var tax = determineBaseTax()
        tax += BadBodAdjuster(this).getAdjustments()
        return tax
    }

    @Suppress("UNCHECKED_CAST")
    private fun determineBaseTax(): Double {
        val income = taxReturn!!["income"] as Map<String, Int>
        totalIncome = income["salary"]!!.toDouble()
        var tax = totalIncome * 0.15
        val afterTaxIncome = totalIncome - tax
        if (afterTaxIncome < 30000) {
            tax = totalIncome - 30000
        }
        return tax
    }
}
fun main(){
  val calc = TaxCalculator()
  val t = mapOf("income" to mapOf("salary" to 50000),
  "badbobs" to mapOf("class1" to listOf<Int>(),"class2" to listOf(10000,40000)))
  println("Tax : ${calc.getTax(t)}")
}