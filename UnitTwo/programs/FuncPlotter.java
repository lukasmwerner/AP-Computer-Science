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
            g.drawLine(0,0+i,500,0+i);
        }
        int[] previousPoint = {0,0};
        g.setColor(Color.BLUE); // quadratic
        for (int i=500; i >= -500; i-=1) {
            int x = i+100;
            int y = (int)(Math.pow(i,2));
            g.drawLine(previousPoint[0], previousPoint[1], x, y);
            g.fillOval(x-2,y-2,4,4);
            previousPoint[0] = x;
            previousPoint[1] = y;
        }
        
        g.setColor(Color.RED); // y = x
        for (int x=0;x<=500; x+=1) {
            g.drawOval(x,x,1,1);
        }
        g.setColor(Color.GREEN); //linear eqn
        for (int i=0;i<=500;i+=1) {
            int y = (3*i) +4;
            g.fillOval(i-2, y-2, 4,4);
        }

    }
}