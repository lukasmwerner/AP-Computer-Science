import java.awt.*;
import java.awt.event.*;
import java.util.LinkedList;
import javax.swing.*;

public class Game extends JComponent implements KeyListener {
    //Snake snake = new Snake();
    static LinkedList<int[]> snakeList = new LinkedList<int[]>(); //head at position 0
    static int dir = 0; // 0 UP 1 DOWN 2 LEFT 3 RIGHT
    static private char c = ' ';
    static double diff = 4;
    static int length = 2;
    static int score = 0;
    static boolean gameOver = false;
    static int appleX = (int)(Math.random()*10);
    static int appleY = (int)(Math.random()*10);

    public static void main(String[] args) {
        JFrame window = new JFrame("Snake"); // create window with the title "Snake"
        Game game = new Game();

        game.addKeyListener(game);
        window.setSize(650, 540 + 23); // set up window frame to be a 540x540px window plus the 23 px offset
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button = close

        window.add(game); // add game to the window

        window.setVisible(true); // show window
        while (true) {
            snakeList.addLast(new int[] {200,500});
            snakeList.addLast(new int[] {200,550});
            while (!gameOver) { // main function loop
                int headX = snakeList.get(0)[0];
                int headY = snakeList.get(0)[1];
                int[] headed = new int[] {headX, headY};
                snakeList.addFirst(headed);
                if (dir == 0) {snakeList.get(0)[1] -= 50;}
                if (dir == 1) {snakeList.get(0)[1] += 50;}
                if (dir == 2) {snakeList.get(0)[0] -= 50;}
                if (dir == 3) {snakeList.get(0)[0] += 50;}
                if (!detectCollision()) {
                    snakeList.removeLast();
                }
                

                
                try {
                    Thread.sleep((int)(diff*100));
                } catch (Exception e) {
                ;
                }

                game.repaint();
            }
            if (dir == -10) {
                for (int i = 0; i < snakeList.size(); i++) {
                    snakeList.remove(i);
                }
                gameOver = false;
            }
            game.repaint();
        }
    }


    // Collision Detection Function
    public static boolean detectCollision() {
        int[] head = snakeList.getFirst();
        //move and detect eating and gen apple
        if (appleX*50 == head[0] && appleY*50 == head[1]) {
            score++;
            appleX = (int)(Math.random()*10);
            appleY = (int)(Math.random()*10);
            boolean inBody = false;
            while (!inBody) {
                for (int[] bodyPart: snakeList) {
                    while (appleX*50 == bodyPart[0] && appleY*50 == bodyPart[1]) {
                        appleX = (int)(Math.random()*10);
                        appleY = (int)(Math.random()*10);
                    }
                }
                for (int[] bodyPart: snakeList) {
                    if (appleX*50 != bodyPart[0] && appleY*50 != bodyPart[1]) {
                        inBody = true;
                    }
                }
            } 
            return true;
        }


        //detect if death
        int i = 0;
        if (head[0] < 0 || head[0] >= 500) {
            gameOver = true;
        }
        if (head[1] < 0 || head[1] >= 500) {
            gameOver = true;
        }
        for (int[] bodyPart : snakeList) {
            if (head[0] == bodyPart[0]) {
                if (head[1] == bodyPart[1]) {
                    if (i != 0) {
                        gameOver = true;
                    }
                    
                }
            }
            i++;
            length++;
        }
        return false;
    }


    //rendering function
    public void paint(Graphics g) {
        int offset = 10;

        g.setColor(new Color(87,138,52));
        g.fillRect(0, 0, 650, 540);

        g.setColor(new Color(170, 215, 81));
        g.fillRect(offset, offset, 500, 500);

        g.setColor(new Color(162,209,73));
        for ( int row = 0; row < 10; row++ )
        {
            for ( int col = row % 2; col < 10; col += 2 )
            {
                g.fillRect( (row * 50)+offset, (col * 50)+offset, 50, 50 );
            }
        }

        
        int i = 0;
        Color darkenMe = Color.BLUE;
        for (int[] bodyPart : snakeList) {
            g.setColor(darkenMe);
            g.fillRect(bodyPart[0]+10, bodyPart[1]+10, 50, 50);
            if (i >= 6 && i <= 11) {darkenMe = darkenMe.brighter();}
            else {darkenMe = darkenMe.darker();}
            i++;
        }
        g.setColor(Color.RED);
        g.fillRect(appleX*50+offset, appleY*50+offset, 50, 50);

        g.setColor(Color.WHITE);
        g.drawString("Score: \n"+score, 560, 60);
        g.drawString("Difficulty: \n"+diff, 540, 80);
        if (gameOver) {
            g.drawString("Game Over", 325, 270);
        }

    }


    // Keyboard commands
    public void addNotify() {
      super.addNotify();
      requestFocus();
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) {
        c = e.getKeyChar();
        if (c == 'w') {dir = 0;}
        if (c == 's') {dir = 1;}
        if (c == 'a') {dir = 2;}
        if (c == 'd') {dir = 3;}
        if (c == 'q') {dir = 9999999; diff= 9999999;}
        if (c == 'r') {dir = -10;}
        if (c == '1') {diff = 5;}
        if (c == '2') {diff = 3;}
        if (c == '3') {diff = 2;}
        if (c == '4') {diff = 1;}
        if (c == '5') {diff = 0.75;}
        if (c == '6') {diff = 0.5;}
        if (c == '7') {diff = 0.25;}
    }
}