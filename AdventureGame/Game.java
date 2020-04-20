import java.util.Scanner;
import java.util.ArrayList;

public class Game {
	public static void main(String[] args) {

		Player thePlayer = new Player("some name");

		Location l1 = new Location("loc1", "This is the first room you enter");
		Location l2 = new Location("loc2", "This is the second room you enter");
		Location currentLoc = l1;

		l1.setNeighbors(null, null, l2, null);
		l2.setNeighbors(l1, null, null, null);

		System.out.println("Welcome to the adventure " + thePlayer.getName());
		Scanner kb = new Scanner(System.in);

		while (true) {
			System.out.println("\nYou are at " + currentLoc);
			System.out.println(currentLoc.getLocText());
			System.out.println("The items here are: " + currentLoc.getItemsHere());
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
		}

	}
}
