public class Merchandise {
    private double wholesale;
    private double retail;
    private String name;
    private int qty;

    public Merchandise() {
        name = "Fritt";
        wholesale = 0.5;
        retail = 2.5;
        qty = 20;
    }
    public Merchandise(String n, double w, double r, int q) {
        name = n;
        wholesale = w;
        retail = r;
        qty = q;
    }

    public void buy(int amt) {
        qty += amt;
    }


    public void discount(double pct) {
        retail *= pct;
    }


    public void sell(int amt) {
        qty -= amt;
    }

    public String toString() {
       return "Name: " + name + " Retail Price: $" + retail + " Wholesale Price: $" + wholesale + " Quantity: " + qty;
    }
}