import java.util.*;

/* 
    Items Completed | Points
    * Question 1 | 8
    * Question 2 | 8
    * Question 3 | 8
    * Question 4 | 3
    * Question 5 | 2
    * Question 7 | 2
    * Question 8 | 2
    * Question 9 | 2
*/

public class DNA {

  public static void main(String[] args) {
    String org1 = "TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC";
    String org2 = "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC";
    String org3 = "AAACCCCTCTAGTGGTCATCTGGTCCGCCGAGC";
    String[] sequences = new String[] { "AAACCC", "CTCTA", "CCGAGC" };
    System.out.println(
      norm(
        "TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC",
        "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC"
      )
    ); //Question 1
    System.out.println(norm("GAAT", "GAAA")); // Question 1
    System.out.println(match(org1, sequences)); // Question 2
    System.out.println(match(org2, sequences)); // Question 2
    System.out.println(doubleMatch(org1, org2, sequences));
    System.out.println();
    String mutatedOrg1 = mutate(org1, 4); // Question 3
    System.out.println(mutatedOrg1);
    System.out.println(norm(org1, mutatedOrg1)); // Question 3
    System.out.println();
    String[] compares = {
      "TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC",
      "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC",
      "TCCAACCTCAGCTCTCTTTCAGTGGTCATGGGTTCTGGTACCACCGGACC",
      "TTCAAATCCAGCTCTGTTTTAGTAGCCATGGGTTCTGGCCCCCCCGAGCC",
      "CCCAAACCCATCTCTAGTTTCGTGGGCATGGGTTTTGGTCACCCCTAGCC",
    };
    String[] largeSimilar = mostSimilar(compares); // Question 4
    System.out.println(Arrays.toString(largeSimilar)); // Question 4
    System.out.println(norm(largeSimilar[0], largeSimilar[1])); // Question 4
    System.out.println(
      probMutate(
        new ArrayList<>(
          Arrays.asList(
            'C',
            'C',
            'C',
            'A',
            'A',
            'A',
            'C',
            'C',
            'C',
            'A',
            'T',
            'C',
            'T',
            'C',
            'T',
            'A',
            'G',
            'T',
            'T',
            'T',
            'C',
            'G',
            'T',
            'G',
            'G',
            'G',
            'C',
            'A',
            'T',
            'G',
            'G',
            'G',
            'T',
            'T',
            'T',
            'T',
            'G',
            'G',
            'T',
            'C',
            'A',
            'C',
            'C',
            'C',
            'C',
            'T',
            'A',
            'G',
            'C',
            'C'
          )
        ),
        0.8
      )
    ); // Question 7
    System.out.println(
      norm(
        new ArrayList<>(Arrays.asList('A', 'B')),
        new ArrayList<>(Arrays.asList('A', 'B'))
      )
    ); // Question 5
    System.out.println(cross("AAAAA", "BBBB")); // Question 8
    System.out.println(longestCommonSubstring(org1, org3)); // Question 9
  }

  public static double norm(String s, String t) {
    // converts the wagner fisher output into a percentage
    double diff =
      wagnerFisher(s, t) / (max(new int[] { s.length(), t.length() }) + 0.0);
    return 1.0 - diff;
  }

  public static double norm(ArrayList<Character> s, ArrayList<Character> t) {
    // converts the wagner fisher output into a percentage
    double diff =
      wagnerFisher(s, t) / (max(new int[] { s.size(), t.size() }) + 0.0);
    return 1.0 - diff;
  }

