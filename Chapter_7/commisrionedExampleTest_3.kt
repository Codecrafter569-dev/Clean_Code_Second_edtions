class CommissionEmployee{
  private val salesReceipts = mutableListOf<Double>()
  
  fun addSalesReceipt(amount: Double){
    salesReceipts.add(amount)
  }
  
  
  private fun totalSales(): Double = salesReceipts.sum()
  fun calculateCommissions(rate: Double): Double = totalSales() * rate
}

fun main(){
  val employee = CommissionEmployee()
  employee.addSalesReceipt(400.0)
  employee.addSalesReceipt(900.0)
  employee.addSalesReceipt(2293.93)
  println(employee.calculateCommissions(0.1))
  
  
}