import java.util.Scanner;
public class TwoDArr {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char[][] board = {
                        {'H', 'O', 'P', 'E', 'N'},
                        {'E', 'E', 'A', 'T', 'O'},
                        {'L','A','L','S','P'},
                        {'L','T', 'W', 'P', 'E'},
                        {'O', 'E', 'B', 'L', 'B'}
                    };
        // Display the Array
        for (char[] row: board) {
            for (char item: row) {
                System.out.print(item+" ");
            }
            System.out.println();
        }



        System.out.print("First word to look for: ");
        String word1 = input.nextLine();
        System.out.print("Second word to look for: ");
        String word2 = input.nextLine();


        for (int r = 0; r < board.length; r++) {
            String row = "";
            for (int c = 0; c < board[r].length; c++) {
                row += board[r][c];
            }
            if (row.contains(word1)) {
                System.out.println("Row: " + r + ", At index " + row.indexOf(word1) + " contains the first word");
            }
            if (row.contains(word2)) {
                System.out.println("Row: " + r + ", At index " + row.indexOf(word2) + " contains the second word");
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            String column = "";
            for (int r = 0; r < board.length; r++) {
                column += board[r][c];
            }
            if (column.contains(word1)) {
                System.out.println("Column: " + c +", At index " + column.indexOf(word1) + " contains the first word");
            }
            if (column.contains(word2)) {
                System.out.println("Column: " + c +", At index " + column.indexOf(word2) + " containsthe second word");
            }
        }

    }
}