  public static int wagnerFisher(String s, String t) {
    // Implementation of the wagner fisher algorithm https://en.wikipedia.org/wiki/Levenshtein_distance
    int m = s.length() + 1;
    int n = t.length() + 1;
    int[][] distances = new int[n][m];
    for (int i = 1; i < n; i++) {
      distances[i][0] = i;
    }
    for (int i = 1; i < m; i++) {
      distances[0][i] = i;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        int subCost = 0;
        if (s.charAt(j - 1) == t.charAt(i - 1)) {
          subCost = 0;
        } else {
          subCost = 1;
        }
        int value = min(
          new int[] {
            distances[i - 1][j] + 1,
            distances[i][j - 1] + 1,
            distances[i - 1][j - 1] + subCost,
          }
        );
        distances[i][j] = value;
      }
    }
    return distances[n - 1][m - 1];
  }

  public static int wagnerFisher(
    ArrayList<Character> s,
    ArrayList<Character> t
  ) {
    // Implementation of the wagner fisher algorithm https://en.wikipedia.org/wiki/Levenshtein_distance
    int m = s.size() + 1;
    int n = t.size() + 1;
    int[][] distances = new int[n][m];
    for (int i = 1; i < n; i++) {
      distances[i][0] = i;
    }
    for (int i = 1; i < m; i++) {
      distances[0][i] = i;
    }
    for (int i = 1; i < n; i++) {
      for (int j = 1; j < m; j++) {
        int subCost = 0;
        if (s.get(j - 1) == t.get(i - 1)) {
          subCost = 0;
        } else {
          subCost = 1;
        }
        int value = min(
          new int[] {
            distances[i - 1][j] + 1,
            distances[i][j - 1] + 1,
            distances[i - 1][j - 1] + subCost,
          }
        );
        distances[i][j] = value;
      }
    }
    return distances[n - 1][m - 1];
  }

  public static ArrayList<String> doubleMatch(
    String compareToA,
    String compareToB,
    String[] sequences
  ) {
    // checks if there are common sequences between the two given strings
    ArrayList<String> returns = new ArrayList<String>();
    ArrayList<String> compareA = match(compareToA, sequences);
    ArrayList<String> compareB = match(compareToB, sequences);
    ArrayList<Integer> used = new ArrayList<Integer>();
    for (String string : compareA) {
      for (int i = 0; i < compareB.size(); i++) {
        if (string.equals(compareB.get(i)) && !used.contains(i)) {
          returns.add(string);
        }
      }
    }
    return returns;
  }

  public static ArrayList<String> match(String compareTo, String[] sequences) {
    // Retruns sequences that are in the string that we are comparing to
    ArrayList<String> returns = new ArrayList<String>();
    for (String seq : sequences) {
      if (compareTo.contains(seq)) { // check if the sequence is in the compare to item
        returns.add(seq);
      }
    }
    return returns;
  }

  public static String mutate(String source, int itemsToSwap) {
    // Takes a string and swaps items X times
    String mutated = source;
    char[] mutatedArr = mutated.toCharArray(); // convert to array for better array algorithm helpers
    for (int i = 0; i < itemsToSwap; i++) {
      int positionA = (int) (Math.random() * (source.length() - 1) / 2) + 1; // pick a position in the first half of the string
      int positionB = source.length() - positionA; // pick the inverse of the first position
      mutatedArr = swap(mutatedArr, positionA, positionB); // swap the random position
    }
    mutated = new String(mutatedArr); // make it a string again so we can return the right type
    return mutated;
  }

  public static ArrayList<Character> probMutate(
    ArrayList<Character> source,
    double percent
  ) {
    // mutates the given array of characters based on the percentage provided
    ArrayList<Character> spemin = new ArrayList<Character>();
    for (Character c : source) {
      spemin.add(c);
    } // make a deep copy so that we don't worry about pass by reference issues
    while (norm(source, spemin) >= percent) { // while the score is larger than the desired percentage
      int positionA = (int) (Math.random() * (source.size() - 1) / 2) + 1; // grab a random position
      spemin = blarg(spemin, positionA); // move it to the end of the array
      //System.out.println(norm(source, spemin)); // check how we are doing
    }
    return spemin;
  }

  public static String[] mostSimilar(String[] items) {
    // returns the two most similar items given an array of strings
    ArrayList<WagnerFisher> matchList = new ArrayList<WagnerFisher>();
    for (int i = 0; i < items.length; i++) { // calculate the leivenstein numbers for every string
      ArrayList<Score> m = new ArrayList<Score>(); // creates a list of scores (target, score)
      for (int j = i + 1; j < items.length; j++) { // check every item after the one we are currently processing
        int v = wagnerFisher(items[i], items[j]); // calculate the leivenstein number (source, target)
        Score asdf = new Score(items[j], v); // make a new score object to add to the list of scores
        m.add(asdf); // add the score object to the list of scores
      }
      for (int j = 0; j < i; j++) { // check all the items before the index we are currently processing
        int v = wagnerFisher(items[i], items[j]); // calculate the leivenstein number (source, target)
        Score asdf = new Score(items[j], v); // make a new score object to add to the list of scores
        m.add(asdf); // add the score object to the list of scores
      }
      Score closest = m.get(0); // grab the first item in the list to have a basis of where we need to find the smallest number
      for (int z = 1; z < m.size(); z++) { // iterate through every score
        if (closest.score > m.get(z).score) { // if it is closer (smaller) then use that add that one to the closest one
          closest = m.get(z);
        }
      }
      matchList.add(new WagnerFisher(items[i], closest.string, closest.score)); // add the smallest leivenstein number and the closest string and the source to the list of all computed items
    }
    WagnerFisher closest = matchList.get(0); // get the first items so we have a basis of where to find the closest match
    for (int z = 1; z < matchList.size(); z++) { // iterate through every processes string
      if (closest.score > matchList.get(z).score) { // grab the first smallest score in the list
        closest = matchList.get(z); // set that to the closest item
      }
    }
    // Returning the correct data type
    String[] clo = new String[2];
    clo[0] = closest.source;
    clo[1] = closest.match;
    return clo;
  }

  // Common array helpers
  public static int min(int[] a) {
    // returns the first smallest value of an array of doubles
    int smallest = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < smallest) {
        smallest = a[i];
      }
    }
    return smallest;
  }

  public static double min(double[] a) {
    // returns the first smallest value of an array of doubles
    double smallest = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < smallest) {
        smallest = a[i];
      }
    }
    return smallest;
  }

  public static int min(String[] a) {
    // returns the length of the smallest string given
    String smallest = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i].length() < smallest.length()) {
        smallest = a[i];
      }
    }
    return smallest.length();
  }

  public static int max(int[] a) {
    // returns the first largest value of an array of ints
    int max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static double max(double[] a) {
    // returns the first largest value of an array of doubles
    double max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static int[] swap(int[] array, int indexA, int indexB) {
    // swaps two items in an array of ints
    int temp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = temp;
    return array;
  }

  public static double[] swap(double[] array, int indexA, int indexB) {
    // swaps two items in an array of doubles
    double temp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = temp;
    return array;
  }

  public static char[] swap(char[] array, int indexA, int indexB) {
    // swaps two items in an array of chars
    char temp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = temp;
    return array;
  }

  public static ArrayList<Character> swap(
    ArrayList<Character> array,
    int indexA,
    int indexB
  ) {
    // takes an Arraylist of characters and swaps two characters based on the provided indexes
    Character temp = array.get(indexA);
    array.set(indexA, array.get(indexB));
    array.set(indexB, temp);
    return array;
  }

  public static ArrayList<Character> blarg(
    ArrayList<Character> array,
    int pos
  ) {
    // takes an array of characters and takes the character at a position and moves it to the back
    Character c = array.get(pos);
    array.remove(pos);
    array.add(c);
    return array;
  }

  private static class Score {
    public String string;
    public int score;

    public Score(String string, int score) {
      this.string = string;
      this.score = score;
    }
  }

  private static class WagnerFisher {
    // A data structure to store a string, match, and its leivenstein number in an araylist
    public String source;
    public String match;
    public int score;

    public WagnerFisher(String s, String m, int sc) {
      source = s;
      match = m;
      score = sc;
    }
  }

  public static ArrayList<String> cross(String seq1, String seq2) {
    // Crosses two strings in the middle and returns a list of both of them
    int index = min(new String[] { seq1, seq2 }) / 2;
    String build1 = "";
    String build2 = "";
    for (int i = 0; i < index; i++) {
      build1 += seq1.charAt(i);
      build2 += seq2.charAt(i);
    }
    for (int i = index; i < min(new String[] { seq1, seq2 }); i++) {
      build1 += seq2.charAt(i);
      build2 += seq1.charAt(i);
    }
    // strings build complete
    return new ArrayList<String>(Arrays.asList(build1, build2));
  }

  public static ArrayList<String> cross(String seq1, String seq2, int index) {
    // Crosses two strings at a given index and returns a list of both of them
    String build1 = "";
    String build2 = "";
    for (int i = 0; i < index; i++) {
      build1 += seq1.charAt(i);
      build2 += seq2.charAt(i);
    }
    for (int i = index; i < min(new String[] { seq1, seq2 }); i++) {
      build1 += seq2.charAt(i);
      build2 += seq1.charAt(i);
    }
    // strings build complete
    return new ArrayList<String>(Arrays.asList(build1, build2));
  }

  public static int[][] longestCommonSubstring(String a, String b, int flag) {
    String longest = "";
    //if (a.length() == 0 || b.length() == 0) {return longest;}
    int[][] cache = new int[a.length()][b.length()];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          if (i == 0 || j == 0) {
            cache[i][j] = 1;
          } else {
            cache[i][j] = cache[i - 1][j - 1] + 1;
          }
          if (cache[i][j] > longest.length()) {
            longest = a.substring(i - longest.length() + 1, i + 1);
          }
        }
      }
    }
    return cache;
  }

  public static String longestCommonSubstring(String a, String b) {
    String longest = "";
    //if (a.length() == 0 || b.length() == 0) {return longest;}
    int[][] cache = new int[a.length()][b.length()];
    for (int i = 0; i < a.length(); i++) {
      for (int j = 0; j < b.length(); j++) {
        if (a.charAt(i) == b.charAt(j)) {
          if (i == 0 || j == 0) {
            cache[i][j] = 1;
          } else {
            cache[i][j] = cache[i - 1][j - 1] + 1;
          }
          if (cache[i][j] > longest.length()) {
            System.out.println(longest.length());
            longest = a.substring(i - longest.length(), i + 1);
          }
        }
      }
    }
    return longest;
  }
}
