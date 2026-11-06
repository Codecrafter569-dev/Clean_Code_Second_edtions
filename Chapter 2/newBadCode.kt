fun isEligiblev1(age: Int, hasLincence: Boolean, points: Int): Boolean{
  if(age >= 18 && hasLincence == true && points  < 12){
    return true
  }else{
    return false
  }
}

fun isEligiblev2(age: Int, hasLincence: Boolean, points: Int): Boolean{
  return age >= 18 && hasLincence == true && points < 12
}

const val MINIMUM_DRIVING_AGE  = 18
const val MAX_ALLOWED_POINTS = 12

fun isEligiblevGoodaCode(age: Int, hasLincence: Boolean , points: Int): Boolean{
  return age >= MINIMUM_DRIVING_AGE && hasLincence == true && points < MAX_ALLOWED_POINTS
}
fun main(){
  println(isEligiblev1(20,true,5));
  println(isEligiblev2(20,true,10));
  println(isEligiblevGoodaCode(20,true,8));
}