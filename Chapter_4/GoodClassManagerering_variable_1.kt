val street = "MG Road"
val city = "Pune"
val state = "MH"
val amount = 100.0
class Payment(val amount: Double , val currency: String)
class Address(val street: String, val city: String,val state: String)

class GSDAccountAddress(val gsdStreet: String , val gsdCity: String)

class AccountAddress(val street: String , val city: String)
class Customer{
  val customerName = "Codecrafter"
  val customerEmail = "a@vikash.com"
}
class CustomerRecord{
  val name = "Codecrafter"
  val eamil = "vilash@kumar.com"
}
fun main(){
val customer = Customer()
val  customer_1 = CustomerRecord()
println(customer)

println(customer_1)
val bad = GSDAccountAddress("MG Road","Pune")
println(bad.gsdStreet)
println(bad.gsdCity)

val code_2 = AccountAddress("MG Road","Pune")
println(code_2.city)
println(code_2.street)


  println("$street , $city , $state")
  val add = Address("MG Road","Pune","HM")
  println("${add.street}, ${add.city} , ${add.state}")
  
  println(amount)
  val payment_1 = Payment(204.3,"INR")
  println("${payment_1.amount} ${payment_1.currency}")
  
}