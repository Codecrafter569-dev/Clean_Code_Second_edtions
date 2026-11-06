fun discountBad(price: Double,isMember: Boolean,itemCount: Int,isSeassonalSale: Boolean): Double{
  var p = price
  if(isMember) p = p * 0.9
  if(itemCount > 5) p = p * 0.95
  if(isSeassonalSale) p = p * 0.97
  
  return p
}
fun applyMemberDiscount(price: Double): Double = price * 0.9
fun applyBulDiscount(price: Double): Double = price * 0.95
fun applySeasonalDiscount(price: Double): Double = price * 0.97


fun calculateFinalPrice(price: Double , isMember : Boolean, itemCount: Int, isSeassonalSale: Boolean): Double{
  var finalPrice = price
  if(isMember) finalPrice = applyMemberDiscount(finalPrice)
  if(itemCount  > 5) finalPrice = applyBulDiscount(finalPrice)
  if(isSeassonalSale) finalPrice = applySeasonalDiscount(finalPrice)
  return finalPrice
}
fun main(){
  println(discountBad(100.0,true,3,false))
  println(calculateFinalPrice(100.0,true,9,true))
  println(calculateFinalPrice(100.0,false,2,false))
  println(calculateFinalPrice(100.0,false,4,true))
}