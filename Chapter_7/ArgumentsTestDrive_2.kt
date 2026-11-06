interface TurnstileEvents{
  fun coin()
  fun pass()
}
interface TurnstileActions{
  fun lock()
  fun unlock()
  fun alarmOn()
  fun alarmOff()
  fun thankYou()
}

abstract class TurnstileFSM : TurnstileEvents , TurnstileActions {
  private enum class State{ LOCKED , UNLOCKED }
  private var state = State.LOCKED
  
  override fun coin(){
    when(state){
      State.LOCKED -> { state = State.UNLOCKED; alarmOff(); unlock() }
      State.UNLOCKED -> thankYou()
    }
  }
  
  override fun pass(){
    when(state){
      State.LOCKED  -> alarmOn()
      State.UNLOCKED  -> {state = State.LOCKED; lock()}
    }
  }
}

class RealTurnstil : TurnstileFSM(){
  override fun lock()  = println("Locking")
  override fun unlock() = println("Unlocking")
  override fun alarmOn() = println("Alarm ON")
  override fun alarmOff() = println("Alarm Off")
  override fun thankYou() = println("Thank You ?")
}


fun main(){
  val tr1 = RealTurnstil()
  tr1.coin()
  tr1.pass()
  tr1.pass()
}