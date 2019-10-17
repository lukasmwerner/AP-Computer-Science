import java.awt.*;
import java.util.LinkedList;

import javax.swing.*;

public class Snake extends JComponent {
    static LinkedList<int[]> snakeList = new LinkedList<int[]>(); //head at position 0
    static int dir = 0; // 0 UP 1 DOWN 2 LEFT 3 RIGHT

    public static void main(String[] args) {
        JFrame window = new JFrame("My Drawing"); // create window with the title "My Drawing"
        Snake snakes = new Snake();

        window.setSize(540, 540 + 23); // set up window frame to be a 540x540px window plus the 23 px offset
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button = close

        window.add(snakes); // add shapes to the window

        window.setVisible(true); // show window
        snakeList.addLast(new int[] {450,450});

        
        while (true) { // main function loop
            if (dir == 0) {snakeList.get(0)[1] -= 50;}
            if (dir == 1) {snakeList.get(0)[1] += 50;}
            if (dir == 2) {snakeList.get(0)[0] -= 50;}
            if (dir == 3) {snakeList.get(0)[0] += 50;}
            try {
                Thread.sleep(1000);
            } catch (Exception e) {;}
            snakes.repaint();
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
}