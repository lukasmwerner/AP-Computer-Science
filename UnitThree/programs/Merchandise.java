public class Merchandise {
    private String name;
    private int quantity;
    private double price;

    public Merchandise(String name, int qty, double price) {
        this.name = name;
        this.price = price;
        quantity = qty;
    }

    public Merchandise(String name, int qty, int price) {
        this.name = name;
        this.price = price + 0.0;
        quantity = qty;
    }

    public String toString() {
        String s = name + " qty:" + quantity + " price: $" + price;
        return s;
    }

}