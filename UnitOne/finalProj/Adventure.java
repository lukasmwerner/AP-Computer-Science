/* 
    Lukas Werner 
    (c) 2019 
    AP Computer Science
    Created for Unit One Project
*/

import java.util.Scanner;
import java.util.ArrayList;

public class Adventure {
    public static void main(String[] args) {
        // Main function variables
        Scanner kb = new Scanner(System.in);
        int[][] playField = new int[20][20]; // create the playfield 2D array to contain our enemies and items
        boolean gameRunning = true; // create our main quitting boolean for our sentinal loop
        /*
         * Object IDs: 1 = Player | 2 = Enemy | 3 = Sword | 4 = Treasure | 5 = Hole | 6 = Crown
         */

        playField[10][10] = 1; // set player in center of field

        playField[0][0] = 2;

        while (gameRunning) {

            render(playField);
            String direction = kb.nextLine();
            if (direction.toLowerCase().equals("n")) {
                int x = findTypePosition(playField, 1).get(0);
                int y = findTypePosition(playField, 1).get(1);
                moveEntity(playField, 1, x-1, y);
            } else if (direction.toLowerCase().equals("s")){
                int x = findTypePosition(playField, 1).get(0);
                int y = findTypePosition(playField, 1).get(1);
                moveEntity(playField, 1, x+1, y);
            }
            else if (direction.toLowerCase().equals("e")) {
                int x = findTypePosition(playField, 1).get(0);
                int y = findTypePosition(playField, 1).get(1);
                moveEntity(playField, 1, x, y+1);
            } else if (direction.toLowerCase().equals("w")) {
                int x = findTypePosition(playField, 1).get(0);
                int y = findTypePosition(playField, 1).get(1);
                moveEntity(playField, 1, x, y-1);
            }

        }

    }

    // Seccondary 'libraries' that help with sanity and shorter function
    public static void print(String sentString) {
        System.out.print(sentString);
    }

    public static void printf(String sentString) {
        System.out.println(sentString);
    }

    public static void render(int[][] playField) {
        for (int[] row : playField) {
            for (int item: row) {
                System.out.print(item);
                
            }
            System.out.print("\n");
        }
    }

    public static void moveEntity(int[][] playField, int typeId, int x, int y) {
        int oldX = findTypePosition(playField, typeId).get(0); // get the old x position of the entity
        int oldY = findTypePosition(playField, typeId).get(1); // get the old y position of the entity

        try { // make sure that the intended location is not outside of the 2D Array
            playField[oldX][oldY] = 0; // null out that number
            playField[x][y] = typeId; // set to new position
        }
        catch (ArrayIndexOutOfBoundsException e) {
            playField[oldX][oldY] = typeId;
            
        }
        
        
            

    }

    public static ArrayList<Integer> findTypePosition(int[][] playField, int typeId) {
        ArrayList list = new ArrayList<Integer>();

        int y = 0;
        boolean found = false;
        for (int[] row : playField) {
            int x = 0;
            for (int position : row) {
                if (position == typeId) {
                    list.add(y);
                    list.add(x);
                    found = true;
                    break;
                }
                x++;
            }
            if (found) {
                break;
            }
            y++;

        }

        return list;
    }
}