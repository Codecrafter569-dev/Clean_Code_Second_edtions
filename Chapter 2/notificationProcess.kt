//notificationProcess.kt
fun processNotify(orderedId: Int, amount: Double, email: String){
  println("Processing order ${orderedId} for ${amount}.")
  println("Notifying $email")
}

fun processOrder(orderedId: Int, amount: Double){
  println("Processing order ${orderedId} for ${amount}.")
}
fun notifyingCustomer(email: String){
  println("Notifying $email .")
}
fun main(){
  processNotify(12,892.338,"vikashkumar@gmai.com")
  processOrder(12,939.3)
  notifyingCustomer("anmolkumar@gmail.com")
}