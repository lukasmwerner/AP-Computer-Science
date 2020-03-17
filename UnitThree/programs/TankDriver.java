public class TankDriver{ 
public static void main(String[] args) {
    Tank t1 = new Tank(500, 10);;
    Tank t2 = new Tank(250, 200);;
    System.out.println(t1.getTick());;
    System.out.println(t1);
    System.out.println(t2);
    System.out.println("--");
    t1.setTick(10);
    System.out.println(t1);
    System.out.println(t2);
    System.out.println("--");
    t1.takeDamage(t2.getAttack());
    System.out.println(t1);
    System.out.println(t2);
    System.out.println("--");
}}