import java.util.Scanner;

class Bank {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    BankAccount falken = new BankAccount();
    BankAccount lukas = new BankAccount("Lukas Werner", 0, 2);
    falken.deposit(500);
    System.out.println(falken);
    lukas.deposit(20);
    System.out.println(lukas);

    try {
      falken.transfer(lukas, 501);
    } catch (Exception e) {
      System.out.println(e);
    }
    System.out.println(falken);
    System.out.println(lukas);
    System.out.print("\n");
    System.out.print("Account Holder Name: ");
    String name = in.nextLine();
    System.out.print("Account Holder Balance: ");
    double bal = in.nextInt();
    System.out.print("Account Holder Number: ");
    int accN = in.nextInt();
    BankAccount user = new BankAccount(name, bal, accN);
    System.out.println(user);
  }
}
