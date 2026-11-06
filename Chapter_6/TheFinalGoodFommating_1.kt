class ShoppingCart{
  private val items = mutableListOf<Pair<String,Double>>()
  
  fun addItem(name: String , price: Double){
    items.add(name to price)
  }
  
  fun printRecipt(){
    val total = calculateTotal()
    println(" --- Recipt ---")
    for(item in items){
      println("${item.first}: ${item.second}")
    }
    println("Total: $total")
  }
  
  private  fun calculateTotal(): Double =
  items.sumOf{it.second}
}
fun main(){
  val cart = ShoppingCart()
  cart.addItem("Head first java",222.2)
  cart.printRecipt()
  
}