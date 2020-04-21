import java.util.ArrayList;

public class Location {
  /* Instance variables */
  private String locName;
  private ArrayList<Item> itemsHere;
  private ArrayList<Enemy> enemiesHere;
  private String locText;
  private Location north;
  private Location east;
  private Location south;
  private Location west;

  /* Methods */
  public Location() {
    itemsHere = new ArrayList<Item>();
    enemiesHere = new ArrayList<Enemy>();
    locName = "location";
    locText = "This is a location";
  }

  public Location(String name, String text) {
    itemsHere = new ArrayList<Item>();
    enemiesHere = new ArrayList<Enemy>();
    locName = name;
    locText = text;
  }

  public void setNeighbors(Location n, Location e, Location s, Location w) {
    north = n;
    east = e;
    south = s;
    west = w;
  }

  public void addItem(Item i) {
    itemsHere.add(i);
  }

  public void addEnemy(Enemy c) {
    enemiesHere.add(c);
  }

  public boolean hasEnemies() {return enemiesHere.size() > 0;}

  public ArrayList<Enemy> getEnemies() {return enemiesHere;}

  public String getLocText() {
    return locText;
  }

  public ArrayList<Item> getItemsHere() {
    return itemsHere;
  }

  public Item removeItem(String name) {
    /* implment this method */
    /* Search through the itemsHere ArrayList to find the matching name.
			   If a match is found, remove that item from the ArrayList, and have
				 this method return that item. */
    return null;
  }

  public void removeAllItems() {
    itemsHere.clear();
  }

  public Location north() {
    return north;
  }

  public Location east() {
    return east;
  }

  public Location south() {
    return south;
  }

  public Location west() {
    return west;
  }

  public String toString() {
    return locName;
  }
}
