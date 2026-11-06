fun createAccountBad(name: String, isAdmin: Boolean , isActive: Boolean){
  println("Same admin=$isAdmin , active=$isActive")
}

fun createAccount(name: String, isAdmin: Boolean = false, isActive: Boolean = true){
  println("$name admin=$isAdmin active=$isActive")
}

fun resizeImage(width: Int, height: Int, maintainsAspectRetio: Boolean= true){
  println("ResizeImage to ${width}x $height,aspect ratio kept: $maintainsAspectRetio")
}

fun whackTheServer(){
  println("Restarting....")
}
fun eatMyShort(list: MutableList<Int>){
  list.clear()
}
fun restartServer(){
  println("Restarting.....")
}

fun clearList(list: MutableList<Int>){
  list.clear()
}

fun holyHandGrande() = println("Deleting all temp files...")
fun deleteTemporaryFiles() = println("Deleting all temp files")
fun main(){
createAccountBad("Codecrafter",true,false)
createAccount(name="Vikash kumar",isAdmin=true,isActive=false)
resizeImage(height=300,width=4000,maintainsAspectRetio=false)

whackTheServer()
restartServer()

clearList(mutableListOf(10,20,30))
eatMyShort(mutableListOf(30,40,50))

deleteTemporaryFiles()
holyHandGrande()
go()
}

class UserRepo{fun fetchUser(id: Int) = "User$id"}
class OrderRepo{fun getOrder(id: Int) = "Order$id"}
class InvoiceRepo{fun retrieveInvoice(id: Int) = "Invoice$id"}

class UserRepository{fun fetchUser(id: Int) = "User$id"}
class OrderRepository{fun fetchOrder(id: Int) = "Order$id"}
class InvoiceRepository{fun fetchInvoice(id: Int) = "Invoice$id"}

fun validateEmail(email: String) = email.contains("@")
fun validatePassword(password: String) = password.length >= 8
fun validateUsername(username: String) = username.isNotBlank()
fun go(){
  println(UserRepo().fetchUser(20))
  println(OrderRepo().getOrder(20))
  println(InvoiceRepo().retrieveInvoice(45))
  
  println(validateEmail("Vikahs@9292.com"))
  println(validatePassword("kwCodemw0203md30"))
  println(validateUsername("Codecrafter"))
  
  println(UserRepository().fetchUser(30))
  println(OrderRepository().fetchOrder(430))
  println(InvoiceRepository().fetchInvoice(22))
}