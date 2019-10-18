import java.awt.event.*;
import javax.swing.*;

public class KeyTester extends JComponent implements KeyListener {
    private char c = ' ';
    
    public void addNotify() {
      super.addNotify();
      requestFocus();
    }
    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }
    public void keyTyped(KeyEvent e) { 
        c = e.getKeyChar();
        System.out.println(c);
    }

    public static void main(String[] args) {
        JFrame window = new JFrame("My Drawing"); // create window with the title "My Drawing"
        KeyTester shapes = new KeyTester();
        shapes.addKeyListener(shapes);
        window.setSize(400, 400+23); //set up window frame to be a 400x400px window plus the 23 px offset
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button = close

        window.add(shapes); // add shapes to the window

        window.setVisible(true); // show window
    }
}