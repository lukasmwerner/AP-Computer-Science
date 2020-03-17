public class Square {

  // X, Y coordinate system assumes the origin is in the upper left
  private Point upperLeft;
  private Point lowerRight;

  public Square() {
    upperLeft = new Point(0,0);
    lowerRight = new Point(1,1);
  }

  public Square(Point a, Point b) {
    upperLeft = a;
    lowerRight = b;
  }

  public int getSideLength() {   // q4,5
    int side = lowerRight.getX() - upperLeft.getX();
    return side;
  }

  public int area() {    // q6,7
    int side = getSideLength();
    return side * side;
  }

  public void scale(double scaleFactor) {
    int newSide = (int)(getSideLength() * scaleFactor);
    lowerRight = new Point(upperLeft.getX() + newSide, upperLeft.getY() + newSide);
  }

  public Point findCenter() {
    int centerX = upperLeft.getX() + getSideLength() / 2;
    int centerY = upperLeft.getY() + getSideLength() / 2;
    return new Point(centerX, centerY);    // q11
  }

  public double findDistance(Square other) {
    LineSegment ab = new LineSegment(findCenter(), other.findCenter());   // q12
    return ab.distance();
  }

  public String toString() {
    return "UL:" + upperLeft + ", LR:" + lowerRight + " : side length " + getSideLength();
  }


}
