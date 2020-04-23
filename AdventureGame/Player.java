import java.util.ArrayList;

public class Player extends GameCharacter {
  private ArrayList<Item> inventory;

  public Player(String name) {
    super(name);
    inventory = new ArrayList<Item>();
    setHealth(20);
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

  private boolean hasSword() {
    for (Item item : inventory) {
      if (item.type.equals("sword")) {
        return true;
      }
    }
    return false;
  }

  public Sword canAttack() {
    if (hasSword()) {
      ArrayList<Sword> swords = new ArrayList<>();
      for (Item item : inventory) {
        if (item.type.equals("sword")) {
          swords.add((Sword) item);
        }
      }
      Sword bestSword = swords.get(0);
      for (int i = 1; i < swords.size(); i++) {
        if (bestSword.attack() < swords.get(i).attack()) {
          bestSword = swords.get(i);
        }
      }
      return bestSword;
    } else {
      return null;
    }
  }
}
