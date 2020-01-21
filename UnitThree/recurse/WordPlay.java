import java.util.Scanner;

public class WordPlay {

  public static void main(String[] args) {
    System.out.println("Enter a list of words, one per line.");
    System.out.println("The final word should be a period.");
    stackWords();
  }

  public static void stackWords() {

    Scanner kb = new Scanner(System.in);
    String word = kb.nextLine();

    if (word.equals("."))
      System.out.println();

    else
      stackWords();

    System.out.println(word);

  }

}