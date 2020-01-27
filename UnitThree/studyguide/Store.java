public class Store {
    public static void main(String[] args) {
        Merchandise fritt = new Merchandise();
        System.out.println(fritt);
        fritt.buy(5);
        fritt.sell(10);
        fritt.discount(0.9);
        System.out.println(fritt);
    }
}