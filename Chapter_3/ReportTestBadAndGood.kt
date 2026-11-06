class ReportBad{
  var title = ""
  var rows = mutableListOf<String>()
  fun addRows(r : String){
    rows.add(r)
  }
  fun render(): String{
    var out = " === $title ===\n"
    for (r in rows) out += "$r\n"
    return out
  }
  fun rowCount() = rows.size
}


class Report(private val title:String){
  private val rows = mutableListOf<String>()
  fun addRow(row: String){
    rows.add(row);
  }
  fun rowCount(): Int = rows.size
  
  fun render(): String{
    val header = "=== $title ===\n"
    val body = rows.joinToString("\n")
    return header + body
  }
}
fun main(){
  val bad = ReportBad()
  bad.title = "Sales"
  bad.addRows("Item A: 10")
  bad.addRows("Item B: 300")
  bad.addRows("Item C : 500")
  println(bad.render())
  
  val report = Report("Sales")
  report.addRow("Item A : 230")
  report.addRow("Item B : 332")
  report.addRow("Item C : 4430")
  println(report.render())
  println("Rows : ${report.rowCount()}")
}