val accountList: Set<String> = setOf("A1","A2")
val accountIds: Set<String> = setOf("A1","A2")

val userInfo = "Codecrafter"
val userInfor = "Backup"

val primaryUser = "Codecrafter"
val backupUser = "Backup"

fun copyChars_1(a1: CharArray, a2: CharArray){
  for(i in a1.indices) a2[i] = a1[i]
}

fun copyChars_2(source: CharArray , destination: CharArray){
  for(i in source.indices) destination[i] = source[i]
}


class CustomerData(val name: String)
class CustomerInfo(val name: String)

class Customer(val name: String)

fun main(){
  println(accountList)
  println(accountIds)
  
  println(userInfo)
  println(userInfor)
  
  println(primaryUser)
  println(backupUser)
  
  val src = charArrayOf('a','b','c')
  val dest = CharArray(3)
  copyChars_2(src,dest)
  println(dest.joinToString(""))
  
  
  val src1 = charArrayOf('v','k','a')
  val dest_1 = CharArray(3)
  copyChars_1(src1,dest_1)
  println(dest_1.joinToString(""))
  
  val c1 = CustomerData("How to make a money..")
  val c2 = CustomerInfo("Codecrafter")
  val c3 = Customer("Vikash")
  
  
  val genymbeh = "Hill"
  val generationTimestamp = "12 : 34"
  println(c1.name)
  println(c2.name)
  println(c3.name)
  
  println(genymbeh)
  println(generationTimestamp)
  
  
}