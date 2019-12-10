public class Building extends CityObject {

  private int occupancy;

  public Building(String name, int x, int y, int occ) {
    super(name, x, y);
    occupancy = occ;
  }

  public String toString() {
    String str = super.toString();
    return str + " occupancy: " + occupancy;
  
  }

}
