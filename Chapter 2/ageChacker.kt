fun aiSuggestedIsAdult(age: Int): Boolean = age >= 18
const val LEGAL_ADULT_AGE_IN_REGION = 21
fun isLegalAdultForPurchase(age: Int):Boolean = age >= LEGAL_ADULT_AGE_IN_REGION


fun main(){
  println(aiSuggestedIsAdult(20))
  println(isLegalAdultForPurchase(20))
  println(isLegalAdultForPurchase(22))
}