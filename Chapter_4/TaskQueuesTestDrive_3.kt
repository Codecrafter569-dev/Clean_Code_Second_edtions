class TaskQueue{
  private val tasks = ArrayDeque<String>()
  fun enqueue(task: String) = tasks.addLast(task)
  fun dequeue(): String? = tasks.removeFirstOrNull()
  
}
interface Shape{ fun area(): Double}
class Circle(val radius: Double): Shape{ override fun area() = Math.PI * radius * radius }
class Square(val side: Double): Shape{ override fun area() = side*side}

class ShapeFactory{
  fun create(type: String,size: Double): Shape = when(type){
    "circle" -> Circle(size)
    else  -> Square(size)
  }
}
class PolicyHolder(val name: String)
class Premium(val monthlyAmount: Double)
class ClaimSettlement(val approvedAmount: Double)

class StockKeepingUnit(val sku: String , val quantityOnHand: Int)
class Reorder(val sku: String , val reorderQuantity: Int)

fun main(){

val  item = StockKeepingUnit("SKU-0001",4)
val record_1 = Reorder("FFCI-4593",90)
println(item.sku)

println(item.quantityOnHand)

println(record_1.reorderQuantity)

println(record_1.sku)
  val holder = PolicyHolder("Codecrafter")
  val premium = Premium(499.0)
  val factory = ShapeFactory()
  println(factory.create("circle",30.3).area())
  val queue = TaskQueue()
  queue.enqueue("Sent Email")
  queue.enqueue("Generate report")
  println(queue.dequeue())
  println(queue.dequeue())
  
  println("${holder.name} pays ${premium.monthlyAmount} monthly.")
}