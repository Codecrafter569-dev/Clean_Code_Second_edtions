//customerRecordeNameGood.kt

class DtrRecord123(val pszFirstName: String , val pszLastName: String)

class CustomerRecord(val firstName: String, val secondName: String)


fun bad(){
  for( i in 0..7) println(i*4)
}

fun sumBad(list: List<Int>): Int{
  var s = 0
  for(e in list) s += e
  return s
}
fun sumOfValue(values: List<Int>): Int{
  var sum = 0
  for(value in values){
    sum += value
  }
  return sum
}
const val WORK_DAYS_PER_WEEK = 7
const val HOUSE_PER_WORK_DAY = 4

fun good(){
  for(day in 0 until WORK_DAYS_PER_WEEK) println(day * HOUSE_PER_WORK_DAY)
}



fun sumSquare(n: Int): Int{
  var total = 0
  for(i in 1..n){
    total += i * i
  }
  return total
  
}

// appropriate: wide-scope value gets a full descriptive name
const val MAXIMUM_RETRY_ATTEMPTS_BEFORE_ALERTING_ADMIN = 5

fun printRangeBad(limit: Int){
  for(currentLoopIterationIndexValue in 0 until limit){
    println(currentLoopIterationIndexValue)
  }
}

fun printRange(limit: Int){
  for(i in 0 until limit){
    println(i)
  }
}


fun main(){

  val record = CustomerRecord("Vikash","Kumar")
  val record_1 = DtrRecord123("Codercrater","Kumar")
  println("${record.firstName} ${record.secondName}")
  println("${record_1.pszFirstName} ${record_1.pszLastName}")
  bad()
  good()
  
  
  println(sumBad(listOf(12,1,2,3,4,5,5)))
  println(sumOfValue(listOf(20,33,1,2,3,4,5,6,7)))
  
  
  println("===== New Programs =====")
  println(sumSquare(20))
  println(MAXIMUM_RETRY_ATTEMPTS_BEFORE_ALERTING_ADMIN)
  println(printRangeBad(10))
  println(printRange(30))
  
}

