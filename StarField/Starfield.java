import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Starfield extends JPanel {
  ArrayList<SpaceObject> spaceObjects = new ArrayList<SpaceObject>();
  static final int FIELD_WIDTH = 500;
  static final int FIELD_HEIGHT = 500;
  static final int MAX_DIAMETER = 10;
  static final double MAX_SPEED = 0.1;
  static final int NUM_STARS = 50;
  static final int MOVING_STARS = 25;
  static final int NUM_ASTEROIDS = 10;
  static final int NUM_PLANETS = 10;
  static final int ANIMATION_DELAY = 1; // in milliseconds

  public static void main(String[] args) {
    JFrame window = new JFrame("Starfield");
    window.setSize(FIELD_WIDTH, FIELD_HEIGHT);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    Starfield field = new Starfield();

    for (int i = 0; i < NUM_STARS - MOVING_STARS; i++) field.spaceObjects.add(
      new Star()
    );

    for (int i = 0; i < MOVING_STARS; i++) field.spaceObjects.add(
      new MovingStar()
    );

    for (int i = 0; i < NUM_ASTEROIDS; i++) field.spaceObjects.add(
      new Asteroid()
    );

    for (int i = 0; i < NUM_PLANETS; i++) field.spaceObjects.add(new Planet());

    window.add(field);
    window.setVisible(true);

    while (true) {
      for (SpaceObject star : field.spaceObjects) {
        if (star instanceof MovingObject) ((MovingObject) star).move();
        if (star instanceof Asteroid) {
          for (SpaceObject rock : field.spaceObjects) {
            if (rock instanceof CollidingObject && rock != star) {
              ((Asteroid) star).collide((CollidingObject) rock);
            }
          }
        }
      }

      try {
        Thread.sleep(ANIMATION_DELAY);
      } catch (Exception e) {}

      field.repaint();
    }
  }

  public void paint(Graphics g) {
    setOpaque(true);
    setBackground(Color.BLACK);
    super.paintComponent(g);

    for (SpaceObject star : spaceObjects) {
      g.setColor(star.color);
      g.fillOval((int) star.x, star.y, star.diameter, star.diameter);
    }
  }
}

abstract class SpaceObject {
  double x;
  int y;
  int diameter;
  Color color;

  public SpaceObject() {
    x = (int) (Math.random() * Starfield.FIELD_WIDTH);
    y = (int) (Math.random() * Starfield.FIELD_HEIGHT);
    diameter = (int) (Math.random() * Starfield.MAX_DIAMETER);
    int brightness = (int) (Math.random() * 255);
    color = new Color(brightness, brightness, brightness);
  }
}

abstract class MovingObject extends SpaceObject {
  double speed;

  public MovingObject() {
    super();
    speed = Math.random() * Starfield.MAX_SPEED;
  }

  public void move() {
    x -= speed;
    if (x < 0) {
      x = Starfield.FIELD_WIDTH + 100;
      y = (int) (Math.random() * Starfield.FIELD_HEIGHT);
    }
  }
}

class Star extends SpaceObject {

  public Star() {
    super();
  }
}

class MovingStar extends MovingObject {

  public MovingStar() {
    super();
  }
}

abstract class CollidingObject extends MovingObject {

  public void collide(CollidingObject other) {}
}

class Asteroid extends CollidingObject {

  public Asteroid() {
    super();
    int red = 255;//(int) (Math.random() * 255);
    int green = 0;//(int) (Math.random() * 255);
    int blue = 0;//(int) (Math.random() * 255);
    color = new Color(red, green, blue);
  }

  @Override
  public void collide(CollidingObject other) {
    double distance = Math.sqrt( Math.pow((other.x - this.x), 2)+ Math.pow((other.y - this.y), 2) );
    double sumOfRadiusis = (this.diameter/2.0 + other.diameter/2.0);
    if (distance == sumOfRadiusis) { // Touching
      this.speed = 0;
      this.diameter = 0;
      this.x = -1000;
      return;
    }
    if (distance <= sumOfRadiusis) { // Hitting
      this.speed = 0;
      this.diameter = 0;
      this.x = -1000;
      return;
    }
  }

}

class Planet extends CollidingObject {

  public Planet() {
    super();
    diameter =
      (int) (Math.random() * 2 * Starfield.MAX_DIAMETER) +
      Starfield.MAX_DIAMETER;
    int red = (int) (Math.random() * 255);
    int green = (int) (Math.random() * 255);
    int blue = (int) (Math.random() * 255);
    color = new Color(red, green, blue);
    speed = 0;
  }
}
