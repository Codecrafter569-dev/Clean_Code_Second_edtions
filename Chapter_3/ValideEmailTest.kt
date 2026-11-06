fun isValidEmail(email: String): Boolean{
  val trimmed = email.trim()
  return trimmed.isNotEmpty() && trimmed.contains("@") && trimmed.contains(".")
}


fun main(){
  println(isValidEmail("  codecrafter@gamil.com  "))
  println(isValidEmail("  vikash kumar "))
}