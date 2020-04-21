public class Sword extends Item {
  private double attackDamage;

  public Sword() {
    super("Generic Sword");
  }

  public Sword(double attackDamage) {
    super("Generic Sword");
    this.attackDamage = attackDamage;
  }

  public Sword(String name, double attackDamage) {
    super(name);
    this.attackDamage = attackDamage;
  }

  public String toString() {
    return getName() + " <Attack Damage: " + attackDamage+">";
  }

  public double attack() {return attackDamage;}
}
