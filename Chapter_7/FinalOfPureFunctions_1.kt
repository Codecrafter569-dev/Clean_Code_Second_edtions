//FinalOfPureFunctions_1.kt


// Still pure — internal state is hidden inside a private helper class,
// but the outward-facing function remains a clean mapping of input -> output.
private class SigmaCalculator(private val numbers: DoubleArray) {
    private var varianceSum = 0.0

    fun invoke(): Double {
        val mean = numbers.average()
        for (n in numbers) {
            val deviation = n - mean
            varianceSum += deviation * deviation
        }
        val variance = varianceSum / numbers.size
        return Math.sqrt(variance)
    }
}

fun sigma(numbers: DoubleArray): Double = SigmaCalculator(numbers).invoke()

fun main() {
    val data = doubleArrayOf(2.0, 4.0, 4.0, 4.0, 5.0, 5.0, 7.0, 9.0)
    println(sigma(data))
    // the impurity (mutable instance variable) is completely hidden —
    // to any caller, sigma() behaves as a pure function
}
