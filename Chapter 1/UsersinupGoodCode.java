public class UsersinupGoodCode{
  public boolean signup(String email,String password){
    if(!isValideEmail(email)) return false;
    if(!isStrongPassword(password)) return false;
    saveUser(email,password);
    return true;
  }
  private boolean isValideEmail(String email){
    return email != null && email.contains("@");
  }
  private boolean isStrongPassword(String password){
    return password != null && password.length() >= 8;
  }
  
  private void saveUser(String email , String password){
    System.out.println("Save user :"+email);
  }
  public static void main(String[] args){
    UsersinupGoodCode gd = new UsersinupGoodCode();
    System.out.println(gd.signup("codecrafter@192gmail.com","039dmCkwVikasjCode"));
  }
}