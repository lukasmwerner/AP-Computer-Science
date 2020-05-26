import java.util.ArrayList;
import java.util.Scanner;

public class Game {

  public static void main(String[] args) {
    Player thePlayer = new Player("some name");

    Location devLocation = new Location(
      "Dev room",
      "This room is only for testing.!"
    );
    Location l1 = new Location("loc1", "This is the first room you enter");
    Location l2 = new Location("loc2", "This is the second room you enter");
    Location l3 = new Location(
      "Cave",
      "There are many loots & enemies here beware."
    );
    Location l4 = new Location("Treasure Room", "Here be all the loots.");
    Location currentLoc = l1;

    devLocation.setNeighbors(null, null, l1, null);
    l1.setNeighbors(devLocation, null, l2, null);
    l2.setNeighbors(l1, l3, null, null);
    l3.setNeighbors(null, null, l4, l2);
    l4.setNeighbors(l3, null, null, null);

    devLocation.addItem(new Sword("Javac Sword", 100));
    l1.addItem(new Coin(10));
    l1.addItem(new Sword(5));
    l2.addEnemy(new Enemy("Goblin", 1, 10, new Coin(20)));

    for (int i = 0; i < 10; i++) {
      l3.addEnemy(new Enemy("Goblin " + i, 1, 10));
    }
    for (int i = 0; i < 10; i++) {
      l4.addItem(new Coin((int) (Math.random() * 100) + 1));
    }
    l4.addItem(new Sword("The Paper Cut", 15));

    System.out.println("Welcome to the adventure " + thePlayer.getName());
    Scanner kb = new Scanner(System.in);

    while (true) {
      System.out.println("\nYou are at " + currentLoc);
      System.out.println(currentLoc.getLocText());
      System.out.println("Your health: " + thePlayer.health());
      System.out.println("The items here are: " + currentLoc.getItemsHere());
      if (currentLoc.hasEnemies()) {
        System.out.println("The enemes here are: " + currentLoc.getEnemies());
      }

      System.out.print("What would you like to do? ");
      String input = kb.nextLine();

      if (input.equals("north") && currentLoc.north() != null) {
        currentLoc = currentLoc.north();
      }
      if (input.equals("east") && currentLoc.east() != null) {
        currentLoc = currentLoc.east();
      }
      if (input.equals("south") && currentLoc.south() != null) {
        currentLoc = currentLoc.south();
      }
      if (input.equals("west") && currentLoc.west() != null) {
        currentLoc = currentLoc.west();
      }
      if (input.equals("exit")) {
        break;
      }
      if (input.equals("map")) {
        currentLoc.render();
      }
      if (input.equals("attack") && thePlayer.canAttack() != null) {
        if (currentLoc.hasEnemies()) {
          for (int i = 0; i < currentLoc.getEnemies().size(); i++) {
            Enemy character = currentLoc.getEnemies().get(i);
            if (character.health() - thePlayer.canAttack().attack() <= 0) {
              if (character.drops() != null) {
                thePlayer.addToInventory(character.drops());
              }
              currentLoc.removeEnemy(i);
              i--;
            } else {
              character.takeDamage(thePlayer.canAttack().attack());
            }
          }
        }
      }
      if (input.equals("get items")) {
        for (Item item : currentLoc.getItemsHere()) {
          thePlayer.addToInventory(item);
        }
        currentLoc.removeAllItems();
      } else if (input.contains("get")) {
        String searchQuery = input.replace("get ", "");
        Item wants = currentLoc.removeItem(searchQuery);
        if (wants != null) {
          thePlayer.addToInventory(wants);
        }
      }
      if (input.equals("inventory")) {
        System.out.println("Inventory: " + thePlayer.getInventory());
      }
      if (currentLoc.hasEnemies()) {
        for (Enemy character : currentLoc.getEnemies()) {
          if (character.health() > 0) {
            thePlayer.takeDamage(character.attack());
          }
        }
      }
      if (thePlayer.health() <= 0) {
        System.out.println("Game Over!");
        break;
      }
    }
  }
}
