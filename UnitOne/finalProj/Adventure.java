import java.util.Scanner;
import java.nio.charset.Charset;
import java.util.ArrayList;

/* 
Checklist:
    (x) Escape Character
    (X) Concatenation
    (x) Outputing a variable value
    (x) Text input
    (X) Use 3 string methods
    (X) Capitalize the first letter of a user-inputed word 
    (x) Loops to do cycles
    (x) Conditionals using some decision branching
    (x) Variables, use them!
*/

public class Adventure {
    int score = 0;
    static boolean debug = false;

    public static void main(String[] args) {
        // Main function variables
        Scanner kb = new Scanner(System.in);
         // create the playfield 2D array to contain our enemies and items
        boolean gameRunning = true; // create our main quitting boolean for our sentinal loop
        /*
         * Object IDs: 
         * 1 = Player 
         * 2 = Enemy 
         * 3 = Sword 
         * 4 = Treasure 
         * 5 = Wall 
         * 6 = Crown
         */

        //generated using https://www.dcode.fr/maze-generator
        String locationString = "  5555555555555555555\n"+
                                "  5         5       5\n"+
                                "5 555 55555 55555 5 5\n"+
                                "5       5 5   5 5 5 5\n"+
                                "5 555 5 5 5 555 5 5 5\n"+
                                "5   5 5 5   5 5   5 5\n"+
                                "555 5555555 5 555 555\n"+
                                "5   5   5 5     5   5\n"+
                                "5 55555 5 5 5555555 5\n"+
                                "5 5     5       5   5\n"+
                                "5 555 555 5 55555 5 5\n"+
                                "5       5 5       5 5\n"+
                                "555 5 55555 555555555\n"+
                                "5   5     5         5\n"+
                                "55555 555 555 5555555\n"+
                                "5 5 5   5   5     5 5\n"+
                                "5 5 555 555 55555 5 5\n"+
                                "5 5       5 5   5   5\n"+
                                "5 5 5 5555555 555 5 5\n"+
                                "5   5 5           5 1\n"+
                                "5555555555555555555  ";
        int[][] playField = genMapByStr(locationString);

        print("What's your name? ");
        String name = kb.nextLine();
        String uppercased = Character.toUpperCase(name.charAt(0)) + name.substring(1);
        int moves = 0;
        boolean solved = false;
        while (gameRunning) {
            int x = findTypePosition(playField, 1).get(0);
            int y = findTypePosition(playField, 1).get(1);
            if (x == 20 && y == 20) {
                gameRunning = false;
                solved = true;
            } else {
                render(playField);
                try {
                    String direction = kb.nextLine();
                    if (direction.toUpperCase().equals("N")) {              
                        if (!collisions(playField, x, y, 'n')) {
                            moveEntity(playField, 1, x - 1, y);
                        }
                    } else if (direction.toUpperCase().equals("S")) {
                        if (!collisions(playField, x, y, 's')) {
                            moveEntity(playField, 1, x + 1, y);
                        }
                    } else if (direction.toUpperCase().equals("E")) {
                        if (!collisions(playField, x, y, 'e')) {
                            moveEntity(playField, 1, x, y + 1);
                        }
                        
                    } else if (direction.toUpperCase().equals("W")) {
                        if (!collisions(playField, x, y, 'w')) {
                            moveEntity(playField, 1, x, y - 1);
                        }
                    } else if (direction.toUpperCase().equals("Q")) {
                        gameRunning = false;
                    } else if (direction.toLowerCase().contains("help") || direction.toLowerCase().charAt(0) == 'h'){
                        printf("Movement: ");
                        printf("    N: Move North");
                        printf("    S: Move South");
                        printf("    E: Move East");
                        printf("    W: Move West");
                        printf("Commands: ");
                        printf("    Q: Quit");
                        printf("    (H)elp: Shows this help text");


                        printf("");
                        print("Please press enter to continue");
                        kb.nextLine();
                    }
                    moves++;
                } catch (StringIndexOutOfBoundsException e) {;}

            }
        }
        if (solved) {
            printf("Congrats " + uppercased + " completed the maze in " + moves + " moves!");
        }
            
    }

