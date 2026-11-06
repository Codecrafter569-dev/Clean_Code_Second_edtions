class Page{
  private String name;
  Page(String name){
    this.name = name;
  }
  void delete(){
    System.out.println("Delete page : "+name);
  }
  String getName(){ return name;}
}
class Registry{
  void deleteRerence(String pageName){
    System.out.println("Deleted reference :"+pageName);
  }
}

class ConfigKeys{
  void deleteKeys(String keys){
    System.out.println("delete config key :"+keys);
  }
}
public class PageDeleteProgram_1{
  Registry registry = new Registry();
  ConfigKeys configkeys = new ConfigKeys();
  
  
  public void delete(Page page){
    try{
     deletePageAndAllReferences(page); 
    }catch(Exception e){
      logError(e);
    }
    
  }
  private void deletePageAndAllReferences(Page page) throws Exception{
    page.delete();
    registry.deleteRerence(page.getName());
    configkeys.deleteKeys(page.getName()+"_Key");
  }
  
  private void logError(Exception e){
    System.out.println("Log Error :"+e.getMessage());
  }
  public static void main(String[] args){
    PageDeleteProgram_1 deleter = new PageDeleteProgram_1();
    Page page = new Page("HomePage");
    deleter.delete(page);
  }
}