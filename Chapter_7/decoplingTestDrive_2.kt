// BAD — mixes the high-level "determine sign" idea with low-level comparison logic
fun orientationBad(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double): Int {
    val value = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax)
    if (value == 0.0) return 0
    return if (value > 0) 1 else -1
}

// BETTER — extract the low-level sign logic into its own function
fun orientationBetter(ax: Double, ay: Double, bx: Double, by: Double, cx: Double, cy: Double): Int {
    val value = (bx - ax) * (cy - ay) - (by - ay) * (cx - ax)
    return sign(value)
}

private fun sign(n: Double): Int = when {
    n == 0.0 -> 0
    n > 0 -> 1
    else -> -1
}

// BEST — named types instead of raw ints, and each function does one clear job
enum class Chirality { LEFT, RIGHT, NONE }

data class Point(val x: Double, val y: Double)

fun getChirality(a: Point, b: Point, c: Point): Chirality =
    chirality(crossProduct(a, b, c))

private fun crossProduct(a: Point, b: Point, c: Point): Double {
    val abx = b.x - a.x
    val aby = b.y - a.y
    val acx = c.x - a.x
    val acy = c.y - a.y
    return abx * acy - aby * acx
}

private fun chirality(value: Double): Chirality = when {
    value == 0.0 -> Chirality.NONE
    value > 0 -> Chirality.LEFT
    else -> Chirality.RIGHT
}

fun main() {
    println(orientationBad(0.0, 0.0, 1.0, 1.0, 2.0, 0.0))

    val a = Point(0.0, 0.0)
    val b = Point(1.0, 1.0)
    val c = Point(2.0, 0.0)
    println(getChirality(a, b, c))
}
