class Account{
  private  double balance ;
  public void deposite(double amount){
    if(amount <= 0){
      System.out.println("Cannot diposite "+amount);
      return;
    }
    balance += amount;
    System.out.println("Deposite is successful "+amount);
  }
  public void withdraw(double amount){
    if(amount <= 0 || balance < amount){
      System.out.println("Cannot withdraw "+amount);
      return;
    }
    balance -= amount;
  }
  public void checkBalance(){
    System.out.println("This is your current balance :"+balance);
  }
}
public class Code_1 {
  public static void main(String[] args) {
    Account ac = new Account();
    ac.deposite(300);
    ac.withdraw(30);
    ac.withdraw(500);
    ac.checkBalance();
  }
}