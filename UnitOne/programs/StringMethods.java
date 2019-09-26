import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        prints("Please enter a word or phrase: ");
        String input = kb.nextLine();

        int length = input.length();
        printo("The length of the string is: " + length);

        char c = input.charAt(1);
        printo("The second character is: " + c);

        String upper = input.toUpperCase();
        printo("The string in uppercase: " + upper);

        boolean contains = input.contains("at");
        printo("The string contains \"at\": "+ contains);

        String sub1 = input.substring(2);
        printo("The substring starting at index 2 is: "+ sub1);

        String sub2 = input.substring(1,3);
        printo("The substring between index 1 and 3 is: "+ sub2);

        int index = input.indexOf("at");
        printo("\"At\" occurs at the index: "+ index);

        boolean isEqual = input.equals("cat");
        printo("Is your string equal to \"cat\"? "+ isEqual);

        int distance = input.compareTo("cat");
        printo("Your string and \"cat\" are apart by: "+ distance);
    }

    public static void prints(String text) {
        System.out.print(text);
    }
    public static void printo(String text) {
        System.out.println(text);
    }
}