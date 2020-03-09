import java.util.Scanner;
public class TicTacToe {
    // x = 1
    // o = -1
    // add them together to see if there was someone who won.


    private static int[][] board;
    private static boolean endGame;
    public static void main(String[] args) {
        endGame = false;
        board = new int[3][3];
        Scanner in = new Scanner(System.in);
        while (!endGame) {
            displayBoard();
            System.out.print("(X's) Please pick your spot (row,col): ");
            String data = in.nextLine();
            String[] ins = data.split(",");
            board[Integer.parseInt(ins[0])][Integer.parseInt(ins[1])] = 1; //X = 1
            if (checkWinner() != 0)
                break;
            displayBoard();
            System.out.print("(O's) Please pick your spot (row,col): ");
            String data2 = in.nextLine();
            String[] ins2 = data2.split(",");
            board[Integer.parseInt(ins2[0])][Integer.parseInt(ins2[1])] = -1; //X = 1
            if (checkWinner() != 0)
                break;
        }
        if (checkWinner() == 1) {
            System.out.println("X's win!");
        } else if (checkWinner() == -1) {
            System.out.println("O's win!");
        } else {
            System.out.println("Tie.");
        }
        in.close();
    }
    public static void displayBoard() {
        System.out.println("  0 1 2");
        for (int i = 0; i < board.length; i++) {
            String rowStr = "";
            rowStr += i + " ";
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == -1) {
                    rowStr += "o" + " ";
                } else if (board[i][j] == 1) {
                    rowStr += "x" + " ";
                } else {
                    rowStr += " " + " ";
                }
                
            }
            System.out.println(rowStr);
        }
        System.out.println();
    }
    public static int checkWinner() {
        for (int i = 0; i < board.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < board[i].length; j++) {
                rowSum +=board[i][j];
            }
            if (rowSum == 3) {
                return 1;
            } else if (rowSum == -3) {
                return -1;
            }
        }
        for (int c = 0; c < board[0].length; c++) {
            int colSum = 0;
            for (int r = 0; r < board.length; r++) {
                colSum += board[r][c];
            }
            if (colSum == 3) {
                return 1;
            } else if (colSum == -3) {
                return -1;
            }
        }
        int diagSum = 0;
        for (int i = 0; i < board.length; i++) {
            diagSum += board[i][i];
        }
        if (diagSum == 3) {
            return 1;
        } else if (diagSum == -3) {
            return -1;
        }
        diagSum = 0;
        for (int i = board.length-1; i >=0; i--) {
            diagSum += board[i][board.length-1-i];
        }
        if (diagSum == 3) {
            return 1;
        } else if (diagSum == -3) {
            return -1;
        }
        int boardSum = 0;
        int zeroCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[i].length; k++) {
                if (board[i][k] == 0)
                    zeroCount++;
                boardSum += board[i][k];
            }
        }
        if (boardSum == 1 && zeroCount < 1) {
            return -3; // game is over and tied
        }


        return 0;
    }
}