import java.util.ArrayList;

public class Player extends GameCharacter {
  private ArrayList<Item> inventory;

  public Player(String name) {
    super(name);
    inventory = new ArrayList<Item>();
    setHealth(10);
  }

  public void addToInventory(Item i) {
    inventory.add(i);
  }

  public ArrayList<Item> getInventory() {
    return inventory;
  }

  public String toString() {
    return getName() + " " + inventory;
  }

  public Sword canAttack() {
    for (Item item : inventory) {
      if (item.getName().contains("Sword")) {
        return (Sword) item;
      }
    }
    return null;
  }
}
