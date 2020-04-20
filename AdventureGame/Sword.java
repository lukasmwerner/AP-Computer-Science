public class Sword extends Item {
  private double damage;
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

  public Sword(String name, double attackDamage, double damage) {
    super(name);
    this.attackDamage = attackDamage;
    this.damage = attackDamage;
  }

  public String toString() {
    return getName() + " Damage: " + damage + " Attack Damage: " + attackDamage;
  }
}
