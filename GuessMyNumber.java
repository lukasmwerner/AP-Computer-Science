import java.util.Scanner;

public class GuessMyNumber {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean gameRunning = true;
        print("What should be the highest number? ");
        int difficulty = Integer.parseInt(kb.nextLine());
        boolean wrong = false;
        int random = 0;
        while (gameRunning) {
            if (!wrong) {
                random = (int)(Math.random() * difficulty) + 1;
                printf("New round!");
            }

            print("Guess my number? ");
            int input = Integer.parseInt(kb.nextLine());
            if (input > random) {
                printf("You're too high!");
                wrong = true;
            }
            else if (input < random) {
                printf("You're too low!");
                wrong = true;
            } else if (input == random) {
                printf("You got it right!");
                wrong = false;
            }



        }

    }

    // Toolbox lol
    public static void print(String sentString) {
        System.out.print(sentString);
    }
    public static void printf(String sentString) {
        System.out.println(sentString);
    }
}