class TaxBracketter {
    // (maximum, rate) — null maximum = top/catch-all bracket
    private val taxBrackets: List<Pair<Int?, Double>> = listOf(
        30000 to 0.0,
        100000 to 0.15,
        250000 to 0.20,
        500000 to 0.30,
        null to 0.40
    )

    fun determineBaseTax(taxReturn: TaxReturn): Double {
        val totalIncome = taxReturn.getTotalIncome()
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
}

class BadBobAdjuster {
    private val class2Table: List<Pair<Int?, Double>> = listOf(
        1001 to 0.0,
        10001 to 0.05,
        50001 to 0.1,
        null to 0.15
    )

    fun getAdjustment(taxReturn: TaxReturn): Double {
        val totalIncome = taxReturn.getTotalIncome()
        val class1Adjustment = class1Adjustment(taxReturn)
        val class2Adjustment = getClass2BadbobAdjustment(taxReturn, totalIncome)
        return class1Adjustment + class2Adjustment
    }

    private fun class1Adjustment(taxReturn: TaxReturn): Double {
        return taxReturn.getTotalClass1Badbobs() / 2.0
    }

    private fun getClass2BadbobAdjustment(taxReturn: TaxReturn, totalIncome: Double): Double {
        val class2 = taxReturn.getTotalClass2Badbobs()
        val rate = getClass2Rate(class2)
        return rate * totalIncome
    }

    private fun getClass2Rate(class2: Int): Double {
        for ((limit, rate) in class2Table) {
            if (limit == null || class2 < limit) return rate
        }
        return 0.0
    }
}

class TaxCalculator {
    fun getTax(taxReturn: TaxReturn): Double {
        val totalIncome = taxReturn.getTotalIncome()
        val baseTax = TaxBracketter().determineBaseTax(taxReturn)
        val badbobAdjustment = BadBobAdjuster().getAdjustment(taxReturn)
        var totalTax = baseTax + badbobAdjustment
        val afterTaxIncome = totalIncome - totalTax
        if (afterTaxIncome < 20000) {
            totalTax = maxOf(0.0, totalIncome - 20000)
        }
        return totalTax
    }
}

fun main() {
    val calc = TaxCalculator()
    val data = mapOf(
        "income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100), "class2" to listOf(10000, 40000))
    )
    val taxReturn = TaxReturn(data)
    println("Total Tax: \${calc.getTax(taxReturn)}")
}
