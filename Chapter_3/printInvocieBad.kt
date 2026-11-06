fun printInvoiceBad(customer: String , amount: Double){
  val line = "-".repeat(20)
  println(line)
  println("Invoice for :"+customer.trim().replaceFirstChar{
    it.uppercase()
  })
  println("Amount due: $"+ String.format("%.2f",amount))
  println(line)
}

fun divider(): String = "-".repeat(20)
fun formatCustomerName(name: String): String = name.trim().replaceFirstChar{it.uppercase()}
fun formatAmount(amount: Double): String = "$"+String.format("%.2f",amount)

fun printInvoice(customer: String, amount: Double){
  println(divider())
  println("Invoice for: ${formatCustomerName(customer)}")
  println("Amount due : ${formatAmount(amount)}")
  println(divider())
}
fun main(){
  printInvoiceBad("codercrafter",392.43)
  printInvoice("codecrafter",93.242)
}