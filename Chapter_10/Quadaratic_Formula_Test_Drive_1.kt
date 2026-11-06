//Quadaratic_Formula_Test_Drive_1.kt

object Quadaratic_Formula{
  fun solve(a: Double , b: Double, c: Double): List<Double>{
    return if(a == 0.0){
      if(b==0.0){
        emptyList()
      }else{
        listOf(-c / b)
      }
    }else{
      val d = b * b - 4 * a * c
      if(d > 0){
        val sqrted = Math.sqrt(d)
        val x1 = (-b+sqrted)/(2*a)
        val x2 = (-b - sqrted)/ (2 * a)
        listOf(x1,x2)
      }else if( d == 0.0){
        listOf(-b/(2*a))
      }else{
        emptyList()
      }
    }
  }
}

fun main(){
  println(Quadaratic_Formula.solve(1.0,-3.0,2.0))
}