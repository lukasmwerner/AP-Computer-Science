public class Article extends Text {

  public String periodical;

  public Article() {
    super("The C Programming Language", "Bell Laboratories", 1978);
    periodical = "0";
  }

  public Article(String t, String a, int y, String p) {
    super(t, a, y);
    periodical = p;
  }

  public String toString() {
    return String.format("%s, %s", super.toString() , periodical);
  }

}
