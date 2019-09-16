public class FlowControl {

  public static void main(String[] args) {

    int x = 3;
    int y = 5;
    boolean T = true;
    boolean F = false;

    // #1
    System.out.println("1. " + (x == 3));

    // #2
    if (x >= 3)
      System.out.println("2a. " + T);
    if (y >= 5)
      System.out.println("2b. " + T);
    else
      System.out.println("2c. " + F);

    // #3
    if (x >= 3) {
      System.out.println("3a. " + true);
    }
    if (y > 5) {
      System.out.println("3b. " + true);
    }
    else {
      System.out.println("3c. " + false);
    }

    // #4
    if (x < 3) {
      System.out.println("4a. " + T);
      if (y > 0) {
        System.out.println("4b. " + T);
      }
    }
    else {
      System.out.println("4c. " + F);
    }

    // #5
    if (x <= 3) {
      System.out.println("5a. " + T);
      if (y < 0) {
        System.out.println("5b. " + T);
      }
      else {
        System.out.println("5c. " + F);
      }
    }

    // #6
    if (x == 3 || y / 0 > 0) {
      System.out.println("6a. " + T);
    }
    else {
      System.out.println("6b. " + F);
    }

    // #7
    if (x == 3) {
      System.out.println("7a. " + T);
      if (y / 0 > 0) {
        System.out.println("7b. " + T);
      }
    }
    else {
      System.out.println("7c. " + F);
    }

  }

}
