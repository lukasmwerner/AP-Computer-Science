public class CheckDigit {

  public static void main(String[] args) {
    String pass = "✅ Test Case Passed";
    String fail = "❌ Test Case Failed";
    System.out.println(getCheck(283415) == 6 ? pass : fail);
    System.out.println(getCheck(2183) == 2 ? pass : fail);
    System.out.println(isValid(1592) == true ? pass : fail);
  }

  public static int getCheck(int num) {
    int sum = 0;
    int mult = 7;
    for (int i = 0; i < getNumberOfDigits(num); i++) {
      sum += getDigit(num, i) * mult;
      mult--;
    }
    sum = getDigit(sum, getNumberOfDigits(sum) - 1);
    return sum;
  }

  public static boolean isValid(int numWithCheckDigit) {
    String a = numWithCheckDigit + "";
    return (
      getDigit(numWithCheckDigit, getNumberOfDigits(numWithCheckDigit) - 1) ==
      getCheck(
        Integer.parseInt(
          a.substring(0, getNumberOfDigits(numWithCheckDigit) - 1)
        )
      )
    );
  }

  public static int getNumberOfDigits(int num) {
    return (num + "").length();
  }

  public static int getDigit(int num, int n) {
    String dString = num + "";
    return Integer.parseInt(dString.charAt(n) + "");
  }

  public static void p(int i) {
    System.out.println(i);
  }
}
