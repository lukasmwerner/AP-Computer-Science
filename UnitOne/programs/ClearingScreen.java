public class ClearingScreen {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}