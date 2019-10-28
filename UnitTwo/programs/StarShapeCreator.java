import java.util.Scanner;

public class StarShapeCreator {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        System.out.print("What width of a square please? ");
        int input = Integer.parseInt(kb.nextLine());
        for (int x = 0; x < input; x++) {
            for (int y = 0; y < input; y++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");

        System.out.print("What should the width of the rectangle be? ");
        int width = Integer.parseInt(kb.nextLine());
        System.out.print("What should the height of the rectangle be? ");
        int height = Integer.parseInt(kb.nextLine());
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");


        System.out.print("What should the height of the right triangle be? ");
        height = Integer.parseInt(kb.nextLine());
        for (int x = 1; x <= height; x++) {
            for (int y = 1; y<= x; y++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
        
        System.out.print("What should the width of the icosceles triangle be?");
        width = Integer.parseInt(kb.nextLine());
        for (int x = 0; x <= (width/2); x++) {
            for (int y = 0; y <= x; y++) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        for (int x = width-1; x >= 0; x--) {
            for (int y = x; y >= 0; y--) {
                System.out.print("* ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}