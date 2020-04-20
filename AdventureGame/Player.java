import java.util.ArrayList;

public class Player extends GameCharacter {

	private ArrayList<Item> inventory;

	public Player (String name) {
		super(name);
		inventory = new ArrayList<Item>();
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
}
