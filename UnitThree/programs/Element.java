public class Element {

  private int protons;
  private int neutrons;
  private int electrons;
  private String name;
  private String symbol;
  private int quantity;

  public Element() {
    protons = 1;
    neutrons = 0;
    electrons = 1;
    name = "Hydrogen";
    symbol = "H";
    quantity = 1;
  }

  public Element(int p, int n, int e, String na, String s, int q) {
    protons = p;
    neutrons = n;
    electrons = e;
    name = na;
    symbol = s;
    quantity = q;
  }

  public String getSymbol() {
    return symbol;
  }

  public int getQuantity() {
    return quantity;
  }

  public String toString() {
    return name + "(" + symbol + ") " + protons;
  }

}
