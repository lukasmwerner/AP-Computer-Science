import java.util.Scanner;

class RectStripe {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("How many rows?: ");
        int rows = in.nextInt();
        System.out.print("How many colums?: ");
        int cols = in.nextInt();
        String symA = "A";
        System.out.println("What should symbol B be?: ");
        String symB = "B";

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (r%2 == 0) {
                    System.out.print(symB);
                } else {
                    System.out.print(symA);
                }
            }
            System.out.println();
        }


        System.out.println();

        for (int r = 0; r < rows; r++) {
            if (r%2 == 0) {
                for (int c = 0; c < cols; c++) {
                    if (c%2 == 0) {
                        System.out.print(symB);
                    } else {
                        System.out.print(symA);
                    }
                }
            } else {
                for (int c = 1; c <= cols; c++) {
                    if (c%2 == 0) {
                        System.out.print(symB);
                    } else {
                        System.out.print(symA);
                    }
                }
            }
            System.out.println();
        }

    }
}