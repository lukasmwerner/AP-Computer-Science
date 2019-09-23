import java.util.Scanner;

public class AddingQuiz {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean gameRunning = true;

        while (gameRunning) {
            boolean wrong = true;
            int firstRandom = (int)(Math.random()*100)+1;
            int seccondRandom = (int)(Math.random()*100)+1;
            while (wrong) {
                printf("what is "+firstRandom+"+"+seccondRandom+"? ");
                int userInput = Integer.parseInt(kb.nextLine());
                int awnser = firstRandom + seccondRandom;
                if (awnser == userInput) {
                    printf("You got it right");
                    wrong = false;
                }
                else if (awnser >= userInput) {
                    printf("You got it wrong, try again");
                    wrong = true;
                }
                else if (awnser <= userInput) {
                    printf("You got it wrong, try again");
                    wrong = true;
                }
            }
            printf("next round!");
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