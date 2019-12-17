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
		int newNum = numerator + other.numerator;
		int newDen = (denominator + other.denominator)/denominator;
		Fraction newFrac = new Fraction(newNum, newDen);
		return newFrac;
	}

  /*
    Create a multiply method for fractions
  */

  /*
    Challenge : create a simplify method
  */

  public String toString() {
	  return String.format("%s/%s", numerator, denominator);
  }
}
