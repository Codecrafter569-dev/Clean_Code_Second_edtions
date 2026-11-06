class TaxCalculator{
  
   @Suppress("UNCHECKED_CAST")
   fun getTax(taxReturn: Map<String,Any>): Double{
     val income = taxReturn["income"] as Map<String,Int> 
     val totalIncome = income["salary"]!!.toDouble()
     var tax = totalIncome * 0.15
     val afterTaxIncome = totalIncome - tax
     if(afterTaxIncome < 30000){
       tax = totalIncome - 30000
     }
     
     val badbobs = taxReturn["badbobs"] as Map<String,List<Int>>
     tax += badbobs["class1"]!!.sum() / 2.0
     return tax
   }
      
}
fun main(){
  val calc = TaxCalculator()
  val taxReturn = mapOf(
          "income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100))
  )
  println("Tax : ${calc.getTax(taxReturn)}") //expect 7550
}
