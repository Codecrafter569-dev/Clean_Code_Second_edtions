fun main(){
    println("Use the val keyword when the value doesn't change.")
    println("Use the var keyword when the value can change.")
    println("When you define a function, you define the parameters that can be passed to it. ")
    println("When you call a function, you pass arguments for the parameters.")


    println("New chat message from my friends .")

go()

}
fun go(){
    println("This is a new functions")

    var discountPercentage: Int = 0
    var offer: String = ""
    val item = "Google Chromecast"
    discountPercentage = 20
    offer = "Sale - Up to $discountPercentage% discount on $item! Hurry up!"
    println(offer)
    go1()
    printbonus()

}

fun go1() {
    val numberOfAdults = "20"
    val numberOfKids = "30"
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
    go2()
    hello()
}


fun go2() {
    val numberOfAdults = 20
    val numberOfKids = 30
    val total = numberOfAdults + numberOfKids
    println("The total party size is: $total")
}



fun printbonus() {
    val baseSalary = 5000
    val bonusAmount = 1000
    val totalSalary = "$baseSalary + $bonusAmount"
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
}


fun hello() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 300
    val result = add(firstNumber , secondNumber)
    val result1 = add(firstNumber , thirdNumber)
    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = $result1")
}


fun add( f:Int  ,s: Int): Int{
    return f + s

}
























