var loginAttempts = 0
fun checkPasswordBad(password: String): Boolean{
  loginAttempts++
  return password == "secret123"
}
fun isPasswordValid(password: String): Boolean = password == "secret123"

var attempts = 0
fun recordLoginAttempts(){
  attempts++
}
fun main(){
  println(checkPasswordBad("hello"))
  println(checkPasswordBad("secret123"))
  println("Attempts $loginAttempts")
  
  
  recordLoginAttempts()
  println(isPasswordValid("hello"))
  recordLoginAttempts()
  println(isPasswordValid("secret123"))
  println("Attempts (explicit): $attempts")
}