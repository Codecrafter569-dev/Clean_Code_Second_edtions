//QuadraticTestDrive_3.kt
object QuadraticFormula{
  fun solve(a: Double , b: Double , c: Double): List<Double>{
    if(a == 0.0) return linearSolution(b,c)
    return quadraticSolutions(a,b,c);
  }
  private fun linearSolution(b: Double , c: Double): List<Double>{
    if(b == 0.0) return emptyList()
    return listOf(-c/b)
  }
  private fun quadraticSolutions(a: Double , b: Double, c: Double): List<Double>{
    val discriminant = b*b - 4*a*c
    return when{
      discriminant < 0  -> complexSolution()
      discriminant == 0.0 -> singleQuadraticSolutions(a,b)
      else -> twoQuadraticSolutions(a,b,discriminant)
    }
  }
  private fun complexSolution(): List<Double> = emptyList()
  private fun singleQuadraticSolutions(a: Double , b: Double): List<Double> =
  listOf(-b/(2*a))
  private fun twoQuadraticSolutions(a: Double, b: Double, discriminant: Double): List<Double>{
    val sqrted = Math.sqrt(discriminant)
    val x1 = (-b + sqrted) / (2 * a)
    val x2 = (-b - sqrted)/(2*a)
    return listOf(x1 , x2)
  }
}

fun main(){
  println(QuadraticFormula.solve(1.0,-3.0,2.0))
}