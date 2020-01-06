import java.util.ArrayList;

public class Fraction {

	private int numerator;
	private int denominator;

	public Fraction() {
		numerator = 1;
		denominator = 1;
	}

	public Fraction(int n, int d) {
		numerator = n;
		denominator = d;
	}

	public Fraction add(Fraction other) {
		if (denominator == other.denominator) {
			int newNum = numerator + other.numerator;
			Fraction newFrac = new Fraction(newNum, denominator);
			return newFrac;
		} else {
			int f1Num = numerator * other.denominator;
			int f2Num = other.numerator * denominator;
			int newDen = denominator * other.denominator;

			int newNum = f1Num + f2Num;

			Fraction newFrac = new Fraction(newNum, newDen);
			newFrac.simp();
			return newFrac;


		}
		
		
	}

  /*
    Create a multiply method for fractions
  */

	public Fraction mult(Fraction other) {
		int newNum = numerator * other.numerator;
		int newDen = denominator * other.denominator;

		Fraction newFrac = new Fraction(newNum, newDen);

		return newFrac;


	}


  /*
    Challenge : create a simplify method
  */

	public void simp() {
		int gcf = gcd(numerator, denominator);

		numerator /= gcf;
		denominator /= gcf;
	}

	private int gcd(int numerator, int denominator) {
		if (numerator % denominator == 0) {
			return denominator;
	   	}
		return gcd(denominator, numerator % denominator);
	}


  public String toString() {
	  return String.format("%s/%s", numerator, denominator);
  }
}
