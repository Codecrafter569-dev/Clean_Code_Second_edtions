val strName = "Codecrafter"
val iCount = 10

val name = "Codecrafter"
val count = 20

class AccountBad{
  var m_balance = 0.0
  fun m_deposite(amount: Double){
    m_balance += amount
  }
}

class Account{
  var balance = 0.0
  fun deposite(amount: Double){
    balance += amount
  }
}


class Calculate(val a: Int, val b: Int){
  fun sum():Int {
    return 4
  }
}
class Calculator(val a: Int,val b: Int){
  fun add(): Int = a + b
}
fun main(){

  println(strName)
  println(name)
  println(iCount)
  println(count)
  
  val a1 = AccountBad()
  val a2 = Account()
  
  println(a1.m_deposite(30.0))
  println(a2.deposite(40.0))
  
  println(a1.m_balance)
  println(a2.balance)
  
  val calc = Calculator(30,20)
  println(calc.add())
  
  
  val calc_1 = Calculate(10,5)
  println(calc_1.sum())
  go()
  
}



class Invoice(val amount: Double){
  fun generateInvoice(amount: Double): Invoice = Invoice(amount)
  fun printInvoice(invoice: Invoice) = println("Invoice: ${invoice.amount}")
}
fun go(){
  val invoice_1 = generateInvoice(340.0)
  printInvoice(invoice_1)
  
}

