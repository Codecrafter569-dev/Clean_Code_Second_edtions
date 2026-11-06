class CheckOutBad{
  fun pay(amount: Double){
    println("Charging $amount via CreditCardGateWays")
  }
}

interface PaymentProcessor{
  fun charge(amount: Double)
}

class CreditCardProcessor : PaymentProcessor{
  override fun charge(amount: Double) =
  println("Charging $amount via CreditCardGateWays")
  
}

class UpiProcessor : PaymentProcessor{
  override fun charge(amount : Double) =
  println("Charging $amount via UPI")
}

class Checkout(private val processor : PaymentProcessor){
  fun completePurchase(amount : Double){
    processor.charge(amount)
  }
}
fun main(){
 CheckOutBad().pay(200.0) 
 
 val cardCheckout = Checkout(CreditCardProcessor())
 cardCheckout.completePurchase(300.0)
 
 val cardUpi = Checkout(UpiProcessor())
 cardUpi.completePurchase(300.0)
}