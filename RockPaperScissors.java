import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            printf("Rock:     1");
            printf("Paper:    2");
            printf("Scissors: 3");
            int rPS = (int)(Math.random()*3)+1;
            int userInput = Integer.parseInt(kb.nextLine());

            printf(rockPaperScisors(rPS, userInput));
        }
    }

    // Toolbox lol
    public static void print(String sentString) {
        System.out.print(sentString);
    }
    public static void printf(String sentString) {
        System.out.println(sentString);
    }

    public static String rockPaperScisors(int computer, int human) {
        /*
            Rock:     1
            Paper:    2
            Scissors: 3

        */
        if (computer == human) {
            return "Tie";
        } 
        else if (computer == 1 && human == 2) {
            return "Human Wins!";
        }
        else if (computer == 2 && human == 3) {
            return "Human Wins!";
        }
        else if (computer == 3 && human == 1) {
            return "Human Wins!";
        }
        else if (computer == 3 && human == 2) {
            return "Computer Wins!";
        }
        else if (computer == 2 && human == 1) {
            return "Computer Wins!";
        }
        else if (computer == 1 && human == 3) {
            return "Computer Wins!";
        }
        else {
            return "No Case";
        }
    }
}