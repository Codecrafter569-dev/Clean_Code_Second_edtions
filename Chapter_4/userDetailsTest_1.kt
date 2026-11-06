fun getUser(id: Int) = "User$id"
fun fetchOrder(id: Int) = "Order$id"
fun retrieveInvoice(id: Int) = "Invoice$id"

fun fetchOrder_1(id: Int) = "User$id"
fun fetchUser(id: Int) = "Order$id"
fun fetchInvoice(id: Int) = "Invoice$id"
fun main(){
  println(fetchInvoice(20))
  println(fetchUser(30))
  println(fetchOrder_1(40))
  
  println(fetchOrder(20))
  println(getUser(30))
  println(retrieveInvoice(50))
  
  
}