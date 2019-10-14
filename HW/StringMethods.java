public class StringMethods {
    public static void main(String[] args) {
        String someString = "This some string!";
        int stringLength = someString.length(); // grabs the length of the string
        String stringed = someString.substring(0, stringLength - 3); // gets a substring from the first character to the
                                                                     // 4th to las character
        System.out.println(someString + stringLength + stringed); // outputs info to screen
    }
}
/*
 * an error i have seen with string methods is miscalculating where the
 * substring will end because the last character is exclusive
 */