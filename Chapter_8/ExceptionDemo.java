public class ExceptionDemo{
  static void deletePage(String page) throws Exception{
    if(page == null) throw new Exception("Page not found!");
    System.out.println("Page deleted :"+page);
  }
  static void deleteReference(String page) throws Exception{
    System.out.println("Reference deleted :"+page);
  }
  
  public static void main(String[] args){
    try{
      deletePageAndAllReferences("Home");
    }catch(Exception e){
      System.out.println("Error : "+e.getMessage());
    }
  }
  
  private static void deletePageAndAllReferences(String page) throws Exception {
    deletePage(page);
    deleteReference(page);
  }
}