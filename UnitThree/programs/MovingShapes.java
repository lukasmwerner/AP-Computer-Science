import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.util.ArrayList;

public class MovingShapes extends JComponent {


  private static ArrayList<Shape> shapeList;
  private static ArrayList<Shape> notMovingShapes;

  public static void main(String[] args) {
    shapeList = new ArrayList<Shape>();
    notMovingShapes = new ArrayList<Shape>();
    JFrame window = new JFrame();

    MovingShapes field = new MovingShapes();
    
    field.shapeList.add(new Shape(100, 100, 10, new Color(0,0,255) , 5) );
    field.shapeList.add(new Shape(140, 130, 10, new Color(255,0,0), false) );

    for (int z = 0; z < 200; z++) {
      int x = (int)((Math.random() * 800)+1);
      int y = (int)((Math.random() * 800)+1);
      int r = (int)((Math.random() * 255));
      int g = (int)((Math.random() * 255));
      int b = (int)((Math.random() * 255));
      field.shapeList.add(new Shape(x,y, new Color(r,g,b)));
    }

    for (int z = 0; z < 20; z++) {
      int x = (int)((Math.random() * 799)+1);
      int y = (int)((Math.random() * 799)+1);
      field.notMovingShapes.add(new Shape(x,y, 20, Color.ORANGE) );
    }




    window.setSize(800, 800);
    window.add(field);


    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.show();

    while(true) {
      int i = 0;
      for (Shape shape: shapeList) {
        for (int x = 0; x < shapeList.size(); x++) {
          if (x != i) {
            shape.collide(shapeList.get(x));
          }
        }
        for (int x = 0; x < notMovingShapes.size(); x++) {
          if (x != i) {
            shape.collide(notMovingShapes.get(x));
          }
        }
        shape.move();
        i++;
      }

      try {
        Thread.sleep(10);
      } catch(Exception e) {}

      field.repaint();
    }

  }

  public void paint(Graphics g) {
    g.drawRect(0,0,800,800-23);
    int oob = 0;

    for (Shape shape: notMovingShapes) {
      g.setColor(shape.getColor());
      g.fillRect(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
    }
    for (Shape shape: shapeList) {
      g.setColor(shape.getColor());
      g.fillOval(shape.getX(), shape.getY(), shape.getWidth(), shape.getHeight());
      if (shape.getX() > 800 || shape.getY() > 800) {oob++;}
    }
    g.setColor(Color.black);
    g.drawString("Size: "+ shapeList.size()+" Out of Bounds Count: " + oob, 10, 10);
  }



}
