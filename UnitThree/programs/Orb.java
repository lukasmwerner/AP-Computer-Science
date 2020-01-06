public class Orb {

  private int x;
  private int y;
  private double radius;

  public Orb() {
    x = 0;
    y = 0;
    radius = 1;
  }

  public Orb(int x, int y, double rad) {
    this.x = x;
    this.y = y;
    radius = rad;
  }

  public int getX() {
    return x;
  }

  public int getY() {
    return y;
  }

  public double getRadius() {
    return radius;
  }

  public void setRadius(double newRadius) {
    radius = newRadius;
  }

  public double distance(Orb other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }

  public boolean absorb(Orb other) {
    if (distance(other) <= this.radius - other.radius) {
      this.radius = Math.sqrt(Math.pow(this.radius,2) + Math.pow(other.radius, 2));
      other.setRadius(0);
      return true;
    }

    return false;
  }

  public void moveTo(int newX, int newY) {
    x = newX;
    y = newY;
  }

  public String toString() {
    return x + ", " + y + " radius: " + radius;
  }
}
