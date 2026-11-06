//MoreTaxRateTestDrive1.kt
class TaxCalculator {
    private var taxReturn: Map<String, Any>? = null
    var totalIncome: Double = 0.0
        private set

    @Suppress("UNCHECKED_CAST")
    private fun determineBaseTax(): Double {
        val income = taxReturn!!["income"] as Map<String, Int>
        totalIncome = income["salary"]!!.toDouble()
        return when {
            totalIncome <= 30000 -> 0.0
            totalIncome <= 100000 -> Math.round(0.15 * (totalIncome - 30000)).toDouble()
            totalIncome <= 250000 -> Math.round(0.2 * (totalIncome - 100000) + 10500).toDouble()
            totalIncome <= 500000 -> Math.round(0.3 * (totalIncome - 250000) + 40500).toDouble()
            else -> Math.round(0.4 * (totalIncome - 500000) + 115500).toDouble()
        }
    }

    @Suppress("UNCHECKED_CAST")
    fun getTax(taxReturn: Map<String, Any>): Double {
        this.taxReturn = taxReturn
        // (badbob handling omitted here for focus — same as Stage 7)
        return determineBaseTax()
    }
}

fun main() {
    const_test()
}

fun const_test() {
    val TAX_50K = 10500.0 // placeholder just to show constant usage pattern
    val calc = TaxCalculator()

    fun assertTaxFor(income: Int, expected: Double) {
        val tr = mapOf("income" to mapOf("salary" to income))
        val actual = calc.getTax(tr)
        println(if (actual == expected) "PASS ($income -> $actual)" else "FAIL ($income -> expected $expected got $actual)")
    }

    assertTaxFor(15000, 0.0)
    assertTaxFor(30000, 0.0)
    assertTaxFor(30001, 0.0)
    assertTaxFor(50000, 3000.0)
    assertTaxFor(100000, 10500.0)
    assertTaxFor(100001, 10500.0)
    assertTaxFor(200000, 30500.0)
    assertTaxFor(250000, 40500.0)
    assertTaxFor(250001, 40500.0)
    assertTaxFor(500000, 115500.0)
    assertTaxFor(500001, 115500.0)
    assertTaxFor(1000000, 315500.0)
}

