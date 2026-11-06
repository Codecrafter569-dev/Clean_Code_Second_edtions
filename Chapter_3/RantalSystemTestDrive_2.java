import java.util.Map;
public class RantalSystemTestDrive_2{
  
  private String roman;
  private static final String REGEX =
    "^M{0,3}(CM|CD|D?C{0,3})(XC|XL|L?X{0,3})(IX|IV|V?I{0,3})$";
  private static final Map<Character, Integer> VALUES = Map.of(
    'I', 1,
    'V', 5,
    'X', 10,
    'L', 50,
    'C', 100,
    'D', 500,
    'M', 1000
);

public RantalSystemTestDrive_2(String roman){
  if(!roman.matches(REGEX)){
    throw new InvalidRomanNumeralException(roman);
  }
  this.roman = roman;
}

public int toInt(){
  int sum = 0;
  for(int i=0; i < roman.length();i++){
    int currentValue = VALUES.get(roman.charAt(i));
    if(i < roman.length() - 1){
      int nextValue = VALUES.get(roman.charAt(i+1));
      if(currentValue < nextValue){
        sum -= currentValue;
      }else{
        sum += currentValue;
      }
   //   sum -= currentValue;
    }else{
 //     sum += currentValue;
   sum += currentValue;
    }
  }
  
  return sum;
}

public static int convert(String roman){
  return new RantalSystemTestDrive_2(roman).toInt();
}
public static class InvalidRomanNumeralException extends RuntimeException{
  public InvalidRomanNumeralException(String roman){
    super("Invalid Roman Numeral Exception :"+roman);
  }
}
  public static void main(String[] args) {
    
    
    String[] testCase = {
        "III", "IV", "IX", "LVIII", "MCMXCIV", "MMXXV"
    };
    
    for(String roman : testCase){
      int value = RantalSystemTestDrive_2.convert(roman);
      System.out.println(roman+" = "+value);
    }
    
    try{
      RantalSystemTestDrive_2.convert("IIII");
    }catch(InvalidRomanNumeralException e){
      System.out.println("Caught excepted error :"+e.getMessage());
    }
    
    
       
    try{
      RantalSystemTestDrive_2.convert("ABC");
    }catch(InvalidRomanNumeralException e){
      System.out.println("Caught excepted error :"+e.getMessage());
    }
    
    
    
  }
}