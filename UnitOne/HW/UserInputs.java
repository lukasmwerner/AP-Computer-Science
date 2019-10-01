import java.util.Scanner; // import the java Scanner from the java utilities folder

public class UserInputs { //actual file class so that we can type `javac ClassName`
    public static void main(String[] args) { // the main function of our class so that we can execute our program and have it do things
        Scanner keyboardObj = new Scanner(System.in); // Create a new keyboard Scanner Object which takes the System.in as input

        String userInput = keyboardObj.nextLine(); // Wait untill enter/return is sent and then read the contents of that to a string input
    }
}
/*
An error that one can end up with from userinput is trying to do math with the String variable type
to be able to get integer or boolean or double or float variables from userinput one must use a parse ex:

int userInput = Integer.parseInt(keyboardObj.nextLine());

The parseing is what converts the string which is passes, in this case the keyboardObject which waits until it recives the new line
and in the end we store it into a variable type int with a name of userInput
*/