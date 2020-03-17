public class TriangleFunc {
    public static void main(String[] args) {
        System.out.println(tri(4));  
    }

    public static int tri(int n) {
        if (n == 1) {
            return 1;
        }
        return n + tri(n-1);
    }
}