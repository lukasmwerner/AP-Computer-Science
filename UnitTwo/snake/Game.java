import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;


import javax.swing.*;

public class Game extends JComponent implements KeyListener {
    Snake snake = new Snake();
    static LinkedList<int[]> snakeList = new LinkedList<int[]>(); //head at position 0
    static int[] lastLoc = new int[2];
    static int[] prevMove = new int[4];
    static int dir = 0; // 0 UP 1 DOWN 2 LEFT 3 RIGHT
    private char c = ' ';

    public static void main(String[] args) {
        JFrame window = new JFrame("Snake"); // create window with the title "Snake"
        Game game = new Game();

        game.addKeyListener(game);
        window.setSize(540, 540 + 23); // set up window frame to be a 540x540px window plus the 23 px offset
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button = close

        window.add(game); // add game to the window

        window.setVisible(true); // show window
        snakeList.addLast(new int[] {450,450});
        snakeList.addLast(new int[] {450,500});
        
        while (true) { // main function loop

            lastLoc[0] = snakeList.get(1)[0];
            lastLoc[1] = snakeList.get(1)[1];

            int length = snakeList.size();

            for (int i=0; i < length; i++) {
                if (dir == 0) {snakeList.get(i)[1] -= 50;}
                if (dir == 1) {snakeList.get(i)[1] += 50;}
                if (dir == 2) {snakeList.get(i)[0] -= 50;}
                if (dir == 3) {snakeList.get(i)[0] += 50;}
            }
            try {
                Thread.sleep(1000);
            } catch (Exception e) {;}
            game.repaint();
        }
    }

    public void paint(Graphics g) {
        int offset = 10;

        for (int i = 0; i <= 500; i+=50) {
            g.drawLine(0+i+offset, 0+offset, 0+i+offset, 500+offset);
        }
        
        for (int i = 0; i <= 500; i+=50) {
            g.drawLine(0+offset,0+i+offset,500+offset,0+i+offset);
        }
        g.setColor(Color.RED);
        for (int[] bodyPart : snakeList) {
            g.fillRect(bodyPart[0]+10, bodyPart[1]+10, 50, 50);
        }

    }
    
    public void addNotify() {
      super.addNotify();
      requestFocus();
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { 
        c = e.getKeyChar();
        prevMove[1] = dir;
        if (c == 'w') {dir = 0;}
        if (c == 's') {dir = 1;}
        if (c == 'a') {dir = 2;}
        if (c == 'd') {dir = 3;}
        if (c == 'q') {dir = 9999999;}
        prevMove[0] = dir;
    }
}

class Snake {
    LinkedList<int[]> snakeList = new LinkedList<int[]>();
    
    public static void rotate() {
        
    }
    
}