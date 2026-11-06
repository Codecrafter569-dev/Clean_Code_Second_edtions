enum ErrorCodes{
  OK,
  INVALID,
  NO_SUCH,
  LOCKED,
  OUT_OF_RESOURCES;
}


public class ErrorDemo_2{
  
  static ErrorCodes deletePage(String page){
    if(page == null) return ErrorCodes.NO_SUCH;
    return ErrorCodes.OK;
  }
  public static void main(String args[]){
    ErrorCodes result = deletePage("Home");
    System.out.println("Result : "+result);
  }
}