public class Enemy extends GameCharacter {
  private double dpa;
  private Item drops;

  public Enemy() {
    super("Generic Enemy");
    dpa = 1;
    setHealth(10);
    drops = null;
  }

  public Enemy(String name) {
    super(name);
    dpa = 1;
    setHealth(10);
    drops = null;
  }

  public Enemy(String name, double dpa, double health) {
    super(name);
    this.dpa = dpa;
    setHealth(health);
    drops = null;
  }

  public Enemy(String name, double dpa, double health, Item drops) {
    super(name);
    this.dpa = dpa;
    setHealth(health);
    this.drops = drops;
  }

  public double attack() {
    return dpa;
  }
}
