fun handleBad(input: String){
  val trimmed = input.trim()
  if(trimmed.isEmpty()){
    println("empty");
    return
  }
  val upper = trimmed.uppercase()
  println("Processing: $upper")
  val reversed = upper.reversed()
  println("Reversed: $reversed")
}

fun normalized(input: String): String = input.trim()
fun isBlank(text: String): Boolean = text.isEmpty()
fun  toUpper(text: String): String = text.uppercase()
fun toReversed(text: String): String = text.reversed()

fun handleInput(input: String){
  val normalized = normalized(input)
  if(isBlank(normalized)){ println("Empty"); return}
  val upper = toUpper(normalized)
  println("Processing: $upper")
  
  
  val reversed = toReversed(upper)
  println("Reversed: $reversed")
}
fun main(){
  handleBad("   vikash      ")
  handleInput("    vikash   ")
}