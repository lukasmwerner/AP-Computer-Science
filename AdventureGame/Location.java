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

  public boolean hasEnemies() {
    return enemiesHere.size() > 0;
  }

  public ArrayList<Enemy> getEnemies() {
    return enemiesHere;
  }

  public void removeEnemy(Enemy e) {
    enemiesHere.remove(e);
  }

  public void removeEnemy(int i) {
    enemiesHere.remove(i);
  }

  public String getLocText() {
    return locText;
  }

  public ArrayList<Item> getItemsHere() {
    return itemsHere;
  }

  public boolean hasLoot() {
    return itemsHere.size() > 0;
  }

  public Item removeItem(String name) {
    /* Linear Search */
    name = name.toLowerCase();
    for (int i = 0; i < itemsHere.size(); i++) {
      Item currentItem = itemsHere.get(i);
      if (currentItem.getName().toLowerCase().contains(name)) {
        itemsHere.remove(i);
        return currentItem;
      }
    }
    return null;
  }

  public Item removeItem(String name, int f) {
    /* Binary Search */
    /* prerequisite Array is sorted*/
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

  public void render() {
    ArrayList<String> view = new ArrayList<>();
    for (int i = 0; i < 5; i++) {
      String row = "";
      for (int j = 0; j < 5; j++) {
        row += " ";
      }
      view.add(row);
    }
    if (north() != null) {
      String wall = "";
      for (int i = 0; i < 5; i++) {
        if (i != 1 && i != 2 && i != 3) {
          wall += "*";
        } else {
          wall += " ";
        }
      }
      view.set(0, wall);
    } else {
      String wall = "";
      for (int i = 0; i < 5; i++) {
        wall += "*";
      }
      view.set(0, wall);
    }
    if (south() != null) {
      String wall = "";
      for (int i = 0; i < 5; i++) {
        if (i != 1 && i != 2 && i != 3) {
          wall += "*";
        } else {
          wall += " ";
        }
      }
      view.set(4, wall);
    } else {
      String wall = "";
      for (int i = 0; i < 5; i++) {
        wall += "*";
      }
      view.set(4, wall);
    }
    if (west() != null) {
      for (int i = 0; i < view.size(); i++) {
        String alter = view.get(i);
        if (i != 1 && i != 2 && i != 3) {
          alter = "*" + alter.substring(1);
        } else {
          alter = " " + alter.substring(1);
        }
        view.set(i, alter);
      }
    } else {
      for (int i = 0; i < view.size(); i++) {
        String alter = view.get(i);
        alter = "*" + alter.substring(1);
        view.set(i, alter);
      }
    }
    if (east() != null) {
      for (int i = 0; i < view.size(); i++) {
        String alter = view.get(i);
        if (i != 1 && i != 2 && i != 3) {
          alter = alter.substring(0, alter.length() - 2) + "*";
        } else {
          alter = alter.substring(0, alter.length() - 2) + " ";
        }
        view.set(i, alter);
      }
    } else {
      for (int i = 0; i < view.size(); i++) {
        String alter = view.get(i);
        alter = alter.substring(0, alter.length() - 2) + "*";
        view.set(i, alter);
      }
    }
    if (hasEnemies()) {
      view.set(
        2,
        view.get(2).substring(0, 2) +
        "E" +
        view.get(2).substring(2, view.get(2).length())
      );
    }
    if (hasLoot()) {
      view.set(
        3,
        view.get(3).substring(0, 1) +
        "@" +
        view.get(3).substring(2, view.get(3).length())
      );
    }

    for (String string : view) {
      System.out.println(string);
    }
  }
}
