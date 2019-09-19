import java.util.Scanner;

public class AddingQuiz {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        boolean gameRunning = true;

        int userInput = Integer.parseInt(kb.nextLine());
        int firstRandom = (int)(Math.random())+1;
        int seccondRandom = (int)(Math.random())+1;

        while (gameRunning) {
            printf("what is "+firstRandom+"+"+seccondRandom+"? ");
            int awnser = firstRandom + seccondRandom;
            if (awnser == userInput) {
                
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