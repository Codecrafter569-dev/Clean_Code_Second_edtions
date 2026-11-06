import java.util.Arrays;
public class MakeRomanNumber_1V_1{
  public static int convert(String roman){
    
    
    if(roman.contains("VIV")||
      roman.contains("IVI") ||
      roman.contains("IXI") ||
      roman.contains("LXL") ||
      roman.contains("XLX") ||
      roman.contains("XCX") ||
      roman.contains("DCD") ||
      roman.contains("CDC") ||
      roman.contains("MCM") ){
        throw new InvalidRomanNumberException(roman);
      }
      roman = roman.replace("IV","4");
      roman = roman.replace("IX","9");
      roman = roman.replace("XL","F");
      roman = roman.replace("XC","N");
      roman = roman.replace("CD","G");
      roman = roman.replace("CM","O");
      if(roman.contains("III") || 
        roman.contains("VV")||
        roman.contains("XXXX")||
        roman.contains("LL")||
        roman.contains("CCCC")||
        roman.contains("DD")||
        roman.contains("MMMM")){
        throw new InvalidRomanNumberException(roman);
      }
    
    int[] numbers = new int[roman.length()];
    int i = 0;
    for(char digits : roman.toCharArray()){
      switch (digits) {
        case 'I'-> numbers[i] = 1;
        case 'V'-> numbers[i] = 5;
        case 'X'-> numbers[i] = 10;
        case 'L'-> numbers[i] = 50;
        case 'C'-> numbers[i] = 100;
        case 'D'-> numbers[i] = 500;
        case 'M'-> numbers[i] = 1000;
        case '4'-> numbers[i] = 4;
        case '9'-> numbers[i] = 9;
        case 'F'-> numbers[i] = 40;
        case 'N'-> numbers[i] = 90;
        case 'G'-> numbers[i] = 400;
        case 'O'-> numbers[i] = 900;
        
        default  -> throw new InvalidRomanNumberException(roman);
      }
      i++;
    }
    int lastDigit = 1000;
    for(int number : numbers){
      if(number > lastDigit){
        throw new InvalidRomanNumberException(roman);
      }
      lastDigit = number;
    }
    return Arrays.stream(numbers).sum();
  }
  
  
  
  public static void main(String[] args){
    String[] testCases = {
            "I",
            "IV",
            "IX",
            "X",
            "XL",
            "XC",
            "C",
            "CD",
            "CM",
            "M",
            "XIV",
            "XXIV",
            "XLII",
            "XCIX",
            "CDXLIV",
            "CMXCIX",
            "IIII",
            "VV",
            "IL",
            "IC",
            "VX",
            "IIV"
        };

        for (String roman : testCases) {
            try {
                int result = convert(roman);
                System.out.println(roman + " = " + result);
            } catch (InvalidRomanNumberException e) {
                System.out.println(roman + " = Invalid Roman Numeral");
            }
        }
  }
  public static class InvalidRomanNumberException extends RuntimeException{
    public InvalidRomanNumberException(String roman){
      
    }
  }
}