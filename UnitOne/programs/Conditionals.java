/*
  1. Look at the program, and predict what will be output for options 1 - 5
     for a score of 95, 85, 75, and 65
  2. Run the program and compare the results with your predictions
  3. Fix any of the code that produces the wrong results
*/

import java.util.*;

public class Conditionals {

  public static void main(String[] args) {

    Scanner kb = new Scanner(System.in);
    System.out.print("What score did you get on the assignment? ");
    int score = Integer.parseInt(kb.nextLine());
    String grade = "";

    /* Option 1 : stand-alone if statements */
    if (score >= 90)
      grade = "A";
    if (score >= 80)
      grade = "B";
    if (score >= 70)
      grade = "C";
    if (score < 70)
      grade = "F";
    System.out.println("Option 1 grade = " + grade);

    /* Option 2 : else if statements */
    grade = "";
    if (score >= 90)
      grade = "A";
    else if (score >= 80)
      grade = "B";
    else if (score >= 70)
      grade = "C";
    else
      grade = "F";
    System.out.println("Option 2 grade = " + grade);

    /* Option 3 : if statements in 'reverse' */
    grade = "";
    if (score >= 0)
      grade = "F";
    if (score >= 70)
      grade = "C";
    if (score >= 80)
      grade = "B";
    if (score >= 90)
      grade = "A";
    System.out.println("Option 3 grade = " + grade);

    /* Option 4 : nesting if statements */
    grade = "";
    if (score >= 90) {
      grade = "A";
      if (score >= 80) {
        grade = "B";
        if (score >= 70) {
          grade = "C";
          if (score < 70) {
            grade = "F";
          }
        }
      }
    }
    System.out.println("Option 4 grade = " + grade);

    /* Option 5 : compound if statements */
    grade = "";
    if (score >= 90)
      grade = "A";
    if (score < 90 && score >= 80)
      grade = "B";
    if (score < 80 && score >= 70)
      grade = "C";
    if (score < 70)
      grade = "F";
    System.out.println("Option 5 grade = " + grade);

  }

}
