import java.util.Scanner;

public class StringMethods2 {

  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    System.out.print("Please enter a word or phrase: ");
    String input = kb.nextLine();

    input = input.trim(); // trims any whitespace before or after

    // Example 1: Get the last character
    int length = input.length();
    char c = input.charAt(length - 1); // why is it necessary to subtract 1?
    System.out.println("The last character is: " + c);

    // #1 Get the first character
    // Write the code to get the first character from the input and print it out
    char first = input.charAt(0);
    System.out.println("First Char " + first);

    // Example 2: Splitting a word in thirds
    String firstThird = input.substring(0, length / 3);
    String secondThird = input.substring(length / 3, length * 2 / 3).toUpperCase();
    String thirdThird = input.substring(length * 2 / 3);
    System.out.println("The word is:" + firstThird + secondThird + thirdThird);

    // #2 Complete the following code so the characters after the 'a' are CAPS
    int aPos = input.indexOf("a");
    String beforeA = input.substring(0, aPos).toUpperCase(); // change after the = sign
    char fillerA = input.charAt(aPos);
    String afterA = input.substring(aPos + 1).toUpperCase(); // change after the = sign
    System.out.println("Before and after \'a\'" + beforeA + fillerA + afterA);

  }

}
