import java.util.Scanner;

public class NameGuess {
    public static void main(String[] args) {
        printf("Welcome to the name game!");
        Scanner kb = new Scanner(System.in);
        boolean gamerunning = true;
        while (gamerunning) {
            String[] names = { "mark zuckerburg", "elon musk", "bill gates", "tim cook", "steve jobs", };
            int random = (int) (Math.random() * names.length);
            String clean = names[random];
            String obfuscater = "--" + names[random].substring(2, clean.length() - 3) + "---";
            printf(obfuscater);
            String input = kb.nextLine();
            if (clean.equals(input)) {
                printf("You got it right!");
            } else if (input.equals("quit") || input.equals("exit")) {
                gamerunning = false;
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