    public static void render(int[][] playField) {
        
        //make sure we don't mess up the terminal output on windows
        if (!System.getProperty("os.name").contains("Windows") && !debug) {
            System.out.print("\033[H\033[2J");
            System.out.flush();
        }
        for (int[] row : playField) {
            for (int item : row) {
                if (item == 5) {
                    print("#");
                } else if (item != 0) {
                    print(item);
                } else {
                    print(" ");
                }
                    
            }
            System.out.print("\n");
        }
    }

    public static boolean collisions(int[][] playField, int charX, int charY, char dir ) {
        int aboveD = charX + 1;
        int belowD = charX - 1;
        int leftD  = charY - 1;
        int rightD = charY + 1;

        //weither something is open or not | True = open
        boolean above = true;
        boolean below = true;
        boolean left = true;
        boolean right = true;

        //the item that is whereever stored into an int
        int aboveType = 0;
        int belowType = 0;
        int leftType = 0;
        int rightType = 0;

        try { if (playField[aboveD][charY] != 0) {above = false; aboveType = playField[aboveD][charY]; } } catch (ArrayIndexOutOfBoundsException e) {if (debug){printf("Above error");}}
        try { if (playField[belowD][charY] != 0) {below = false; belowType = playField[belowD][charY]; } } catch (ArrayIndexOutOfBoundsException e) {if (debug){printf("Below error");}}
        try { if (playField[charX][leftD] != 0) {left = false;   leftType  = playField[charX][leftD]; } } catch (ArrayIndexOutOfBoundsException e) {if (debug){printf("Left error");}}
        try { if (playField[charX][rightD] != 0) {right = false; rightType = playField[charX][rightD]; } } catch (ArrayIndexOutOfBoundsException e) {if (debug){printf("Right error");}}
        if (below && (aboveType == 3 || aboveType == 4 || aboveType == 6) ) {
            return false;
        } 
        else if (above && (belowType == 3 || belowType == 4 || belowType == 6)) {return false;}
        else if (right && (leftType == 3 || leftType == 4 || leftType == 6)) {return false;}
        else if (left && (rightType == 3 || rightType == 4 || rightType == 6)) {return false;} 

        if (dir == 'n' && below) {return false;}
        else if (dir == 's' && above) {return false;}
        else if (dir == 'e' && right) {return false;}
        else if (dir == 'w' && left) {return false;}
        else {return true;}
    }

    public static void moveEntity(int[][] playField, int typeId, int x, int y) {
        int oldX = findTypePosition(playField, typeId).get(0); // get the old x position of the entity
        int oldY = findTypePosition(playField, typeId).get(1); // get the old y position of the entity

        try { // make sure that the intended location is not outside of the 2D Array
            playField[oldX][oldY] = 0; // null out that number
            playField[x][y] = typeId; // set to new position
        } catch (ArrayIndexOutOfBoundsException e) {
            playField[oldX][oldY] = typeId;

        }

    }

    public static int[][] genMapByStr(String mapString) {
        char[] chars = mapString.toCharArray();
        int width = 1;
        int height = 1;
        for (char ch : chars) {
            if (ch == '\n'){width++;height++;}
        }
        int[][] playField = new int[width][height];
        
        
        int x = 0;
        int y = 0;
        int type = 0;
        for (char ch : chars) {
            //below is for dubuging the string to type converter
            //printf(ch+" "+y+" "+x+";");
            
            if (ch == ' '){type = 0;}
            else if (ch == '1'){type = 1;}
            else if (ch == '2'){type = 2;}
            else if (ch == '3'){type = 3;}
            else if (ch == '4'){type = 4;}
            else if (ch == '5'){type = 5;}
            else if (ch == '6'){type = 6;}
            else if (ch == '\n'){x = 0; y++; continue;}
            playField[y][x] = type;
            x++;
        }

        return playField;
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

    // Seccondary 'libraries' that help with sanity and shorter function
    public static void print(Object sentString) {
        System.out.print(sentString);
    }

    public static void printf(Object sentString) {
        System.out.println(sentString);
    }
}