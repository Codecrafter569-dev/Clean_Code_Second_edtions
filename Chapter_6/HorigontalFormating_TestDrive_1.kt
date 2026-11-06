fun calculateArea(width: Int, height: Int): Int = width * height

fun describleShape(width: Int, height: Int): String{
  val area = calculateArea(width,height)
  return "Shape with area : $area"
}

// BAD — indentation broken for a "shortcut," hides the actual structure
fun checkAge(age: Int) { if (age >= 18) println("Adult") else println("Minor") }

fun checkAgeGroup(age: Int){
  if(age >= 18){
    println("Adult")
  }else{
    println("Minor")
  }
}

fun classifyNumber(n: Int){
  if(n > 0){
    if(n % 2 == 0){
      println("positive even")
    }else{
      println("positive Odd")
    }
  }else{
    println("Non- positive")
  }
}

object TeamStyle{
  const val MAX_LINE_LENGTH = 100
  const val INDENT_SPACES = 24
}

class TeamFormattedExample(val id: Int,val label: String){
  fun describle(): String = "Item $id: $label "
}
fun main(){

  val item = TeamFormattedExample(3,"Sample")
  println(item.describle())
  checkAge(30)
  checkAgeGroup(42)
  println(describleShape(30,40))
  println()
  classifyNumber(20)
  classifyNumber(23)
}