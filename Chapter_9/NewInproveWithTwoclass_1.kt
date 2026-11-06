// ---- Interfaces (the "abstractions" that TaxCalculator depends on) ----
interface BaseTaxStrategy {
    fun determineBaseTax(taxReturn: TaxReturn): Double
}

interface BadbobAdjustmentStrategy {
    fun getAdjustment(taxReturn: TaxReturn): Double
}

// ---- TaxReturn: hides the raw data shape ----
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

// ---- Concrete strategy: base tax brackets ----
class TaxBracketter : BaseTaxStrategy {
    private val taxBrackets: List<Pair<Int?, Double>> = listOf(
        30000 to 0.0,
        100000 to 0.15,
        250000 to 0.20,
        500000 to 0.30,
        null to 0.40
    )

    override fun determineBaseTax(taxReturn: TaxReturn): Double {
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

// ---- Concrete strategy: badbob social demerit adjustment ----
class BadBobAdjuster : BadbobAdjustmentStrategy {
    private val class2Table: List<Pair<Int?, Double>> = listOf(
        1001 to 0.0,
        10001 to 0.05,
        50001 to 0.1,
        null to 0.15
    )

    override fun getAdjustment(taxReturn: TaxReturn): Double {
        val totalIncome = taxReturn.getTotalIncome()
        val class1Adjustment = taxReturn.getTotalClass1Badbobs() / 2.0
        val class2Adjustment = getClass2Rate(taxReturn.getTotalClass2Badbobs()) * totalIncome
        return class1Adjustment + class2Adjustment
    }

    private fun getClass2Rate(class2: Int): Double {
        for ((limit, rate) in class2Table) {
            if (limit == null || class2 < limit) return rate
        }
        return 0.0
    }
}

// ---- High-level policy: TaxCalculator depends only on interfaces ----
class TaxCalculator(
    private val baseTaxStrategy: BaseTaxStrategy,
    private val badbobStrategy: BadbobAdjustmentStrategy
) {
    fun getTax(taxReturn: TaxReturn): Double {
        val totalIncome = taxReturn.getTotalIncome()
        val baseTax = baseTaxStrategy.determineBaseTax(taxReturn)
        val badbobAdjustment = badbobStrategy.getAdjustment(taxReturn)
        var totalTax = baseTax + badbobAdjustment
        val afterTaxIncome = totalIncome - totalTax
        if (afterTaxIncome < 20000) {
            totalTax = maxOf(0.0, totalIncome - 20000)
        }
        return totalTax
    }
}

// ---- "main" component: wires everything together (lowest level, outermost) ----
fun main() {
    // main creates the concrete strategies...
    val bracketter: BaseTaxStrategy = TaxBracketter()
    val badbobAdjuster: BadbobAdjustmentStrategy = BadBobAdjuster()

    // ...and hands them to TaxCalculator (Dependency Injection)
    val calc = TaxCalculator(bracketter, badbobAdjuster)

    val data = mapOf(
        "income" to mapOf("salary" to 50000),
        "badbobs" to mapOf("class1" to listOf(100), "class2" to listOf(10000, 40000))
    )
    val taxReturn = TaxReturn(data)

    println("Total Tax: ${calc.getTax(taxReturn)}")   // expect 8050.0
}
