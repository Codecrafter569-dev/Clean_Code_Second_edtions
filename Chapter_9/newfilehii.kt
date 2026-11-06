class TaxReturn(private val data: Map<String, Any>) {

    @Suppress("UNCHECKED_CAST")
    fun getTotalIncome(): Double {
        val income = data["income"] as Map<String, Int>
        return income["salary"]!!.toDouble()
    }

    @Suppress("UNCHECKED_CAST")
    fun getTotalClass1Badbobs(): Int {
        val badbobs = data["badbobs"] as Map<String, List<Int>>
        return badbobs["class1"]!!.sum()
    }

    @Suppress("UNCHECKED_CAST")
    fun getTotalClass2Badbobs(): Int {
        val badbobs = data["badbobs"] as Map<String, List<Int>>
        return badbobs["class2"]!!.sum()
    }
}

fun main() {
    val data = mapOf(
        "income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100), "class2" to listOf(10000, 40000))
    )
    val taxReturn = TaxReturn(data)
    println("Income: ${taxReturn.getTotalIncome()}")
    println("Class1 badbobs: ${taxReturn.getTotalClass1Badbobs()}")
    println("Class2 badbobs: ${taxReturn.getTotalClass2Badbobs()}")
}
