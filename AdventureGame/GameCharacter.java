class GameCharacter {
  private String name;
  private double health = 10;

  public GameCharacter(String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public String toString() {
    return name;
  }

  public void takeDamage(double amt) {
    health -= amt;
  }

  public double health() {
    return health;
  }

  public void setHealth(double h) {
    health = h;
  }
}
