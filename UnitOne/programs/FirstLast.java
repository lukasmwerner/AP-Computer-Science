import java.util.Scanner;

public class FirstLast {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        print("Please enter your name \"First, Last\" ");
        String input = kb.nextLine();

        String[] names = input.split(", ");
        printf("Your name is :" + names[1] + ", " + names[0]);

    }

    public static void print(String sentString) {
        System.out.print(sentString);
    }

    public static void printf(String sentString) {
        System.out.println(sentString);
    }
}