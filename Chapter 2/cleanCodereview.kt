//cleanCodereview.kt
fun passesCleanCodeReview(functionName: String,lineCount: Int, doesOneThing: Boolean): Boolean{
  val hasGoodName = functionName.length > 2 && functionName[0].isLowerCase()
  val isReasonablyShort = lineCount <= 20 
  
  return hasGoodName && isReasonablyShort && doesOneThing
  
}
fun main(){
  println(passesCleanCodeReview("printHellousingArray",20,true))
  println(passesCleanCodeReview("printDosomthing",30,true))
}