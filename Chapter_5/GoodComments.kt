//GoodComments.kt


// final illustration: code that needs zero comments because it explains itself
class SubscriptionPlan(val name: String, val monthlyPrice: Double, val trialDays: Int)

fun isTrialActive(daysSinceSignup: Int, plan: SubscriptionPlan): Boolean =
    daysSinceSignup <= plan.trialDays

fun main() {
    val plan = SubscriptionPlan("Pro", 9.99, 14)
    println(isTrialActive(10, plan))
    println(isTrialActive(20, plan))
}


