class SettingsBad{
  private val values = mutableMapOf<String,String>()
  fun set(key: String , value: String): Boolean{
    values[key] = value
    return true
  }
}

class Settings{
  private val values = mutableMapOf<String, String>()
  
  fun hasKey(key: String): Boolean = values.containsKey(key)
  fun setValues(key: String, value : String){
    values[key] = value
    
  }
}


fun main(){
  val bad = SettingsBad()
  if(bad.set("username","codecrafter")) println("Set (ambiguous meaning)")
  val settings = Settings()
  if(!settings.hasKey("username")){
    settings.setValues("username","codecrafter")
  }
  println("Set cleanly ....")
}