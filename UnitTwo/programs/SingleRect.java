import java.awt.*;
import javax.swing.*;

public class SingleRect extends JComponent {
    public static void main(String[] args) {
        JFrame window = new JFrame("One rect");
        SingleRect shapes = new SingleRect();

        window.setSize(500, 500+23);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        window.add(shapes);

        window.setVisible(true);
    }

    public void paint(Graphics g) {
        g.setColor( new Color(55, 178, 143) );
        
        for (int i =0; i <400; i+=100) {
            g.setColor( new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)) );
            g.fillRect(50+i, 50, 50, 50);
        }
        try {
            Thread.sleep(200);
        } catch (Exception e) {;}
        for (int i =0; i <400; i+=100) {
            g.setColor( new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)) );
            g.fillRect(50+i, 50+i, 50+i, 50);
        }
    }   
}