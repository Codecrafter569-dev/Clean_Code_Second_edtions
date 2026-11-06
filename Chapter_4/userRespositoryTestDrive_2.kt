class UserRepository{
  fun createUser(name: String) = println("Create $name")
  fun readUser(id: Int) = println("Read user $id")
  fun updateUser(id: Int,name: String) =  println("Update $id to $name")
}
fun main(){
  val repo = UserRepository()
  repo.createUser("Codecrafter")
  repo.readUser(20)
  repo.updateUser(30,"Codecrafter_2")
}