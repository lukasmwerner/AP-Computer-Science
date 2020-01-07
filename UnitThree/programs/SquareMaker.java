public class SquareMaker {

  public static void main(String[] args) {
    Square sq1 = new Square();
    Square sq2 = new Square(new Point(2,2), new Point(4,4));

    System.out.println(sq1);
    System.out.println(sq2);
    System.out.println(sq2.area());   // q13

    System.out.println(sq1.findDistance(sq2));   // q14

    sq1.scale(3);   // q15
    System.out.println(sq1);

  }


}
