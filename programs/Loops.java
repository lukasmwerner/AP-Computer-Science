public class Loops {

  public static void main(String[] args) {

    /* fix #1 so it prints: 1 0.5 0.25 0.125 */

    System.out.println("#1 print 1 0.5 0.25 0.125:");
    for (double j = 1; j >= 0.125; j /= 2) {
      System.out.println(j);
    }

    /*
     * fix #2 so it successfully counts the number of heads (0) flipped in a row it
     * should break the loop when a tails (1) is flipped
     */

    System.out.println("How many heads can you flip in a row?");

    int count = 0;

    while (true) {
      int coin = (int) (Math.random() * 2);
      if (coin % 2 == 1) {
        System.out.println("tails");
        break;
      } else {
        System.out.println("heads");
        count += 1;
      }
    }
    System.out.println("You flipped " + count + " heads in a row");

  }

}
