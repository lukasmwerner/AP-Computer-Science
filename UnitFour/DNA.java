import java.util.*;
public class DNA {
    public static void main(String[] args) {
        String org1 = "TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC";
        String org2 = "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC";
        //String org3 = "AAACCCCTCTAGTGGTCATCTGGTCCGCCGAGC";
        String[] sequences = new String[] {"AAACCC", "CTCTA", "CCGAGC"};
        System.out.println(norm("TCCAAACCCAGCTCTATTTTAGTGGTCATGGGTTCTGGTCCCCCCGAGCC", "TCCAAACCCAGCTCTAATTAAGTGGTCAAGCGTTCTGGTCCCCCCGAGGC"));
        System.out.println(norm("GAAT", "GAAA"));
        System.out.println(match(org1, sequences));
        System.out.println(match(org2, sequences));
        System.out.println(doubleMatch(org1, org2, sequences));
        System.out.println();
        String mutatedOrg1 = mutate(org1, 4);
        System.out.println(mutatedOrg1);
        System.out.println(norm(org1, mutatedOrg1));
        System.out.println();
        String[] compares = {"123", "aqv", "1ab", "aac", "abb", "abc"};
        System.out.println(Arrays.toString(mostSimilar(compares)));

    }
    public static double norm(String s, String t) {
        double diff = wagnerFisher(s, t) / (max(new int[] {s.length(), t.length()})+0.0);
        return 1.0-diff;
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
        //System.out.println(Arrays.deepToString(distances));
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int subCost = 0;
                if (s.charAt(j-1) == t.charAt(i-1)) {
                    subCost = 0;
                } else {
                    subCost = 1;
                }
                int value = min(new int[] {
                    distances[i-1][j] + 1,
                    distances[i][j-1] + 1,
                    distances[i-1][j-1] + subCost
                });
                distances[i][j] = value;
            }
        }
        return distances[n-1][m-1];
    }

    public static String doubleMatch(String compareToA, String compareToB, String[] sequences) {
        if (match(compareToA, sequences).equals(match(compareToB, sequences))) {
            return match(compareToA, sequences);
        }
        return "N/A";
    }

    public static String match(String compareTo, String[] sequences) {
        for (String seq : sequences) {
            if (compareTo.contains(seq)) {
                return seq;
            }
        }
        return "N/A";
    }

    public static String mutate(String source, int itemsToSwap) {
        String mutated = source;
        char[] mutatedArr = mutated.toCharArray();
        for (int i = 0; i < itemsToSwap; i++) {
            int positionA = (int)(Math.random()*(source.length()-1)/2)+1;
            int positionB = source.length() - positionA;
            mutatedArr = swap(mutatedArr, positionA, positionB);
            
        }
        mutated = new String(mutatedArr);
        return mutated;
    }

    public static String[] mostSimilar(String[] items) {
        ArrayList<WagnerFisher> matchList = new ArrayList<WagnerFisher>();
        for (int i = 0; i < items.length; i++) {
            ArrayList<Score> m = new ArrayList<Score>();
            for (int j = i+1; j < items.length; j++) {
                int v = wagnerFisher(items[i], items[j]);
                Score asdf = new Score(items[j], v);
                m.add( asdf );
            }
            for (int j = 0; j < i; j++) {
                int v = wagnerFisher(items[i], items[j]);
                Score asdf = new Score(items[j], v);
                m.add( asdf );
            }
            Score closest = m.get(0);
            for (int z = 1; z < m.size(); z++) {
                if (closest.score > m.get(z).score) {
                    closest = m.get(z);
                }
            }
            matchList.add( new WagnerFisher(items[i], closest.string, closest.score) );
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
}

