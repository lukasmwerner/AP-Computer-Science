public class ConditionalsHW {
    public static void main(String[] args) {
        int condOne = 1;
        int condTwo = 2;
        if (condOne == 1) {
            System.out.println("Condition one was met");
        } else if (condTwo == 2) {
            System.out.println("Only runs when condition one was not met but condition two was met");
        } else {
            System.out.println("Runs when both one and two conditions were not met.");
        }
        /*
         * An error might be that you expect one conditon to run instead of another when
         * using an `else if` conditional comparison
         */
    }
}