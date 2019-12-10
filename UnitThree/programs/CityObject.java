public class CityObject {

  private String name;
  private int x;
  private int y;

  public CityObject(String name, int x, int y) {
    this.name = name;
    this.x = x;
    this.y = y;
  }

  public String toString() {
    return name + " is at location: " + x + "," + y;
  }

}
