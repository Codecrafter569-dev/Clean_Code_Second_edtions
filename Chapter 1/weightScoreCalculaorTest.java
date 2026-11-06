public class weightScoreCalculaorTest{
  public int calculateScore(int baseValue, int multiplier){
    int product = baseValue * multiplier;
    int adjustments = (baseValue - multiplier)/2;
    return product + adjustments;
  }
  public static void main(String[] args){
    weightScoreCalculaorTest calculator = new weightScoreCalculaorTest();
    int score = calculator.calculateScore(20,23);
    System.out.println("Score :"+score);
  }
}