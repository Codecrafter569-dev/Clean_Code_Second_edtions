//ShoppingCartItem_2.kt

class ShoppingCartItem(val productName: String, val unitPrice: Double, val quantity: Int){
  fun lineTotal(): Double = unitPrice * quantity
}
fun calcualteCartTotal(items: List<ShoppingCartItem>): Double =
items.sumOf{it.lineTotal()}

fun isWithBusinessHours(hours: Int): Boolean{
  val openHours = 9
  val closingHours = 18
  return hours in openHours until closingHours
}
fun main(){
  val cart = listOf(
  ShoppingCartItem("NoteBook",5.0,3),
  ShoppingCartItem("Pen",2.3,30)
  )
  println(calcualteCartTotal(cart))
  
  
  println(isWithBusinessHours(40))
  println(isWithBusinessHours(20))
}