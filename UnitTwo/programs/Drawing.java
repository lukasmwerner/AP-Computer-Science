import java.awt.*;
import javax.swing.*;

public class Drawing extends JComponent {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public static void main(String[] args) {
        JFrame window = new JFrame("My Drawing"); // create window with the title "My Drawing"
        Drawing shapes = new Drawing();

        window.setSize(400, 400+23); //set up window frame to be a 400x400px window plus the 23 px offset
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // X button = close

        window.add(shapes); // add shapes to the window

        window.setVisible(true); // show window 


    }
    public void paint(Graphics g) {


        // Java preset colors are Color.COLOR_NAME
        
        //top left origin
        g.setColor(Color.BLUE);
        g.drawLine(0,0,100,100);
        g.setColor(Color.RED);
        g.drawLine(50,0,50,100);

        g.setColor( new Color(104, 70, 21));
        g.fillRect(100,200,200,300);
    }
}