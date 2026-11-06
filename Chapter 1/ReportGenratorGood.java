public class ReportGenratorGood{
  public String buildReportLine(String name,int age){
    return String.format("Report for %s , age %d",name,age);
  }
  public void printReport(String name , int age){
    System.out.println(buildReportLine(name,age));
  }
  public static void main(String[] args){
    ReportGenratorGood generator = new ReportGenratorGood();
    generator.printReport("Codecrafter",17);
  }
}