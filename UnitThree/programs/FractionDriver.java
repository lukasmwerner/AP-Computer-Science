public class FractionDriver{ 
public static void main(String[] args) {
    Fraction f1 = new Fraction(78,106);
    Fraction f2 = new Fraction(1,2);
    Fraction f3 = f1.add(f2);
    System.out.println(f3);
    Fraction f4 = f1.mult(f2);
    System.out.println(f4);
    Fraction f5 = new Fraction(24,90);
    f5.simp();
    System.out.println(f5);
    System.out.println(blarg());
}
public static String blarg() {
    return "Hello";
}}