public class Tank {

  private int energy;
  private int attack;
  private static int tick;

  public Tank(int e, int a) {
    energy = e;
    attack = a;
  }

  public int getEnergy() {
    return energy;
  }

  public int getAttack() {
    return attack;
  }

  public static int getTick() {
    return tick;
  }
  public void takeDamage(int amt) {
    energy -= amt;
  }

  public static void setTick(int t) {
    tick = t;
  }
  public String toString() {
    return "Energy: " + energy + " Attack: " + attack + " Tick: " + this.tick;
  }
}
