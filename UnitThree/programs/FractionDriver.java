public class FractionDriver{ 
public static void main(String[] args) {
    Fraction f1 = new Fraction(500,1000);
    Fraction f2 = new Fraction(1000,2000);
    Fraction f3 = f1.add(f2);
    System.out.println(f3);
    Fraction f4 = f1.mult(f2);
    System.out.println(f4);
    Fraction f5 = new Fraction(24,90);
    f5.simp();
    System.out.println(f5);
}}