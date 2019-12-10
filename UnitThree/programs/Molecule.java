public class Molecule {

  private Element element1;
  private Element element2;
  private Element element3;
  private String name;

  public Molecule() {
    element1 = new Element(1, 0, 1, "Hydrogen", "H", 2);
    element2 = new Element(8, 8, 8, "Oxygen", "O", 1);
    name = "Water";
  }

  public Molecule(Element e1, String n) {
    element1 = e1;
    name = n;
  }

  public Molecule(Element e1, Element e2, String n) {
    element1 = e1;
    element2 = e2;
    name = n;
  }

  public Molecule(Element e1, Element e2, Element e3, String n) {
    element1 = e1;
    element2 = e2;
    element3 = e3;
    name = n;
  }

public String getCompound() {
  String str = "";
  str += element1.getSymbol();
  if (element1.getQuantity() > 1) str += element1.getQuantity();
  if (element2 != null) {
    str += element2.getSymbol();
    if (element2.getQuantity() > 1) str += element2.getQuantity();
  }
  if (element3 != null)  {
    str += element3.getSymbol();
    if (element3.getQuantity() > 1) str += element3.getQuantity();
  }
  return str;
}

  public String toString() {
    String str = "";
    if (name != null)
      str += name + " ";
    str += getCompound();
    return str;
  }

}
