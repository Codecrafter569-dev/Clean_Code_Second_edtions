fun sendNotificstions(userId: Int){
  println("Notifying user $userId (stub)")
}
fun canAccess(role: String , isOwner: Boolean): Boolean{
  return role == "admin" || isOwner
}
fun isAdmin(role: String): Boolean = role == "admin"
fun canAccessResourcess(role: String , isOwner: Boolean): Boolean = 
isAdmin(role) || isOwner

fun getName() = "Codecrafter"
fun setName(n: String) {
  println("set to $n")
}
class UserProfile(var name: String)

fun square(x: Int) = x * x
fun squareValue(x: Int): Int = x * x
fun main(){
val profile = UserProfile("Codecrafter")
println(profile.name)

println(square(33))
println(squareValue(43))

println(canAccessResourcess("user",true))
println(canAccess("user",true))
  sendNotificstions(33)
}