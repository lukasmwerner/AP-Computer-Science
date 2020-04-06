class BankAccount {
  private String name;
  private double balance;
  private int accountNumber;

  private static int year;

  public BankAccount() {
    name = "Prof. Falken";
    accountNumber = 0000000001;
    balance = 0;
  }

  public BankAccount(String n, double bal, int accN) {
    name = n;
    balance = bal;
    accountNumber = accN;
  }

  public void deposit(double amt) {
    balance += amt;
  }

  public void use(double amt) {
    balance -= amt;
  }

  public void deposit(int amt) {
    balance += amt;
  }

  public void use(int amt) {
    balance -= amt;
  }

  public void transfer(BankAccount other, double amt)
    throws InsufficientFundError {
    if (balance - amt >= 0) {
      other.deposit(amt);
      this.use(amt);
    } else {
      throw new InsufficientFundError();
    }
  }

  public String toString() {
    return (
      "Name: " +
      this.name +
      " Account Number: " +
      this.accountNumber +
      " Balance: " +
      this.balance
    );
  }
}

class InsufficientFundError extends Exception {

  public InsufficientFundError() {
    super("Insufficient funds to transfer money!");
  }
}
