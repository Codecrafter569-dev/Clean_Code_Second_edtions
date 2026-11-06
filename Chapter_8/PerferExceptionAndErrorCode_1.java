//PerferExceptionAndErrorCode_1.java

public class PerferExceptionAndErrorCode_1{
  static final int E_OK = 0;
  static final int E_ERROR = 1;
  
  static int deletePage(String page){
    if(page == null) return E_ERROR;
    System.out.println("Page deleted :"+page);
    return E_OK;
  }
  static int deletedReference(String page){
    System.out.println("Reference deleted : "+page);
    return E_OK;
  }
  
  public static void main(String[] args){
    String page = "Home";
    if(deletePage(page) == E_OK){
      if(deletedReference(page) == E_OK){
        System.out.println("All deleted successfully.");
      }else{
        System.out.println("Reference delete failed");
      }
    }else{
      System.out.println("Page delete failed");
    }
  }
}