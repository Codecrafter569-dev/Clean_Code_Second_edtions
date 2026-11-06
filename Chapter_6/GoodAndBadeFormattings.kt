class Order{val id:Int;val amount:Double
    constructor(id:Int,amount:Double){this.id=id;this.amount=amount}
    fun total():Double{return amount*1.1}}

  
class Order_1(val id:Int,val amount: Double){
  fun total(): Double = amount * 1.1
}
class ReceiptPrinter {
    val taxRate = 0.08
    fun calculateTax(amount: Double) = amount * taxRate
    fun printHeader() = println("=== Receipt ===")
    fun calculateTotal(amount: Double) = amount + calculateTax(amount)
    fun printFooter() = println("=== End ===")
}

class Receipt_1{
  val taxRate = 0.09
  
  fun calculateTax(amount: Double) = amount * taxRate
  
  fun calculateTotal(amount: Double) = amount + calculateTax(amount)
  
  fun printHeader() = println(" === Receipt ===")
  
  fun printFooter() = println("=== End ===")
}

fun processOrderBad(price: Double, quantity: Int) {
    var subtotal: Double
    var tax: Double
    var total: Double

    subtotal = price * quantity
    tax = subtotal * 0.08
    total = subtotal + tax
    println(total)
}

fun processOrder(price: Double, quantity: Int){
  val subtotal = price * quantity
  val tax = subtotal * 0.08
  val total = subtotal + tax
  println(total)
}

fun printOrderSummery(price: Double , quantity: Int){
  val total = calculateTotal(price,quantity)
  println("Total : $total")
}
fun calculateTotal(price: Double , quantity: Int): Double = price * quantity

fun runPipeLine(input: String){
  val cleaned = cleanInput(input)
  val result = analyzeInput(cleaned)
  println(result)
}
fun cleanInput(input: String) : String = input.trim().lowercase()
fun analyzeInput(input: String): String = "Analyzed: $input"

fun isValidEmail(email: String): Boolean = email.contains("@")
fun isValidPhone(phone: String): Boolean = phone.length == 10
fun isValidZip(zip: String): Boolean = zip.length == 6




fun main(){
println(isValidEmail("a@.com"))
println(isValidPhone("980293392"))
println(isValidZip("929202"))
runPipeLine("   Hello World  ")
printOrderSummery(50.20,8)
val order = Order_1(1,100.0)
val receipt = Receipt_1()
receipt.printHeader()
println(receipt.calculateTotal(100.0))
receipt.printFooter()
println(order.total())

println("=== New Program ====")
processOrderBad(10.39,4)
processOrder(10.0,3)





// BAD — forced column alignment; painful to maintain when names change length
val name        = "Codecrafter"
val age         = 25
val profession  = "Developer"
println("$name  , $age , $profession ")
val name_1 = "Codecrafter"
val age_1 = 25
val profession_1 = "Developer"

println("$name_1 , $age_1 , $profession_1")


}