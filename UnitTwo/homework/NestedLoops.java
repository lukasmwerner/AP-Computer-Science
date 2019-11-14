
public class NestedLoops {

    public static void main(String[] args) {

        /*
         * Create a small example program that creates a small nested for loop that executes at least 10 times total between the two loops
         */

        for (int x = 0; x <= 1; x++) {
            for (int y = 0; y <= 4; y++) {
                System.out.print(" * ");
            }

            System.out.print("\n");
        }

        System.out.print("\n");

        /*
         * Given the code make the output: 
         *   *** 
         *   ** 
         *   *
         */

        for (int y = 3; y >= 0; y--) { // we start at the target value and then decrement down to 0 we also need to make sure that we start at 3
            for (int x = 0; x < y; x++) { // we just need to make sure that our boolean operation is correct so that we exclude the value of y itself
                System.out.print(" * "); // added spaces for better looking output
            }
            System.out.println();
        }

    }

}