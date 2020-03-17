public class Text {

  private String title;
  private String author;
  private int year;

  public Text() {
    title = "";
    author = "";
    year = 0;
  }

  public Text(String t, String a, int y) {
    title = t;
    author = a;
    year = y;
  }

  public String toString() {
    return author + ", " + title + ", " + year;
  }

}
