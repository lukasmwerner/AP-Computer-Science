public class Point {
    private int x;
    private int y;
    ;
    public static void main(String[] args) {
        /* For testing methods */;
        Point p = new Point();
        System.out.println(p);
    }
    public String toString() {
        return String.format("%s, %s", x, y);
    }
    public Point() {
        x = 0;
        y = 0;
    }
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}