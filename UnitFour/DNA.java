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
*/

public class DNA {

  public static void main(String[] args) {
    String org1 = "TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC";
    String org2 = "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC";
    //String org3 = "AAACCCCTCTAGTGGTCATCTGGTCCGCCGAGC";
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
  }

  public static double norm(String s, String t) {
    double diff =
      wagnerFisher(s, t) / (max(new int[] { s.length(), t.length() }) + 0.0);
    return 1.0 - diff;
  }

  public static double norm(ArrayList<Character> s, ArrayList<Character> t) {
    double diff =
      wagnerFisher(s, t) / (max(new int[] { s.size(), t.size() }) + 0.0);
    return 1.0 - diff;
  }

  public static int wagnerFisher(String s, String t) {
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
    ArrayList<String> returns = new ArrayList<String>();
    if (match(compareToA, sequences).equals(match(compareToB, sequences))) {
      for (String str : match(compareToA, sequences)) {
        returns.add(str);
      }
    }
    return returns;
  }

  public static ArrayList<String> match(String compareTo, String[] sequences) {
    ArrayList<String> returns = new ArrayList<String>();
    for (String seq : sequences) {
      if (compareTo.contains(seq)) {
        returns.add(seq);
      }
    }
    return returns;
  }

  public static String mutate(String source, int itemsToSwap) {
    String mutated = source;
    char[] mutatedArr = mutated.toCharArray();
    for (int i = 0; i < itemsToSwap; i++) {
      int positionA = (int) (Math.random() * (source.length() - 1) / 2) + 1;
      int positionB = source.length() - positionA;
      mutatedArr = swap(mutatedArr, positionA, positionB);
    }
    mutated = new String(mutatedArr);
    return mutated;
  }

  public static ArrayList<Character> probMutate(
    ArrayList<Character> source,
    double percent
  ) {
    ArrayList<Character> spemin = new ArrayList<Character>();
    for (Character c : source) {
      spemin.add(c);
    }
    while (norm(source, spemin) >= percent) {
      int positionA = (int) (Math.random() * (source.size() - 1) / 2) + 1;
      spemin = blarg(spemin, positionA);
      System.out.println(norm(source, spemin));
    }
    return spemin;
  }

  public static String[] mostSimilar(String[] items) {
    ArrayList<WagnerFisher> matchList = new ArrayList<WagnerFisher>();
    for (int i = 0; i < items.length; i++) {
      ArrayList<Score> m = new ArrayList<Score>();
      for (int j = i + 1; j < items.length; j++) {
        int v = wagnerFisher(items[i], items[j]);
        Score asdf = new Score(items[j], v);
        m.add(asdf);
      }
      for (int j = 0; j < i; j++) {
        int v = wagnerFisher(items[i], items[j]);
        Score asdf = new Score(items[j], v);
        m.add(asdf);
      }
      Score closest = m.get(0);
      for (int z = 1; z < m.size(); z++) {
        if (closest.score > m.get(z).score) {
          closest = m.get(z);
        }
      }
      matchList.add(new WagnerFisher(items[i], closest.string, closest.score));
    }
    WagnerFisher closest = matchList.get(0);
    for (int z = 1; z < matchList.size(); z++) {
      if (closest.score > matchList.get(z).score) {
        closest = matchList.get(z);
      }
    }
    String[] clo = new String[2];
    clo[0] = closest.source;
    clo[1] = closest.match;
    return clo;
  }

  // Common array helpers
  public static int min(int[] a) {
    int smallest = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < smallest) {
        smallest = a[i];
      }
    }
    return smallest;
  }

  public static double min(double[] a) {
    double smallest = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] < smallest) {
        smallest = a[i];
      }
    }
    return smallest;
  }
  public static int min(String[] a) {
      String smallest = a[0];
      for (int i = 0; i < a.length; i++) {
          if (a[i].length() < smallest.length()) {
              smallest = a[i];
          }
      }
      return smallest.length();
  }

  public static int max(int[] a) {
    int max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static double max(double[] a) {
    double max = a[0];
    for (int i = 0; i < a.length; i++) {
      if (a[i] > max) {
        max = a[i];
      }
    }
    return max;
  }

  public static int[] swap(int[] array, int indexA, int indexB) {
    int temp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = temp;
    return array;
  }

  public static double[] swap(double[] array, int indexA, int indexB) {
    double temp = array[indexA];
    array[indexA] = array[indexB];
    array[indexB] = temp;
    return array;
  }

  public static char[] swap(char[] array, int indexA, int indexB) {
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
    Character temp = array.get(indexA);
    array.set(indexA, array.get(indexB));
    array.set(indexB, temp);
    return array;
  }

  public static ArrayList<Character> blarg(
    ArrayList<Character> array,
    int pos
  ) {
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
    int index = min(new String[] {seq1, seq2}) / 2;
    String build1 = "";
    String build2 = "";
    for (int i = 0; i < index; i++) {
        build1 += seq1.charAt(i);
        build2 += seq2.charAt(i);
    }
    for (int i = index; i < min(new String[] {seq1, seq2}); i++) {
        build1 += seq2.charAt(i);
        build2 += seq1.charAt(i);
    }
    // first string build complete
    return new ArrayList<String>(Arrays.asList(build1, build2));
  }
  public static ArrayList<String> cross(String seq1, String seq2, int index) {
    String build1 = "";
    String build2 = "";
    for (int i = 0; i < index; i++) {
        build1 += seq1.charAt(i);
        build2 += seq2.charAt(i);
    }
    for (int i = index; i < min(new String[] {seq1, seq2}); i++) {
        build1 += seq2.charAt(i);
        build2 += seq1.charAt(i);
    }
    // first string build complete
    return new ArrayList<String>(Arrays.asList(build1, build2));
  }
}
