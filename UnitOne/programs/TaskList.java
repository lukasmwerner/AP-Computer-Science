import java.util.Scanner;

public class TaskList {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String input = "";
        int taskListLength = 0;

        while (!input.equalsIgnoreCase("q")) {
            System.out.print("Create a task (q to quit): ");
            input = keyboard.nextLine();
            if (!input.equalsIgnoreCase("q")) {
                System.out.println("'"+input + "'"+ " added to task list");
                taskListLength++;
            } else {
                System.out.println("Good bye");
            }

        }
        System.out.println(taskListLength);
    }
}