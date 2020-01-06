public class OrbDriver {
    public static void main(String[] args) {
        Orb orb1 = new Orb();
        Orb orb2 = new Orb(3,4,2);
        System.out.println(orb1);
        System.out.println(orb2);
        System.out.println(orb1.distance(orb2));
        orb2.moveTo(1,0);
        System.out.println(orb1.distance(orb2));
        orb2.absorb(orb1);
        System.out.println(orb1);
        System.out.println(orb2);
    }
}