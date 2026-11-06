//FinalQuadraticTest_1.kt
object QuadraticFormula{
  private var a = 0.0;
  private var b = 0.0;
  private var c = 0.0;
  private var discrarimnat = 0.0
  
  fun solve(a: Double , b: Double , c: Double): List<Double>{
    this.a = a
    this.b = b
    this.c  = c
    if(a == 0.0) return linearSolutions()
    return quadraticSolutions()
  }
  private fun linearSolutions(): List<Double>{
    if(b == 0.0) return emptyList()
    return listOf(-c / b)
  }
  private fun quadraticSolutions(): List<Double>{
    discrarimnat = b*b-4*a*c
    return when{
      discrarimnat < 0 -> complexSolutions()
      discrarimnat == 0.0  -> singleQuadraticSolutions(a,b)
      else -> twoQuadraticSolutions(a,b,discrarimnat)
    }
  }
  private fun complexSolutions(): List<Double> = emptyList()
  private fun singleQuadraticSolutions(a: Double , b: Double): List<Double> =
  listOf(-b/(2*a))
  private fun twoQuadraticSolutions(a: Double , b: Double, discrarimnat: Double): List<Double>{
    val sqrted = Math.sqrt(discrarimnat)
    val x1 = (-b+sqrted) / ( 2 * a)
    val x2 = (-b - sqrted) / (2 * a)
    return listOf(x1,x2)
  }
}

fun main(){
  println(QuadraticFormula.solve(1.0,-3.0,2.0))
}