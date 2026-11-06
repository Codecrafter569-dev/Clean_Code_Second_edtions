//Table_Drive_1TaxFinal_1.kt
class TaxCalculator {
    private var taxReturn: Map<String, Any>? = null
    var totalIncome: Double = 0.0
        private set

    // (maximum, rate) — null maximum means "no upper limit" (the top bracket)
    private val taxBrackets: List<Pair<Int?, Double>> = listOf(
        30000 to 0.0,
        100000 to 0.15,
        250000 to 0.20,
        500000 to 0.30,
        null to 0.40
    )

    @Suppress("UNCHECKED_CAST")
    private fun determineBaseTax(): Double {
        val income = taxReturn!!["income"] as Map<String, Int>
        totalIncome = income["salary"]!!.toDouble()

        var previousMaximum = 0.0
        var offset = 0.0

        for ((maximum, rate) in taxBrackets) {
            if (maximum == null || totalIncome <= maximum) {
                return Math.round(rate * (totalIncome - previousMaximum) + offset).toDouble()
            } else {
                offset = (maximum - previousMaximum) * rate + offset
                previousMaximum = maximum.toDouble()
            }
        }
        return 0.0
    }

    fun getTax(taxReturn: Map<String, Any>): Double {
        this.taxReturn = taxReturn
        return determineBaseTax()
    }
}

fun main() {
    val calc = TaxCalculator()

    val incomes = listOf(15000, 30000, 30001, 50000, 100000, 100001, 200000, 250000, 250001, 500000, 500001, 1000000)
    val expected = listOf(0.0, 0.0, 0.0, 3000.0, 10500.0, 10500.0, 30500.0, 40500.0, 40500.0, 115500.0, 115500.0, 315500.0)

    for (i in incomes.indices) {
        val tr = mapOf("income" to mapOf("salary" to incomes[i]))
        val actual = calc.getTax(tr)
        val result = if (actual == expected[i]) "PASS" else "FAIL"
        println("$result: income=${incomes[i]} -> tax=$actual (expected ${expected[i]})")
    }
}




