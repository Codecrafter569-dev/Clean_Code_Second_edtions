data class CartItem(val name: String,val price: Double,val quantity: Int)

fun subtotal(items: List<CartItem>): Double =
items.sumOf{it.price * it.quantity}

fun applyTax(amount: Double, taxRate: Double = 0.08): Double =
amount + (amount*taxRate)

fun applyShipping(amount: Double, freeShippingThreshold: Double = 100.0): Double =
if(amount >= freeShippingThreshold) amount else amount + 5.0

fun formatCurrency(amount: Double): String =
"$"+String.format("%.2f",amount)

fun buildReceipt(items: List<CartItem>): String{
  val sub = subtotal(items)
  val withTax = applyTax(sub)
  val total = applyShipping(withTax)
  
  
  val line = items.joinToString("\n"){
    "${it.name} x ${it.quantity}: ${formatCurrency(it.price * it.quantity)}"
  }
  return "$line\n---\nTotal: ${formatCurrency(total)}"
}
fun main(){
  val cart = listOf(
  CartItem("NoteBook",3.9,39),
  CartItem("Pen",2.3,40)
  )
  
  println(buildReceipt(cart))
}