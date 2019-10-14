import java.util.Scanner;
public class ParrotProgram {
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        String input = "";
        String input2 = "";
        while (!input.equals("q")) {
            System.out.print("Enter a word (q to quit): ");
            input = kb.nextLine();
            if (input.equals("q")) {
                input2 = "good bye";
            } else {
                input2 = input;
            }
            System.out.println("Parrot says: " + input2);
        }
    }
}