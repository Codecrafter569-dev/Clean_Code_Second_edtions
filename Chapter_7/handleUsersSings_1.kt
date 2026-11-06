fun handleUsersSigupBad(email: String,password: String){
  if(email.contains("@") && password.length >= 8){
    println("Validateds .")
    println("Saving user : $email")
    println("Sending welcome email to $email")
  }else{
    println("Invalid signup")
  }
}

fun isValidSignup(email: String , password : String) = 
email.contains("@") && password.length >= 8

fun saveUser(email: String) = println("Saving user : $email")

fun sendWelcomeEmail(email: String) = println("Sending welcome email to $email")

fun signUp(email: String , password: String){
  if(!isValidSignup(email,password)){
    println("Invalid signUp")
    return
  }
  saveUser(email)
  sendWelcomeEmail(email)
}

class Employee(val name: String , val houseWorked: Int){
  fun shouldBePaidToday(): Boolean = houseWorked > 0
  fun pay() = println("$name has beed paid .")
}
fun processPayroll(employee : Employee){
  if(employee.shouldBePaidToday()){
    employee.pay()
  }
}

fun printReceiptBad(items: List<Pair<String,Double>>){
  var total = 0.0
  for(item in items){
    val formattedPrice = "$"+String.format("%.2f",item.second)
    println("${item.first}: $formattedPrice")
    total += item.second
  }
  
  println("Total : $"+String.format("%.2f",total))
}

fun formatPrice(amount: Double): String = "$"+String.format("%.2f",amount)

fun printLineItem(name: String , price: Double) =
println("$name: ${formatPrice(price)}")

fun printReceiptGood(items: List<Pair<String,Double>>){
  var total = 0.0
  for(item in items){
    printLineItem(item.first,item.second)
    total += item.second
  }
  println("Total : ${formatPrice(total)}")
}
fun main(){
  handleUsersSigupBad("vikash@com.log","password1")
  signUp("a@bloghell.com","password1")
  
  val emp = Employee("Codecrafter",50)
  processPayroll(emp)
  
  val cart = listOf("NoteBook" to 5.0, "Pen" to 23.45)
  printReceiptBad(cart)
  printReceiptGood(cart)
  
}