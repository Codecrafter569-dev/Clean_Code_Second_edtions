fun getThem(list: List<IntArray>): List<IntArray> = list.filter{ it[0] == 4}

fun findFlaggedCells(cells: List<IntArray>): List<IntArray>{
  val flaggedStatus = 4
  val statusIndex = 0
  return cells.filter{ it[statusIndex] == flaggedStatus }
}
fun main(){
  val grid = listOf(intArrayOf(4,1),intArrayOf(2,1))
  println(findFlaggedCells(grid).size)
}