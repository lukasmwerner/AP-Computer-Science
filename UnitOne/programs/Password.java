/* 
Password program, AP Computer Science
Lukas Werner 9/6/19 
*/

import java.util.Scanner;


public class Password {

    public static void main(String[] args) {
        boolean correct = true;
        while (correct) {
            System.out.println("Username: ");
            Scanner keyboard = new Scanner(System.in);
            String input = keyboard.nextLine();
            if (input.equals("username")) { // checks if userinput is equivalent to username
                System.out.println("Password: ");
                keyboard = new Scanner(System.in);
                input = keyboard.nextLine();
                if (input.equals("password")) { // check if password is correct
                    System.out.println("You got it right");
                    correct = false; // break out of loop
                } else {
                    System.out.println("You got it wrong!");
                } // end password compare
                
            } else {
                System.out.println("You got it wrong!");
            } //end of username compare
        } // end of loop
            
    } // end of function main

}