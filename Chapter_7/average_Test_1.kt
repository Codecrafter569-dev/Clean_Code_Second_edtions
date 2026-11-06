fun average(a: Double , b: Double) = ( a + b) / 2.0;


class CommissionEmployee(val name: String){
  private val salesRecipts = mutableListOf<Double>();
  
  
  fun addSalesReceipts(amount: Double){
    salesRecipts.add(amount)
  }
}
fun readFile(path : String): String = "Context of $path"
class InvoiceProcessor{
  fun calculateLateFeeForOverdueInvoice(daysOverdue: Int) : Double =
        if(daysOverdue > 0) daysOverdue * 3.8 else 0.0
}

fun main(){
  println(average(2383.392,493.94))
  val employee = CommissionEmployee("Codecrafter")
  employee.addSalesReceipts(803.2)
  
  
  println(readFile("data.txt"))
  val processor = InvoiceProcessor()
  println(processor.calculateLateFeeForOverdueInvoice(10))
}