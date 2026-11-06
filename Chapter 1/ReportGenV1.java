public class ReportGenV1{
  public void gen(String n , int a){
    System.out.println("Report for "+n+", age "+a);
  }
  public static void main(String[] args){
    new ReportGenV1().gen("Codecrafter",37);
  }
}