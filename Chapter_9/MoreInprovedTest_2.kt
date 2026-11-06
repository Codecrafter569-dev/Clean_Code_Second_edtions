class TaxCalculator {
    private var taxReturn: Map<String, Any>? = null
    var totalIncome: Double = 0.0
        private set

    fun getTax(taxReturn: Map<String, Any>): Double {
        this.taxReturn = taxReturn
        val baseTax = determineBaseTax()
        val badbobAdjustment = BadBobAdjuster(this).getAdjustment()
        var totalTax = baseTax + badbobAdjustment
        val afterTaxIncome = totalIncome - totalTax
        if (afterTaxIncome < 20000) {
            totalTax = maxOf(0.0, totalIncome - 20000)
        }
        return totalTax
    }

    @Suppress("UNCHECKED_CAST")
    private fun determineBaseTax(): Double {
        val income = taxReturn!!["income"] as Map<String, Int>
        totalIncome = income["salary"]!!.toDouble()
        var tax = totalIncome * 0.15
        val afterTaxIncome = totalIncome - tax
        if (afterTaxIncome < 30000) {
            tax = maxOf(0.0, totalIncome - 30000)
        }
        return tax
    }

    @Suppress("UNCHECKED_CAST")
    fun badbobsClass1(): List<Int> = (taxReturn!!["badbobs"] as Map<String, List<Int>>)["class1"]!!
    @Suppress("UNCHECKED_CAST")
    fun badbobsClass2(): List<Int> = (taxReturn!!["badbobs"] as Map<String, List<Int>>)["class2"]!!
}

class BadBobAdjuster(private val calc: TaxCalculator) {
    fun getAdjustment(): Double = class1Adjustment() + class2Adjustment()
    private fun class1Adjustment(): Double = calc.badbobsClass1().sum() / 2.0
    private fun class2Adjustment(): Double {
        val class2 = calc.badbobsClass2().sum()
        val table = listOf(1001 to 0.0, 10001 to 0.05, 50001 to 0.1, null to 0.15)
        val rate = table.first { it.first == null || class2 < it.first!! }.second
        return rate * calc.totalIncome
    }
}

fun main() {
    val calc = TaxCalculator()
    val t1 = mapOf("income" to mapOf("salary" to 20000),
        "badbobs" to mapOf("class1" to listOf<Int>(), "class2" to listOf(10000)))
    println("Test 1 (expect 0): ${calc.getTax(t1)}")

    val t2 = mapOf("income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100), "class2" to listOf<Int>()))
    println("Test 2 (expect 7550): ${calc.getTax(t2)}")
}
