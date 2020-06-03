public class Hailstone {
    public static int hailstoneLength(int n) {
        int stone = n;
        int count = 1;
        while (stone != 1) {
            if (stone%2 == 0) { //even
                stone = stone/2;
            } else { //odd
                stone = 3 * stone + 1;
            }
            count++;
        }
        return count;
    }   
    public static boolean isLongSeq(int n) {
        int hailstoneNumber = hailstoneLength(n);
        return (hailstoneNumber > n);
    }
    public static double propLong(int n) {
        boolean[] evaluations = new boolean[n];
        for (int i = 1; i <= n; i++) {
            evaluations[i-1] = isLongSeq(i);
        }
        int sumOfPositives = 0;
        for (boolean b : evaluations) {
            if (b) {sumOfPositives++;}
        }
        return sumOfPositives/((double)n);
    }
    public static void main(String[] args) {
        System.out.println(hailstoneLength(5));
        System.out.println(isLongSeq(5));
        System.out.println(propLong(10));
    }
}