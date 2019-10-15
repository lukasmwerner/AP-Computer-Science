import java.awt.*;
import javax.swing.*;

public class FuncPlotter extends JComponent {
    public static void main(String[] args) {
        JFrame window = new JFrame("Function Plotter");
        FuncPlotter shapes = new FuncPlotter();

        window.setSize(500, 500+23);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.add(shapes);
        window.setVisible(true);


    }
    public void paint(Graphics g) { 
        for (int i = 0; i <= 500; i+=50) {
            g.drawLine(0+i, 0, 0+i, 500);
        }
        for (int i = 0; i <= 500; i+=50) {
            g.drawLine(0, 0+i, 0, 500);
        }
    }
}