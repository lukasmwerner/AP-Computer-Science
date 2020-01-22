import java.util.Scanner;

public class RectangleGen {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 

        System.out.print("Please enter the width: ");
        int width = scan.nextInt();
        System.out.print("Please enter the height: ");
        int height = scan.nextInt();
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (y % 2 == 0) {
                    System.out.print("B");
                } else {
                    System.out.print("A");
                }
            }
            System.out.print("\n");
        }
    }
}