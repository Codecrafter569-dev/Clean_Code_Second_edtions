fun fmt1(fname: String, lname: String, yrs: Int): String{
  var s = ""
  s = s+fname.trim().replaceFirstChar{it.uppercase()}
  s = s +" "+lname.trim().replaceFirstChar{it.uppercase()}
  s = s+" ("+yrs.toString()+"yrs)"
  return s
}
fun capitalize(words: String):String = words.trim().replaceFirstChar{it.uppercase()}

fun fm2(fname: String ,lname: String, yrs: Int):String =
"${capitalize(fname)} ${capitalize(lname)} (${yrs} yrs.)"


fun capitalizeName(word: String): String = word.trim().replaceFirstChar{it.uppercase()}

fun formatPersonSummery(firstName: String, lastName: String , years : Int): String =
"${capitalizeName(firstName)} ${capitalizeName(lastName)} (${years} years)"
fun main(){
  println(fmt1("vikash","kumar",17))
  println(fm2("suman","kumari",18))
  println(formatPersonSummery("anmol","kumar",19))
}