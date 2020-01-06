public class MP3Player {

  public static void main(String[] args) {

    MP3 song1 = new MP3();
    MP3 song2 = new MP3("Unknown", "Seikilos epitaph", 3.5, 160);

    System.out.println(song1);
    System.out.println(song2);

  }
}
