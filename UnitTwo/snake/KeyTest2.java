/*
  http://stackoverflow.com/questions/9333876/how-to-simply-implement-a-keylistener
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class KeyTest2 extends JPanel implements KeyListener {
    private char c = ' ';

    public void paintComponent(Graphics g) {
        g.clearRect(0, 0, getWidth(), getHeight());
        g.drawString("the key that pressed is " + c, 250, 250);
    }

    public void addNotify() {
      super.addNotify();
      requestFocus();
    }

    public void keyPressed(KeyEvent e) { }
    public void keyReleased(KeyEvent e) { }

    public void keyTyped(KeyEvent e) {
        c = e.getKeyChar();
        repaint();
    }

    
    
    
    public static void main(String[] s) {
        JFrame f = new JFrame();
        KeyTest2 tester = new KeyTest2();
        f.setSize(500, 500);
        tester.addKeyListener(tester);
        f.add(tester);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }
}
