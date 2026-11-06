public class RomanTestDrive_4{
  enum state{
    I,V,X,L,C,D,M
  }
  public static int convert(String roman){
    int currentSum = 0;
    for(int i=0; i < roman.length();i++){
      char c = roman.charAt(i);
      
      int currentValue =  getValue(c);
      if(i+1 <  roman.length()){
        int nextValue = getValue(roman.charAt(i+1));
        
        
        if(currentValue < nextValue){
          currentSum -= currentValue;
        }else{
          currentSum += currentValue;
        }
      }else{
        currentSum += currentValue;
      }
    }
    return currentSum;
  }
  
  public static class InvalidRomanNumeralException
            extends RuntimeException {

        public InvalidRomanNumeralException(String roman) {
            super("Invalid Roman numeral: " + roman);
        }
    }
    
    
  
  private static int getValue(char c) {

        return switch (c) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;

            default -> throw new InvalidRomanNumeralException(
                String.valueOf(c)
            );
        };
    }
    
    
    
  public static void main(String[] args){
        System.out.println("Roman Numeral Converter");
        System.out.println("-----------------------");

        System.out.println("III      = " + convert("III"));
        System.out.println("IV       = " + convert("IV"));
        System.out.println("IX       = " + convert("IX"));
        System.out.println("XIV      = " + convert("XIV"));
        System.out.println("XL       = " + convert("XL"));
        System.out.println("XC       = " + convert("XC"));
        System.out.println("CD       = " + convert("CD"));
        System.out.println("CM       = " + convert("CM"));
        System.out.println("MCMXCIV  = " + convert("MCMXCIV"));
        System.out.println("MMXXVI   = " + convert("MMXXVI"));
  }
}