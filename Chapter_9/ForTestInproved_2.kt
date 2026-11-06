class TaxTestHelper(private val calc: TaxCalculator) {

    fun makeReturn(salary: Int, class1: List<Int> = emptyList(), class2: List<Int> = emptyList()): Map<String, Any> {
        return mapOf(
            "income" to mapOf("salary" to salary),
            "badbobs" to mapOf("class1" to class1, "class2" to class2)
        )
    }

    fun assertTaxFor(income: Int, expectedTax: Double) {
        val tr = makeReturn(income)
        check(calc, tr, expectedTax, "income=\$income")
    }

    fun assertTaxWithBadbobs(income: Int, class1: List<Int>, class2: List<Int>, expectedTax: Double) {
        val tr = makeReturn(income, class1, class2)
        check(calc, tr, expectedTax, "income=\$income, class1=\$class1, class2=\$class2")
    }

    private fun check(calc: TaxCalculator, tr: Map<String, Any>, expected: Double, label: String) {
        val actual = calc.getTax(tr)
        println(if (actual == expected) "PASS: \$label -> \$actual"
                 else "FAIL: \$label -> expected \$expected got \$actual")
    }
}

fun main() {
    val calc = TaxCalculator()
    val helper = TaxTestHelper(calc)
    val tax50K = 3000.0

    helper.assertTaxWithBadbobs(50000, listOf(100), emptyList(), tax50K + 50)
    helper.assertTaxWithBadbobs(50000, emptyList(), listOf(400, 600), tax50K)
    helper.assertTaxWithBadbobs(50000, emptyList(), listOf(10000), tax50K + 2500)
    helper.assertTaxFor(15000, 0.0)
    helper.assertTaxFor(30000, 0.0)
    helper.assertTaxFor(100000, 10500.0)
}
