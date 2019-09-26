import java.util.Scanner;
public class MiddleLetter {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        print("enter a word please: ");
        String input = kb.nextLine();

        int length = input.length();
        int midpoint = length/2;
        char middleChar = input.charAt(length/2);
        printf("Middle Char: " + middleChar);

        String before = input.substring(0, midpoint);
        String after = input.substring(midpoint+1, length);

        printf(before + Character.toUpperCase(middleChar) + after);

    }

    public static void print(String sentString) {
        System.out.print(sentString);
    }
    public static void printf(String sentString) {
        System.out.println(sentString);
    }
}