public class UserSignupFastTest{
  public boolean signup(String email,String pass){
    if(email.contains("@") && pass.length() > 4){
      System.out.println("Saved :"+email);
      return true;
    }
    return false;
  }
  public static void main(String[] args){
    UserSignupFastTest s1 = new UserSignupFastTest();
    System.out.println(s1.signup("vikash@kumar939.com","12348"));
  }
}