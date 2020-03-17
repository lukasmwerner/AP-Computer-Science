import java.util.*;

public class MagicBox {
    private static [[int req = 15;
    public static void main(String[] args) {
        System.out.println(isMagicBox(new int[][] {
            {7, 0, 5},
            {2, 4, 6},
            {3, 8, 1}
        }));

        int[][] m = magic();
        System.out.println("-----");
        printMatrix(m);
    }
    public static boolean isMagicBox(int[][] box) {
        for (int[] row : box) {
            int sum = 0;
            for(int item: row) {
                sum += item;
            }
            if (sum < 15 || sum > req) {
                return false;
            }
        }
        for (int j = 0; j < box[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < box.length; i++) {
                sum += box[i][j];
            } 
            if (sum < req || sum > req) {
                return false;
            }      
        }

        int sum = 0;
        for (int i = 0; i < box.length; i++) {
            sum += box[i][i];
        }
        if (sum < req || sum > req) {
            return false;
        }
        sum = 0;
        for (int i = box.length-1; i >=0; i--) {
            sum += box[i][box.length-1-i];
        }
        if (sum < req || sum > req) {
            return false;
        }

        // passed all the checks must be sum of 15
        return true;
    }
    public static int[][] magic() {
        int[][] matrix = new int[3][3];
        int z = 1;
        while (true) {
            ArrayList<Integer> values = new ArrayList<Integer>();
            for (int i = 1; i < 10; i++) {
                values.add(i);
            }
            Collections.shuffle(values);

            int x = 0;
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = values.get(x);
                    x++;
                }
            }

            if (isMagicBox(matrix)) {
                break;
            }
            z++;
        }
        return matrix;
    }

    public static void printMatrix(int[][] m) {
        for (int[] is : m) {
            
            for (int i : is) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}