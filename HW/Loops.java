public class Loops {
    public static void main(String[] args) {

        int[] iteratedList = { 1, 5, 6, 7, 8, 7, 9, 5, 3, 5, 7, 78 };
        for (int item : iteratedList) {
            System.out.print(item + " ");
        }
        System.out.println();
        /*
         * this program goes through the array of integers and prints them individualy
         * out using an enhanced for loop this program will output
         * ---------------------- 1 5 6 7 8 7 9 5 3 5 7 78 This is because the loop is
         * iterating through the list
         */

        //////////////////////////////////////////////////////////////
        for (int i = 0; i < 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        /*
         * This program will repeat until it has i is greater than or equal to 10
         * therefore it will output 0 1 2 3 4 5 6 7 8 9
         */

        /*
         * an error people can encounter when programming loops is that they incorectly
         * create the boolean expression that will provide exit from the loop this can
         * be fixed by revaluating the expression and figuring out what went wrong
         */
    }
}